package api.utfpr.projeto2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.utfpr.projeto2.models.UserMessage;
import api.utfpr.projeto2.repositories.UserMessageRepository;

@Service
public class UserMessageService {
    
    @Autowired
    private UserMessageRepository userMessageRepository;

    public UserMessage createUserMessage(UserMessage userMessage){
        return this.userMessageRepository.save(userMessage);
    }

    public List<UserMessage> getAllUserMessages(){
        return this.userMessageRepository.findAll();
    }

    public List<UserMessage> getUserMessages(Integer user) {
        return this.userMessageRepository.findByUser(user);
    }

    public UserMessage updateUserMessage(Integer id, UserMessage userMessage){
        userMessage.setId(id);
        return this.userMessageRepository.save(userMessage);
    }

    public void deleteUserMessage(Integer id){
        this.userMessageRepository.deleteById(id);
    }
}
