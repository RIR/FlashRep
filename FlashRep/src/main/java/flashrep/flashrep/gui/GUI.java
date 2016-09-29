package flashrep.flashrep.gui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Raine Rantanen
 */
public class GUI implements Runnable {

    private JFrame frame;

    public GUI() {
    }

    @Override
    public void run() {
        frame = new JFrame("FlashRep");
        frame.setPreferredSize(new Dimension(600, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents(Container container) {
        // lisätään näkymät
        container.add(new Views());    
    }

    public JFrame getFrame() {
        return frame;
    }
}
