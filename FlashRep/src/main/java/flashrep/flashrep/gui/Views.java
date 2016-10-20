package flashrep.flashrep.gui;

import flashrep.flashrep.logic.AppControlLogic;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 * JPanel luokka CardLayoutilla eri ikkunanäkymiä varten.
 */
public class Views extends JPanel {

    // Kirjautumisvalikko
    final static String SIGNINMENUPANEL = "SignInMenu";
    // Käyttäjävalikko
    final static String USERMENUPANEL = "UserMenu";
    //Opiskelunäkymä
    final static String STUDYPANEL = "StudyView";
    // admin-näkymä
    final static String ADMINPANEL = "AdminMenu";

    private CardLayout cardLayout;
    private AppControlLogic controller;
    private JPanel view1;
    private JPanel view2;
    private JPanel view3;
    private JPanel view4;

    /**
     * Luokan konstruktori joka injektoi näkymien käyttöön kontrollerin.
     *
     * @param controller Kontrolleri käyttäjä- ja korttiluokkien käyttöä varten
     */
    public Views(AppControlLogic controller) {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {
        // luodaan näkymät ja lisätään ne käyttöön   
        this.view1 = new SignInMenuPanel(this, this.controller);
        this.view2 = new UserMenuPanel(this, this.controller);
        this.view3 = new StudyViewPanel(this, this.controller);
        this.view4 = new AdminMenuPanel(this, this.controller);
        add(view1, SIGNINMENUPANEL);
        add(view2, USERMENUPANEL);
        add(view3, STUDYPANEL);
        add(view4, ADMINPANEL);

    }

    //Metodi päivittää paneelien komponentit
    private void refreshComponents() {
        this.remove(this.view1);
        this.remove(this.view2);
        this.remove(this.view3);
        this.remove(this.view4);
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
