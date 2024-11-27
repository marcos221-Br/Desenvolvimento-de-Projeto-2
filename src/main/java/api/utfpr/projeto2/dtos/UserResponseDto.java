package api.utfpr.projeto2.dtos;

import api.utfpr.projeto2.models.Role;
import api.utfpr.projeto2.models.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserResponseDto {
    
    private Integer id;
    private String name;
    private String email;
    private Role type;

    public static UserResponseDto userDto(User user){
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getType());
    }
}
