package flashrep.flashrep.logic;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author Raine Rantanen
 */
public class SpacedRepetition implements RepetitionLogic {

    private PriorityQueue<Flashcard> rotationQueue;
    private FlashcardCollection flashcardCollection;
    private boolean removeFromRotation;

    public SpacedRepetition(FlashcardCollection flashcardCollection) {
        this.rotationQueue = new PriorityQueue<Flashcard>();
        this.flashcardCollection = flashcardCollection;
        this.loadFlashcardCollectionIntoRotation();
        removeFromRotation = false;
    }

    public void loadFlashcardCollectionIntoRotation() {
        this.rotationQueue.addAll(this.flashcardCollection.getFlashcards());
    }

    public Flashcard showCard() {
        this.removeFromRotation = false;
        if (!this.rotationQueue.isEmpty()) {
            return this.rotationQueue.poll();
        }
        return null;
    }

    public void insertCardInToRotation(Flashcard flashcard) {
        if (!isRemovedFromRotation()) {
            this.rotationQueue.add(flashcard);
        }
    }

    public boolean isRemovedFromRotation() {
        return removeFromRotation;
    }

    public void removeFromRotation() {
        this.removeFromRotation = true;
    }

    public void removeAllCardsFromRotation() {
        this.rotationQueue.clear();
    }

    public Queue<Flashcard> cardsInRotation() {
        return rotationQueue;
    }

    public FlashcardCollection getFlashcardCollection() {
        return this.flashcardCollection;
    }

    public void setFlashcardCollection(FlashcardCollection flashcardCollection) {
        this.flashcardCollection = flashcardCollection;
    }

}
