package flashrep.flashrep.logic;

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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
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
        assertEquals(this.controller.currentUser, user);
    }
   
}
