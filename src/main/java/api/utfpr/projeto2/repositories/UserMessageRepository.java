package api.utfpr.projeto2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.utfpr.projeto2.models.UserMessage;

public interface UserMessageRepository extends JpaRepository<UserMessage,Integer> {
    
    @Query(value = "SELECT * FROM usersmessages WHERE user = ?", nativeQuery = true)
    public List<UserMessage> findByUser(Integer user);
}
