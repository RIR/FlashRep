package flashrep.flashrep.logic;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import flashrep.flashrep.gui.CollectionsModel;
import flashrep.flashrep.io.DataHandler;
import flashrep.flashrep.useraccounts.User;
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
public class AppControlLogicTest {

    AppControlLogic controller;
    String userName;
    char[] password;
    String adminName;
    char[] adminPass;

    public AppControlLogicTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        controller = new AppControlLogic();
        userName = "user";
        password = new char[]{'p', 'a', 's', 's'};
        adminName = "admin";
        adminPass = new char[]{'a', 'd', 'm', 'i', 'n'};
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
    }

    @Test
    public void isAdminWorks() {
        assertEquals(false, this.controller.isAdmin(userName, password));
        assertEquals(true, this.controller.isAdmin(adminName, adminPass));

    }

    @Test
    public void canAddNewUserReturnsTrueIfCanAddNewUser() {
        assertEquals(true, this.controller.canAddNewUser(userName, password));
    }

    @Test
    public void canAddNewUserReturnsFalseIfCanNotAddNewUser() {
        assertEquals(true, this.controller.canAddNewUser(userName, password));
        assertEquals(false, this.controller.canAddNewUser(userName, password));
    }

    @Test
    public void canSignInUserReturnsTrueIfCanSignInUser() {
        this.controller.canAddNewUser(userName, password);
        assertEquals(true, this.controller.canSignInUser(userName, password));
    }

    @Test
    public void canSignInUserReturnsFalseIfCanNotSignInUser() {
        assertEquals(false, this.controller.canSignInUser(userName, password));
    }

    @Test
    public void getCurrentUserIsSignedInUser() {
        this.controller.canAddNewUser(userName, password);
        User user = new User(userName, String.valueOf(password));
        assertEquals(this.controller.getCurrentUser(), user);
    }

    @Test
    public void getCurrentUsersCollectionsSizeIsZeroAtFirst() {
        this.controller.canAddNewUser(userName, password);
        assertEquals(this.controller.getCurrentUsersCollections().getSize(), 0);
    }

    @Test
    public void getCurrentUsersCollectionsSizeIsOneAfterAddingCollection() {
        this.controller.canAddNewUser(userName, password);
        this.controller.getCurrentUsersCollections().addNewCollection("new collection");
        assertEquals(this.controller.getCurrentUsersCollections().getSize(), 1);
    }

    @Test
    public void getCurrentCollectionIsNotChosenAtFirst() {
        this.controller.canAddNewUser(userName, password);
        assertEquals(this.controller.getCurrentCollection(), new FlashcardCollection(""));
    }

    @Test
    public void startNewRepetitionStartsNewRepetitionWithCurrentCollection() {
        FlashcardCollection collection = new FlashcardCollection("");
        SpacedRepetition spacedRepetition = new SpacedRepetition(collection);

        this.controller.canAddNewUser(userName, password);
        this.controller.startNewRepetition();

        assertEquals(this.controller.getRepetitionLogic().getFlashcardCollection(), spacedRepetition.getFlashcardCollection());
    }

    @Test
    public void quitRepetitionUpdatesCurrentCollectionForUser() {
        this.controller.canAddNewUser(userName, password);
        this.controller.getCurrentUser().addToOwnCollections(new FlashcardCollection(""));
        this.controller.startNewRepetition();
        Flashcard flashcard = new Flashcard("Kysymys", "Vastaus");
        this.controller.getRepetitionLogic().insertCardInToRotation(flashcard);
        this.controller.quitRepetition();
        for (FlashcardCollection c : this.controller.getCurrentUser().getOwnCollections()) {
            if (c.equals(this.controller.getCurrentCollection())) {
                assertTrue(c.getCards().contains(flashcard));
            }
        }
    }

    @Test
    public void getCurrentCardIsNullAtFirst() {
        this.controller.canAddNewUser(userName, password);
        assertNull(this.controller.getCurrentCard());
    }
}
