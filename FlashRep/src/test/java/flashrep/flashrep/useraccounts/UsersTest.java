/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.useraccounts;

import flashrep.flashrep.useraccounts.Users;
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
    }

    @After
    public void tearDown() {
    }

    private void userAdderHelper(int num) {
        for (int i = 0; i < num; i++) {
            String str = Integer.toString(i);
            user = new User("username " + str, "password" + str);
            users.addUser(user);
        }
    }

    @Test
    public void hello() {
    }

    @Test
    public void constructorInitializesList() {
        assertEquals(0, users.getUsercount());
    }

    @Test
    public void addingUserIncreasesListSize() {
        userAdderHelper(1);
        assertEquals(1, users.getUsercount());
    }

    @Test
    public void addUserAddsRightUser() {
        userAdderHelper(1);
        assertEquals(true, users.getUsers().contains(user));
    }

    @Test
    public void removeUserRemovesUser() {
        userAdderHelper(1);
        users.removeUser(user);
        assertEquals(0, users.getUsercount());
        assertEquals(false, users.getUsers().contains(user));
    }

    @Test
    public void RemovingAllUsersRemovesUsers() {
        userAdderHelper(20);
        assertEquals(20, users.getUsercount());
        users.removeAllUsers();
        assertEquals(0, users.getUsercount());
    }

    @Test
    public void getUsersReturnsRightUsers() {
        userAdderHelper(20);
        int i = 0;
        for (User user : users.getUsers()) {
            String str = Integer.toString(i);
            User comparisonUser = new User("username " + str, "password" + str);
            assertEquals(user, comparisonUser);
            i++;
        }
    }

    @Test
    public void GetUserGetsUserIfUserAdded() {
        user = new User("user", "password");
        users.addUser(user);
        assertEquals(user, users.getUser(user));
    }

    @Test
    public void GetUserReturnsNullWhenUserNotInList() {
        user = new User("user", "password");
        users.addUser(user);
        users.removeAllUsers();
        assertEquals(null, users.getUser(user));
    }

}
