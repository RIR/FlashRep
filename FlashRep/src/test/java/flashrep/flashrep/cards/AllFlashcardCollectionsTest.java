package flashrep.flashrep.cards;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class AllFlashcardCollectionsTest {

    AllFlashcardCollections listOfFlashcardCollections;
    FlashcardCollection flashcardCollection;

    public AllFlashcardCollectionsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        listOfFlashcardCollections = new AllFlashcardCollections();
        flashcardCollection = new FlashcardCollection("Collection");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
    }

    @Test
    public void constructorInitializesList() {
        assertEquals(0, listOfFlashcardCollections.getAmountOfCollections());
    }

    @Test
    public void addingCollectionIncreasesListSize() {
        listOfFlashcardCollections.addCollection(flashcardCollection);
        assertEquals(1, listOfFlashcardCollections.getAmountOfCollections());
    }

    @Test
    public void listHasRightCollectionAfterAddingCollection() {
        listOfFlashcardCollections.addCollection(flashcardCollection);
        assertTrue(listOfFlashcardCollections.getFlashcardCollections().contains(flashcardCollection));
    }

    @Test
    public void removingCollectionDecreasesListSize() {
        listOfFlashcardCollections.addCollection(flashcardCollection);
        listOfFlashcardCollections.removeCollection(flashcardCollection);
        assertEquals(0, listOfFlashcardCollections.getAmountOfCollections());
    }

    @Test
    public void RemovingCollectionRemovesFlashcard() {
        listOfFlashcardCollections.addCollection(flashcardCollection);
        listOfFlashcardCollections.removeCollection(flashcardCollection);
        assertFalse(listOfFlashcardCollections.getFlashcardCollections().contains(flashcardCollection));
    }
}
