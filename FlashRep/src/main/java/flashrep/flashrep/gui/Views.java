/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.gui;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.useraccounts.Users;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Raine Rantanen
 */
public class Views extends JPanel {

    final static String signInMenuPanel = "Sign in menu";
    final static String userMenuPanel = "User menu";
    private CardLayout cardLayout;
    private Users users;
    private AllFlashcardCollections allFlashcardCollections;

    public Views() {
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);
        initComponents();
        this.users = new Users();
        this.allFlashcardCollections=new AllFlashcardCollections();
    }

    //Luodaan valikon komponentit
    private void initComponents() {
        // luodaan komponentit
        JPanel view1 = new SignInMenuPanel(this);
        JPanel view2 = new UserMenuPanel(this);
        add(view1, signInMenuPanel);
        add(view2, userMenuPanel);

    }

    public void switchToView(String view) {
        cardLayout.show(this, view);
    }

    public Users users() {
        return users;
    }
    
    
}
