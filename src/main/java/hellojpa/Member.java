package hellojpa;

import javax.persistence.*;

@Entity
//@Table(name="MBR")  //DB 테이블의 이름이 MBR과 동일하게 나감
//@Table(name="USER") //테이블 이름이 다를경우
public class Member {
    @Id
    private Long id;
    @Column(unique = true,length = 10)  //unique 제약조건, 10자까지
    private String name;



    public Member() { } //반드시 기본생성자 만들어줘야함

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }



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
}
