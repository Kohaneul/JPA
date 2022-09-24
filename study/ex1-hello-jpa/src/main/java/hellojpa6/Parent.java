package hellojpa6;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {
    @Id @GeneratedValue
    @Column(name="parent_id")
    private Long id;


//    @OneToMany(mappedBy = "parent",orphanRemoval = true)
    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Child> childList = new ArrayList<>();
     // CascadeType.ALL : 부모를 저장할때 연관되어있는 엔티티도 함께 저장한다
    //  주의사항 : 1. 라이프 사이클이 거의 유사할때, 2. 소유자가 하나일때만

    //orphanRemoval=true 부모관계를 삭제할때 해당되는 자식 객체도 함께 삭제
      private String name;


    public Parent() {
    }

    public Parent(String name) {
        this.name = name;
    }




    public void addChild(Child child){
          childList.add(child);
          child.setParent(this);
    }

    public List<Child> getChildList() {
        return childList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
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
