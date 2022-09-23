package jpabook.jpashop;

import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.Item.Album;
import jpabook.jpashop.domain.Item.Book;
import jpabook.jpashop.domain.Item.Item;

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

            Book book = new Book();
            book.setItemName("JPA");
            book.setAuthor("김영한");
            book.setUpdate(LocalDateTime.now());
            book.setUpload(LocalDateTime.now());

            em.persist(book);
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
