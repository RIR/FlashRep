package flashrep.flashrep.app;

import flashrep.flashrep.gui.GUI;
import flashrep.flashrep.logic.Controller;
import javax.swing.SwingUtilities;

/**
 *
 * @author Raine Rantanen
 */
/**
 * Luokka jossa luodaan ohjelman tarvitsemat toiminnot.
 */
public class FlashRepApp {

    private Controller controller;

    /**
     * Luokan konstruktori.
     */
    public FlashRepApp() {
        this.controller = new Controller();
    }

    /**
     * Metodi käynnistää ohjelman käyttämän käyttöliittymän.
     */
    public void start() {
        GUI gui = new GUI(this.controller);
        SwingUtilities.invokeLater(gui);
    }

}
