package api.utfpr.projeto2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.utfpr.projeto2.dtos.LoginDto;
import api.utfpr.projeto2.dtos.LoginResponseDto;
import api.utfpr.projeto2.models.User;
import api.utfpr.projeto2.services.AuthenticationService;
import api.utfpr.projeto2.services.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponseDto authenticate(@RequestBody LoginDto loginDto) {
        System.out.println(loginDto);
        User authenticatedUser = authenticationService.authenticate(loginDto.userObject());
        return LoginResponseDto.loginDto(jwtService.generateToken(authenticatedUser),jwtService.getExpirationTime());
    }
}
