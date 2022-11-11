package hellojpa8;

import hellojpa5.Address;

import javax.persistence.*;

@Entity
@Table(name="ADDRESS")
public class AddressEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Address address;

    public AddressEntity() {
    }

    public AddressEntity(String city,String street, String zipCode) {
        this.address = new Address(city,street,zipCode);
    }
}
