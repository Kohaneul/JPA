package hellojpa2;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

//@Entity
public class MemberTest {
//    @Id @GeneratedValue
//    private Long id;
//    @Column(name="name",nullable = false)    // DB 컬럼명은 name , nullable => not null 제약조건
//    private String userName;    //직접 제약조건을 넣고 싶을때 columnDefinition = "varchar(100) default 'EMPTY'"
//    private Integer age;
//    @Enumerated(EnumType.STRING)   //ENUM타입을 쓰고싶을때 EnumType.ORDINAL(ENUM 순서를 DB 에 저장)=>enum 타입 추가될때 인덱스에 영향이 있음. 사용 X
//    private RoleType roleType;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    private LocalDate testLocalDate;    //연,월
//    private LocalDateTime testLocalDateTime;    //연,월,일
//
//
//    @Transient  //해당 컬럼 매핑 무시
//    private int temp;
//
//    @Lob    //VARCHAR 보다 큰 컨텐츠를 넣고 싶을때 Lob 사용
//    private String description;
//    public MemberTest() {}
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public RoleType getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(RoleType roleType) {
//        this.roleType = roleType;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public Date getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Date lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
}
