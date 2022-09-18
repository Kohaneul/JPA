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

        try {
//            Member member1 = new Member(150L,"A");
//            Member member2 = new Member(160L,"B");
//
//            //영속성 컨텍스트에 쿼리가 생성되어 차곡차곡 쌓임
//            em.persist(member1);
//            em.persist(member2);
            Member findMember1 = em.find(Member.class, 150L);   //찾아온 다음
            findMember1.setName("ZZZZZ");   //데이터 변경


            System.out.println("=================================================");
            tx.commit();    //쿼리가 나감


        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
//        try {
//        //비영속 상태
////            Member member = new Member();
////            member.setId(101L);
////            member.setName("hello");
////
////            //영속상태 : EntityManager 안에 있는 영속성 컨텍스트에 의해서 member 객체가 관리되는 상태
////            System.out.println("**********************BEFORE**********************");
////            em.persist(member); //아직 db에 저장되지 않음.
////            System.out.println("**********************AFTER**********************");
////            Member findMember = em.find(Member.class, 101L);    //1차캐시에서 저장했기 때문에 먼저 1차캐시에 있는것을 조회
////            System.out.println("findMember.getId() = " + findMember.getId());
////            System.out.println("findMEmber.getName() = " + findMEmber.getName());
//
//        Member findMember1 = em.find(Member.class, 101L);
//        Member findMember2 = em.find(Member.class, 101L);    //1차캐시에서 저장했기 때문에 먼저 1차캐시에 있는것을 조회
//
//        System.out.println("(findMember1==findMember2) = " + (findMember1==findMember2));
//
//        tx.commit();    //트랜잭션 커밋하는 상태에 db에 쿼리(insert)가 날라감.
//    } catch (Exception e) {
//        tx.rollback();
//    } finally {
//        em.close();
//    }
//}






//
//        try{
//
////            Member findMember = em.find(Member.class, 1L);
////            //JPA를 통해서 엔티티를 가져오면 그 뒤로부터는 JPA가 관리함.
////            findMember.setName("HelloJPA");
////            //변경이 되었는지 안되었는지 트랜잭션이 커밋한 시점에 다 체크함.   변경이 된게 확인이 된다면 트랜잭션 커밋직전에 update 쿼리를 날려서 변경 후 커밋
//
//            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();
//            //Member 는 테이블이 아닌, 객체가 대상이 된다.
//
//            for (Member member : result) {
//                System.out.println("member = " + member.getId()+", "+member.getName());
//            }
//            tx.commit();
//        }
//        catch(Exception e){
//            tx.rollback();
//        }
//        finally{
//            em.close(); //자원을 다쓰면 반환
//        }
//        emf.close();
//
    }
