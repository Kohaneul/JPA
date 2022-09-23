package jpabook.jpashop;

import jpabook.jpashop.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
          Member memberA = new Member();
          memberA.setName("haneul Ko");
          memberA.setCity("Gun-po");
          memberA.setStreet("sanbon-ro");
          memberA.setZipCode("112545");
          em.persist(memberA);

          Order order1 = new Order();
          order1.setMember(memberA);
          order1.setOrderDate(LocalDateTime.now());
          order1.setStatus(OrderStatus.ORDER);
          em.persist(order1);

          Item item1 = new Item();
          item1.setItemName("snack");
          item1.setPrice(1000);
          item1.setStockQuantity(5);
          em.persist(item1);

          OrderItem orderItem1 = new OrderItem();
          orderItem1.setItem(item1);
          orderItem1.setOrder(order1);
          orderItem1.setOrderPrice(2000);
          em.persist(orderItem1);

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
