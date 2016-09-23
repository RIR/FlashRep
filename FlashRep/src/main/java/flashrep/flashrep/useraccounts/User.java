package flashrep.flashrep.useraccounts;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Raine Rantanen
 */
public class User {

    private String userName;
    private String password;
    private List<FlashcardCollection> ownCollections;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.ownCollections = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void rateCard(Flashcard flashcard, int rating) {
        flashcard.setRating(rating);
    }

    public void addToOwnCollections(FlashcardCollection flashcardCollection) {
        this.ownCollections.add(flashcardCollection);
    }

    public void removeFromOwnCollections(FlashcardCollection flashcardCollection) {
        this.ownCollections.remove(flashcardCollection);
    }

    public List<FlashcardCollection> getOwnCollections() {
        return ownCollections;
    }

    public void setOwnCollections(List<FlashcardCollection> collections) {
        this.ownCollections = collections;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

}
