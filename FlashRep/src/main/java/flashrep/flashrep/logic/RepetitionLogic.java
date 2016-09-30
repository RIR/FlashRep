package flashrep.flashrep.logic;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;

/**
 *
 * @author Raine Rantanen
 */
/**
 * Rajapintaluokka joka määrittää korttikokoelman korttien toistolta vaaditut
 * metodit .
 */
public interface RepetitionLogic {

    /**
     * Metodi lataa parametrina annettavan korttikokoelman toistojonoon.
     *
     * @param flashcardCollection Parametrina annettava korttikokoelma
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
     * @param flashcard parametrina annettava kortti
     */
    public void insertCardInToRotation(Flashcard flashcard);

    /**
     * Metodi poistaa metodia käyttävän kortin toistojonosta.
     */
    public void removeFromRotation();
}
