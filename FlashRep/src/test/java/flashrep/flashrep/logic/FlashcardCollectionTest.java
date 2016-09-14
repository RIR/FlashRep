/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.logic;

import java.util.ArrayList;
import java.util.List;
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
public class FlashcardCollectionTest {

    Flashcard flashcard;
    FlashcardCollection flashCardCollection;
    List<Flashcard> flashcards;

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        flashcard = new Flashcard("Kuka on kingi", "Rane");
        flashCardCollection = new FlashcardCollection("Suomi-Englanti");
        flashcards = new ArrayList<>();
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    public void hello() {
    }

    @Test
    public void constructorSetsNameRight() {
        assertEquals("Suomi-Englanti", flashCardCollection.getName());
    }

    @Test
    public void constructorInitializesList() {
        List<Flashcard> flashcards = new ArrayList<Flashcard>();
        assertEquals(flashcards.size(), flashCardCollection.getSize());
    }

    @Test
    public void addingFlashcardIncreasesListSize() {
        flashCardCollection.addFlashcardToCollection(flashcard);
        assertEquals(1, flashCardCollection.getSize());
    }

    @Test
    public void listHasRightCardAfterAddingFlashcard() {
        flashCardCollection.addFlashcardToCollection(flashcard);
        assertTrue(flashCardCollection.getFlashcards().contains(flashcard));
    }

    @Test
    public void removingFlashcardDecreasesListSize() {
        flashCardCollection.addFlashcardToCollection(flashcard);
        flashCardCollection.removeFlashcardFromCollection(flashcard);
        assertEquals(0, flashCardCollection.getSize());
    }

    @Test
    public void RemovingFlashcardRemovesFlashcard() {
        flashCardCollection.addFlashcardToCollection(flashcard);
        flashCardCollection.removeFlashcardFromCollection(flashcard);
        assertFalse(flashCardCollection.getFlashcards().contains(flashcard));
    }

    @Test
    public void getCardsFromCollectionReturnsRightList() {
        flashCardCollection.addFlashcardToCollection(flashcard);
        flashcards.add(flashcard);
        assertEquals(flashcards, flashCardCollection.getFlashcards());
    }

    @Test
    public void getsizeReturnsRightSizeWhenEmptyList() {
        assertEquals(0, flashCardCollection.getSize());
    }

    @Test
    public void getsizeReturnsRightSizeWithSingleCard() {
        flashCardCollection.addFlashcardToCollection(flashcard);
        assertEquals(1, flashCardCollection.getSize());
    }

    @Test
    public void getsizeReturnsRightSizeWithMultipleCards() {
        for (int i = 0; i < 9; i++) {
            flashCardCollection.addFlashcardToCollection(flashcard);
        }
        assertEquals(9, flashCardCollection.getSize());
    }
}
