/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.gui;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author Raine Rantanen
 */
public class Views extends JPanel {
    final static String signInMenuPanel = "Sign in view";
    final static String userMenuPanel = "Users personal view";

    public Views() {
        super(new CardLayout());
        initComponents();
    }

    //Luodaan valikon komponentit
    private void initComponents() {
        // luodaan komponentit
        JPanel view1 = new SignInMenuPanel();
        JPanel view2 = new UserMenuPanel();
        add(view1, signInMenuPanel);
        add (view2, userMenuPanel);
        
    }
}
