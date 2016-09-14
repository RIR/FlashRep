/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.userlogic;

import flashrep.flashrep.userlogic.User;
import flashrep.flashrep.logic.Flashcard;
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
    public void rateCardIsWorkingRight() {
        user.rateCard(flashcard, 4);
        assertEquals(4, flashcard.getRating());
    }
}
