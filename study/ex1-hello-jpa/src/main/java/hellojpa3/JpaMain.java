//package hellojpa3;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.List;
//
//public class JpaMain {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        try{
//            //저장
//           Team team = new Team();
//           team.setName("TeamA");
//           em.persist(team);    //영속상태가 되면 pk값이 셋팅된 후 영속 상태가 된다.
//
//
//            Member member = new Member();
//            member.setUserName("member1");
//            //*** 참고  :  team.getMembers().add(member)만 입력하면 성립이 안된다. 왜냐하면 mappedBy라고 쓰여져있어서 읽기전용으로 JPA가 인식하기 떄문에
//            member.setTeam(team);
//            em.persist(member);
//
//            team.addMember(member); //연관관계 편의메서드
//
//            em.flush(); //쿼리 강제 호출
//            em.clear(); //영속성 컨텍스트 초기화 > DB에서 다시 조회
//
//
//            Team findTeam = em.find(Team.class, team.getId());  //1차캐시
//            List<Member> members = findTeam.getMembers();
//            System.out.println(" ============================= ");
//            for (Member member1 : members) {
//                System.out.println("member1.getUserName() = " + member1.getUserName());
//            }
//            System.out.println(" ============================= ");
//
////
////            Member findMember = em.find(Member.class, member.getId());
////            List<Member> members = findMember.getTeam().getMembers();
////            for (Member member1 : members) {
////                System.out.println("m = " + member1.getUserName());
////            }
//
//            tx.commit();
//        }
//        catch(Exception e){
//            tx.rollback();
//        }
//        finally{
//            em.close();
//        }
//        emf.close();
//    }
//}
