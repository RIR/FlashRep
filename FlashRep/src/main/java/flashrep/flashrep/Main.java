/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import flashrep.flashrep.logic.SpacedRepetition;
import java.util.Scanner;

/**
 *
 * @author Raine Rantanen
 */
public class Main {
  private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        FlashcardCollection flashcardCollection = new FlashcardCollection("Kokoelma");
        addCardsIntoCollectionHelper(20, flashcardCollection);
        SpacedRepetition spacedRepetition = new SpacedRepetition(flashcardCollection);
        
        for (Flashcard flashcard:flashcardCollection.getFlashcards()){
            
            System.out.print(flashcard.getQuestion()+ " ");
            System.out.print(" : " + spacedRepetition.showCard().getQuestion());
            System.out.println(" ");
        }
    }
    private static void addCardsIntoCollectionHelper(int cards, FlashcardCollection flashcardCollection) {
        for (int i = 1; i <= cards; i++) {
            String str = Integer.toString(i);
            Flashcard flashcard = new Flashcard("Kysymys " + str, "Vastaus " + str);
            flashcardCollection.addFlashcardToCollection(flashcard);
        }      
    }
}


