package flashrep.flashrep.cards;

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
public class FlashcardCollection {

    private String name;
    private List<Flashcard> flashcards;

    /**
     * Luokan konstruktori, asettaa korttikokoelmalle parametrina annettavan nimen.
     * @param name Parametrina annettava nimi
     */
    public FlashcardCollection(String name) {
        this.name = name;
        this.flashcards = new ArrayList<>();
    }

    /**
     * Metodi lisää korttikokoelmaan parametrina annettavan kortin.
     * @param flashcard parametrina annettava kortti
     */
    public void addCardToCollection(Flashcard flashcard) {       
        this.flashcards.add(flashcard);
    }

    /**
     * Metodi poistaa parametrina annettavan kortin korttikokoelmasta.
     * @param flashcard parametrina annettava kortti
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
     * Metodi palauttaa korttikokoelman.
     * @return korttikokoelma
     */
    public List<Flashcard> getCards() {
        return flashcards;
    }

    /**
     * Metodi palauttaa korttikokoelman nimen.
     * @return korttikokoelman nimi
     */
    public String getName() {
        return name;
    }

    /**
     * Metodi asettaa korttikokoelmalle parametrina annettavan nimen.
     * @param name Parametrina annettava nimi
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodi palauttaa korttikokoelman korttien lukumäärän.
     * @return korttikokoelman korttien lukumäärä
     */
    public int getSize() {
        return this.flashcards.size();
    }

    /**
     * Metodi antaa korttikokoelmalle hajautusarvon ja palauttaa sen.
     * @return korttikokoelman hajautusarvo
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.flashcards);
        return hash;
    }

    /**
     * Metodi vertailee keskenään metodia käyttävää korttikokoelmaa ja 
     * parametrina annettavaa korttikokoelmaa keskenään tarkistaakseen ovatko 
     * korttikokoelmat sama kokoelma.
     * @param flashcardcollection parametrina annettava korttikokoelma
     * @return true jos kokoelmat ovat sama kokoelma ja false jos ne eivät ole sama kokoelma
     */
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
        if (!Objects.equals(this.flashcards, other.flashcards)) {
            return false;
        }
        return true;
    }
}
