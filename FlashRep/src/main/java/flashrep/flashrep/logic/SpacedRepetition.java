package flashrep.flashrep.logic;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Raine Rantanen
 */
public class SpacedRepetition implements RepetitionLogic {

    private PriorityQueue<Flashcard> rotationQueue;
    private boolean removeFromRotation;
    private FlashcardCollection flashcardCollection;

    public SpacedRepetition(FlashcardCollection flashcardCollection) {
        this.rotationQueue = new PriorityQueue<Flashcard>();
        this.loadFlashcardCollectionIntoRotation(flashcardCollection);
        removeFromRotation = false;
    }

    public void loadFlashcardCollectionIntoRotation(FlashcardCollection flashcardCollection) {
        this.flashcardCollection = flashcardCollection;
        if (!this.rotationQueue.isEmpty()) {
            removeAllCardsFromRotation();
        }
        this.rotationQueue.addAll(this.flashcardCollection.getCards());
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

    private boolean isRemovedFromRotation() {
        return removeFromRotation;
    }

    public void removeFromRotation() {
        this.removeFromRotation = true;
    }

    public void removeAllCardsFromRotation() {
        this.rotationQueue.clear();
    }

    public FlashcardCollection getFlashcardCollection() {
        this.flashcardCollection.removeAllCardsFromCollection();
        this.flashcardCollection.getCards().addAll(rotationQueue);
        return this.flashcardCollection;
    }
}
