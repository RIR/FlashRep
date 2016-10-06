package flashrep.flashrep.main;

import flashrep.flashrep.logic.AppControlLogic;
import flashrep.flashrep.useraccounts.User;
import javax.swing.JPasswordField;

/**
 * @author Raine Rantanen
 */
/**
 * Ohjelman pääluokka josta ohjelma käynnistyy.
 */
public class Main {

    public static void main(String[] args) {
        AppControlLogic flashrepApp = new AppControlLogic();
        flashrepApp.start();
    }
}
