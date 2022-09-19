package hellojpa1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();//트랜잭션
        tx.begin();
        try{
            Member member1 = new Member();
            member1.setUserName("AA");
            Member member2 = new Member();
            member2.setUserName("BB");
            Member member3 = new Member();
            member3.setUserName("CC");
            System.out.println(" ==========================" );
            //    call next value for MEMBER_SEQ  PK값 얻기 위해  커밋 전 시퀀스 값을 불러옴
//            em.persist(member); //@GeneratedValue(strategy = GenerationType.IDENTITY 일 경우 커밋 전에 쿼리 날림
            em.persist(member1);    //1 , DB : 51
            em.persist(member2);    // DB 호출X , MEMORY
            em.persist(member3);    // DB 호출X , MEMORY

            System.out.println("member1.getId() = " + member1.getId());
            System.out.println("member2.getId() = " + member2.getId());
            System.out.println("member3.getId() = " + member3.getId());


            // DB SEQ = 1  |  1
            // DB SEQ = 51 |  2
            // DB SEQ = 51 |  3

            System.out.println(" ==========================" );
            tx.commit();    //트랜잭션 커밋 시점에 INSERT 쿼리 날라옴
        }
        catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        finally{
            em.close();
        }
        emf.close();
    }
}
