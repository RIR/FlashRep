package flashrep.flashrep.logic;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;

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

    /**
     * Metodi palauttaa toistologiikan käyttämän korttikokoelman niin kuin se on
     * mahdollisten korttien lisäysten ja poistojen jälkeen.
     *
     * @return Toistologiikan käyttämä korttikokoelma
     */
    public FlashcardCollection getFlashcardCollection();

    /**
     * Metodi palauttaa toistojonon korttien lukumäärän.
     *
     * @return Toistojonon koko
     */
    public int getRotationSize();
}
