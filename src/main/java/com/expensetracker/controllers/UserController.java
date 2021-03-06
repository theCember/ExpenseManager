package com.expensetracker.controllers;

import com.expensetracker.entities.ActionStatus;
import com.expensetracker.entities.User;
import com.expensetracker.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/createacc")
    public String showUserCreatorView(Model model){
        model.addAttribute("user", new User());
        return "user-creator";
    }

    @RequestMapping("/submitacc")
    public ModelAndView submitCreationForm(@Valid User user, Errors errors, Model model) {

        ModelAndView mav = new ModelAndView();

        if(errors.hasErrors()){
            mav.addObject("user", user);
            mav.setViewName("user-creator");
            return mav;
        }

        userService.insertOrUpdatePerson(user);
        mav.setViewName("redirect:/");
        return mav;
    }

    /*@RequestMapping("/signin")
    public String showUserSignInView(){
        return "sign-in";
    }*/

    @RequestMapping("/showall")
    public String showAllUsersList(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "all-users";
    }
}