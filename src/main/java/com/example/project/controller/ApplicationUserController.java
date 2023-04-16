package com.example.project.controller;

import com.example.project.Model.ApplicationUser;
import com.example.project.security.JwtUtil;
import com.example.project.service.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ApplicationUserController {

    private final ApplicationUserService service;
    private final JwtUtil jwtutil;
    private final AuthenticationManager authmanager;

    @Autowired
    public ApplicationUserController(ApplicationUserService service, JwtUtil jwtutil,
                                     AuthenticationManager authmanager) {
        this.service = service;
        this.jwtutil = jwtutil;
        this.authmanager = authmanager;
    }


    @PostMapping(value = "/register", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> register(@RequestBody ApplicationUser user) {
        service.saveUsers(user);
        Map<String, String> result = new HashMap<>();
        result.put("message", "Registeraion sucessful");
        return result;
    }

    @PostMapping(value = "/signin", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> signIn(@RequestBody ApplicationUser user) {
        try {
            authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.user_name, user.password));
        } catch (Exception e) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("message", "Invalid cretentials");
            return map;
        }

        String token = jwtutil.generateToken(user.user_name);
        Map<String, String> map = new HashMap<String, String>();
        map.put("message", "Authentication sucessfull!");
        map.put("token", token);
        map.put("id", user.user_name);

        return map;
    }

    @GetMapping(value = "/viewprofile/{userId}")
    @ResponseBody
    public Optional<ApplicationUser> viewProfile(@PathVariable(name = "userId") String userId) {
        return service.viewprofile(userId);
    }

    @GetMapping(value = "/editprofile/{userId}")
    @ResponseBody
    public void editProfile(@PathVariable(name = "userId") String userId) {

    }

}
