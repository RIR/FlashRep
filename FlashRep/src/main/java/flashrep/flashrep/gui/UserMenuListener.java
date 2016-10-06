package flashrep.flashrep.gui;

import flashrep.flashrep.logic.Controller;
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
    private Controller controller;
    private JList collectionList;
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
    public UserMenuListener(Views views, Controller controller, JList collectionList, CollectionsModel model, JButton studyNowButton, JButton createNewCollectionButton, JButton removeCollectionButton, JButton signOutButton) {
        this.views = views;
        this.controller = controller;
        this.collectionList = collectionList;
        this.model = model;
        this.studyNowButton = studyNowButton;
        this.createNewCollectionButton = createNewCollectionButton;
        this.removeCollectionButton = removeCollectionButton;
        this.signOutButton = signOutButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();

        if (ac.equals("study")) {
            this.model.setCurrentCollection(collectionList.getSelectedIndex());
            this.views.switchToView("StudyView");
        }

        if (ac.equals("create")) {
            String collectionName = JOptionPane.showInputDialog(views, "Anna nimi kokoelmalle:", "Luo uusi kokoelma", JOptionPane.INFORMATION_MESSAGE);
            if (collectionName != null && !collectionName.isEmpty()) {
                this.model.addNewCollection(collectionName);
            }
        }
        if (ac.equals("remove")) {
            this.model.removeCollection(collectionList.getSelectedIndex());
        }

        if (ac.equals("signOut")) {
            this.views.switchToView("SignInMenu");
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (collectionList.getSelectedIndex() == -1) {
                //No selection, disable fire button.
                removeCollectionButton.setEnabled(false);

            } else {
                //Selection, enable the fire button.
                removeCollectionButton.setEnabled(true);
            }
        }
    }
}
