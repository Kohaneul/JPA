package hellojpa3;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

//@Entity
public class Member {   //id, name

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    @Column(name="USERNAME")
    private String userName;

    @ManyToOne(fetch=FetchType.LAZY)  //관계가 무엇인가 -> 하나의 팀에 여러 멤버가 소속되므로 N(Member) 대 1(Team)의 관계 성립
    @JoinColumn(name="TEAM_ID") //조인하는 칼럼은 무엇인가
    private Team team;  //연관관계의 주인

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

    public Team getTeam() {
        return team;
    }


    public void setTeam(Team team) {
        this.team = team;
    }


}
