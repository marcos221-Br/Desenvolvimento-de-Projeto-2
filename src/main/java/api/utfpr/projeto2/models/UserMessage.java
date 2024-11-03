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
@Table(name = "usersmessages")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserMessage implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    @Basic(optional = false)
    @ManyToOne
    @JoinColumn(name = "message", referencedColumnName = "id")
    private Message message;

    @Basic(optional = false)
    @Column(name = "messageread")
    private Boolean read;

    public UserMessage(User user, Message message, Boolean read){
        this.user = user;
        this.message = message;
        this.read = read;
    }
}
