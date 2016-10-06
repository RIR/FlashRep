package flashrep.flashrep.gui;

import flashrep.flashrep.logic.Controller;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Raine Rantanen
 */
public class StudyViewPanel extends JPanel {

    private Views views;
    private Controller controller;

    public StudyViewPanel(Views views, Controller controller) {
        this.views = views;
        this.controller = controller;
        initComponents();
    }

    //Luodaan valikon komponentit
    private void initComponents() {
        // luodaan komponentit

        BoxLayout mainLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(mainLayout);

        //Aloitusruudun teksti luodaan, keskitetään ja lisätään
        JLabel label1 = new JLabel("Kokoelma: " + this.controller.getCurrentCollection().toString());
        label1.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label1);
        for (int i = 0; i < 3; i++) {
            add(new JLabel("\n"));
        }

    }

}
