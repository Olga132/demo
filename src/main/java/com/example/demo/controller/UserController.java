package com.example.demo.controller;


import com.example.demo.db.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/userService")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path="/users")
    public @ResponseBody Iterable<User> getAll(){
        return userService.getAll();
    }

    @PostMapping(path = "/add")
    public String add(@RequestBody User user){
        userService.add(user);
        return "redirect:/userService/users";
    }

    @DeleteMapping(path = "/user/{id}")
    public String delete(@PathVariable Long id){
        userService.deleteById(id);
        return "redirect:/userService/users";
    }

    @PutMapping(path = "/user")
    public String update(@RequestBody User user){
        userService.update(user);
        return "redirect:/userService/users";
    }



}
