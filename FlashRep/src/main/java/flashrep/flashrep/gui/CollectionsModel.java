package flashrep.flashrep.gui;

import flashrep.flashrep.cards.FlashcardCollection;
import flashrep.flashrep.logic.Controller;
import flashrep.flashrep.useraccounts.User;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Raine Rantanen
 */
/**
 * Luokka joka luo mallin jonka pohjalta käyttäjän kokoelmalistaus toimii myös
 * graafisessa käyttöliittymässä, luokka perii luokan AbstractListModel ominaisuudet.
 * @author Raine Rantanen
 */
public class CollectionsModel extends AbstractListModel {
    private List<FlashcardCollection> collections;
    private FlashcardCollection currentCollection;

    /**
     * Luokan konstruktori joka asettaa kokoelmalistaukseksi parametrina annettavan listauksen.
     * @param Collections Kokoelmalistaus
     */
    public CollectionsModel(List<FlashcardCollection> Collections) {
        this.collections = Collections;
    }

    /**
     * Metodi lisää kokoelmalistaukseen uuden kokoelman joka saa nimeksi 
     * parametrina annettavan nimen.
     * @param collectionName Kokoelmalle annettava nimi
     */
    public void addNewCollection(String collectionName) {
        FlashcardCollection flashcardCollection = new FlashcardCollection(collectionName);
        this.collections.add(flashcardCollection);
        fireContentsChanged(this, 0, getSize());
    }

    /**
     * Metodi poistaa parametrina annettavan indeksin mukaisen kokoelman listauksesta.
     * @param index Poistettavan kokoelman indeksi listauksessa
     */
    public void removeCollection(int index) {
        collections.remove(index);
        fireContentsChanged(this, 0, getSize());
    }

    /**
     * Metodi palauttaa kokoelmalistauksen kokoelmien lukumäärän.
     * @return 
     */
    @Override
    public int getSize() {
        return collections.size();
    }

    /**
     * Metodi palauttaa parametrina annettavan indeksin mukaisen kokoelman listauksesta.
     * @param index Indeksinumero 
     * @return Indeksinumeron mukainen kokoelma
     */
    @Override
    public Object getElementAt(int index) {
        return collections.get(index);
    }

    /**
     * Metodi asettaa parametrina annettavan indeksin mukaisen kokoelman listauksesta
     * valituksi.
     * @param index Indeksinumero
     */
    public void setCurrentCollection(int index) {     
        this.currentCollection = this.collections.get(index);
    }

    /**
     * Metodi palauttaa listauksesta valituksi asetetun kokoelman.
     * @return 
     */
    public FlashcardCollection getCurrentCollection() {
        return currentCollection;
    }

    
}
