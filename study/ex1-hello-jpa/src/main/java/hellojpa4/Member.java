package hellojpa4;

import javax.persistence.*;

@Entity
public class Member {   //id, name

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    @Column(name="USERNAME")
    private String userName;


    @ManyToOne @JoinColumn(name="TEAM_ID",insertable = false,updatable = false)
    @JoinColumn
    private Team team;
    public Member(){}



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
