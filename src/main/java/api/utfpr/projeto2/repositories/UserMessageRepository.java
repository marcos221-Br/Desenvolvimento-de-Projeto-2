package api.utfpr.projeto2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.utfpr.projeto2.models.User;
import api.utfpr.projeto2.models.UserMessage;

public interface UserMessageRepository extends JpaRepository<UserMessage,Integer> {
    
    public UserMessage findByUser(User user);
}
