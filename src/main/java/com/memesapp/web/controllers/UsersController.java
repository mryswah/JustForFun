package com.memesapp.web.controllers;

import com.memesapp.web.constants.CommonConstants;
import com.memesapp.web.dto.CategoriesDto;
import com.memesapp.web.dto.LabelsDto;
import com.memesapp.web.dto.MemesDto;
import com.memesapp.web.dto.UsersDto;
import com.memesapp.web.model.Users;
import com.memesapp.web.security.SecurityUtil;
import com.memesapp.web.service.MemesService;
import com.memesapp.web.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
public class UsersController {
    private UsersService usersService;
    private MemesService memesService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsersController(UsersService usersService, MemesService memesService, PasswordEncoder passwordEncoder) {
        this.usersService = usersService;
        this.memesService = memesService;
        this.passwordEncoder = passwordEncoder;
    }

    // Populate the common Categories and Labels model attribute on the Nav Bar (on the left)
    private void populateCommonModelAttributes(Model model){
        List<CategoriesDto> categories = memesService.listAllCategories();
        List<LabelsDto> labels = memesService.listAllLabels();
        model.addAttribute(CommonConstants.ATTRIB_CATEGORIES, categories);
        model.addAttribute(CommonConstants.ATTRIB_LABELS, labels);
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        Users users = new Users();
        model.addAttribute(CommonConstants.ATTRIB_USERS,users);
        populateCommonModelAttributes(model);
        return CommonConstants.PAGE_LOGIN_PAGE;
    }

    @PostMapping("/logout")
    public String logout(){
        return "logout";
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        Users users = new Users();
        model.addAttribute(CommonConstants.ATTRIB_USERS,users);
        populateCommonModelAttributes(model);
        return CommonConstants.PAGE_REGISTER_PAGE;
    }

    @PostMapping("/register")
    public String register(UsersDto usersDto, Model model){
        List<UsersDto> users = usersService.searchByUsernameAndEmail(usersDto.getUsername(), usersDto.getEmail());
        if(users.size()>=1){
            return "redirect:/register?error";
        }
        usersService.registerUser(usersDto);
        return "redirect:/memes?successfulRegistration";
    }

    @GetMapping("/settings")
    public String settingsPage(Model model){
        Users users = new Users();
        String username = SecurityUtil.getSessionUser();
        if(username != null) {
            users = usersService.searchByUsername(username);
        }
        model.addAttribute(CommonConstants.ATTRIB_USERS,users);
        populateCommonModelAttributes(model);
        return CommonConstants.PAGE_USER_SETTINGS;
    }

    @PostMapping("/users/{usersId}/update")
    public String userUpdate(@Validated(UsersDto.EmailOnly.class) @ModelAttribute("users") UsersDto usersDto, BindingResult result, Model model){
        Users users = new Users();
        String username = SecurityUtil.getSessionUser();
        if(username != null) {
            users = usersService.searchByUsername(username);
        }
        if(result.hasErrors()) {
            populateCommonModelAttributes(model);
            model.addAttribute(CommonConstants.ATTRIB_USERS, usersDto);
            return CommonConstants.PAGE_USER_SETTINGS;
        }
        usersService.updateUser(usersDto);
        model.addAttribute(CommonConstants.ATTRIB_USERS,usersDto);
        return "redirect:/settings?success";
    }

    @PostMapping("/users/{usersId}/updatePassword")
    public String userUpdatePassword(@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword, @RequestParam("retypeNewPassword") String retypeNewPassword, UsersDto usersDto, Model model){
        if(!newPassword.equalsIgnoreCase(retypeNewPassword)){
            return "redirect:/settings?errorPassword";
        }
        Users users = new Users();
        String username = SecurityUtil.getSessionUser();
        if(username != null) {
            users = usersService.searchByUsername(username);
        }

        // Encode old Password and compare with the encoded version in the Database
        if(!passwordEncoder.matches(oldPassword, users.getPassword())){
            return "redirect:/settings?errorPassword";
        }
        usersDto.setPassword(newPassword);
        usersService.updateUserPassword(usersDto);
        model.addAttribute("users",usersDto);
        return "redirect:/settings?success";
    }

    @PostMapping("/users/{usersId}/delete")
    public String userDeleteAccount(@PathVariable("usersId") Long usersId){
        Users users = new Users();
        String username = SecurityUtil.getSessionUser();
        if(username != null) {
            users = usersService.searchByUsername(username);
        }
        usersService.deleteUser(usersId);
        return "redirect:/logout";
    }

    @GetMapping("/profile/{query}")
    public String profilePage(@PathVariable("query") String query,Model model){
        Users users = new Users();
        String username = SecurityUtil.getSessionUser();
        if(username != null) {
            users = usersService.searchByUsername(username);
        }
        model.addAttribute(CommonConstants.ATTRIB_USERS,users);
        List<MemesDto> myMemes = memesService.listAllMemesCreatedByUser(username);
        List<String> image = new ArrayList<String>();
        if(!myMemes.isEmpty()){
            for (MemesDto memeDto : myMemes){
                String imageString = Base64.getEncoder().encodeToString(memeDto.getImage());
                image.add(imageString);
                model.addAttribute(CommonConstants.ATTRIB_IMAGE, image);
            }
        }
        model.addAttribute("myMemes", myMemes);
        populateCommonModelAttributes(model);
        return CommonConstants.PAGE_USER_PROFILE;
    }
}
