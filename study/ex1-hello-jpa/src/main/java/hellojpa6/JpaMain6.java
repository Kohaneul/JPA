package hellojpa6;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain6 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            Child child1 = new Child("child1");
            Child child2 = new Child("child2");

            Parent parent = new Parent("ParentA");

            parent.addChild(child1);
            parent.addChild(child2);
            em.persist(parent);
//      parent에 CascadeType.ALL (부모 엔티티가 저장되면 자동적으로 자식 엔티티도 저장) 이라는 설정을 하였기 때문에 하기 코드는 작성하지 않아도 된다.
//            em.persist(child1);
//            em.persist(child2);
            em.flush();
            em.clear();
            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);    //orphanRemoval 동작하여 0번째 인덱스에 있는 데이터가 지워짐
            em.remove(findParent);  //부모객체가 지워지면 자식 객체도 다 지워짐(orphanRemoval 설정했기 떄문)
            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
        emf.close();


    }
}
