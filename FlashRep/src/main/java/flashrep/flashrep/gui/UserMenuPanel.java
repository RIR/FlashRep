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
//Käyttäjävalikko
public class UserMenuPanel extends JPanel {

    public UserMenuPanel() {
        super(new GridLayout(0, 2));
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