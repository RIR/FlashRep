package flashrep.flashrep.gui;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Raine Rantanen
 */
//Kirjautumisvalikko
public class SignInMenuPanel extends JPanel {

    public SignInMenuPanel() {
        super(new GridLayout(0, 2));
        initComponents();
    }

    //Luodaan valikon komponentit
    private void initComponents() {
        // luodaan komponentit
        JLabel usernameText = new JLabel("Käyttäjätunnus");
        JTextField usernameField = new JTextField();
        JButton signInOrCreateUserButton = new JButton("Kirjaudu");

        //Jos on jo tunnukset
        JLabel areUaUserText = new JLabel("Onko sinulla jo käyttäjätunnus?");
        JLabel empty = new JLabel("");
        JRadioButton isUserButton = new JRadioButton("Kyllä, salasanani on:");
        isUserButton.setActionCommand("isUser");
        isUserButton.setSelected(true);
        JTextField isUserPasswordField = new JTextField();

        //Kun ei ole vielä tunnuksia
        JRadioButton isNotUserButton = new JRadioButton("Ei, haluan luoda tunnukset!");
        isNotUserButton.setActionCommand("isNotUser");

        /*Uuden käyttäjän salasanan luonti on aluksi piilossa 
        kunnes käyttäjä ilmoittaa, ettei hänellä ole tunnuksia
         */
        JLabel newPasswordText = new JLabel("Keksi salasana:");
        newPasswordText.setVisible(false);
        JTextField newPasswordField = new JTextField();
        newPasswordField.setVisible(false);
        JLabel repeatPasswordText = new JLabel("Toista salasana:");
        repeatPasswordText.setVisible(false);
        JTextField repeatPasswordField = new JTextField();
        repeatPasswordField.setVisible(false);

        //Lisätään valintanapit ryhmään
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(isUserButton);
        buttonGroup.add(isNotUserButton);

        //lisätään komponentit
        add(usernameText);
        add(usernameField);
        add(areUaUserText);
        add(empty);
        add(isUserButton);
        add(isUserPasswordField);
        add(isNotUserButton);
        add(new JLabel(""));
        add(newPasswordText);
        add(newPasswordField);
        add(repeatPasswordText);
        add(repeatPasswordField);
        add(new JLabel(""));
        add(new JLabel(""));
        add(new JLabel(""));
        add(signInOrCreateUserButton);

        //lisätään kuuntelija      
        SignInMenuListener listener = new SignInMenuListener(isUserPasswordField, newPasswordText, newPasswordField, repeatPasswordText, repeatPasswordField, signInOrCreateUserButton);
        isUserButton.addActionListener(listener);
        isNotUserButton.addActionListener(listener);

    }
}
