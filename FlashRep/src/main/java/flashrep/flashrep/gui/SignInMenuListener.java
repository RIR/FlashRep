package flashrep.flashrep.gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.View;

/**
 *
 * @author Raine Rantanen
 */
public class SignInMenuListener implements ActionListener {
    
    private JPasswordField isUserPasswordField;
    private JLabel newPasswordText;
    private JPasswordField newPasswordField;
    private JLabel createPasswordText;
    private JPasswordField createPasswordField;
    private JButton signInOrCreateUserButton;
    private Views views;
    
    public SignInMenuListener(JPasswordField isUserPasswordField, JLabel newPasswordText, JPasswordField newPasswordField, JLabel createPasswordText, JPasswordField createPasswordField, JButton signInOrCreateUserButton, Views views) {
        this.isUserPasswordField = isUserPasswordField;
        this.newPasswordText = newPasswordText;
        this.newPasswordField = newPasswordField;
        this.createPasswordText = createPasswordText;
        this.createPasswordField = createPasswordField;
        this.signInOrCreateUserButton = signInOrCreateUserButton;
        this.views=views;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        if (ac.equals("isNotUser")) {
            this.isUserPasswordField.setEditable(false);
            this.newPasswordText.setVisible(true);
            this.newPasswordField.setVisible(true);
            this.createPasswordText.setVisible(true);
            this.createPasswordField.setVisible(true);
            this.signInOrCreateUserButton.setText("Luo tunnukset");
        } else {
            this.isUserPasswordField.setEditable(true);
            this.newPasswordText.setVisible(false);
            this.newPasswordField.setVisible(false);
            this.createPasswordText.setVisible(false);
            this.createPasswordField.setVisible(false);
            this.signInOrCreateUserButton.setText("Kirjaudu");
        }
        if (ac.equals("pushed")) {
            views.switchToView("User menu");
        }
    }
    
}
