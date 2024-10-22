package api.utfpr.projeto2.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class LoginResponseDto {
    
    private String token;
    private long expiresIn;

    public static LoginResponseDto loginDto(String token, long expirationTime){
        return new LoginResponseDto(token, expirationTime);
    }
}
