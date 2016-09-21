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
    
    private void addCardsIntoCollectionHelper(int cards, FlashcardCollection flashcardCollection) {
        for (int i = 0; i < cards; i++) {
            String str = Integer.toString(i);
            Flashcard flashcard = new Flashcard("Kysymys " + str, "Vastaus " + str);
            flashcardCollection.addFlashcardToCollection(flashcard);
        }
    }
    
    private void placecardToCorrectPlaceHelper(int cards) {
        for (int i = 1; i <= cards; i++) {
            Flashcard flashcard = new Flashcard("Kysymys", "Vastaus");
            flashcard.setRating(i);
            spacedRepetition.insertCardInToQueue(flashcard);
        }
        for (int i = 0; i < cards; i++) {
            assertEquals(cards - i, spacedRepetition.showCard().getRating());
        }
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void hello() {
    }
    
    
    @Test
    
    public void loadFlashcardCollectionIntoRotationLoadsAllCardsToRotation(){

}
    @Test
    public void isRemovedFromRotationIsFalseAtFirst() {
        assertEquals(false, spacedRepetition.isRemovedFromRotation());
    }
    
    @Test
    public void removeFromRotationIsWorking() {
        assertEquals(false, spacedRepetition.isRemovedFromRotation());
        
        spacedRepetition.removeFromRotation();
        assertEquals(true, spacedRepetition.isRemovedFromRotation());
    }
    
    @Test
    public void removeAllCardsFromRotationIsWorking() {
        addCardsIntoCollectionHelper(10, flashcardCollection);
        spacedRepetition.setFlashcardCollection(flashcardCollection);
        assertNotEquals(null, spacedRepetition.showCard());
        
        spacedRepetition.removeAllCardsFromRotation();
        assertEquals(null, spacedRepetition.showCard());
    }
    
    @Test
    public void getFlashcardCollectionReturnsRightCollection() {
        assertEquals(flashcardCollection, spacedRepetition.getFlashcardCollection());
    }
    
    @Test
    public void setFlashcardCollectionSetsRightCollection() {
        FlashcardCollection fCollection = new FlashcardCollection("uusi kokoelma");
        spacedRepetition.setFlashcardCollection(fCollection);
        assertEquals("uusi kokoelma", spacedRepetition.getFlashcardCollection().getName());
    }
    
    @Test
    public void insertCardIntoQueueGivesRightOrderWhenCardsRated() {
        spacedRepetition.removeAllCardsFromRotation();
        
        placecardToCorrectPlaceHelper(5);
    }
}
