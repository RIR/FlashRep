/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.cards;

import flashrep.flashrep.cards.FlashcardCollection;
import flashrep.flashrep.cards.Flashcard;
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
        flashCardCollection = new FlashcardCollection("Suomi-Englanti");
        flashcards = new ArrayList<>();
    }

    @After
    public void tearDown() {
    }

    private void cardAdderHelper(int num) {
        for (int i = 0; i < num; i++) {
            String str = Integer.toString(i);
            flashcard = new Flashcard("Kysymys: " + str, "Vastaus: " + str);
            flashCardCollection.addCardToCollection(flashcard);
        }
    }

    @Test
    public void hello() {
    }

    @Test
    public void constructorSetsNameRight() {
        assertEquals("Suomi-Englanti", flashCardCollection.getName());
    }

    @Test
    public void constructorInitializesList() {
        assertEquals(flashcards, flashCardCollection.getCards());
    }

    @Test
    public void addingCardIncreasesListSize() {
        cardAdderHelper(1);
        assertEquals(1, flashCardCollection.getSize());
    }

    @Test
    public void listHasRightCardAfterAddingCard() {
        cardAdderHelper(1);
        assertTrue(flashCardCollection.getCards().contains(flashcard));
    }

    @Test
    public void RemovingCardRemovesCard() {
        cardAdderHelper(1);
        flashCardCollection.removeCardFromCollection(flashcard);
        assertEquals(0, flashCardCollection.getSize());
        assertFalse(flashCardCollection.getCards().contains(flashcard));
    }

    @Test
    public void RemovingAllCardsRemovesCards() {
        cardAdderHelper(20);
        assertEquals(20, flashCardCollection.getSize());
        flashCardCollection.removeAllCardsFromCollection();
        assertEquals(0, flashCardCollection.getSize());
    }

    @Test
    public void getCardsFromCollectionReturnsRightList() {
        cardAdderHelper(1);
        flashcards.add(flashcard);
        assertEquals(flashcards, flashCardCollection.getCards());
    }

    @Test
    public void getsizeReturnsRightSizeWhenEmptyList() {
        assertEquals(0, flashCardCollection.getSize());
    }

    @Test
    public void getsizeReturnsRightSizeWithSingleCard() {
        cardAdderHelper(1);
        assertEquals(1, flashCardCollection.getSize());
    }

    @Test
    public void getsizeReturnsRightSizeWithMultipleCards() {
        cardAdderHelper(9);
        assertEquals(9, flashCardCollection.getSize());
    }

    @Test
    public void setNameSetsName() {
        flashCardCollection.setName("Nimi");
        assertEquals("Nimi", flashCardCollection.getName());
    }

    @Test
    public void toStringReturnsName() {
        assertEquals("Suomi-Englanti", flashCardCollection.toString());
    }

}
