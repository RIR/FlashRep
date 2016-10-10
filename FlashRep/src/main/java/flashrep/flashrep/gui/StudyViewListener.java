package flashrep.flashrep.gui;

import flashrep.flashrep.logic.AppControlLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class StudyViewListener implements ActionListener {

    private Views views;
    private AppControlLogic controller;

    private JButton easyButton;
    private JButton goodButton;
    private JButton hardButton;
    private JButton veryHardButton;

    private JButton showAnswerButton;
    private JButton createNewCardButton;
    private JButton removeCardButton;
    private JButton backToUsermenuButton;

    public StudyViewListener(Views views, AppControlLogic controller, JButton easyButton, JButton goodButton, JButton hardButton, JButton veryHardButton, JButton showAnswerButton, JButton createNewCardButton, JButton removeCardButton, JButton backToUsermenuButton) {
        this.views = views;
        this.controller = controller;
        this.easyButton = easyButton;
        this.goodButton = goodButton;
        this.hardButton = hardButton;
        this.veryHardButton = veryHardButton;
        this.showAnswerButton = showAnswerButton;
        this.createNewCardButton = createNewCardButton;
        this.removeCardButton = removeCardButton;
        this.backToUsermenuButton = backToUsermenuButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
