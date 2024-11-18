package api.utfpr.projeto2.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import api.utfpr.projeto2.models.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    
    public Optional<User> findByEmail(String email);

    @Query(value = "SELECT * FROM users WHERE type=?", nativeQuery = true)
    public List<User> findAllUsersByType(Integer type);
}
