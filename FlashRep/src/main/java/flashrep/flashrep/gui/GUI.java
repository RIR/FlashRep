package flashrep.flashrep.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        frame.setPreferredSize(new Dimension(200, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void initComponents(Container container) {
        //Käyttöliittymän asetteluksi BoxLayout
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        //Aloitusruudun teksti luodaan, keskitetään ja lisätään
        JLabel label1 = new JLabel("Kirjaudu tai luo tunnus");
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(label1);
        // lisätään kirjautumisvalikko
        container.add(new SignInMenuPanel());
    }

    public JFrame getFrame() {
        return frame;
    }
}
