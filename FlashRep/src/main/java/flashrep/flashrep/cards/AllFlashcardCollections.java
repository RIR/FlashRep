package flashrep.flashrep.cards;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raine Rantanen
 */
public class AllFlashcardCollections {

    private List<FlashcardCollection> flashcardCollections;

    public AllFlashcardCollections() {
        this.flashcardCollections = new ArrayList<>();
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
}
