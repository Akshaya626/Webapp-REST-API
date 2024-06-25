package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.RegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@Api(tags = "Registration API")
public class RegisterController {

    private final RegisterService userService;

    @Autowired
    public RegisterController(RegisterService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Register a new user")
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user.getName(), user.getEmailId(), user.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
}
