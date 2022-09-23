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
    @ManyToOne(fetch=FetchType.LAZY)    //프록시객체로 조회한다... Member 클래스만 db에서 조회
    @JoinColumn(name="TEAM_ID")
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
