package flashrep.flashrep.gui;

import flashrep.flashrep.logic.Controller;
import javax.swing.JPanel;

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
    }
    
    
}
