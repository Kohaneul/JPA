package hellojpa8;


import hellojpa5.Address;

public class JpaMain8 {

    public static void main(String[] args) {

    int a = 10;
    int b = 10;

    System.out.println("(a==b) = " + (a==b));   //값을 비교 => TRUE

    Address address1 = new Address("city","street","zipCode");
    Address address2 = new Address("city","street","zipCode");
    System.out.println("address2 = " + (address1==address2));        //참조값(REFERENCE) 비교 => FALSE
    System.out.println("EQUALS " + (address1.equals(address2)));        // equals 메소드 오버라이드 후 값 타입 비교 => true


    }
}
