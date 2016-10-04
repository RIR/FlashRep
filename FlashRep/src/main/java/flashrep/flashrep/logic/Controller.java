package flashrep.flashrep.logic;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.useraccounts.User;
import flashrep.flashrep.useraccounts.Users;

/**
 * Luokka käyttäjä- ja korttiluokkien käyttöä ja hallinnointia varten.
 *
 * @author rairanta@cs
 */
public class Controller {

    Users users;
    User user;
    AllFlashcardCollections allFlashcardCollections;
    RepetitionLogic repetitionLogic;

    /**
     * Luokan konstruktori.
     */
    public Controller() {
        this.users = new Users();
        this.user = new User("", "");
        this.allFlashcardCollections = new AllFlashcardCollections();
        
    }

    /**
     * Metodi joka tarkistaa kirjautumisvalikossa voiko lisätä uuden käyttäjän
     * ja lisää sen jos voi.
     *
     * @param username Käyttäjänimi
     * @param password Salasana
     * @return true jos käyttäjän voi lisätä, false jos käyttäjää ei voi lisätä
     */
    public boolean canAddNewUser(String username, char[] password) {
        this.user = new User(username, String.valueOf(password));
        if (!this.users.containsUser(user)) {
            this.users.addUser(user);
            return true;
        }
        return false;
    }

    /**
     * Metodi joka tarkistaa voiko annetulla käyttäjätunnuksella ja salasanalla
     * kirjautua.
     *
     * @param username Käyttäjänimi
     * @param password Salasana
     * @return True Jos annetulla käyttäjätunnuksella ja salasanalla voi
     * kirjautua, false jos ei voi kirjautua.
     */
    public boolean canSignInUser(String username, char[] password) {
        this.user = new User(username, String.valueOf(password));
        if (this.users.containsUser(user) && this.users.getUser(user).getPassword().equals(String.valueOf(password))) {
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa ohjelman tämänhetkisen käyttäjän.
     * @return Ohjelman tämänhetkinen käyttäjä
     */
    public User currentUser() {
        return this.user;      
    }
}
