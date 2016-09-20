package flashrep.flashrep.logic;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import java.util.ArrayDeque;

/**
 *
 * @author Raine Rantanen
 */
public class SpacedRepetition implements RepetitionLogic {

    private ArrayDeque[] rotationQueue;
    private FlashcardCollection flashcardCollection;
    private boolean removeFromRotation;
    final int queueCount =5;

    public SpacedRepetition(FlashcardCollection flashcardCollection) {
        this.initiateRotationQueue();
        this.flashcardCollection = flashcardCollection;
        this.loadFlashcardCollectionIntoRotation();
        removeFromRotation = false;
    }

    private void initiateRotationQueue() {
        this.rotationQueue = new ArrayDeque[queueCount];
        for (int i = 0; i < queueCount; i++) {
            this.rotationQueue[i] = new ArrayDeque<Flashcard>();
        }
    }

    public void loadFlashcardCollectionIntoRotation() {
        this.rotationQueue[0].addAll(this.flashcardCollection.getFlashcards());
    }

    private boolean queueIsEmpty(int queueNum) {
        if (this.rotationQueue[queueNum].isEmpty()) {
            return true;
        }
        return false;
    }

    public Flashcard showFlashcard() {
        this.removeFromRotation = false;
        for (int i = 0; i < this.rotationQueue.length; i++) {
            if (!queueIsEmpty(i)) {
                return (Flashcard) this.rotationQueue[i].pollFirst();
            }
        }
        return null;
    }

    public void placeFlashcardInCorrectPlace(Flashcard flashcard) {
        int rating = flashcard.getRating() - 1;
        int lastQueue = 4;
        int placement = lastQueue - rating;
        if (!this.isRemovedFromRotation()) {
            this.rotationQueue[placement].add(flashcard);
        }
    }

    public boolean isRemovedFromRotation() {
        return removeFromRotation;
    }

    public void removeFromRotation() {
        this.removeFromRotation = true;
    }

    public void removeAllFlashcardsFromRotation() {
        for (int i = 0; i < queueCount; i++) {
            this.rotationQueue[i].clear();
        }
    }

    public FlashcardCollection getFlashcardCollection() {
        return this.flashcardCollection;
    }

    public void setFlashcardCollection(FlashcardCollection flashcardCollection) {
        this.flashcardCollection = flashcardCollection;
    }
}
