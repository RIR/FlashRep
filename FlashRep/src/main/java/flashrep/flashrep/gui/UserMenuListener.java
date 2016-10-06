package flashrep.flashrep.gui;

import flashrep.flashrep.logic.AppControlLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Raine Rantanen
 */
/**
 * Luokka käyttäjävalikon toimintojen kuuntelua varten.
 *
 */
public class UserMenuListener implements ActionListener, ListSelectionListener {

    private Views views;
    private AppControlLogic controller;
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
     * @param collectionList Kokoelmalistaus
     * @param studyNowButton Painike opiskelunäkymään siirtymistä varten
     * @param createNewCollectionButton Painike uuden kokoelmaan luontia varten
     * käyttäjän kokoelmalistaukseen
     * @param removeCollectionButton Painike kokoelman poistamista varten
     * @param signOutButton Uloskirjautumispainike
     */
    public UserMenuListener(Views views, AppControlLogic controller, JList collectionList, CollectionsModel model, JButton studyNowButton, JButton renameButton, JButton createNewCollectionButton, JButton removeCollectionButton, JButton signOutButton) {
        this.views = views;
        this.controller = controller;
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

    //kuuntelija nappeja varten
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();

        //Jos on painettu opiskele nyt nappia 
        if (ac.equals("study")) {
            this.model.setCurrentCollection(collectionList.getSelectedIndex());
            this.controller.setCurrentCollection();
            this.views.switchToView("StudyView");
        }
        // Jos on painettu uudelleennimeämisnappia
        if (ac.equals("rename")) {
            String collectionName = JOptionPane.showInputDialog(views, "Anna nimi kokoelmalle:", "Nimeä kokoelma uudelleen", JOptionPane.INFORMATION_MESSAGE);
            if (collectionName != null && !collectionName.isEmpty()) {
                this.model.setName(collectionName, collectionList.getSelectedIndex());
            }
        }
        // Jos on painettu luo uusi kokoelma nappia
        if (ac.equals("create")) {
            String collectionName = JOptionPane.showInputDialog(views, "Anna nimi kokoelmalle:", "Luo uusi kokoelma", JOptionPane.INFORMATION_MESSAGE);
            if (collectionName != null && !collectionName.isEmpty()) {
                this.model.addNewCollection(collectionName);
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
            //muuten
        } else {
            enableButtons();
            this.collectionList.setSelectedIndex(0);
        }

    }

    //kuuntelijan metodi joka reagoi listan muutoksiin
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            if (collectionList.getSelectedIndex() == -1) {
                disableButtons();
            } else if (collectionList.getSelectedIndices().length > 1) {
                disableButtons();
                this.removeCollectionButton.setEnabled(true);
            } else {
                enableButtons();
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
}
