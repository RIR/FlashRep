package flashrep.flashrep.gui;

import flashrep.flashrep.logic.AppControlLogic;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Raine Rantanen
 */
/**
 * JPanelin toiminnot perivä luokka joka toteuttaa kirjautumisvalikon.
 */
public class SignInMenuPanel extends JPanel {

    private Views views;
    private AppControlLogic controller;

    /**
     * Luokan konstruktori joka injektoi kontrollerin.
     *
     * @param views Ikkunanäkymät
     * @param controller Kontrolleri käyttäjä- ja korttiluokkien käyttöä varten
     */
    public SignInMenuPanel(Views views, AppControlLogic controller) {
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(layout);
        this.views = views;
        this.controller = controller;
        initComponents();
    }

    //Luodaan valikon komponentit
    private void initComponents() {

        //Aloitusruudun teksti luodaan, keskitetään ja lisätään
        JLabel label1 = new JLabel("Kirjaudu tai luo tunnus");
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label1);

        //Lisätään paneeli paneelin sisälle jotta saadaan haluttu tyyli
        JPanel signInMenuPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        add(signInMenuPanel);

        //Luodaan tekstit, kentät ja painikkeet
        JLabel usernameText = new JLabel("Käyttäjätunnus");
        JTextField usernameField = new JTextField(20);

        JLabel areUaUserText = new JLabel("Onko sinulla jo käyttäjätunnus?");
        JLabel empty = new JLabel("");

        //Jos on jo tunnukset
        JRadioButton isUserButton = new JRadioButton("Kyllä, salasanani on:");

        isUserButton.setSelected(true);
        JPasswordField isUserPasswordField = new JPasswordField(20);

        //Kun ei ole vielä tunnuksia
        JRadioButton isNotUserButton = new JRadioButton("Ei, haluan luoda tunnukset!");

        //Lisätään valintanapit ryhmään
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(isUserButton);
        buttonGroup.add(isNotUserButton);

        /*Uuden käyttäjän salasanan luonti on aluksi piilossa 
        kunnes käyttäjä ilmoittaa, ettei hänellä ole tunnuksia
         */
        JLabel createPasswordText = new JLabel("Keksi salasana:");
        createPasswordText.setVisible(false);
        JPasswordField createPasswordField = new JPasswordField(20);
        createPasswordField.setVisible(false);
        JLabel repeatPasswordText = new JLabel("Toista salasana:");
        repeatPasswordText.setVisible(false);
        JPasswordField repeatPasswordField = new JPasswordField(20);
        repeatPasswordField.setVisible(false);

        //Kirjautuminen/tunnusten luontipainike
        JButton signInOrCreateUserButton = new JButton("Kirjaudu");

        //Komentotunnisteet kuuntelijaa varten 
        isUserButton.setActionCommand("isUser");
        isNotUserButton.setActionCommand("isNotUser");
        signInOrCreateUserButton.setActionCommand("pushed");

        //lisätään komponentit paneeliin
        signInMenuPanel.add(usernameText);
        signInMenuPanel.add(usernameField);
        signInMenuPanel.add(areUaUserText);
        signInMenuPanel.add(empty);
        signInMenuPanel.add(isUserButton);
        signInMenuPanel.add(isUserPasswordField);
        signInMenuPanel.add(isNotUserButton);
        signInMenuPanel.add(new JLabel(""));
        signInMenuPanel.add(createPasswordText);
        signInMenuPanel.add(createPasswordField);
        signInMenuPanel.add(repeatPasswordText);
        signInMenuPanel.add(repeatPasswordField);
        signInMenuPanel.add(new JLabel(""));
        signInMenuPanel.add(new JLabel(""));
        signInMenuPanel.add(new JLabel(""));
        signInMenuPanel.add(signInOrCreateUserButton);

        //lisätään kuuntelija ja asetetaan se eri painikkeille      
        SignInMenuListener listener = new SignInMenuListener(usernameField, isUserPasswordField, createPasswordText, createPasswordField, repeatPasswordText, repeatPasswordField, signInOrCreateUserButton, views, controller);
        isUserButton.addActionListener(listener);
        isNotUserButton.addActionListener(listener);
        signInOrCreateUserButton.addActionListener(listener);
    }
}
