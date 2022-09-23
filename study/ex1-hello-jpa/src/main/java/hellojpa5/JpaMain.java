package hellojpa5;


import hellojpa5.item.Album;
import hellojpa5.item.Book;
import hellojpa5.item.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
           Member member = new Member();
           member.setCreatedBy("ko");
           member.setCreatedDate(LocalDateTime.now());
           member.setUserName("K H N");
           member.setLastModifiedBy("efwfefaafw");
            em.persist(member);
            em.flush();
            em.clear();
            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
        }
        finally{
            em.close();
        }
        emf.close();
    }
}
