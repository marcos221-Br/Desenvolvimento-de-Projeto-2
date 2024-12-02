package api.utfpr.projeto2.dtos;

import java.util.ArrayList;
import java.util.List;

import api.utfpr.projeto2.models.Message;
import api.utfpr.projeto2.models.User;
import api.utfpr.projeto2.models.UserMessage;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserMessageDto {
    
    private List<User> users;
    private Message message;
    private Boolean read;

    public List<UserMessage> userMessageObject(){
        List<UserMessage> userMessages = new ArrayList<>();
        for (User user : users) {
            userMessages.add(new UserMessage(user, message, read));
        }
        return userMessages;
    }
}
