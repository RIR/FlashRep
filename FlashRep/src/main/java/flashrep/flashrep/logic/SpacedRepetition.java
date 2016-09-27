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
/**
 * Luokka korttikokoelmien aikavälikertaukseen, toteuttaa
 * RepetitionLogic-rajapinnan.
 */
public class SpacedRepetition implements RepetitionLogic {

    private PriorityQueue<Flashcard> rotationQueue;
    private boolean removeFromRotation;
    private FlashcardCollection flashcardCollection;

    /**
     * Luokan konstruktori, asettaa parametrina annettavan korttikokoelman
     * toistojonoon.
     *
     * @param flashcardCollection Parametrina annettava korttikokoelma
     */
    public SpacedRepetition(FlashcardCollection flashcardCollection) {
        this.rotationQueue = new PriorityQueue<Flashcard>();
        this.loadFlashcardCollectionIntoRotation(flashcardCollection);
        removeFromRotation = false;
    }

    /**
     * Metodi lataa parametrina annettavan korttikokoelman toistojonoon.
     *
     * @param flashcardCollection Parametrina annettava toistojono
     */
    public void loadFlashcardCollectionIntoRotation(FlashcardCollection flashcardCollection) {
        this.flashcardCollection = flashcardCollection;
        if (!this.rotationQueue.isEmpty()) {
            removeAllCardsFromRotation();
        }
        this.rotationQueue.addAll(this.flashcardCollection.getCards());
    }

    /**
     * Metodi palauttaa toistojonossa ensimmäisenä olevan kortin, tai null jos
     * jono on tyhjä.
     *
     * @return toistojonon ensimmäinen kortti tai null jos jono on tyhjä
     */
    public Flashcard showCard() {
        this.removeFromRotation = false;
        if (!this.rotationQueue.isEmpty()) {
            return this.rotationQueue.poll();
        }
        return null;
    }

    //Pitäisi ehkä olla yksityinen metodi? 
    /**
     * Metodi asettaa parametrina annettavan kortin toistojonoon, jos ei ole
     * valittu, että kortti poistetaan toistojonosta.
     *
     * @param flashcard Parametrina annettava kortti
     */
    public void insertCardInToRotation(Flashcard flashcard) {
        if (!isRemovedFromRotation()) {
            this.rotationQueue.add(flashcard);
        }
    }

    //Yksityinen metodi ei JavaDociin
    private boolean isRemovedFromRotation() {
        return removeFromRotation;
    }

    /**
     * Metodi poistaa metodia käyttävän kortin toistojonosta.
     */
    public void removeFromRotation() {
        this.removeFromRotation = true;
    }

    /**
     * Metodi poistaa kaikki kortit toistojonosta.
     */
    public void removeAllCardsFromRotation() {
        this.rotationQueue.clear();
    }

    /**
     * Metodi palauttaa toistojonon FlashcardCollection-muodossa.
     *
     * @return toistojonon kortit tallennettuna
     * FlashcardCollection-korttikokoelmaan
     */
    public FlashcardCollection getFlashcardCollection() {
        this.flashcardCollection.removeAllCardsFromCollection();
        this.flashcardCollection.getCards().addAll(rotationQueue);
        return this.flashcardCollection;
    }
}
