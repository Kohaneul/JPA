package hellojpa5;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)   //InheritanceType.SINGLE_TABLE 은 DiscriminatorColumn이 필수로 생성됨.
@DiscriminatorColumn    //dtype이라는 컬럼이 생기고 디폴트로 엔티티 명이 들어가게 된다.
public abstract class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
