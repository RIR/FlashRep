package flashrep.flashrep.gui;

import flashrep.flashrep.logic.Controller;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

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
    private JList collectionlist;

    /**
     * Luokan konstruktori jolle annetaan parametreina näkymiä hallitseva
     * Views-luokan olio sekä kortti- ja käyttäjäluokkia hallinnoiva
     * kontrolleri.
     *
     * @param views Views-luokan olio
     * @param controller Kontrolleri
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
        for (int i = 0; i < 3; i++) {
            add(new JLabel("\n"));
        }

        //Luodaan ja lisätään kömpelösti paneeleja jotta saadaan jotenkin haluttu näkö
        JPanel userMenuPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        JPanel listPanel = new JPanel();
        JPanel buttonsPanelWrapper = new JPanel();
        BoxLayout layout = new BoxLayout(listPanel, BoxLayout.Y_AXIS);
        BoxLayout layout2 = new BoxLayout(buttonsPanelWrapper, BoxLayout.Y_AXIS);
        listPanel.setLayout(layout);
        buttonsPanelWrapper.setLayout(layout2);
        JPanel buttonsPanel = new JPanel(new GridLayout(8, 0, 20, 20));

        userMenuPanel.add(listPanel);
        userMenuPanel.add(buttonsPanelWrapper);
        buttonsPanelWrapper.add(new JLabel("\n"));
        buttonsPanelWrapper.add(buttonsPanel);
        add(userMenuPanel);

        this.collectionlist = new JList(this.controller.getCollectionsInArray()); //data has type Object[]
        this.collectionlist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.collectionlist.setLayoutOrientation(JList.VERTICAL);
        this.collectionlist.setVisibleRowCount(10);
        this.collectionlist.setFixedCellHeight(20);
        this.collectionlist.setFixedCellWidth(140);
        JScrollPane listScroller = new JScrollPane(collectionlist);

        // Luodaan tekstit ja painikkeet sekä lisätään ne
        JLabel ownCollectionsLabel = new JLabel("Omat kokoelmat");
        JButton StudyNowButton = new JButton("Opiskele nyt");
        JButton removeCollectionButton = new JButton("Poista omista kokoelmista");
        JButton createNewCollectionButton = new JButton("Luo uusi kokoelma");
        JButton signOutButton = new JButton("Kirjaudu ulos");

        ownCollectionsLabel.setAlignmentX(CENTER_ALIGNMENT);
        listPanel.add(ownCollectionsLabel);
        listPanel.add(listScroller);

        buttonsPanel.add(createNewCollectionButton);
        buttonsPanel.add(removeCollectionButton);
        buttonsPanel.add(StudyNowButton);
        buttonsPanel.add(signOutButton);

        UserMenuListener listener = new UserMenuListener(views, controller, signOutButton);
        signOutButton.addActionListener(listener);

    }
}
