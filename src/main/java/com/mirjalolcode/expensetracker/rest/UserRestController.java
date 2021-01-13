package com.mirjalolcode.expensetracker.rest;

import com.mirjalolcode.expensetracker.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Void> loginUser(@RequestBody UserLoginRequest request) {

        userService.validateUser(request.getEmail(), request.getPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody @Valid UserRegistrationRequest request) {
        userService.registerUser(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword());

        return new ResponseEntity<>(new UserRegistrationResponse("registered successfully"), HttpStatus.OK);
    }
}