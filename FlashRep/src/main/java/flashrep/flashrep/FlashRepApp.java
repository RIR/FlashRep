package flashrep.flashrep;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.gui.GUI;
import flashrep.flashrep.useraccounts.Users;
import javax.swing.SwingUtilities;

/**
 *
 * @author Raine Rantanen
 */
/**
 * Luokka jossa luodaan ohjelman tarvitsemat toiminnot.
*/
public class FlashRepApp {

    private Users users;
    private AllFlashcardCollections allFlashcardCollections;

    /**
     * Luokan konstruktori.
     */
    public FlashRepApp() {
        this.users = new Users();
        this.allFlashcardCollections = new AllFlashcardCollections();
    }
    
    
    
    /**
     * Metodi käynnistää ohjelman käyttämän käyttöliittymän.
     */
    public void start() {
        GUI gui = new GUI(users, allFlashcardCollections);
        SwingUtilities.invokeLater(gui);
    }
    
    
}
