/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.userlogic;

import flashrep.flashrep.userlogic.Users;
import flashrep.flashrep.userlogic.User;
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
public class UsersTest {

    Users users;
    User user;

    public UsersTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        users = new Users();
        user = new User("user", "password");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
    }

    @Test
    public void constructorInitializesListRight() {
        assertEquals(0, users.getSize());
    }

    @Test
    public void addUserAddsUser() {
        users.addUser(user);
        assertEquals(true, users.getUsers().contains(user));
    }

    @Test
    public void removeUserRemovesUser() {
        users.addUser(user);
        assertEquals(1, users.getSize());
        assertEquals(true, users.getUsers().contains(user));

        users.removeUser(user);
        assertEquals(0, users.getSize());
        assertEquals(false, users.getUsers().contains(user));
    }
}
