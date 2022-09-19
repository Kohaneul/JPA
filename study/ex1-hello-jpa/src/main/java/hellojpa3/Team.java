package hellojpa3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(name="TEAM_SEQ_GENERATOR", sequenceName = "TEAM_SEQ",initialValue = 1)
public class Team {
    @Id
    @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team")   //Member에는 Team team으로 되어있기 때문에 참조값으로 team을 기재함
    private List<Member> members = new ArrayList<>();   //member <-> team 탐색 가능(여기선 읽기만 가능함)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void addMember(Member member) {
       member.setTeam(this);
       members.add(member);
    }

}
