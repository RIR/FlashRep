package flashrep.flashrep.gui;

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
/*Käyttäjävalikko, toistaiseksi vaan kopsattu toisesta valikosta
näkymien välillä liikkumisen testailua varten
 */
public class UserMenuPanel extends JPanel {

    private Views views;

    public UserMenuPanel(Views views) {
        this.views = views;
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        initComponents();
    }

    //Luodaan valikon komponentit
    private void initComponents() {
        // luodaan komponentit

        //Aloitusruudun teksti luodaan, keskitetään ja lisätään
        JLabel label1 = new JLabel("Käyttäjävalikko");
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label1);

        //Lisätään paneeli paneelin sisälle jotta saadaan haluttu tyyli
        JPanel userMenuPanel = new JPanel(new GridLayout(0, 2));
        add(userMenuPanel);
    }
}
