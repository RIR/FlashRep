package flashrep.flashrep.gui;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.logic.AppControlLogic;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

        showCard();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ac = e.getActionCommand();

        if (ac.equals("showAnswer")) {
            this.answerLabel.setVisible(true);
            this.showAnswerButton.setVisible(false);
            setRatingButtonsVisible();
        }
        if (ac.equals("createNewCard")) {
            JTextField question = new JTextField();
            JTextField answer = new JTextField();
            Object[] card = {
                "Kysymys: ", question,
                "Vastaus:", answer
            };
            int option = JOptionPane.showConfirmDialog(null, card, "Uusi kortti", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            String q = question.getText();
            String a = answer.getText();

            if (option == JOptionPane.OK_OPTION) {
                if (!q.isEmpty() && !a.isEmpty()) {
                    Flashcard flashcard = new Flashcard(q, a);
                    this.controller.getRepetitionLogic().insertCardInToRotation(flashcard);
                } else {
                    System.out.println("Annoithan sekä kysymyksen, että vastauksen?");
                }
                if (this.controller.getCurrentCard() == null) {
                    showCard();
                }
            }
        }
        if (ac.equals("removeCard")) {
            this.controller.getRepetitionLogic().removeFromRotation();
            showCard();

        }
        if (ac.equals("backToUserMenu")) {
            this.controller.quitRepetition();
            this.views.switchToView("UserMenu");
        }

        if (ac.equals("easy")) {
            this.controller.getCurrentCard().setRating(1);
            this.controller.getRepetitionLogic().insertCardInToRotation(this.controller.getCurrentCard());
            showCard();
        }
        if (ac.equals("good")) {
            this.controller.getCurrentCard().setRating(2);
            this.controller.getRepetitionLogic().insertCardInToRotation(this.controller.getCurrentCard());
            showCard();
        }
        if (ac.equals("hard")) {
            this.controller.getCurrentCard().setRating(3);
            this.controller.getRepetitionLogic().insertCardInToRotation(this.controller.getCurrentCard());
            showCard();
        }
        if (ac.equals("veryHard")) {
            this.controller.getCurrentCard().setRating(4);
            this.controller.getRepetitionLogic().insertCardInToRotation(this.controller.getCurrentCard());
            showCard();
        }

    }

    private void showCard() {
        if (this.controller.getRepetitionLogic().getRotationSize() != 0) {
            setCollectionEmptyTextNotVisible();
            setRatingButtonsNotVisible();
            this.showAnswerButton.setVisible(true);
            this.removeCardButton.setEnabled(true);
            this.controller.setCurrentCard();
            setQuestionAndAnswerLabels();

        } else {
            setCollectionEmptyTextVisible();
            setRatingButtonsNotVisible();
            this.showAnswerButton.setVisible(false);
            this.removeCardButton.setEnabled(false);

        }
    }

    private void setCollectionEmptyTextVisible() {
        this.questionLabel.setVisible(false);
        this.answerLabel.setVisible(false);
        this.noCardsLabel.setVisible(true);
    }

    private void setCollectionEmptyTextNotVisible() {
        this.questionLabel.setVisible(true);
        this.answerLabel.setVisible(false);
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

    private void setQuestionAndAnswerLabels() {
        this.questionLabel.setText(this.controller.getCurrentCard().getQuestion());
        this.answerLabel.setText(this.controller.getCurrentCard().getAnswer());
    }

}
