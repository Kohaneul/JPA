//package hellojpa5;
//
//
//import hellojpa5.item.Album;
//import hellojpa5.item.Book;
//import hellojpa5.item.Movie;
//import org.hibernate.Hibernate;
//import org.hibernate.LazyInitializationException;
//import org.hibernate.jpa.internal.PersistenceUnitUtilImpl;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.List;
//
//public class JpaMain {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        try{
//
//            Team team = new Team();
//            team.setName("team");
//            em.persist(team);
//
//            Team team1 = new Team();
//            team1.setName("teamA");
//            em.persist(team1);
//
//
//
//
//            Member member1 = new Member();
//            member1.setUserName("member1");
//            member1.setTeam(team1);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUserName("member2");
//            member2.setTeam(team);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
////            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class).getResultList();
//
///*
//            Member m = em.find(Member.class, member1.getId());
//            System.out.println("m.getClass() = " + m.getClass());   //프록시 x
//
//            System.out.println("m = " + m.getTeam().getClass());    //프록시로 조회된다.
//            System.out.println("=====================================================");
//            m.getTeam().getName();      // 이 시점에서 쿼리가 나감.
//            System.out.println("m.getTeam().getName() = " + m.getTeam().getName());
//            System.out.println("=====================================================");
//
//*/
///*
//
////            JPA 는 == 비교에 대하여 무조건 TRUE로 보장해주어야 한다.
////
////            Member refMember = em.getReference(Member.class, member1.getId());    //프록시 초기화
////            System.out.println("refMember = " + refMember.getClass());
////
////            Member findMember = em.find(Member.class, member1.getId());
////            System.out.println("findMember = " + findMember.getClass());    //프록시 객체로 나옴
////
////            System.out.println("****findMember==refMember**** = " + (findMember==refMember));   //무조건 참으로 보장해줘야함.
////
////
////            Member m1 = em.find(Member.class, member1.getId()); // 영속성 컨텍스트에 이미 올라온 상태
////            System.out.println("m1 = " + m1.getClass());
////            Member m1_ref= em.getReference(Member.class, member1.getId());
////            System.out.println("m1_ = " + m1_ref.getClass());
////            System.out.println("(m1==m1_) = " + (m1==m1_ref));
////            System.out.println(" = =================" );
////            Member m2 = em.getReference(Member.class,member2.getId());
////            System.out.println("m2 = " + m2.getClass());
////
////            proxyMember(m2);
////            Member member = new Member();
////            member.setUserName("hello");
////            em.persist(member);
////
////            em.flush();
////            em.clear();
//
//           // Member findMember = em.find(Member.class, member.getId());
////            Member findMember = em.getReference(Member.class,member.getId());   //호출되는 시점에는 쿼리를 날리지 않음
////           System.out.println("findMember = " + findMember.getClass());//하이버네이트가  내부라이브러리 통해 가짜객체(프록시)생성
////            System.out.println("findMember.getId() = " + findMember.getId());      //쿼리x : 이미 조회할때 id값을 넣었음 =>db에서 조회하지 않아도 알 수 있음
////            System.out.println("findMember.getUserName() = " + findMember.getUserName());//db에서 조회해야함 => 해당 부분을 시작하는 시점에는 쿼리가 날라감
//
////            영속성 컨텍스트의 도움을 받을 수 없는 준영속상태일떄 프록시를 초기화하면 문제 발생
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember.getClass() = " + refMember.getClass());   //Proxy
////            refMember.getUserName();    //강제 호출
//
//
//            Hibernate.initialize(refMember);    //refMember강제초기화
//
//            //emf.getPersistenceUnitUtil().isLoaded : 프록시 인스턴스의 초기화 여부 확인
//            System.out.println("isLoaded(refMember) = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
//            em.detach(refMember);   //영속성 컨텍스트에서 더이상 관리 안한다.
//
//            refMember.getUserName();
////          LazyInitializationException 발생 : 영속성 컨텍스트를 통해서 실제 데이터를 불러와야하는데 제외시키는 바람에 가지고 올 수 없다.
//
//         //   System.out.println("refMember = " + refMember.getClass());
//*/
//            tx.commit();
//        }
//        catch(Exception e){
//            tx.rollback();
//            e.printStackTrace();
//        }
//        finally{
//            em.close();
//        }
//        emf.close();
//    }
//    private static void proxyMember(Member member2){
//        System.out.println("member2(Proxy) instanceof Member class = " +(member2 instanceof Member));
//        //프록시 객체는== 비교가 아닌 instanceof로 비교
//    }
//
//    private static void printMemberAndTeam(Member member){
//        String userName = member.getUserName();
//        System.out.println("userName = " + userName);
//        Team team = member.getTeam();
//        System.out.println("team = " + team);
//
//    }
//
//}
