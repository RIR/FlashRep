package flashrep.flashrep.logic;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;

/**
 *
 * @author Raine Rantanen
 */
public interface RepetitionLogic {

    public Flashcard showCard();

    public void placeCardInCorrectPlace(Flashcard flashcard);

    public boolean isRemovedFromRotation();

    public void removeFromRotation();

    public void removeAllCardsFromRotation();

    public FlashcardCollection getFlashcardCollection();

    public void setFlashcardCollection(FlashcardCollection flashcardCollection);
}
