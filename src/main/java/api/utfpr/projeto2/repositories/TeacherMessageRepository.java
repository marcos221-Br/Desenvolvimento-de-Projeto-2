package api.utfpr.projeto2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import api.utfpr.projeto2.models.TeacherMessage;

public interface TeacherMessageRepository extends JpaRepository<TeacherMessage,Integer> {
    
    public TeacherMessage findByTeacher(Integer teacher);
}
