package flashrep.flashrep.gui;

import flashrep.flashrep.logic.AppControlLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StudyViewListener implements ActionListener {

    private Views views;
    private AppControlLogic controller;

    private JLabel noCardsLabel;
    private JLabel questionLabel;
    private JLabel answerLabel;
    private JButton easyButton;
    private JButton goodButton;
    private JButton hardButton;
    private JButton veryHardButton;

    private JButton showAnswerButton;
    private JButton createNewCardButton;
    private JButton removeCardButton;
    private JButton backToUsermenuButton;

    public StudyViewListener(Views views, AppControlLogic controller, JLabel noCardsLabel, JLabel questionLabel, JLabel answerLabel, JButton easyButton, JButton goodButton, JButton hardButton, JButton veryHardButton, JButton showAnswerButton, JButton createNewCardButton, JButton removeCardButton, JButton backToUsermenuButton) {
        this.views = views;
        this.controller = controller;
        this.noCardsLabel = noCardsLabel;
        this.questionLabel = questionLabel;
        this.answerLabel = answerLabel;
        this.easyButton = easyButton;
        this.goodButton = goodButton;
        this.hardButton = hardButton;
        this.veryHardButton = veryHardButton;
        this.showAnswerButton = showAnswerButton;
        this.createNewCardButton = createNewCardButton;
        this.removeCardButton = removeCardButton;
        this.backToUsermenuButton = backToUsermenuButton;

        if (this.controller.getRepetitionLogic().showCard() != null) {
            setRatingButtonsVisible();
            this.showAnswerButton.setVisible(true);
            this.removeCardButton.setEnabled(true);
            this.controller.setCurrentCard();
            this.questionLabel.setText(this.controller.getCurrentCard().getQuestion());

        } else {
            setCollectionEmptyTextVisible();
            setRatingButtonsNotVisible();
            this.showAnswerButton.setVisible(false);
            this.removeCardButton.setEnabled(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();

        if (ac.equals("showAnswer")) {

        }
        if (ac.equals("createNewCard")) {

        }
        if (ac.equals("removeCard")) {

        }
        if (ac.equals("backToUserMenu")) {

        }

        if (ac.equals("easy")) {

        }
        if (ac.equals("good")) {

        }
        if (ac.equals("hard")) {

        }
        if (ac.equals("veryHard")) {

        }

    }

    private void setCollectionEmptyTextVisible() {
        this.questionLabel.setVisible(false);
        this.answerLabel.setVisible(false);
        this.noCardsLabel.setVisible(true);
    }

    private void setCollectionEmptyTextNotVisible() {
        this.questionLabel.setVisible(true);
        this.noCardsLabel.setVisible(false);
    }

    private void setRatingButtonsVisible() {
        this.easyButton.setVisible(true);
        this.goodButton.setVisible(true);
        this.hardButton.setVisible(true);
        this.veryHardButton.setVisible(true);
    }

    private void setRatingButtonsNotVisible() {
        this.easyButton.setVisible(false);
        this.goodButton.setVisible(false);
        this.hardButton.setVisible(false);
        this.veryHardButton.setVisible(false);
    }
}
