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

import api.utfpr.projeto2.dtos.UserDto;
import api.utfpr.projeto2.dtos.UserResponseDto;
import api.utfpr.projeto2.models.User;
import api.utfpr.projeto2.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserDto userDto){
        return UserResponseDto.userDto(this.userService.createUser(userDto.userObject()));
    }

    @GetMapping
    public List<UserResponseDto> getAllUsers(){
        List<User> users = this.userService.getAllUsers();
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for(User user : users){
            userResponseDtos.add(UserResponseDto.userDto(user));
        }
        return userResponseDtos;
    }

    @GetMapping("/{email}")
    public UserResponseDto getUser(@PathVariable String email){
        return UserResponseDto.userDto(this.userService.getUserByEmail(email));
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Integer id, @RequestBody UserDto userDto){
        return UserResponseDto.userDto(this.userService.updateUser(id, userDto.userObject()));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        this.userService.deleteUser(id);
    }
}
