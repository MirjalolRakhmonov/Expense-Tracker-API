package com.mirjalolcode.expensetracker.rest;

import com.mirjalolcode.expensetracker.model.User;
import com.mirjalolcode.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody UserLoginRequest request) {

        User user = userService.validateUser(request.getEmail(), request.getPassword());

        Map<String, String> map = new HashMap<>();
        map.put("message", "loggedIn successfully");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody UserRegistrationRequest request) {

        userService.registerUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword());

        Map<String, String> map = new HashMap<>();
        map.put("message", "registered successfully");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
