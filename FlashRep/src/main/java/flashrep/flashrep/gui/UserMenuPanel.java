package flashrep.flashrep.gui;

import flashrep.flashrep.logic.Controller;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Raine Rantanen
 */
/**
 * Käyttäjävalikkoluokka.
 */
public class UserMenuPanel extends JPanel {

    private Views views;
    private Controller controller;

    /**
     * Luokan konstruktori joka saa injektoituna näkymiä hallitsevan
     * Views-luokan olion.
     *
     * @param views Views-luokan olio
     */
    public UserMenuPanel(Views views, Controller controller) {
        this.views = views;
        this.controller = controller;
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        initComponents();
    }

    //Luodaan valikon komponentit
    private void initComponents() {
        // luodaan komponentit

        //Aloitusruudun teksti luodaan, keskitetään ja lisätään
        JLabel label1 = new JLabel("Käyttäjä: " + this.controller.currentUser().toString());
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label1);

        //Lisätään paneeli paneelin sisälle jotta saadaan haluttu tyyli
        JPanel userMenuPanel = new JPanel(new GridLayout(0, 2));
        add(userMenuPanel);

        JButton signOutButton = new JButton("Kirjaudu ulos");
        userMenuPanel.add(signOutButton);
        UserMenuListener listener = new UserMenuListener(views, controller, signOutButton);
        signOutButton.addActionListener(listener);

        System.out.println(this.controller.currentUser().toString());
    }
}
