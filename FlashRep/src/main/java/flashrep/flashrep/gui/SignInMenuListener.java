package flashrep.flashrep.gui;

import flashrep.flashrep.useraccounts.User;
import flashrep.flashrep.useraccounts.Users;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.View;

/**
 *
 * @author Raine Rantanen
 */
public class SignInMenuListener implements ActionListener {

    private JTextField usernameField;
    private JPasswordField isUserPasswordField;
    private JLabel createPasswordText;
    private JPasswordField createPasswordField;
    private JLabel repeatPasswordText;
    private JPasswordField repeatPasswordField;
    private JButton signInOrCreateUserButton;
    private Views views;

    public SignInMenuListener(JTextField usernameField, JPasswordField isUserPasswordField, JLabel createPasswordText, JPasswordField createPasswordField, JLabel repeatPasswordText, JPasswordField repeatPasswordField, JButton signInOrCreateUserButton, Views views) {
        this.usernameField = usernameField;
        this.isUserPasswordField = isUserPasswordField;
        this.createPasswordText = createPasswordText;
        this.createPasswordField = createPasswordField;
        this.repeatPasswordText = repeatPasswordText;
        this.repeatPasswordField = repeatPasswordField;
        this.signInOrCreateUserButton = signInOrCreateUserButton;
        this.views = views;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();

        //Jos uusi käyttäjä ja haluaa luoda tunnukset
        if (ac.equals("isNotUser")) {
            this.isUserPasswordField.setEditable(false);
            this.createPasswordText.setVisible(true);
            this.createPasswordField.setVisible(true);
            this.repeatPasswordText.setVisible(true);
            this.repeatPasswordField.setVisible(true);
            this.signInOrCreateUserButton.setText("Luo tunnukset");

        } else if (ac.equals("isUser")) {
            this.isUserPasswordField.setEditable(true);
            this.createPasswordText.setVisible(false);
            this.createPasswordField.setVisible(false);
            this.repeatPasswordText.setVisible(false);
            this.repeatPasswordField.setVisible(false);
            this.signInOrCreateUserButton.setText("Kirjaudu");
        }
        //Jos luo tunnukset nappia on painettu
        if (ac.equals("pushed")) {
            if (signInOrCreateUserButton.getText().equals("Luo tunnukset")) {
                //jos joku on kentistä tyhjä
                if (fieldIsEmpty(usernameField) || fieldIsEmpty(createPasswordField) || fieldIsEmpty(repeatPasswordField)) {
                    JOptionPane.showMessageDialog(views, "Et täyttänyt kaikkia kenttiä!");
                } else if (!fieldsAreEqual(createPasswordField, repeatPasswordField)) {
                    JOptionPane.showMessageDialog(views, "Salasanat eivät täsmänneet");
                }                
                else {                  
                    this.views.switchToView("User menu");
                }
            }

        }
    }

    private boolean fieldIsEmpty(JTextField field) {
        if (field.getText().trim().equals("")) {
            return true;
        }
        return false;
    }

    private boolean fieldsAreEqual(JTextField field1, JTextField field2) {
        if (field1.getText().equals(field2.getText())) {
            return true;
        }
        return false;
    }
}
