package flashrep.flashrep.gui;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.useraccounts.Users;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Raine Rantanen
 */
/**
 * JPanel luokka CardLayoutilla eri ikkunanäkymiä varten.
 */
public class Views extends JPanel {

    // Kirjautumisvalikko
    final static String SIGNINMENUPANEL = "SignInMenu";
    // Käyttäjävalikko
    final static String USERMENUPANEL = "UserMenu";

    private CardLayout cardLayout;
    private Users users;
    private AllFlashcardCollections allFlashcardCollections;

    /**
     * Luokan konstruktori joka injektoi näkymien käyttöön parametreina
     * annettavat oliot.
     *
     * @param users Käyttäjälistaus
     * @param allFlashcardCollections Kokoelmalistaus
     */
    public Views(Users users, AllFlashcardCollections allFlashcardCollections) {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.users = users;
        this.allFlashcardCollections = allFlashcardCollections;
        initComponents();
    }

    private void initComponents() {
        // luodaan näkymät ja lisätään ne käyttöön
        JPanel view1 = new SignInMenuPanel(this, users);
        JPanel view2 = new UserMenuPanel(this);
        add(view1, SIGNINMENUPANEL);
        add(view2, USERMENUPANEL);

    }

    /**
     * Metodi vaihtaa ikkunanäkymää annetun parametrin perusteella.
     *
     * @param view Näytettävä ikkunanäkymä
     */
    public void switchToView(String view) {
        cardLayout.show(this, view);
    }
}
