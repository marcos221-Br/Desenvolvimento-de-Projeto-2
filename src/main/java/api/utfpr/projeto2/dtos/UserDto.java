package api.utfpr.projeto2.dtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import api.utfpr.projeto2.models.User;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserDto {

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private String name;
    private String email;
    private String password;
    private Integer type;

    public User userObject(){
        return new User(name, email, passwordEncoder.encode(password), type);
    }
}
