package flashrep.flashrep.gui;

import java.awt.GridLayout;
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
  Views views;
    public UserMenuPanel(Views views) {   
        super(new GridLayout(0, 2));
           this.views=views;
        initComponents();
    }

    //Luodaan valikon komponentit
    private void initComponents() {
        // luodaan komponentit}
        
         // luodaan komponentit
        JLabel usernameText = new JLabel("Käyttäjätunnus");
        JTextField usernameField = new JTextField(20);
        JButton signInOrCreateUserButton = new JButton("Kirjaudu");
        
        add(usernameText);
        add(usernameField);
        add(signInOrCreateUserButton);
    }
}
