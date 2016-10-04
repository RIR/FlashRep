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
    private JPanel view1;
    private JPanel view2;

    /**
     * Luokan konstruktori joka injektoi näkymien käyttöön kontrollerin.
     *
     * @param controller Kontrolleri käyttäjä- ja korttiluokkien käyttöä varten
     */
    public Views(Controller controller) {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        // luodaan näkymät ja lisätään ne käyttöön   
        this.view1 = new SignInMenuPanel(this, this.controller);
        this.view2 = new UserMenuPanel(this, this.controller);
        add(view1, SIGNINMENUPANEL);
        add(view2, USERMENUPANEL);

    }

    //Metodi päivittää paneelien komponentit
    private void refreshComponents() {
        this.remove(this.view1);
        this.remove(this.view2);
        initComponents();
    }

    /**
     * Metodi vaihtaa ikkunanäkymää annetun parametrin perusteella.
     *
     * @param view Näytettävä ikkunanäkymä
     */
    public void switchToView(String view) {
        refreshComponents();
        cardLayout.show(this, view);
    }

}
