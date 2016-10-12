package flashrep.flashrep.gui;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.logic.AppControlLogic;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Luokka joka toteuttaa toistonäkymän toimintojen kuuntelun.
 *
 */
public class StudyViewListener implements ActionListener {

    private Views views;
    private AppControlLogic controller;
    private JLabel noCardsLabel;
    private JLabel haveCardsLabel;
    private JPanel cardPanel;
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

    /**
     * Luokan konstruktori joka injektoi kuuntelijan käyttöön parametreina
     * annettavat oliot.
     *
     * @param views Paneeli näkymien vaihtoa varten
     * @param controller Kontrolleriluokka ohjelman luokkien kommunikointia
     * varten
     * @param noCardsLabel Teksti, kun kokoelma tyhjä
     * @param haveCardsLabel Teksti joka kertoo paljon kokoelmassa on kortteja
     * @param cardPanel Paneeli johon näytettävä kortti kuuluu
     * @param questionLabel Kysymysteksti
     * @param answerLabel Vastausteksti
     * @param easyButton Arviointinappula, helppo
     * @param goodButton Arviointinappula, ok
     * @param hardButton Arviointinappula, vaikea
     * @param veryHardButton Arviointinappula, Tosi vaikea
     * @param showAnswerButton Nappula joka näyttää vastauksen
     * @param createNewCardButton Nappula uuden kortin luontia varten
     * @param removeCardButton Nappula kortin poistoa varten
     * @param backToUsermenuButton Nappula käyttäjävalikkoon palaamiseen
     */
    public StudyViewListener(Views views, AppControlLogic controller, JLabel noCardsLabel, JLabel haveCardsLabel, JPanel cardPanel, JLabel questionLabel, JLabel answerLabel, JButton easyButton, JButton goodButton, JButton hardButton, JButton veryHardButton, JButton showAnswerButton, JButton createNewCardButton, JButton removeCardButton, JButton backToUsermenuButton) {
        this.views = views;
        this.controller = controller;
        this.noCardsLabel = noCardsLabel;
        this.haveCardsLabel = haveCardsLabel;
        this.cardPanel = cardPanel;
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
            JPanel newCardPanel = new JPanel(new GridLayout(2, 1, 10, 10));
            JPanel row1Panel = new JPanel();
            JPanel row2Panel = new JPanel();
            Object[] buttons = {"Ok", "Peruuta"};
            JTextField questionField = new JTextField(40);
            JTextField answerField = new JTextField(40);

            row1Panel.add(new JLabel("Kysymys: "));
            row1Panel.add(questionField);
            row2Panel.add(new JLabel("Vastaus: "));
            row2Panel.add(answerField);
            newCardPanel.add(row1Panel);
            newCardPanel.add(row2Panel);

            int result = JOptionPane.showOptionDialog(null, newCardPanel, "Luo uusi kortti",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, buttons, null);
            if (result == JOptionPane.OK_OPTION) {
                String q = questionField.getText();
                String a = answerField.getText();

                if (!q.isEmpty() && !a.isEmpty()) {
                    Flashcard flashcard = new Flashcard(q, a);
                    this.controller.getRepetitionLogic().insertCardInToRotation(flashcard);
                    this.haveCardsLabel.setText("Kokoelmassa on " + (this.controller.getRepetitionLogic().getRotationSize() + 1) + " korttia.");
                } else {
                    JOptionPane.showMessageDialog(null, "Kysymys ja/tai vastaus puuttui!");
                }
                if (this.controller.getCurrentCard() == null) {
                    showCard();
                }
            }
        }
        if (ac.equals("removeCard")) {
            this.controller.getRepetitionLogic().removeFromRotation();
            repetition();

        }
        if (ac.equals("backToUserMenu")) {
            this.controller.quitRepetition();
            this.views.switchToView("UserMenu");
        }

        if (ac.equals("easy")) {
            this.controller.getCurrentCard().setRating(1);
            repetition();
        }
        if (ac.equals("good")) {
            this.controller.getCurrentCard().setRating(2);
            repetition();
        }
        if (ac.equals("hard")) {
            this.controller.getCurrentCard().setRating(3);
            repetition();
        }
        if (ac.equals("veryHard")) {
            this.controller.getCurrentCard().setRating(4);
            repetition();
        }

    }

    // Metodi tekstien asettelua ja seuraavan kortin näyttöä varten
    private void showCard() {
        if (this.controller.getRepetitionLogic().getRotationSize() != 0) {
            setCollectionEmptyTextNotVisible();
            setRatingButtonsNotVisible();
            this.showAnswerButton.setVisible(true);
            this.removeCardButton.setEnabled(true);
            this.haveCardsLabel.setText("Kokoelmassa on " + this.controller.getRepetitionLogic().getRotationSize() + " korttia.");
            this.controller.setCurrentCard();
            setQuestionAndAnswerLabels();

        } else {
            setCollectionEmptyTextVisible();
            setRatingButtonsNotVisible();
            this.showAnswerButton.setVisible(false);
            this.removeCardButton.setEnabled(false);
            this.controller.setCurrentCard();
        }
    }

    //Metodi asettaa näkymän kun kokoelma tyhjä
    private void setCollectionEmptyTextVisible() {
        this.cardPanel.setVisible(false);
        this.questionLabel.setVisible(false);
        this.answerLabel.setVisible(false);
        this.noCardsLabel.setVisible(true);
        this.haveCardsLabel.setVisible(false);
    }

    //Metodi asettaa näkymän kun kokoelmassa on kortteja
    private void setCollectionEmptyTextNotVisible() {
        this.cardPanel.setVisible(true);
        this.questionLabel.setVisible(true);
        this.answerLabel.setVisible(false);
        this.noCardsLabel.setVisible(false);
        this.haveCardsLabel.setVisible(true);

    }

    //Metodi asettaa arviointipainikkeet näkyviksi
    private void setRatingButtonsVisible() {
        this.easyButton.setVisible(true);
        this.goodButton.setVisible(true);
        this.hardButton.setVisible(true);
        this.veryHardButton.setVisible(true);
    }

    //Metodi piilottaa arviointipainikkeet
    private void setRatingButtonsNotVisible() {
        this.easyButton.setVisible(false);
        this.goodButton.setVisible(false);
        this.hardButton.setVisible(false);
        this.veryHardButton.setVisible(false);
    }

    //Metodi asettaa kysymys ja vastaustekstit kortin mukaisesti
    private void setQuestionAndAnswerLabels() {
        this.questionLabel.setText(this.controller.getCurrentCard().getQuestion());
        this.answerLabel.setText(this.controller.getCurrentCard().getAnswer());
    }

    // Metodi toteuttaa toiston
    private void repetition() {
        this.controller.getRepetitionLogic().insertCardInToRotation(this.controller.getCurrentCard());
        showCard();
    }
}
