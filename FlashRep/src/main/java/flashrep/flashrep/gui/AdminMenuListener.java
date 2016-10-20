package flashrep.flashrep.gui;

import flashrep.flashrep.logic.AppControlLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Luokka admin-valikon toimintojen kuuntelua varten.
 *
 * @author Raine Rantanen
 */
public class AdminMenuListener implements ActionListener, ListSelectionListener {

    private Views views;
    private AppControlLogic controller;
    private JLabel userCountLabel;
    private JList userlist;
    private JButton setPasswordButton;
    private JButton getPasswordButton;
    private JButton removeUserButton;
    private JButton signOutButton;
    private UsersModel model;

    /**
     * Luokan kontrolleri joka saa parametreina kuunneltavat/muutettavat
     * kohteet.
     *
     * @param views Ikkunanäkymiä hallitseva views-luokan olio
     * @param controller Kontrolleri joka hallinnoi käyttäjä/korttiluokkia
     * @param userCountLabel Käyttäjälaskuriteksti
     * @param userlist Käyttäjälistaus
     * @param model Malli JListia varten
     * @param getPasswordButton Näytä käyttäjän salasana-painike
     * @param setPasswordButton Aseta käyttäjän salasana-painike
     * @param removeUserButton Poista käyttäjä-painike
     * @param signOutButton Uloskirjautumispainike
     */
    public AdminMenuListener(Views views, AppControlLogic controller, JLabel userCountLabel, JList userlist, UsersModel model, JButton getPasswordButton, JButton setPasswordButton, JButton removeUserButton, JButton signOutButton) {
        this.views = views;
        this.controller = controller;
        this.userCountLabel = userCountLabel;
        this.userlist = userlist;
        this.setPasswordButton = setPasswordButton;
        this.getPasswordButton = getPasswordButton;
        this.removeUserButton = removeUserButton;
        this.signOutButton = signOutButton;
        this.model = model;

        if (this.model.getSize() == 0) {
            disableButtons();
        } else {
            this.userlist.setSelectedIndex(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();

        //Jos on painettu Näytä käyttäjän salasana-nappia 
        if (ac.equals("getPass")) {
            currentUserAction();
            JOptionPane.showMessageDialog(views, "Käyttäjän salana on: " + this.controller.getCurrentUser().getPassword());
        }
        // Jos on painettu aseta käyttäjän salasana-nappia
        if (ac.equals("setPass")) {
            Object[] buttons = {"Ok", "Peruuta"};
            JPanel setPasswordPanel = new JPanel();
            setPasswordPanel.add(new JLabel("Anna uusi salasana: "));
            JTextField passwordField = new JTextField(40);
            setPasswordPanel.add(passwordField);

            int result = JOptionPane.showOptionDialog(null, setPasswordPanel, "Vaihda käyttäjän salasana",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, buttons, null);
            if (result == JOptionPane.OK_OPTION) {
                String password = passwordField.getText();
                if (password != null && !password.isEmpty()) {
                    this.model.setPassword(password, userlist.getSelectedIndex());
                }
            }
        }

        // Jos on painettu poista käyttäjä nappia
        if (ac.equals("remove")) {
            this.model.removeUser(userlist.getSelectedIndices());
        }

        // Jos on painettu uloskirjautumisnappia
        if (ac.equals("signOut")) {
            this.views.switchToView("SignInMenu");
        }

        // Jos lista tyhjä 
        if (this.model.getSize() == 0) {
            disableButtons();
            this.userCountLabel.setText("");
            //muuten
        } else {
            enableButtons();
            this.userlist.setSelectedIndex(0);
            currentUserAction();
        }

        this.userCountLabel.setText("Ohjelmalla on " + this.model.getSize() + " käyttäjää.");
    }

    //kuuntelijan metodi joka reagoi listan muutoksiin
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            if (userlist.getSelectedIndex() == -1) {
                disableButtons();
            } else if (userlist.getSelectedIndices().length > 1) {
                disableButtons();
                this.removeUserButton.setEnabled(true);
            } else {
                enableButtons();
                currentUserAction();
            }
        }
    }

    //Metodi poistaa osan napeista käytöstä
    private void disableButtons() {
        this.getPasswordButton.setEnabled(false);
        this.setPasswordButton.setEnabled(false);
        this.removeUserButton.setEnabled(false);
    }

    // Metodi palauttaa kaikki napit käyttöön
    private void enableButtons() {
        this.getPasswordButton.setEnabled(true);
        this.setPasswordButton.setEnabled(true);
        this.removeUserButton.setEnabled(true);
    }

    /* Metodi asettaa valitun käyttäjän valituksi
     */
    private void currentUserAction() {
        this.model.setCurrentUser(userlist.getSelectedIndex());
        this.controller.setCurrentUser();
    }

}
