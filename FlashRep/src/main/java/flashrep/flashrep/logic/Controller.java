package flashrep.flashrep.logic;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import flashrep.flashrep.gui.UsersCollectionsModel;
import flashrep.flashrep.useraccounts.User;
import flashrep.flashrep.useraccounts.Users;

/**
 * Luokka käyttäjä- ja korttiluokkien käyttöä ja hallinnointia varten.
 *
 * @author rairanta@cs
 */
public class Controller {

    Users users;
    User currentUser;
    AllFlashcardCollections allFlashcardCollections;
    RepetitionLogic repetitionLogic;
    UsersCollectionsModel usersCollections;

    /**
     * Luokan konstruktori.
     */
    public Controller() {
        this.users = new Users();
        this.currentUser = new User("", "");
        this.allFlashcardCollections = new AllFlashcardCollections();
        this.usersCollections = new UsersCollectionsModel(this.currentUser.getOwnCollections());
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
        this.currentUser = new User(username, String.valueOf(password));
        if (!this.users.containsUser(currentUser)) {
            this.users.addUser(currentUser);
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
        User oldUser = new User(username, String.valueOf(password));
        if (this.users.containsUser(oldUser) && this.users.getUser(oldUser).getPassword().equals(String.valueOf(password))) {
            this.currentUser = this.users.getUser(oldUser);
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa ohjelman tämänhetkisen käyttäjän.
     *
     * @return Ohjelman tämänhetkinen käyttäjä
     */
    public User currentUser() {
        return this.currentUser;
    }

    public UsersCollectionsModel getCurrentUsersCollections() {
        return usersCollections;
    }
    

}
