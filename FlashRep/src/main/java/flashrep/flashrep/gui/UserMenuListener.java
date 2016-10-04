package flashrep.flashrep.gui;

import flashrep.flashrep.logic.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Raine Rantanen
 */
public class UserMenuListener implements ActionListener {

    private Views views;
    private Controller controller;
    private JButton signOutButton;
    
    public UserMenuListener(Views views,Controller controller, JButton signOutButton) {
        this.views = views;
        this.controller=controller;
        this.signOutButton = signOutButton;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.views.switchToView("SignInMenu");
    }
    
}
