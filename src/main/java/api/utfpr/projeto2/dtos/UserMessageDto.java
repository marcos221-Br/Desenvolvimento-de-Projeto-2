package api.utfpr.projeto2.dtos;

import api.utfpr.projeto2.models.Message;
import api.utfpr.projeto2.models.User;
import api.utfpr.projeto2.models.UserMessage;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserMessageDto {
    
    private User user;
    private Message message;
    private Boolean read;

    public UserMessage userMessageObject(){
        return new UserMessage(user, message, read);
    }
}
