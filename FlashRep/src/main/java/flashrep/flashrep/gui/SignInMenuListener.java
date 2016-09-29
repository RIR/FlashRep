package flashrep.flashrep.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Raine Rantanen
 */
public class SignInMenuListener implements ActionListener {

    private JTextField isUserPasswordField;
    private JLabel newPasswordText;
    private JTextField newPasswordField;
    private JLabel createPasswordText;
    private JTextField createPasswordField;
    private JButton signInOrCreateUserButton;

    public SignInMenuListener(JTextField isUserPasswordField, JLabel newPasswordText, JTextField newPasswordField, JLabel createPasswordText, JTextField createPasswordField, JButton signInOrCreateUserButton) {
        this.isUserPasswordField = isUserPasswordField;
        this.newPasswordText = newPasswordText;
        this.newPasswordField = newPasswordField;
        this.createPasswordText = createPasswordText;
        this.createPasswordField = createPasswordField;
        this.signInOrCreateUserButton = signInOrCreateUserButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();
        if (ac.equals("isUser")) {
            this.isUserPasswordField.setEditable(true);
            this.newPasswordText.setVisible(false);
            this.newPasswordField.setVisible(false);
            this.createPasswordText.setVisible(false);
            this.createPasswordField.setVisible(false);
            this.signInOrCreateUserButton.setText("Kirjaudu");
        } else {
            this.isUserPasswordField.setEditable(false);
            this.newPasswordText.setVisible(true);
            this.newPasswordField.setVisible(true);
            this.createPasswordText.setVisible(true);
            this.createPasswordField.setVisible(true);
            this.signInOrCreateUserButton.setText("Luo tunnukset");
        }
    }

}
