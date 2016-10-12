package flashrep.flashrep.gui;

import flashrep.flashrep.logic.AppControlLogic;
import java.awt.Color;
import java.awt.Component;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
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
        JLabel collectionLabel = new JLabel("Kertaat kokoelmaa: " + this.controller.getCurrentCollection().toString(), JLabel.CENTER);
        collectionLabel.setFont(new Font("", Font.BOLD, 16));
        collectionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        collectionLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        add(collectionLabel);

        add(Box.createRigidArea(new Dimension(0, 30)));

        JLabel noCardsLabel = new JLabel("Kokoelma on tyhjä. Lisää kortteja tai vaihda kokoelmaa.");
        noCardsLabel.setFont(new Font("", Font.BOLD, 16));
        noCardsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        noCardsLabel.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(noCardsLabel);

        JLabel haveCardsLabel = new JLabel("Kokoelmassa on " + this.controller.getRepetitionLogic().getRotationSize() + " korttia.");
        haveCardsLabel.setFont(new Font("", Font.BOLD, 16));
        haveCardsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        haveCardsLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        add(haveCardsLabel);

        JPanel cardPanel = new JPanel();
        BoxLayout cardPanelLayout = new BoxLayout(cardPanel, BoxLayout.Y_AXIS);
        cardPanel.setLayout(cardPanelLayout);

        JLabel questionLabel = new JLabel();
        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
        JLabel answerLabel = new JLabel();

        questionLabel.setFont(new Font("", Font.BOLD, 20));
        answerLabel.setFont(new Font("", Font.BOLD, 20));
        questionLabel.setAlignmentX(CENTER_ALIGNMENT);
        questionLabel.setAlignmentY(TOP_ALIGNMENT);
        answerLabel.setAlignmentX(CENTER_ALIGNMENT);
        questionLabel.setAlignmentY(BOTTOM_ALIGNMENT);
        separator.setAlignmentY(CENTER_ALIGNMENT);

        cardPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        cardPanel.add(questionLabel);
        cardPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        cardPanel.add(separator);
        cardPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        cardPanel.add(answerLabel);
        cardPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        cardPanel.setBackground(Color.white);

        cardPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(cardPanel);

        add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel allButtonsPanel = new JPanel(new FlowLayout());
        JPanel rateButtonsPanel = new JPanel(new FlowLayout());
        JPanel functionButtonsPanel = new JPanel(new FlowLayout());

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

        allButtonsPanel.add(rateButtonsPanel);
        allButtonsPanel.add(functionButtonsPanel);

        allButtonsPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        add(allButtonsPanel);

        easyButton.setActionCommand("easy");
        goodButton.setActionCommand("good");
        hardButton.setActionCommand("hard");
        veryHardButton.setActionCommand("veryHard");

        showAnswerButton.setActionCommand("showAnswer");
        createNewCardButton.setActionCommand("createNewCard");
        removeCardButton.setActionCommand("removeCard");
        backToUsermenuButton.setActionCommand("backToUserMenu");

        StudyViewListener studyViewListener = new StudyViewListener(views, controller, noCardsLabel, haveCardsLabel, cardPanel, questionLabel, answerLabel, easyButton, goodButton, hardButton, veryHardButton, showAnswerButton, createNewCardButton, removeCardButton, backToUsermenuButton);
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
