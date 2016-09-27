package flashrep.flashrep.cards;

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
public class AllFlashcardCollections {

    private List<FlashcardCollection> flashcardCollections;
    private String name;

    /**
     * Luokan konstruktori
     */
    public AllFlashcardCollections() {
        this.flashcardCollections = new ArrayList<>();
    }

    /**
     * Luokan konstruktori, asettaa kokoelmalistaukselle parametrina annetun
     * nimen.
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
     * @param flashcardCollection Parametrina annettava korttikokoelma
     */
    public void addCollection(FlashcardCollection flashcardCollection) {
        this.flashcardCollections.add(flashcardCollection);
    }

    /**
     * Metodi poistaa korttikokoelman kokoelmalistauksesta, jos kokoelma löytyy
     * listauksesta.
     *
     * @param flashcardCollection Parametrina annettava korttikokoelma
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
     * @param name Parametrina annettava nimi
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodi antaa kokoelmalistaukselle hajautusarvon ja palauttaa sen.
     *
     * @return kokoelmalistauksen hajautusarvo
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Metodi vertailee metodia käyttävää kokoelmalistausta ja parametrina annettavaa
     * kokoelmalistausta keskenään tarkistaakseen ovatko ne sama
     * kokoelmalistaus.
     *
     * @param allFlashcardCollections Parametrina annettava kokoelmalistaus
     * @return true jos kokoelmalistaukset ovat samat, tai false jos
     * kokoelmalistaukset eivät ole samat.
     */
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

}
