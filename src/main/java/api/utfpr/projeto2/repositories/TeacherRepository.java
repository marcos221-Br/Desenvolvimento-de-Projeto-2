package api.utfpr.projeto2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.utfpr.projeto2.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    
    public Teacher findByEmail(String email);
}
