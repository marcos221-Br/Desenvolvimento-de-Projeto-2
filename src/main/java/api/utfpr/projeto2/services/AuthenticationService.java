package api.utfpr.projeto2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import api.utfpr.projeto2.models.User;
import api.utfpr.projeto2.repositories.UserRepository;

@Service
public class AuthenticationService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public User authenticate(User user){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        return userRepository.findByEmail(user.getEmail()).orElseThrow();
    }
}
