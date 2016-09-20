package flashrep.flashrep.logic;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;

/**
 *
 * @author Raine Rantanen
 */
public interface RepetitionLogic {

    public Flashcard showFlashcard();

    public void placeFlashcardInCorrectPlace(Flashcard flashcard);

    public boolean isRemovedFromRotation();

    public void removeFromRotation();

    public void removeAllFlashcardsFromRotation();

    public FlashcardCollection getFlashcardCollectionUsedInRotation();

    public void setFlashcardCollectionForRotation(FlashcardCollection flashcardCollection);
}
