package hellojpa5;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Member extends BaseEntity{
    @Id
    @Column(name="MEMBER_ID")
    @GeneratedValue
    private Long id;

    @Column(name="USER_NAME")
    private String userName;
    @ManyToOne
    @JoinColumn(name="TEAM_ID",insertable = false,updatable = false)
    private Team team;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
