package flashrep.flashrep.useraccounts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raine Rantanen
 */
/**
 * Luokka tarjoaa metodeita käyttäjälistauksen käsittelyyn.
 */
public class Users implements Serializable {

    private List<User> users;

    /**
     * Luokan konstruktori.
     */
    public Users() {
        users = new ArrayList<>();
    }

    /**
     * Metodi lisää parametrina annettavan käyttäjän käyttäjälistaukseen jos
     * käyttäjää ei listalla vielä ole.
     *
     * @param user Lisättävä käyttäjä
     */
    public void addUser(User user) {
        if (!containsUser(user)) {
            this.users.add(user);
        }
    }

    /**
     * Metodi poistaa parametrina annettavan käyttäjän käyttäjälistauksesta.
     *
     * @param user Poistettava käyttäjä
     */
    public void removeUser(User user) {
        if (containsUser(user)) {
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
     * Metodi palauttaa parametrina annettavan käyttäjän jos käyttäjä löytyy
     * käyttäjälistauksesta tai null jos käyttäjää ei löydy.
     *
     * @param user Haettava käyttäjä
     * @return käyttäjä jos haettava käyttäjä löytyy tai null jos käyttäjää ei
     * löydy
     */
    public User getUser(User user) {
        if (containsUser(user)) {
            for (User u : this.users) {
                if (u.equals(user)) {
                    return u;
                }
            }
        }
        return null;
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
     * Metodi asettaa käyttäjälistaukseksi parametrina annettavan
     * käyttäjälistauksen.
     * @param users Käyttäjälistaus
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    

    /**
     * Metodi palauttaa true jos käyttäjä löytyy käyttäjälistauksesta, muuten
     * false.
     *
     * @param user Käyttäjä
     * @return true jos käyttäjä löytyy, false jos käyttäjää ei löydy
     */
    public boolean containsUser(User user) {
        if (this.users.contains(user)) {
            return true;
        }
        return false;
    }
}
