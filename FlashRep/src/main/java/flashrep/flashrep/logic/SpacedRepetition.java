package flashrep.flashrep.logic;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import java.util.ArrayDeque;

/**
 *
 * @author Raine Rantanen
 */
public class SpacedRepetition implements RepetitionLogic {

    private ArrayDeque[] queues;
    private FlashcardCollection flashcardCollection;
    private boolean removeFromRotation;

    public SpacedRepetition(FlashcardCollection flashcardCollection) {
        this.initiateQueues();
        this.flashcardCollection = flashcardCollection;
        this.loadFlashcardCollectionIntoRotation();
        removeFromRotation = false;
    }

    private void initiateQueues() {
        this.queues = new ArrayDeque[5];
        for (int i = 0; i < 5; i++) {
            this.queues[i] = new ArrayDeque<Flashcard>();
        }
    }

    private void loadFlashcardCollectionIntoRotation() {
        this.queues[0].addAll(this.flashcardCollection.getFlashcards());
    }

    private boolean queueIsEmpty(int queueNum) {
        if (this.queues[queueNum].isEmpty()) {
            return true;
        }
        return false;
    }

    public Flashcard showFlashcard() {
        this.removeFromRotation = false;
        for (int i = 0; i < this.queues.length; i++) {
            if (!queueIsEmpty(i)) {
                return (Flashcard) this.queues[i].pollFirst();
            }
        }
        return null;
    }

    public void placeFlashcardInCorrectPlace(Flashcard flashcard) {
        int rating = flashcard.getRating() - 1;
        int lastQueue = 4;
        int placement = lastQueue - rating;
        if (!removeFromRotation) {
            this.queues[placement].add(flashcard);
        }
    }

    public boolean isRemovedFromRotation() {
        return removeFromRotation;
    }

    public void removeFromRotation() {
        this.removeFromRotation = true;
    }

    public void removeAllFlashcardsFromRotation() {
        for (int i = 0; i < 5; i++) {
            this.queues[i].clear();
        }
    }

    public FlashcardCollection getFlashcardCollectionUsedInRotation() {
        return this.flashcardCollection;
    }

    public void setFlashcardCollectionForRotation(FlashcardCollection flashcardCollection) {
        this.flashcardCollection = flashcardCollection;
        this.loadFlashcardCollectionIntoRotation();
    }
}
