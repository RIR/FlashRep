package flashrep.flashrep.useraccounts;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raine Rantanen
 */
/**
 * Luokka tarjoaa metodeita käyttäjälistauksen käsittelyyn.
 */
public class Users {

    private List<User> users;

    /**
     * Luokan konstruktori.
     */
    public Users() {
        users = new ArrayList<>();
    }

    /**
     * Metodi lisää parametrina annettavan käyttäjän käyttäjälistaukseen ja
     * palauttaa true jos lisäys onnistui, false jos lisäys ei onnistunut.
     *
     * @param user Parametrina annettava käyttäjä
     */
    public boolean addUser(User user) {
        if (!containsUser(user)) {
            this.users.add(user);
            return true;
        }
        return false;
    }

    /**
     * Metodi poistaa parametrina annettavan käyttäjän käyttäjälistauksesta.
     *
     * @param user Parametrina annettava käyttäjä
     */
    public void removeUser(User user) {
        if (this.users.contains(user)) {
            this.users.remove(user);
        }
    }

    /**
     * Metodi poistaa kaikki käyttäjät käyttäjälistauksesta.
     */
    public void removeAllUsers() {
        this.users.clear();
    }

    /**
     * Metodi palauttaa käyttäjälistauksen käyttäjien lukumäärän.
     *
     * @return käyttäjien lukumäärä
     */
    public int getUsercount() {
        return this.users.size();
    }

    /**
     * Metodi palauttaa käyttäjälistauksen List-muodossa.
     *
     * @return käyttäjät List-muodossa
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Metodi palauttaa true jos käyttäjä löytyy käyttäjälistauksesta, muuten
     * false.
     *
     * @return true jos käyttäjä löytyy, false jos käyttäjää ei löydy
     */
    public boolean containsUser(User user) {
        if (this.users.contains(user)) {
            return true;
        }
        return false;
    }
}
