package flashrep.flashrep.logic;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import java.io.Serializable;

/**
 * Rajapintaluokka joka määrittää korttikokoelman korttien toistolta vaaditut
 * metodit .
 */
public interface RepetitionLogic {

    /**
     * Metodi lataa parametrina annettavan korttikokoelman toistojonoon.
     *
     * @param flashcardCollection Toistojonoon ladattava korttikokoelma
     */
    public void loadFlashcardCollectionIntoRotation(FlashcardCollection flashcardCollection);

    /**
     * Metodi palauttaa toistojonossa ensimmäisenä olevan kortin, jos jono ei
     * ole tyhjä.
     *
     * @return toistojonon ensimmäinen kortti tai null jos jono on tyhjä
     */
    public Flashcard showCard();

    /**
     * Metodi asettaa parametrina annettavan kortin toistojonoon.
     *
     * @param flashcard Toistojonoon annettava kortti
     */
    public void insertCardInToRotation(Flashcard flashcard);

    /**
     * Metodi poistaa metodia käyttävän kortin toistojonosta.
     */
    public void removeFromRotation();

    public FlashcardCollection getFlashcardCollection();

    public int getRotationSize();
}
