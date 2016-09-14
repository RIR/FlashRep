/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.cards;

import flashrep.flashrep.cards.Flashcard;
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
public class FlashcardTest {
    
    Flashcard flashcard;
    Flashcard secondFlashcard;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        flashcard = new Flashcard("Suomen presidentti", "Sauli Niinistö");
        secondFlashcard = new Flashcard("Suomen presidentti", "Sauli Niinistö");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void hello() {
    }
    
    @Test
    public void constructorSetsQuestionRight() {
        String question = flashcard.getQuestion();
        assertEquals("Suomen presidentti", question);
    }
    
    @Test
    public void constructorSetsAnswerRight() {
        String answer = flashcard.getAnswer();
        assertEquals("Sauli Niinistö", answer);
    }
    
    @Test
    public void constructorSetsRatingRight() {
        assertEquals(1, flashcard.getRating());
    }
    
    @Test
    public void setRatingWillNotSetRatingWithNumberTooLow() {
        flashcard.setRating(0);
        assertEquals(1, flashcard.getRating());
    }

     @Test
    public void setRatingWillNotSetRatingWithNumberTooHigh() {
        flashcard.setRating(17);
        assertEquals(1, flashcard.getRating());
    }
    @Test
    public void swapSwitchesTheQuestion() {
        flashcard.swap();
        String question = flashcard.getQuestion();
        assertEquals("Sauli Niinistö", question);
    }
    
    @Test
    public void swapSwitchesTheAnswer() {
        flashcard.swap();
        String answer = flashcard.getAnswer();
        assertEquals("Suomen presidentti", answer);
    }
    
    @Test
    public void equalsReallyEquals() {
        assertEquals(flashcard, secondFlashcard);
    }
    
    @Test
    public void equalsReallyEqualsAfterSwaps() {
        flashcard.swap();
        secondFlashcard.swap();
        assertEquals(flashcard, secondFlashcard);
    }
    
    @Test
    public void hashcodesAreTheSame() {
        assertEquals(flashcard.hashCode(), secondFlashcard.hashCode());
    }
    
}
