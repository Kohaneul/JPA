package hellojpa5;


import hellojpa5.item.Album;
import hellojpa5.item.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            Movie movie = new Movie();
            movie.setName("바람 웅앵");
            movie.setActor("actor A");
            movie.setPrice(5000);
            movie.setDirector("director A");

            Album album = new Album();
            album.setArtist("웅앵웅");
            album.setPrice(333333);
            album.setName("웅웅우앵");
            em.persist(album);
            em.persist(movie);
            em.flush();
            em.clear();

            Item findAlbum = em.find(Item.class, album.getId());
            System.out.println("findAlbum = " + findAlbum);
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
