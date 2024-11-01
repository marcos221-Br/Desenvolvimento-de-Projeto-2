package api.utfpr.projeto2.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.utfpr.projeto2.dtos.UserMessageDto;
import api.utfpr.projeto2.dtos.UserMessageResponseDto;
import api.utfpr.projeto2.models.UserMessage;
import api.utfpr.projeto2.services.UserMessageService;

@RestController
@RequestMapping("/api/usermessage")
public class UserMessageController {
    
    @Autowired
    private UserMessageService userMessageService;

    @PostMapping
    public UserMessageResponseDto createUserMessage(@RequestBody UserMessageDto userMessageDto){
        return UserMessageResponseDto.userMessageDto(this.userMessageService.createUserMessage(userMessageDto.userMessageObject()));
    }

    @GetMapping
    public List<UserMessageResponseDto> getAllUserMessages(){
        List<UserMessage> userMessages = this.userMessageService.getAllUserMessages();
        List<UserMessageResponseDto> userMessageResponseDtos = new ArrayList<>();
        for (UserMessage userMessage : userMessages) {
            userMessageResponseDtos.add(UserMessageResponseDto.userMessageDto(userMessage));
        }
        return userMessageResponseDtos;
    }

    @GetMapping("/{user}")
    public List<UserMessageResponseDto> getUserMessages(@PathVariable Integer user){
        List<UserMessage> userMessages = this.userMessageService.getUserMessages(user);
        List<UserMessageResponseDto> userMessageResponseDtos = new ArrayList<>();
        for (UserMessage userMessage : userMessages) {
            userMessageResponseDtos.add(UserMessageResponseDto.userMessageDto(userMessage));
        }
        return userMessageResponseDtos;
    }

    @PutMapping("/{id}")
    public UserMessageResponseDto updateUserMessageResponse(@PathVariable Integer id, @RequestBody UserMessageDto userMessageDto){
        return UserMessageResponseDto.userMessageDto(this.userMessageService.updateUserMessage(id, userMessageDto.userMessageObject()));
    }

    @DeleteMapping("/{id}")
    public void deleteUserMessage(@PathVariable Integer id){
        this.userMessageService.deleteUserMessage(id);
    }
}
