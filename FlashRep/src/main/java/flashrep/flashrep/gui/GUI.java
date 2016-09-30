package flashrep.flashrep.gui;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.useraccounts.Users;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    private Users users;
    private AllFlashcardCollections allFlashcardCollections;

    /**
     * Luokan konstruktori joka injektoi käyttöliittymän käyttöön parametreina annettavat oliot.
     * @param users
     * @param allFlashcardCollections 
     */
    public GUI(Users users, AllFlashcardCollections allFlashcardCollections) {
        this.users = users;
        this.allFlashcardCollections = allFlashcardCollections;
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
        Views views = new Views(users, allFlashcardCollections);
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
