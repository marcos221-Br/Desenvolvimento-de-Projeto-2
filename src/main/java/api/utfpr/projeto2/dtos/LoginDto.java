package api.utfpr.projeto2.dtos;

import api.utfpr.projeto2.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class LoginDto {
    
    private String email;
    private String password;

    public User userObject(){
        return new User(email, password);
    }
}
