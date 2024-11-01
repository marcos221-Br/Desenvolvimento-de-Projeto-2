package api.utfpr.projeto2.dtos;

import api.utfpr.projeto2.models.Message;
import api.utfpr.projeto2.models.UserMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserMessageResponseDto {
    
    private Integer id;
    private UserResponseDto user;
    private Message message;

    public static UserMessageResponseDto userMessageDto(UserMessage userMessage){
        return new UserMessageResponseDto(userMessage.getId(), UserResponseDto.userDto(userMessage.getUser()), userMessage.getMessage());
    }
}
