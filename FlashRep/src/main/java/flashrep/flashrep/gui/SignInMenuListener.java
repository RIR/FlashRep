package flashrep.flashrep.gui;

import flashrep.flashrep.useraccounts.User;
import flashrep.flashrep.useraccounts.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Raine Rantanen
 */
/**
 * Luokka joka toteuttaa kirjautumisvalikon toimintojen kuuntelun.
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
    private Users users;

    /**
     * Luokan konstruktori joka injektoi kuuntelijan käyttöön parametreina
     * annettavat oliot.
     *
     * @param usernameField Käyttäjävalikon käyttäjätunnuskenttä
     * @param isUserPasswordField Käyttäjävalikon salasanakenttä jo
     * rekisteröityneelle käyttäjälle
     * @param createPasswordText Käyttäjävalikon "Keksi salasana"-teksti
     * @param createPasswordField Käyttäjävalikon salasanakenttä uudelle
     * käyttäjälle
     * @param repeatPasswordText Käyttäjävalikon "Toista salasana" teksti
     * @param repeatPasswordField Käyttäjävalikon salasanan toistokenttä
     * @param signInOrCreateUserButton Käyttäjävalikon painike
     * kirjautumiseen/tunnusten luontiin
     * @param views Views-paneeli ikkunanäkymien vaihtoa varten
     * @param users Käyttäjälistaus
     */
    public SignInMenuListener(JTextField usernameField, JPasswordField isUserPasswordField, JLabel createPasswordText, JPasswordField createPasswordField, JLabel repeatPasswordText, JPasswordField repeatPasswordField, JButton signInOrCreateUserButton, Views views, Users users) {
        this.usernameField = usernameField;
        this.isUserPasswordField = isUserPasswordField;
        this.createPasswordText = createPasswordText;
        this.createPasswordField = createPasswordField;
        this.repeatPasswordText = repeatPasswordText;
        this.repeatPasswordField = repeatPasswordField;
        this.signInOrCreateUserButton = signInOrCreateUserButton;
        this.views = views;
        this.users = users;
    }

    /**
     * Metodi reagoi Käyttäjävalikon toimintoihin.
     *
     * @param e Käyttäjävalikon tapahtuma
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();

        //Jos uusi käyttäjä ja haluaa luoda tunnukset
        if (ac.equals("isNotUser")) {
            this.isUserPasswordField.setText("");
            this.isUserPasswordField.setEditable(false);
            this.createPasswordText.setVisible(true);
            this.createPasswordField.setVisible(true);
            this.repeatPasswordText.setVisible(true);
            this.repeatPasswordField.setVisible(true);
            this.signInOrCreateUserButton.setText("Luo tunnukset");

            //Jos käyttäjä ja haluaa kirjautua sisään
        } else if (ac.equals("isUser")) {
            this.isUserPasswordField.setEditable(true);
            this.createPasswordText.setVisible(false);
            this.createPasswordField.setVisible(false);
            this.createPasswordField.setText("");
            this.repeatPasswordText.setVisible(false);
            this.repeatPasswordField.setVisible(false);
            this.repeatPasswordField.setText("");
            this.signInOrCreateUserButton.setText("Kirjaudu");
        }
        //Jos on painettu nappia tunnusten luontia varten
        if (ac.equals("pushed") && signInOrCreateUserButton.getText().equals("Luo tunnukset")) {

            //jos joku on kentistä tyhjä, näytetään virheviesti
            if (fieldIsEmpty(usernameField) || fieldIsEmpty(createPasswordField) || fieldIsEmpty(repeatPasswordField)) {
                JOptionPane.showMessageDialog(views, "Et täyttänyt kaikkia kenttiä!");

                //Jos luotava salasana ja sen kertaus eivät täsmää näytetään virheviesti.
            } else if (!fieldsAreEqual(createPasswordField, repeatPasswordField)) {
                JOptionPane.showMessageDialog(views, "Salasanat eivät täsmänneet");
                
            } else {
                //Luodaan käyttäjä
                     
                User user = new User(this.usernameField.getText(), String.valueOf(this.createPasswordField.getPassword()));
                //Jos käyttäjän lisääminen onnistuu jatketaan käyttäjävalikkoon ja tyhjennetään kentät
                if (!this.users.containsUser(user)) {
                    this.users.addUser(user);
                    this.views.switchToView("UserMenu");
                       clearFields();
                    //Jos käyttäjätunnus on jo varattu näytetään viesti
                } else {
                    JOptionPane.showMessageDialog(views, "Käyttäjätunnus on jo varattu, valitse toinen");
                }
            }
        }
        //Jos kirjautumisnappia painetaan
        if (ac.equals("pushed") && signInOrCreateUserButton.getText().equals("Kirjaudu")) {
            //Luodaan käyttäjä
            User user = new User(this.usernameField.getText(), String.valueOf(this.isUserPasswordField.getPassword()));
            //Jos käyttäjä löytyy käyttäjälistauksesta ja salasana on oikein
            if (this.users.containsUser(user) && this.users.getUser(user).getPassword().equals(String.valueOf(this.isUserPasswordField.getPassword()))) {
                //siirrytään käyttäjävalikkoon ja tyhjennetään kentät
                this.views.switchToView("UserMenu");
                   clearFields();
            } else {
                JOptionPane.showMessageDialog(views, "Käyttäjätunnus tai salasana on väärin!");
            }
        }   
    }

    // Jos kenttä on tyhjä
    private boolean fieldIsEmpty(JTextField field) {
        if (field.getText().trim().equals("")) {
            return true;
        }
        return false;
    }

    //Jos kentät ovat yhtäläiset
    private boolean fieldsAreEqual(JTextField field1, JTextField field2) {
        if (field1.getText().equals(field2.getText())) {
            return true;
        }
        return false;
    }
    
    //Tyhjennä kentät
    private void clearFields() {
        this.usernameField.setText("");        
        this.isUserPasswordField.setText("");
        this.createPasswordField.setText("");
        this.repeatPasswordField.setText("");
    }
}
