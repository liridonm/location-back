package com.test.location.controller;

import com.test.location.model.User;
import com.test.location.model.jwt.AuthenticationRequest;
import com.test.location.model.jwt.AuthenticationResponse;
import com.test.location.service.UserService;
import com.test.location.util.JwtUtil;
import com.test.location.util.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Response> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        String password = authenticationRequest.getPassword();
        String username = authenticationRequest.getUsername();
        try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Bad Credentials!");
        }

        String jwtToken = jwtUtil.generateToken(userService.readByUsername(username), username);
        Response response = Response.builder().success(true).message("Login Successfully!").data(new AuthenticationResponse(jwtToken)).code(200).build();
        return ResponseEntity.ok(response);

    }

    @PostMapping("/create-user")
    public ResponseEntity<Response> createUser(@RequestBody User user) throws Exception {
        User userCreated = userService.create(user);
        try {
            Response response = Response.builder()
                    .success(true)
                    .code(200)
                    .message("User has been created successfully!")
                    .data(userCreated)
                    .build();
            return ResponseEntity.ok(response);
        }catch (Exception e) {
            throw new Exception("Failed to create user!");
        }

    }
}
