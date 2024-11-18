package api.utfpr.projeto2.dtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import api.utfpr.projeto2.models.User;
import lombok.ToString;

@ToString
public class UserDto {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private String name;
    private String email;
    private String password;
    private Integer type;

    public UserDto(String name, String email, String password, Integer type) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.name = name;
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User userObject(){
        return new User(name, email, passwordEncoder.encode(password), type);
    }
}
