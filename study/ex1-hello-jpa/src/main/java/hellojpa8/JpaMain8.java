package hellojpa8;


import hellojpa5.Address;
import hellojpa5.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
public class JpaMain8 {

    public static void main(String[] args) {
//
//    int a = 10;
//    int b = 10;
//
//    System.out.println("(a==b) = " + (a==b));   //값을 비교 => TRUE
//
//    Address address1 = new Address("city","street","zipCode");
//    Address address2 = new Address("city","street","zipCode");
//    System.out.println("address2 = " + (address1==address2));        //참조값(REFERENCE) 비교 => FALSE
//    System.out.println("EQUALS " + (address1.equals(address2)));        // equals 메소드 오버라이드 후 값 타입 비교 => true
//

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member = new Member();
            member.setUserName("member1");
            member.setHomeAddress(new Address("homeCity","state","111111"));

            member.getFavoriteFoods().add("치킨");
            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");

            member.getAddressHistory().add(new AddressEntity("city1","111","11111"));
            member.getAddressHistory().add(new AddressEntity("city1","222","2222"));


            em.persist(member);

            em.flush();
            em.clear();

            System.out.println(" ====================== START ====================== ");
            Member findMember = em.find(Member.class, member.getId());

//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address = " + address.getCity());
//            }
//            System.out.println("=====================================================");
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }
            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("new City",a.getStreet(),a.getZipCode()));
            //값타입은 불변해야 하기 때문에 수정할때 setter 로 수정 불가! new 로 다시 객체 생성하는 방법으로 해줘야함

//            //치킨->한식으로
//            //치킨의 값을 remove 하고
//            findMember.getFavoriteFoods().remove("치킨");
//            //한식을 넣는다.
//            findMember.getFavoriteFoods().add("한식");

            System.out.println("===================== ADDRESS ========================");
//            findMember.getAddressHistory().remove(new Address("old1","state","11111"));
//            findMember.getAddressHistory().add(new Address("newCity1","street","100000"));
//
//            //주소 변경
//            List<Address> addresses = findMember.getAddressHistory();


            tx.commit();
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
