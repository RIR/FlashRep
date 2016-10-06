package flashrep.flashrep.gui;

import flashrep.flashrep.logic.AppControlLogic;
import java.awt.Component;
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
    private AppControlLogic controller;
    private JList collectionlist;
    private CollectionsModel model;

    /**
     * Luokan konstruktori jolle annetaan parametreina näkymiä hallitseva
     * Views-luokan olio sekä kortti- ja käyttäjäluokkia hallinnoiva
     * kontrolleri.
     *
     * @param views Views-luokan olio
     * @param controller Kontrolleri
     */
    public UserMenuPanel(Views views, AppControlLogic controller) {
        this.views = views;
        this.controller = controller;
        initComponents();
    }

    //Luodaan valikon komponentit
    private void initComponents() {
        // luodaan komponentit

        BoxLayout mainLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(mainLayout);

        //Aloitusruudun teksti luodaan, keskitetään ja lisätään
        JLabel label1 = new JLabel("Käyttäjä: " + this.controller.getCurrentUser().toString());
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label1);
        for (int i = 0; i < 3; i++) {
            add(new JLabel("\n"));
        }

        //Luodaan ja lisätään kömpelösti paneeleja jotta saadaan jotenkin haluttu näkö
        JPanel userMenuPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        JPanel listPanel = new JPanel();
        JPanel buttonsPanelWrapper = new JPanel();
        BoxLayout listPanelLayout = new BoxLayout(listPanel, BoxLayout.Y_AXIS);
        BoxLayout buttonsPanelWrapperLayout = new BoxLayout(buttonsPanelWrapper, BoxLayout.Y_AXIS);
        listPanel.setLayout(listPanelLayout);
        buttonsPanelWrapper.setLayout(buttonsPanelWrapperLayout);
        JPanel buttonsPanel = new JPanel(new GridLayout(8, 0, 20, 20));

        userMenuPanel.add(listPanel);
        userMenuPanel.add(buttonsPanelWrapper);
        buttonsPanelWrapper.add(new JLabel("\n"));
        buttonsPanelWrapper.add(buttonsPanel);
        add(userMenuPanel);

        this.collectionlist = new JList(); //data has type Object[]
        this.model = this.controller.getCurrentUsersCollections();
        this.collectionlist.setModel(model);

        this.collectionlist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.collectionlist.setLayoutOrientation(JList.VERTICAL);
        this.collectionlist.setVisibleRowCount(10);
        this.collectionlist.setFixedCellHeight(20);
        this.collectionlist.setFixedCellWidth(140);
        JScrollPane listScroller = new JScrollPane(collectionlist);

        // Luodaan tekstit ja painikkeet sekä lisätään ne
        JLabel ownCollectionsLabel = new JLabel("Omat kokoelmat");
        JButton studyNowButton = new JButton("Opiskele nyt");
        JButton renameButton = new JButton("Nimeä uudelleen");
        JButton removeCollectionButton = new JButton("Poista kokoelma");
        JButton createNewCollectionButton = new JButton("Luo uusi kokoelma");
        JButton signOutButton = new JButton("Kirjaudu ulos");

        ownCollectionsLabel.setAlignmentX(CENTER_ALIGNMENT);
        listPanel.add(ownCollectionsLabel);
        listPanel.add(listScroller);

        buttonsPanel.add(studyNowButton);
        buttonsPanel.add(renameButton);
        buttonsPanel.add(createNewCollectionButton);
        buttonsPanel.add(removeCollectionButton);
        buttonsPanel.add(signOutButton);

        //Lisätään komentotunnisteet kuuntelija varten
        studyNowButton.setActionCommand("study");
        renameButton.setActionCommand("rename");
        removeCollectionButton.setActionCommand("remove");
        createNewCollectionButton.setActionCommand("create");
        signOutButton.setActionCommand("signOut");

        //Luodaan kuuntelija ja lisätään se nappuloiden ja listan käyttöön
        UserMenuListener listener = new UserMenuListener(views, controller, collectionlist, model, studyNowButton, renameButton, createNewCollectionButton, removeCollectionButton, signOutButton);
        collectionlist.addListSelectionListener(listener);
        studyNowButton.addActionListener(listener);
        renameButton.addActionListener(listener);
        removeCollectionButton.addActionListener(listener);
        createNewCollectionButton.addActionListener(listener);
        signOutButton.addActionListener(listener);

    }
}
