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
 * Luokka käyttäjävalikon toimintojen kuuntelua varten.
 *
 */
public class UserMenuListener implements ActionListener, ListSelectionListener {

    private Views views;
    private AppControlLogic controller;
    private JLabel currentCollectionLabel;
    private JList collectionList;
    private JButton renameButton;
    private JButton studyNowButton;
    private JButton createNewCollectionButton;
    private JButton removeCollectionButton;
    private JButton signOutButton;
    private CollectionsModel model;

    /**
     * Luokan konstruktori joka saa parametreina kuunneltavat/muutettavat
     * kohteet.
     *
     * @param views Ikkunanäkymiä hallitseva views-luokan olio
     * @param controller Kontrolleri joka hallinnoi käyttäjä/korttiluokkia
     * @param currentCollectionLabel Valittu kokoelma teksti
     * @param collectionList Kokoelmalistaus
     * @param model Malli JListia varten
     * @param studyNowButton Painike opiskelunäkymään siirtymistä varten
     * @param renameButton Uuudelleennimeämispainike
     * @param createNewCollectionButton Painike uuden kokoelmaan luontia varten
     * käyttäjän kokoelmalistaukseen
     * @param removeCollectionButton Painike kokoelman poistamista varten
     * @param signOutButton Uloskirjautumispainike
     */
    public UserMenuListener(Views views, AppControlLogic controller, JLabel currentCollectionLabel, JList collectionList, CollectionsModel model, JButton studyNowButton, JButton renameButton, JButton createNewCollectionButton, JButton removeCollectionButton, JButton signOutButton) {
        this.views = views;
        this.controller = controller;
        this.currentCollectionLabel = currentCollectionLabel;
        this.collectionList = collectionList;
        this.model = model;
        this.renameButton = renameButton;
        this.studyNowButton = studyNowButton;
        this.createNewCollectionButton = createNewCollectionButton;
        this.removeCollectionButton = removeCollectionButton;
        this.signOutButton = signOutButton;

        if (this.model.getSize() == 0) {
            disableButtons();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();

        //Jos on painettu opiskele nyt nappia 
        if (ac.equals("study")) {
            currentCollectionAction();
            this.views.switchToView("StudyView");
        }
        // Jos on painettu uudelleennimeämisnappia
        if (ac.equals("rename")) {
            Object[] buttons = {"Ok", "Peruuta"};
            JPanel renamePanel = new JPanel();
            renamePanel.add(new JLabel("Anna uusi nimi kokoelmalle: "));
            JTextField collectionNameField = new JTextField(40);
            renamePanel.add(collectionNameField);

            int result = JOptionPane.showOptionDialog(null, renamePanel, "Nimeä kokoelma uudelleen",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, buttons, null);
            if (result == JOptionPane.OK_OPTION) {
                String collectionName = collectionNameField.getText();
                if (collectionName != null && !collectionName.isEmpty()) {
                    this.model.setName(collectionName, collectionList.getSelectedIndex());
                }
            }
        }
        // Jos on painettu luo uusi kokoelma nappia
        if (ac.equals("create")) {
            Object[] buttons = {"Ok", "Peruuta"};
            JPanel namePanel = new JPanel();
            namePanel.add(new JLabel("Anna nimi kokoelmalle: "));
            JTextField collectionNameField = new JTextField(40);
            namePanel.add(collectionNameField);

            int result = JOptionPane.showOptionDialog(null, namePanel, "Luo uusi kokoelma",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, buttons, null);
            if (result == JOptionPane.OK_OPTION) {

                String collectionName = collectionNameField.getText();
                if (collectionName != null && !collectionName.isEmpty()) {
                    this.model.addNewCollection(collectionName);
                }
            }
        }

        // Jos on painettu poista kokoelma nappia
        if (ac.equals("remove")) {
            this.model.removeCollection(collectionList.getSelectedIndices());
        }

        // Jos on painettu uloskirjautumisnappia
        if (ac.equals("signOut")) {
            this.views.switchToView("SignInMenu");
        }

        // Jos lista tyhjä 
        if (this.model.getSize() == 0) {
            disableButtons();
            this.currentCollectionLabel.setText("");
            //muuten
        } else {
            enableButtons();
            this.collectionList.setSelectedIndex(0);
            currentCollectionAction();
        }

    }

    //kuuntelijan metodi joka reagoi listan muutoksiin
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            if (collectionList.getSelectedIndex() == -1) {
                disableButtons();
                this.currentCollectionLabel.setText("");
            } else if (collectionList.getSelectedIndices().length > 1) {
                disableButtons();
                this.removeCollectionButton.setEnabled(true);
                this.currentCollectionLabel.setText("");
            } else {
                enableButtons();
                currentCollectionAction();
            }
        }
    }

    //Metodi poistaa osan napeista käytöstä
    private void disableButtons() {
        this.studyNowButton.setEnabled(false);
        this.renameButton.setEnabled(false);
        this.removeCollectionButton.setEnabled(false);
    }

    // Metodi palauttaa kaikki napit käyttöön
    private void enableButtons() {
        this.studyNowButton.setEnabled(true);
        this.renameButton.setEnabled(true);
        this.removeCollectionButton.setEnabled(true);
    }

    /* Metodi asettaa käyttäjän valitseman kokoelman valituksi ja 
    ja päivittää samalla korttilaskurin.
     */
    private void currentCollectionAction() {
        this.model.setCurrentCollection(collectionList.getSelectedIndex());
        this.controller.setCurrentCollection();
        this.currentCollectionLabel.setText("Kokoelmassa " + this.controller.getCurrentCollection().toString() + " on " + this.controller.getCurrentCollection().getSize() + " korttia.");
    }

}
