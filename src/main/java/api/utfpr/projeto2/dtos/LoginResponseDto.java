package api.utfpr.projeto2.dtos;

import api.utfpr.projeto2.models.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class LoginResponseDto {
    
    private String token;
    private long expiresIn;
    private UserResponseDto user;

    public static LoginResponseDto loginDto(String token, long expirationTime, User user){
        return new LoginResponseDto(token, expirationTime, UserResponseDto.userDto(user));
    }
}
