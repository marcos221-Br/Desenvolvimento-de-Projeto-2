package api.utfpr.projeto2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.utfpr.projeto2.models.Message;

public interface MessageRepository extends JpaRepository<Message,Integer> {
    
}
