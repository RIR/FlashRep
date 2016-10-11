package flashrep.flashrep.cards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Raine Rantanen
 */
/**
 * Luokka tarjoaa metodeita korttikokoelman käsittelyyn.
 */
public class FlashcardCollection implements Serializable {

    private String name;
    private List<Flashcard> flashcards;

    /**
     * Luokan konstruktori, asettaa korttikokoelmalle parametrina annettavan
     * nimen.
     *
     * @param name Annettava nimi
     */
    public FlashcardCollection(String name) {
        this.name = name;
        this.flashcards = new ArrayList<>();
    }

    /**
     * Metodi lisää korttikokoelmaan parametrina annettavan kortin.
     *
     * @param flashcard Lisättävä kortti
     */
    public void addCardToCollection(Flashcard flashcard) {
        this.flashcards.add(flashcard);
    }

    /**
     * Metodi poistaa parametrina annettavan kortin korttikokoelmasta.
     *
     * @param flashcard Poistettava kortti
     */
    public void removeCardFromCollection(Flashcard flashcard) {
        if (this.flashcards.contains(flashcard)) {
            this.flashcards.remove(flashcard);
        }
    }

    /**
     * Metodi poistaa kaikki kortit korttikokoelmasta.
     */
    public void removeAllCardsFromCollection() {
        if (!this.flashcards.isEmpty()) {
            this.flashcards.clear();
        }
    }

    /**
     * Metodi palauttaa korttikokoelman List-muodossa.
     *
     * @return korttikokoelma List-muodossa
     */
    public List<Flashcard> getCards() {
        return flashcards;
    }

    /**
     * Metodi asettaa parametrina annettavan listan listaksi.
     *
     * @param flashcards Annettava lista
     */
    public void setCards(List<Flashcard> flashcards) {
        this.flashcards = flashcards;
    }

    /**
     * Metodi palauttaa korttikokoelman nimen.
     *
     * @return korttikokoelman nimi
     */
    public String getName() {
        return name;
    }

    /**
     * Metodi asettaa korttikokoelmalle parametrina annettavan nimen.
     *
     * @param name Annettava nimi
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodi palauttaa korttikokoelman korttien lukumäärän.
     *
     * @return korttikokoelman korttien lukumäärä
     */
    public int getSize() {
        return this.flashcards.size();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.flashcards);
        return hash;
    }

    @Override
    public boolean equals(Object flashcardcollection) {
        if (this == flashcardcollection) {
            return true;
        }
        if (flashcardcollection == null) {
            return false;
        }
        if (getClass() != flashcardcollection.getClass()) {
            return false;
        }
        final FlashcardCollection other = (FlashcardCollection) flashcardcollection;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
