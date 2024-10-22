package api.utfpr.projeto2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import api.utfpr.projeto2.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    
    public Optional<User> findByEmail(String email);
}
