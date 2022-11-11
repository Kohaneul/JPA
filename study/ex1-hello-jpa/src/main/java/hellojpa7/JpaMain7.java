package hellojpa7;

import hellojpa5.Address;
import hellojpa5.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain7 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            Address address =  new Address("city","street","10000");
            Member member = new Member();
            member.setUserName("member1");
            member.setHomeAddress(address);
            em.persist(member);

            //address의 값 복사
            Address copyAddress =  new Address(address.getCity(), address.getStreet(), address.getZipCode());

            Member member2 = new Member();
            member2.setUserName("member2");
            member2.setHomeAddress(copyAddress);
            em.persist(member2);

            //Embeded 타입의 경우 공유를 하게되면 값 변경시 동시에 바뀜
            //만약 공유를 하고싶다면 Entity로 만들어야 한다.
          //  member.getHomeAddress().setCity("new City");  // 동시에 바뀜

        // Embeded 는 무조건 불변 객체로 만든다.
            //1.  수정자(Setter) 삭제
            //2. 생성자를 통한 초기화

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
