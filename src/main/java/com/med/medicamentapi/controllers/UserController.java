package com.med.medicamentapi.controllers;


import com.med.medicamentapi.model.UserModel;
import com.med.medicamentapi.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")

public class UserController {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @GetMapping("/users")
//    public String userView(Model model){
//        model.addAttribute("user_list", userRepository.findAll());
//        return "indexUser";
//    }
    private final UserService UserService;

    @Autowired
    public UserController(UserService UserRepository){
        this.UserService = UserRepository;
    }
    @PreAuthorize("hasAnyAuthority('ADMIN', 'DOCTOR')")
    @GetMapping("/all")
    public List<UserModel> getAllUsers() {
        return UserService.getAll();
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/{username}")
    public UserModel userView(@PathVariable String username){
        return UserService.getByUsername(username);
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void getIdAttachment(@PathVariable("id") UUID id) {
        UserService.deleteUserById(id);
    }
//
//    @GetMapping("/users/{id}/update")
//    public String updateView(@PathVariable UUID id, Model model){
//        UserModel user = userRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Пользователя не существует с ID: " + id));
//        model.addAttribute("user_object", user);
////        model.addAttribute("roles", RoleEnum.values());
//        return "updateUser";
//    }
//
//
    @PutMapping("/update/{id}")
    public UserModel updateUser(@RequestBody UserModel userModel) {

        UserService.save(userModel);
        return userModel;
    }
}
