package com.example.k_dish.web;

import com.example.k_dish.model.entity.User;
import com.example.k_dish.model.dto.JwtAuthenticationResponse;
import com.example.k_dish.model.dto.SignInRequest;
import com.example.k_dish.model.dto.SignUpRequest;
import com.example.k_dish.service.AuthenticationService;
import com.example.k_dish.service.impl.UserServiceImpl;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    protected HttpHeaders headers;
    private final AuthenticationService authenticationService;

    @PostConstruct
    private void init() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @PostMapping("/sign_up")
    public JwtAuthenticationResponse signUp(@RequestBody SignUpRequest request) {
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign_in")
    public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request) {
        return authenticationService.signIn(request);
    }
    @GetMapping
    public ResponseEntity<List<User>> get() {
        List<User> users = userService.read();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, headers, HttpStatus.OK);
    }

    @PutMapping("/get-admin")
    public void getAdmin() {
        userService.getAdmin();
    }

    public UserServiceImpl getService() {
        return userService;
    }
}
