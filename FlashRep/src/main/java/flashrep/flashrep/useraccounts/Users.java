package flashrep.flashrep.useraccounts;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raine Rantanen
 */
public class Users {

    private List<User> users;

    public Users() {
        users = new ArrayList<>();
    }

    public boolean addUser(User user) {
        if (!this.users.contains(user)) {
            this.users.add(user);
            return true;
        }
        return false;
    }

    public void removeUser(User user) {
        if (this.users.contains(user)) {
            this.users.remove(user);
        }
    }

    public void removeAllUsers() {
        this.users.clear();
    }

    public int getUsercount() {
        return this.users.size();
    }

    public List<User> getUsers() {
        return users;
    }
}
