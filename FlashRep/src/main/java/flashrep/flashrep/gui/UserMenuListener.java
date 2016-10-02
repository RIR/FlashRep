package flashrep.flashrep.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Raine Rantanen
 */
public class UserMenuListener implements ActionListener {

    private Views views;
    private JButton signOutButton;
    
    public UserMenuListener(Views views, JButton signOutButton) {
        this.views = views;
        this.signOutButton = signOutButton;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.views.switchToView("SignInMenu");
    }
    
}
