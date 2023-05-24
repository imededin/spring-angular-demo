package com.project.backend.controller;

import com.project.backend.model.User;
import com.project.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/add")
    public String adduser(@RequestBody User user){
        userService.addUser(user);
        return "User Added Successfully...";
    }

    @GetMapping("/api/users")
    public List<User> getUsers(){
        System.out.println("Users..");
        return userService.getUser();
    }

    @GetMapping("/api/user/{id}")
    public User getUserById(@PathVariable("id") int id){
        return userService.getUserByid(id);
    }

    @PutMapping("/api/update/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User user){
        userService.updateUser(id, user);
        return "User Updated Successfully...";
    }

    @DeleteMapping("/api/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return "User Deleted Successfully...";
    }
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello!";
    }

}
