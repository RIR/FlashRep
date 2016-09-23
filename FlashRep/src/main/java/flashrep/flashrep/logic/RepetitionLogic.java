package flashrep.flashrep.logic;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;

/**
 *
 * @author Raine Rantanen
 */
public interface RepetitionLogic {
  
    public void loadFlashcardCollectionIntoRotation(FlashcardCollection flashcardCollection);

    public Flashcard showCard();

    public void insertCardInToRotation(Flashcard flashcard);

    public boolean isRemovedFromRotation();

    public void removeFromRotation();

    public void removeAllCardsFromRotation();
}
