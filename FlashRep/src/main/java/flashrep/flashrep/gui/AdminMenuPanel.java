package flashrep.flashrep.gui;

import flashrep.flashrep.logic.AppControlLogic;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
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
 * Adminvalikkoluokka josta hallinnoidaan ohjelman käyttäjiä.
 */
public class AdminMenuPanel extends JPanel {

    private Views views;
    private AppControlLogic controller;
    private JList userlist;
    private UsersModel model;

    /**
     * Luokan kontrolleri joka saa käyttöönsä parametreina annettavat
     * kontrollerin ja näkymiä hallinnoivan Viewsin.
     *
     * @param views Ikkunanäkymiä hallinnoiva views-luokan ilmentymä
     * @param controller Kontrolleri
     */
    public AdminMenuPanel(Views views, AppControlLogic controller) {
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
        JLabel headLineLabel = new JLabel("Tervetuloa pääkäyttäjä!");
        headLineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(headLineLabel);
        add(new JLabel("\n"));

        JLabel userCountLabel = new JLabel("Ohjelmalla on " + this.controller.getUsers().getUsercount() + " käyttäjää.");
        userCountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(userCountLabel);
        add(new JLabel("\n"));

        //Luodaan ja lisätään paneeleja jotta saadaan jotenkin haluttu näkö
        JPanel adminMenuPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        JPanel listPanel = new JPanel();
        JPanel buttonsPanelWrapper = new JPanel();
        BoxLayout listPanelLayout = new BoxLayout(listPanel, BoxLayout.Y_AXIS);
        BoxLayout buttonsPanelWrapperLayout = new BoxLayout(buttonsPanelWrapper, BoxLayout.Y_AXIS);
        listPanel.setLayout(listPanelLayout);
        buttonsPanelWrapper.setLayout(buttonsPanelWrapperLayout);
        JPanel buttonsPanel = new JPanel(new GridLayout(8, 0, 20, 20));

        adminMenuPanel.add(listPanel);
        adminMenuPanel.add(buttonsPanelWrapper);
        buttonsPanelWrapper.add(new JLabel("\n"));
        buttonsPanelWrapper.add(buttonsPanel);
        add(adminMenuPanel);

        this.userlist = new JList();
        this.model = this.controller.getUserList();
        this.userlist.setModel(model);

        this.userlist.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.userlist.setLayoutOrientation(JList.VERTICAL);
        this.userlist.setVisibleRowCount(10);
        this.userlist.setFixedCellHeight(20);
        this.userlist.setFixedCellWidth(140);
        JScrollPane listScroller = new JScrollPane(userlist);

        // Luodaan tekstit ja painikkeet sekä lisätään ne
        JLabel userlistLabel = new JLabel("Käyttäjät");
        JButton getPasswordButton = new JButton("Näytä käyttäjän salasana");
        JButton setPasswordButton = new JButton("Aseta käyttäjän salasana");
        JButton removeUserButton = new JButton("Poista käyttäjä(t)");
        JButton signOutButton = new JButton("Kirjaudu ulos");

        userlistLabel.setAlignmentX(CENTER_ALIGNMENT);
        listPanel.add(userlistLabel);
        listPanel.add(listScroller);

        buttonsPanel.add(getPasswordButton);
        buttonsPanel.add(setPasswordButton);
        buttonsPanel.add(removeUserButton);
        buttonsPanel.add(signOutButton);

        //Lisätään komentotunnisteet kuuntelija varten
        getPasswordButton.setActionCommand("getPass");
        setPasswordButton.setActionCommand("setPass");
        removeUserButton.setActionCommand("remove");
        signOutButton.setActionCommand("signOut");

        //Luodaan kuuntelija ja lisätään se nappuloiden ja listan käyttöön
        AdminMenuListener listener = new AdminMenuListener(views, controller, userCountLabel, userlist, model, getPasswordButton, setPasswordButton, removeUserButton, signOutButton);
        userlist.addListSelectionListener(listener);
        getPasswordButton.addActionListener(listener);
        setPasswordButton.addActionListener(listener);
        removeUserButton.addActionListener(listener);
        signOutButton.addActionListener(listener);
    }
}
