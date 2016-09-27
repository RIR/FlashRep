package flashrep.flashrep.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Raine Rantanen
 */
public class AllFlashcardCollections implements Name {

    private List<FlashcardCollection> flashcardCollections;
    private String name;

    public AllFlashcardCollections() {
        this.flashcardCollections = new ArrayList<>();
    }

    public AllFlashcardCollections(String name) {
        this.flashcardCollections = new ArrayList<>();
        this.name = name;
    }

    public void addCollection(FlashcardCollection flashcardCollection) {
        this.flashcardCollections.add(flashcardCollection);
    }

    public void removeCollection(FlashcardCollection flashcardCollection) {
        if (this.flashcardCollections.contains(flashcardCollection)) {
            this.flashcardCollections.remove(flashcardCollection);
        }
    }

    public void removeAllCollections() {
        this.flashcardCollections.clear();
    }

    public List<FlashcardCollection> getCollections() {
        return this.flashcardCollections;
    }

    public int getAmountOfCollections() {
        return this.flashcardCollections.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final AllFlashcardCollections other = (AllFlashcardCollections) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.flashcardCollections, other.flashcardCollections)) {
            return false;
        }
        return true;
    }

}
