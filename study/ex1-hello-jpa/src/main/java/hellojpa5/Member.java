package hellojpa5;


import hellojpa8.AddressEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ElementCollection  //값 타입 컬렉션 =>영속성 전이 cascade + 고아객체 제거기능 필수로 가짐
    @CollectionTable(name = "FAVORITE_FOOD",joinColumns = @JoinColumn(name="MEMBER_ID"))
    @Column(name="FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="MEMBER_ID")
    private List<AddressEntity> addressHistory = new ArrayList<>();

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }


    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }
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
