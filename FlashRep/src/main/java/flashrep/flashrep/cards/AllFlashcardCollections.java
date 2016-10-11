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
 * Luokka tarjoaa metodeita kokoelmalistauksen käsittelyyn.
 */
public class AllFlashcardCollections implements Serializable {
    
    private List<FlashcardCollection> flashcardCollections;
    private String name;

    /**
     * Luokan konstruktori.
     */
    public AllFlashcardCollections() {
        this.flashcardCollections = new ArrayList<>();
    }

    /**
     * Luokan konstruktori joka asettaa kokoelmalistaukselle parametrina
     * annettavan nimen.
     *
     * @param name Kokoelmalistaukselle annettava nimi
     */
    public AllFlashcardCollections(String name) {
        this.flashcardCollections = new ArrayList<>();
        this.name = name;
    }

    /**
     * Metodi lisää korttikokoelman kokoelmalistaukseen.
     *
     * @param flashcardCollection Lisättävä korttikokoelma
     */
    public void addCollection(FlashcardCollection flashcardCollection) {
        this.flashcardCollections.add(flashcardCollection);
    }

    /**
     * Metodi poistaa korttikokoelman kokoelmalistauksesta, jos kokoelma löytyy
     * listauksesta.
     *
     * @param flashcardCollection Poistettava korttikokoelma
     */
    public void removeCollection(FlashcardCollection flashcardCollection) {
        if (this.flashcardCollections.contains(flashcardCollection)) {
            this.flashcardCollections.remove(flashcardCollection);
        }
    }

    /**
     * Metodi poistaa kaikki kokoelmalistauksen kokoelmat.
     *
     */
    public void removeAllCollections() {
        this.flashcardCollections.clear();
    }

    /**
     * Metodi palauttaa kokoelmalistauksen.
     *
     * @return korttikokoelmalistaus
     */
    public List<FlashcardCollection> getCollections() {
        return this.flashcardCollections;
    }

    /**
     * Metodi palauttaa listauksen kokoelmien lukumäärän.
     *
     * @return listauksen kokoelmien lukumäärä
     */
    public int getAmountOfCollections() {
        return this.flashcardCollections.size();
    }

    /**
     * Metodi palauttaa kokoelmalistauksen nimen.
     *
     * @return kokoelmalistauksen nimi
     */
    public String getName() {
        return name;
    }

    /**
     * Metodi asettaa kokoelmalistaukselle parametrina annettavan nimen.
     *
     * @param name Annettava nimi
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.flashcardCollections);
        hash = 61 * hash + Objects.hashCode(this.name);
        return hash;
    }
    
    @Override
    public boolean equals(Object allFlashcardCollections) {
        if (this == allFlashcardCollections) {
            return true;
        }
        if (allFlashcardCollections == null) {
            return false;
        }
        if (getClass() != allFlashcardCollections.getClass()) {
            return false;
        }
        final AllFlashcardCollections other = (AllFlashcardCollections) allFlashcardCollections;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.flashcardCollections, other.flashcardCollections)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
