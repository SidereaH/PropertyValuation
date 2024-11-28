package com.propertyvaluation.main.controllers;

import com.propertyvaluation.main.PropertyValuationApplication;
import com.propertyvaluation.main.dal.DataAccessLayer;
import com.propertyvaluation.main.dto.SigninClientRequest;
import com.propertyvaluation.main.dto.SignupClientRequest;
import com.propertyvaluation.main.models.Client;
import com.propertyvaluation.main.security.JwtCore;
import com.propertyvaluation.main.service.ClientDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
@Slf4j
@RestController
@RequestMapping("/auth")
public class SecurityController {
    private final ClientDetailsServiceImpl userService;
    @Autowired
    public SecurityController(ClientDetailsServiceImpl userService) {
        this.userService = userService;
    }

    private DataAccessLayer dataAccessLayer;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtCore jwtCore;

    @Autowired
    public void setDataAccessLayer(DataAccessLayer dataAccessLayer) {
        this.dataAccessLayer = dataAccessLayer;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @Autowired
    public void setJwtCore(JwtCore jwtCore) {
        this.jwtCore = jwtCore;
    }


    @PostMapping("/signup/client")
    ResponseEntity<?> signup(@RequestBody SignupClientRequest signupRequest){
        if (dataAccessLayer.existsClientByUsername(signupRequest.getUsername())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }
        if (dataAccessLayer.existsClientByEmail(signupRequest.getEmail())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already exists");
        }

        Client client = new Client();
        client.setUsername(signupRequest.getUsername());
        client.setFirstName(signupRequest.getFirstName());
        client.setLastName(signupRequest.getLastName());
        client.setMiddleName(signupRequest.getMiddleName());
        client.setBirthDate(signupRequest.getBirthDate());
        client.setPhone(signupRequest.getPhone());
        client.setEmail(signupRequest.getEmail());
        client.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        dataAccessLayer.createClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @PostMapping("/signin/client")
    ResponseEntity<?> signin(@RequestBody SigninClientRequest signinRequest) {
//        UserDetails user = userService.loadUserByUsername(signinRequest.getUsername());
//
//        if (Objects.equals(user, null) || !Objects.equals(user.getPassword(), signinRequest.getPassword())) {
//            log.info("Ошибка авторизации пользователя " + signinRequest.getUsername());
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
//        String jwt = jwtCore.generateToken(user);
//
//        PropertyValuationApplication.currentClient = userService.loadUserEntityByUsername(signinRequest.getUsername());
//        log.info("Вход прошёл успешно");
//        return ResponseEntity.ok(jwt);
        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getUsername(), signinRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtCore.generateToken(authentication);
        return ResponseEntity.status(HttpStatus.OK).body(jwt);
    }
}