package api.utfpr.projeto2.models;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "teachesmessages")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class TeacherMessage implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "teacher", referencedColumnName = "id")
    private Teacher teacher;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "message", referencedColumnName = "id")
    private Message message;

    @Basic(optional = false)
    @Column(name = "read")
    private Boolean read;

    public TeacherMessage(Teacher teacher, Message message, Boolean read){
        this.teacher = teacher;
        this.message = message;
        this.read = read;
    }
}
