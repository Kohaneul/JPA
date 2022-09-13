package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();//트랜잭션
        tx.begin();

        try{

//            Member findMember = em.find(Member.class, 1L);
//            //JPA를 통해서 엔티티를 가져오면 그 뒤로부터는 JPA가 관리함.
//            findMember.setName("HelloJPA");
//            //변경이 되었는지 안되었는지 트랜잭션이 커밋한 시점에 다 체크함.   변경이 된게 확인이 된다면 트랜잭션 커밋직전에 update 쿼리를 날려서 변경 후 커밋

            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();
            //Member 는 테이블이 아닌, 객체가 대상이 된다.

            for (Member member : result) {
                System.out.println("member = " + member.getId()+", "+member.getName());
            }
            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
        }
        finally{
            em.close(); //자원을 다쓰면 반환
        }
        emf.close();

    }
}
