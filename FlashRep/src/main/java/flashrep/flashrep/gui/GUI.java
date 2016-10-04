package flashrep.flashrep.gui;

import flashrep.flashrep.logic.Controller;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Raine Rantanen
 */

/**
 * Käyttöliittymäluokka
 */
public class GUI implements Runnable {

    private JFrame frame;
    private Controller controller;

    /**
     * Luokan konstruktori joka injektoi käyttöliittymän käyttöön parametrina annettavan kontrollerin.
     * @param controller Kontrolleri käyttäjä- ja korttiluokkien käyttöä varten
     */
    public GUI(Controller controller) {
        this.controller=controller;
    }

    /**
     * Metodi käynnistää käyttöliittymän.
     */
    @Override
    public void run() {
        frame = new JFrame("FlashRep");
        frame.setPreferredSize(new Dimension(600, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents(Container container) {
        // lisätään näkymät
        Views views = new Views(controller);
        container.add(views);
    }

    /**
     * Metodi palauttaa käyttöliittymän ikkunan.
     * @return 
     */
    public JFrame getFrame() {
        return frame;
    }
}
