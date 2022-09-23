//package hellojpa1;
//
//import javax.persistence.*;
//
////@SequenceGenerator(name="member_seq_generator",sequenceName = "member_seq")
////@Table(name="MBR")  //DB 테이블의 이름이 MBR과 동일하게 나감
////@Table(name="USER") //테이블 이름이 다를경우
////@Entity
////@SequenceGenerator(name="MEMBER_SEQ_GENERATOR",sequenceName = "MEMBER_SEQ"    //매핑할 데이터베이스 시퀀스이름
////        ,initialValue = 1)
////@TableGenerator(name="MEMBER_SEQ_GENERATOR",table="MY_SEQUENCES",pkColumnName = "MEMBER_SEQ",allocationSize = 1)
//public class Member {
////    @Id @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "MEMBER_SEQ_GENERATOR")
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MEMBER_SEQ_GENERATOR")
//    private Long id;
//    //  @Column(unique = true,length = 10)  //unique 제약조건, 10자까지
//    @Column(name="name",nullable = false)
//    private String userName;
//
//
//
//    public Member() { } //반드시 기본생성자 만들어줘야함
//
//    public Member(Long id, String userName) {
//        this.id = id;
//        this.userName = userName;
//    }
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
//}
//
