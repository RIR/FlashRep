package flashrep.flashrep.gui;

import flashrep.flashrep.cards.FlashcardCollection;
import flashrep.flashrep.logic.Controller;
import flashrep.flashrep.useraccounts.User;
import java.lang.reflect.Array;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Raine Rantanen
 */
/**
 * Luokka joka luo mallin jonka pohjalta käyttäjän kokoelmalistaus toimii myös
 * graafisessa käyttöliittymässä, luokka perii luokan AbstractListModel
 * ominaisuudet.
 *
 * @author Raine Rantanen
 */
public class CollectionsModel extends AbstractListModel {

    private List<FlashcardCollection> collections;
    private FlashcardCollection currentCollection;

    /**
     * Luokan konstruktori joka asettaa kokoelmalistaukseksi parametrina
     * annettavan listauksen.
     *
     * @param Collections Annettava kokoelmalistaus
     */
    public CollectionsModel(List<FlashcardCollection> Collections) {
        this.collections = Collections;
    }

    /**
     * Metodi lisää kokoelmalistaukseen uuden kokoelman joka saa nimeksi
     * parametrina annettavan nimen.
     *
     * @param collectionName Kokoelmalle annettava nimi
     */
    public void addNewCollection(String collectionName) {
        FlashcardCollection flashcardCollection = new FlashcardCollection(collectionName);
        this.collections.add(flashcardCollection);
        fireContentsChanged(this, 0, getSize());
    }

    /**
     * Metodi poistaa parametrina annettavat indeksin mukaiset kokoelmat
     * listauksesta.
     *
     * @param index Poistettavien kokoelmien indeksit listauksessa
     */
    public void removeCollection(int[] index) {
        for (int i = index.length - 1; i >= 0; i--) {
            int collection = index[i];
            this.collections.remove(collection);
            fireContentsChanged(this, 0, getSize());
        }
    }

    /**
     * Metodi palauttaa kokoelmalistauksen kokoelmien lukumäärän.
     *
     * @return Kokoelmalistauksen kokoelmien lukumäärä
     */
    @Override
    public int getSize() {
        return collections.size();
    }

    /**
     * Metodi palauttaa parametrina annettavan indeksin mukaisen kokoelman
     * listauksesta.
     *
     * @param index Indeksinumero
     * @return Indeksinumeron mukainen kokoelma
     */
    @Override
    public Object getElementAt(int index) {
        return collections.get(index);
    }

    /**
     * Metodi asettaa parametrina annettavan indeksin mukaisen kokoelman
     * listauksesta valituksi.
     *
     * @param index Indeksinumero
     */
    public void setCurrentCollection(int index) {
        this.currentCollection = this.collections.get(index);
    }

    /**
     * Metodi palauttaa listauksesta valituksi asetetun kokoelman.
     *
     * @return Käyttäjän tällä hetkellä valitsema kokoelma
     */
    public FlashcardCollection getCurrentCollection() {
        return currentCollection;
    }

    /**
     * Metodi asettaaa käyttäjän tällä hetkellä valitsemalle kokoelmalle nimen
     * Tämä metodi käytössä siis kun käyttäjä uudelleennimeää kokoelman.
     *
     * @param name Annettava nimi
     * @param index Valittavan kokoelman indeksinumero kokoelmalistauksessa
     */
    public void setName(String name, int index) {
        setCurrentCollection(index);
        currentCollection.setName(name);
        fireContentsChanged(this, 0, getSize());
    }

}
