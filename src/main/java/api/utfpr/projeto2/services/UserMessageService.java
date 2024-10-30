package api.utfpr.projeto2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.utfpr.projeto2.repositories.UserMessageRepository;

@Service
public class UserMessageService {
    
    @Autowired
    private UserMessageRepository userMessageRepository;
}
