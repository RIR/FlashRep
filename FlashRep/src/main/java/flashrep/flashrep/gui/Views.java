package flashrep.flashrep.gui;

import flashrep.flashrep.logic.Controller;
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
    private Controller controller;

    /**
     * Luokan konstruktori joka injektoi näkymien käyttöön kontrollerin.
     * @param controller Kontrolleri käyttäjä- ja korttiluokkien käyttöä varten
     */
    public Views(Controller controller) {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.controller=controller;
        initComponents();
    }

    private void initComponents() {
        // luodaan näkymät ja lisätään ne käyttöön
        JPanel view1 = new SignInMenuPanel(this, controller);
        JPanel view2 = new UserMenuPanel(this, controller);
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
