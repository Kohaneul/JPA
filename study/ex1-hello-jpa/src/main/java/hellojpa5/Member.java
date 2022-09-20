package hellojpa5;

import javax.persistence.*;

@Entity
public class Member {
    @Id
    @Column(name="MEMBER_ID")
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;
    @Column(name="USER_NAME")
    private String userName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
