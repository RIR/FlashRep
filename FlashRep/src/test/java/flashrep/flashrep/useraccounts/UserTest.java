/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.useraccounts;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.useraccounts.User;
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
public class UserTest {

    User user;
    Flashcard flashcard;
    FlashcardCollection flashcardCollection;

    public UserTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        user = new User("user", "password");
        flashcard = new Flashcard("Kysymys", "vastaus");
        flashcardCollection = new FlashcardCollection("Kokoelma");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
    }

    @Test
    public void constructorSetsUsernameRight() {
        assertEquals("user", user.getUserName());
    }

    @Test
    public void constructorSetsPasswordRight() {
        assertEquals("password", user.getPassword());
    }

    @Test
    public void getUsernameGetsRightNameAfterSetUsernameUsed() {
        user.setUserName("new user");
        assertEquals("new user", user.getUserName());
    }

    @Test
    public void getPasswordGetsRightPasswordAfterSetPasswordUsed() {
        user.setPassword("new password");
        assertEquals("new password", user.getPassword());
    }

    @Test
    public void rateCardIsWorkingWithNumberInCorrectScale() {
        user.rateCard(flashcard, 4);
        assertEquals(4, flashcard.getRating());
    }

    @Test
    public void rateCardIsWorkingWithNumberNotInCorrectScale() {
        user.rateCard(flashcard, 7);
        assertEquals(1, flashcard.getRating());
    }

    @Test
    public void addToOwnCollectionsAddsCollection() {
        user.addToOwnCollections(flashcardCollection);
        assertTrue(user.getOwnCollections().contains(flashcardCollection));
    }

    @Test
    public void removeFromOwnCollectionsRemovesCollection() {
        user.addToOwnCollections(flashcardCollection);
        user.removeFromOwnCollections(flashcardCollection);
        assertFalse(user.getOwnCollections().contains(flashcardCollection));
    }

    @Test
    public void setOwnCollectionsSetsCollections() {
        AllFlashcardCollections someoneElsesCollections = new AllFlashcardCollections();
        someoneElsesCollections.addCollection(flashcardCollection);
        assertNotEquals(user.getOwnCollections(), someoneElsesCollections.getCollections());

        user.setOwnCollections(someoneElsesCollections.getCollections());
        assertEquals(user.getOwnCollections(), someoneElsesCollections.getCollections());
    }

    @Test
    public void toStringReturnsUserame() {
        assertEquals("user", user.toString());
    }
}
