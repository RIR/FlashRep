package flashrep.flashrep.gui;

import flashrep.flashrep.logic.AppControlLogic;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    private AppControlLogic controller;

    /**
     * Luokan konstruktori joka injektoi käyttöliittymän käyttöön parametrina
     * annettavan kontrollerin.
     *
     * @param controller Kontrolleri käyttäjä- ja korttiluokkien käyttöä varten
     */
    public GUI(AppControlLogic controller) {
        this.controller = controller;
    }

    /**
     * Metodi käynnistää käyttöliittymän.
     */
    @Override
    public void run() {
        frame = new JFrame("FlashRep");
        frame.setPreferredSize(new Dimension(800, 400));

        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        initComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);

        centerFrame();

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                Object[] buttons = {"Kyllä", "Ei"};
                if (JOptionPane.showOptionDialog(frame,
                        "Haluatko tosiaan sulkea ohjelman?", "Sulje ohjelma?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[1]) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    private void initComponents(Container container) {
        // lisätään näkymät
        Views views = new Views(controller);
        views.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        container.add(views);
    }

    /* Tämä suoraan Jarmo Kallion ohjelmasta SInkTheShips, 
    keskittää aloittaessa ohjelman ruudun keskelle.
     */
    private void centerFrame() {
        Dimension xy = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame.setLocation(xy.width / 2 - this.frame.getWidth() / 2, xy.height / 2 - this.frame.getHeight() / 2);
    }

    /**
     * Metodi palauttaa käyttöliittymän ikkunan.
     *
     * @return
     */
    public JFrame getFrame() {
        return frame;
    }

}
