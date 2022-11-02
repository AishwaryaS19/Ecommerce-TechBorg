package com.ecommerce.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce.library.dto.AdminDto;
import com.ecommerce.library.model.Admin;
import com.ecommerce.library.service.impl.AdminServiceImpl;

import javax.validation.Valid;

@Controller
public class LoginController {

	@Autowired
    private AdminServiceImpl adminService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("title", "Admin Login");
        return "login";
    }
    
   @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("title", "Admin Register");
        model.addAttribute("adminDto", new AdminDto());
        return "register";
   }

   @PostMapping("/saveAdmin")
   public String addNewAdmin(@Valid @ModelAttribute("adminDto")AdminDto adminDto,
                             BindingResult result,
                             Model model){
        try {
            if(result.hasErrors()){
                model.addAttribute("adminDto", adminDto);
                result.toString();
                return "register";
            }
            String username = adminDto.getUsername();
            Admin admin = adminService.findByUsername(username);
            if(admin != null){
                model.addAttribute("adminDto", adminDto);
                model.addAttribute("emailError", "Your email has been already registered!");
                return "register";
            }
            if(adminDto.getPassword().equals(adminDto.getRepeatPassword())){
                adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
                adminService.save(adminDto);
                model.addAttribute("success", "Registered successfully!");
                model.addAttribute("adminDto", adminDto);
            }else{
                model.addAttribute("adminDto", adminDto);
                model.addAttribute("passwordError", "Your password maybe wrong! Check again!");
                return "register";
            }
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("errors", "Something went wrong!");
        }
        return "register";
   }
   
   @RequestMapping("/index")
   public String home(Model model){
   		model.addAttribute("title", "Admin Home");
   		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
   		if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
           return "redirect:/login";		
   		}
   		return "index";
   }
}