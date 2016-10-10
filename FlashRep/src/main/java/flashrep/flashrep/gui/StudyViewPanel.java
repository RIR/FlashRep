package flashrep.flashrep.gui;

import flashrep.flashrep.logic.AppControlLogic;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Raine Rantanen
 */
public class StudyViewPanel extends JPanel {

    private Views views;
    private AppControlLogic controller;

    public StudyViewPanel(Views views, AppControlLogic controller) {
        this.views = views;
        this.controller = controller;
        this.controller.startNewRepetition();
        initComponents();
    }

    //Luodaan valikon komponentit
    private void initComponents() {
        // luodaan komponentit

        BoxLayout mainLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setLayout(mainLayout);

        //Aloitusruudun teksti luodaan, keskitetään ja lisätään
        JLabel collectionLabel = new JLabel("Kertaat kokoelmaa: " + this.controller.getCurrentCollection().toString());
        collectionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(collectionLabel);
        for (int i = 0; i < 3; i++) {
            add(new JLabel("\n"));
        }

        JPanel cardPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JLabel noCardsLabel = new JLabel("Kokoelma on tyhjä. Lisää kortteja tai vaihda kokoelmaa.");
        JLabel questionLabel = new JLabel();
        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
        JLabel answerLabel = new JLabel();

        cardPanel.add(noCardsLabel);
        cardPanel.add(questionLabel);
        cardPanel.add(separator);
        cardPanel.add(answerLabel);

        this.add(cardPanel);
        this.add(Box.createVerticalStrut(50));

        JPanel allButtonsPanel = new JPanel(new FlowLayout());
        JPanel rateButtonsPanel = new JPanel(new FlowLayout());
        JPanel functionButtonsPanel = new JPanel(new FlowLayout());

        this.add(allButtonsPanel);
        allButtonsPanel.add(rateButtonsPanel);
        allButtonsPanel.add(functionButtonsPanel);

        JButton easyButton = new JButton("Helppo");
        JButton goodButton = new JButton("Hyvä");
        JButton hardButton = new JButton("Melko vaikea");
        JButton veryHardButton = new JButton("Tosi vaikea");

        rateButtonsPanel.add(easyButton);
        rateButtonsPanel.add(goodButton);
        rateButtonsPanel.add(hardButton);
        rateButtonsPanel.add(veryHardButton);

        JButton showAnswerButton = new JButton("Näytä vastaus");
        JButton createNewCardButton = new JButton("Luo uusi kortti");
        JButton removeCardButton = new JButton("Poista kortti");
        JButton backToUsermenuButton = new JButton("Palaa kokoelmavalikkoon");

        functionButtonsPanel.add(showAnswerButton);
        functionButtonsPanel.add(createNewCardButton);
        functionButtonsPanel.add(removeCardButton);
        functionButtonsPanel.add(backToUsermenuButton);

        easyButton.setActionCommand("easy");
        goodButton.setActionCommand("good");
        hardButton.setActionCommand("hard");
        veryHardButton.setActionCommand("veryHard");

        showAnswerButton.setActionCommand("showAnswer");
        createNewCardButton.setActionCommand("createNewCard");
        removeCardButton.setActionCommand("removeCard");
        backToUsermenuButton.setActionCommand("backToUsermenu");

        StudyViewListener studyViewListener = new StudyViewListener(views, controller, noCardsLabel, questionLabel, answerLabel, easyButton, goodButton, hardButton, veryHardButton, showAnswerButton, createNewCardButton, removeCardButton, backToUsermenuButton);
        easyButton.addActionListener(studyViewListener);
        goodButton.addActionListener(studyViewListener);
        hardButton.addActionListener(studyViewListener);
        veryHardButton.addActionListener(studyViewListener);

        showAnswerButton.addActionListener(studyViewListener);
        createNewCardButton.addActionListener(studyViewListener);
        removeCardButton.addActionListener(studyViewListener);
        backToUsermenuButton.addActionListener(studyViewListener);

    }

}
