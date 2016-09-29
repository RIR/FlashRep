package flashrep.flashrep;

import flashrep.flashrep.gui.GUI;
import javax.swing.SwingUtilities;

/**
 * @author Raine Rantanen
 */
public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI();
        SwingUtilities.invokeLater(gui);

    }
}
