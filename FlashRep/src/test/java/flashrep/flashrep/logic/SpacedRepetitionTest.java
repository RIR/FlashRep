/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.logic;

import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raine Rantanen
 */
public class SpacedRepetitionTest {

    SpacedRepetition spacedRepetition;
    FlashcardCollection flashcardCollection;

    public SpacedRepetitionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        flashcardCollection = new FlashcardCollection("Kokoelma");
        addFlashcardsIntoCollectionHelper(20);
        spacedRepetition = new SpacedRepetition(flashcardCollection);
    }

    private void addFlashcardsIntoCollectionHelper(int cards) {
        for (int i = 0; i < cards; i++) {
            String str = Integer.toString(i);
            Flashcard flashcard = new Flashcard("Kysymys " + str, "Vastaus " + str);
            flashcardCollection.addFlashcardToCollection(flashcard);
        }
    }

    private void CollectionAndRotationCardsInSameOrderTest(int cards) {
        for (int i = 0; i < cards; i++) {
            assertEquals(flashcardCollection.getFlashcards().get(i), spacedRepetition.showFlashcard());
        }
    }

    private void placeFlashcardToCorrectPlaceHelper(int cards) {
        for (int i = 0; i < cards; i++) {
            Flashcard flashcard = spacedRepetition.showFlashcard();
            flashcard.setRating(i + 1);
            spacedRepetition.placeFlashcardInCorrectPlace(flashcard);
        }
        for (int i = 0; i < cards; i++) {
            assertEquals(cards - i, spacedRepetition.showFlashcard().getRating());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
    }

    @Test
    public void showFlashcardShowsAllAddedCardsRight() {
        CollectionAndRotationCardsInSameOrderTest(20);
    }

    @Test
    public void placeFlashcardInCorrectPlacePutsFlashcardsInCorrectPlace() {
        int cards = 5;
        spacedRepetition.removeAllFlashcardsFromRotation();
        flashcardCollection.removeAllFlashcardsFromCollection();

        addFlashcardsIntoCollectionHelper(cards);
        spacedRepetition.setFlashcardCollectionForRotation(flashcardCollection);
        CollectionAndRotationCardsInSameOrderTest(cards);

        placeFlashcardToCorrectPlaceHelper(5);

    }
}
