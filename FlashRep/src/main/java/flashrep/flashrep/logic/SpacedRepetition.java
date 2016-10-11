package flashrep.flashrep.logic;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import java.io.Serializable;
import java.util.PriorityQueue;

/**
 * Luokka korttikokoelmien kertaukseen, toteuttaa RepetitionLogic-rajapinnan.
 */
public class SpacedRepetition implements RepetitionLogic, Serializable {

    private Flashcard currentFlashcard;
    private PriorityQueue<Flashcard> rotationQueue;
    private boolean removeFromRotation;
    private FlashcardCollection flashcardCollection;

    /**
     * Luokan konstruktori, asettaa parametrina annettavan korttikokoelman
     * toistojonoon.
     *
     * @param flashcardCollection Toistojonoon ladattava korttikokoelma
     */
    public SpacedRepetition(FlashcardCollection flashcardCollection) {
        this.rotationQueue = new PriorityQueue<Flashcard>();
        this.flashcardCollection = flashcardCollection;
        this.rotationQueue.addAll(this.flashcardCollection.getCards());
        removeFromRotation = false;
    }

    /**
     * Metodi lataa parametrina annettavan korttikokoelman toistojonoon.
     *
     * @param flashcardCollection Toistojonoon ladattava korttikokoelma
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
            this.currentFlashcard = this.rotationQueue.poll();
        } else {
            this.currentFlashcard = null;
        }
        return this.currentFlashcard;
    }

    //Pitäisi ehkä olla yksityinen metodi? 
    /**
     * Metodi asettaa parametrina annettavan kortin toistojonoon, jos ei ole
     * valittu, että kortti poistetaan toistojonosta.
     *
     * @param flashcard Toistojonoon annettava kortti
     */
    public void insertCardInToRotation(Flashcard flashcard) {
        if (!isRemovedFromRotation()) {
            this.rotationQueue.add(flashcard);
        }
        this.removeFromRotation = false;
    }

    /*Yksityinen metodi ei JavaDociin??
    Metodi tarkistaa booleanin tilan ja avustaa insertCardIntoRotation-metodia 
    päättämään asetetaanko jokin kortti takaisin toistojonoon.
     */
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
    private void removeAllCardsFromRotation() {
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
        if (this.currentFlashcard != null) {
            this.flashcardCollection.addCardToCollection(currentFlashcard);
        }
        this.flashcardCollection.getCards().addAll(rotationQueue);
        return this.flashcardCollection;
    }

    public int getRotationSize() {
        return this.rotationQueue.size();
    }
}
