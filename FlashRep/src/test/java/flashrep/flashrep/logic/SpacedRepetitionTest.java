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
        addCardsIntoCollectionHelper(20, flashcardCollection);
        spacedRepetition = new SpacedRepetition(flashcardCollection);
    }

    @After
    public void tearDown() {
    }

    private void addCardsIntoCollectionHelper(int cards, FlashcardCollection flashcardCollection) {
        for (int i = 0; i < cards; i++) {
            String str = Integer.toString(i);
            Flashcard flashcard = new Flashcard("Kysymys " + str, "Vastaus " + str);
            flashcardCollection.addCardToCollection(flashcard);
        }
    }

    private void placecardToCorrectPlaceHelper(int cards, SpacedRepetition spacedRepetition) {
        for (int i = 1; i <= cards; i++) {
            Flashcard flashcard = new Flashcard("Kysymys", "Vastaus");
            flashcard.setRating(i);
            spacedRepetition.insertCardInToRotation(flashcard);
        }
        for (int i = 0; i < cards; i++) {
            assertEquals(cards - i, spacedRepetition.showCard().getRating());
        }
    }

    @Test
    public void hello() {
    }

    @Test
    public void constructorLoadsAllCardsToRotation() {
        assertEquals(spacedRepetition.getFlashcardCollection(), flashcardCollection);
    }

    @Test
    public void showCardReturnsNullIfRotationQueueIsEmpty() {  
       flashcardCollection.removeAllCardsFromCollection();
       spacedRepetition.loadFlashcardCollectionIntoRotation(flashcardCollection);
        assertEquals(null, spacedRepetition.showCard());
    }
    @Test
    public void showCardWorksWithSingleCard() {  
        addCardsIntoCollectionHelper(1, flashcardCollection);
        spacedRepetition.loadFlashcardCollectionIntoRotation(flashcardCollection);
        assertEquals(flashcardCollection.getCards().get(0), spacedRepetition.showCard());
    }

    @Test
    public void showCardWorksWithMultipleCards() {     
        addCardsIntoCollectionHelper(10, flashcardCollection);
        spacedRepetition.loadFlashcardCollectionIntoRotation(flashcardCollection);
        for (int i = 0; i < 10; i++) {
            assertEquals(flashcardCollection.getCards().get(i), spacedRepetition.showCard());
        }
    }

    @Test
    public void getFlashcardCollectionReturnsRightCollection() {
        assertEquals(flashcardCollection, spacedRepetition.getFlashcardCollection());
    }

    @Test
    public void loadFlashcardCollectionIntoRotationSetsRightCollection() {
        FlashcardCollection fCollection = new FlashcardCollection("uusi kokoelma");
        spacedRepetition.loadFlashcardCollectionIntoRotation(fCollection);
        assertEquals("uusi kokoelma", spacedRepetition.getFlashcardCollection().getName());
    }

    @Test
    public void insertCardIntoRotationGivesRightOrderWhenCardsRated() {
        flashcardCollection.removeAllCardsFromCollection();
        placecardToCorrectPlaceHelper(4, new SpacedRepetition(flashcardCollection));
    }
}
