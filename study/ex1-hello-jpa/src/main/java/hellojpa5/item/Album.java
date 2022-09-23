package hellojpa5.item;
import hellojpa5.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("A")    //디폴트로는 엔티티 이름이 들어가게 됨.
public class Album extends Item {
    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
