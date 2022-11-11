package hellojpa5;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Member{
    @Id
    @Column(name="MEMBER_ID")
    @GeneratedValue
    private Long id;

    @Column(name="USER_NAME")
    private String userName;

    @ManyToOne(fetch=FetchType.LAZY)    //프록시객체로 조회한다... Member 클래스만 db에서 조회
    @JoinColumn(name="TEAM_ID")
    private Team team;

    //기간 : Period
    @Embedded
    private Period period;

    //주소
    @Embedded
    private Address homeAddress;

//    @Embedded   //주소 =>두개를 만들시,
//    @AttributeOverrides({
//            @AttributeOverride(name="city", column=@Column(name="WORK_CITY")),
//            @AttributeOverride(name="street", column=@Column(name="WORK_STREET")),
//            @AttributeOverride(name="zipCode",column=@Column(name="WORK_ZIPCODE"))
//    })
//    private Address workAddress;
//
//    public Address getWorkAddress() {
//        return workAddress;
//    }
//
//    public void setWorkAddress(Address workAddress) {
//        this.workAddress = workAddress;
//    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

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
