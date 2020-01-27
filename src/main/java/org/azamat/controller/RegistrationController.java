//package org.azamat.controller;
//
//import org.azamat.model.securitymodel.User;
//import org.azamat.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class RegistrationController {
//    @Autowired
//    UserRepository userRepository;
//
//    @GetMapping("/registration")
//    public String registration() {
//        return "registration";
//    }
//    @PostMapping("/registration")
//    public String addUser(User user, Model model) {
////        User userDB = userRepository.findByUsername(user.getUsername());
//////        Role role =
////        if (userDB != null) {
////            model.addAttribute("message", "User exists!");
////            return "registration";
////        }
//
////        user.setActive(true);
////        user.setRoles((Role.USER));
//
//
//        return "redirect:/login";
//    }
//}
