package flashrep.flashrep.cards;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
        listOfFlashcardCollections = new AllFlashcardCollections("Joku");
    }

    @After
    public void tearDown() {
    }

    private void collectionAdderHelper(int num) {
        for (int i = 0; i < num; i++) {
            flashcardCollection = new FlashcardCollection("Collection " + Integer.toString(i));
            listOfFlashcardCollections.addCollection(flashcardCollection);
        }
    }

    @Test
    public void hello() {
    }

    @Test
    public void constructorInitializesList() {
        assertEquals(0, listOfFlashcardCollections.getAmountOfCollections());
    }

    @Test
    public void constructorSetsName() {
        assertEquals("Joku", listOfFlashcardCollections.getName());
    }

    @Test
    public void addingCollectionIncreasesListSize() {
        collectionAdderHelper(1);
        assertEquals(1, listOfFlashcardCollections.getAmountOfCollections());
    }

    @Test
    public void listHasRightCollectionAfterAddingCollection() {
        collectionAdderHelper(1);
        assertTrue(listOfFlashcardCollections.getCollections().contains(flashcardCollection));
    }

    @Test
    public void removingCollectionDecreasesListSize() {
        collectionAdderHelper(1);
        listOfFlashcardCollections.removeCollection(flashcardCollection);
        assertEquals(0, listOfFlashcardCollections.getAmountOfCollections());
    }

    @Test
    public void removingCollectionRemovesFlashcardCollection() {
        collectionAdderHelper(1);
        listOfFlashcardCollections.removeCollection(flashcardCollection);
        assertFalse(listOfFlashcardCollections.getCollections().contains(flashcardCollection));
    }

    @Test
    public void removingAllCollectionsClearsCollections() {
        collectionAdderHelper(10);
        listOfFlashcardCollections.removeAllCollections();
        assertEquals(0, listOfFlashcardCollections.getAmountOfCollections());
    }

    @Test
    public void collectionGetterGets() {
        collectionAdderHelper(1);
        assertEquals(flashcardCollection, listOfFlashcardCollections.getCollections().get(0));
    }

    @Test
    public void nameGetterAndSetterSetsAndGets() {
        listOfFlashcardCollections.setName("Joku muu");
        assertEquals("Joku muu", listOfFlashcardCollections.getName());
    }

    @Test
    public void toStringReturnsName() {
        assertEquals("Joku", listOfFlashcardCollections.toString());
    }

    @Test
    public void hashIsCorrect() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(listOfFlashcardCollections.getCollections());
        hash = 61 * hash + Objects.hashCode(listOfFlashcardCollections.getName());
        assertEquals(hash, listOfFlashcardCollections.hashCode());
    }

    @Test
    public void equalsIsWorking() {
        AllFlashcardCollections newListOfCollections = new AllFlashcardCollections("Joku");
        assertEquals(listOfFlashcardCollections, newListOfCollections);
        listOfFlashcardCollections.addCollection(flashcardCollection);
        assertNotEquals(listOfFlashcardCollections, newListOfCollections);
        newListOfCollections.addCollection(flashcardCollection);
        assertEquals(listOfFlashcardCollections, newListOfCollections);
    }

}
