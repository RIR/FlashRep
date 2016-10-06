package flashrep.flashrep.logic;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.cards.FlashcardCollection;
import flashrep.flashrep.gui.CollectionsModel;
import flashrep.flashrep.useraccounts.User;
import flashrep.flashrep.useraccounts.Users;

/**
 * Luokka jonka avulla käyttöliittymä saa käyttöönsä
 * ohjelman käyttäjä-, kokoelma ja logiikkaluokat ja niiden toiminnot.
 *
 */
public class Controller {

    Users users;
    User currentUser;
    AllFlashcardCollections allFlashcardCollections;
    RepetitionLogic repetitionLogic;
    CollectionsModel currentUsersCollections;
    FlashcardCollection currentCollection;

    /**
     * Luokan konstruktori.
     */
    public Controller() {
        this.users = new Users();
        this.currentUser = new User("", "");
        this.allFlashcardCollections = new AllFlashcardCollections();
        this.currentUsersCollections = new CollectionsModel(this.currentUser.getOwnCollections());
        this.currentCollection= new FlashcardCollection("");
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
        User prospectUser = new User(username, String.valueOf(password));
        if (this.users.containsUser(prospectUser) && this.users.getUser(prospectUser).getPassword().equals(String.valueOf(password))) {
            this.currentUser = this.users.getUser(prospectUser);
            return true;
        }
        return false;
    }

    /**
     * Metodi palauttaa ohjelman tämänhetkisen käyttäjän.
     *
     * @return Ohjelman tämänhetkinen käyttäjä
     */
    public User getCurrentUser() {
        return this.currentUser;
    }

    /**
     * Metodi palauttaa JListin mallina toimivan CollectionsModel-mallin.
     * @return CollectionsModel joka perii AbstractListModel-luokan ominaisuudet
     * @see AbstractListModel
     */
    public CollectionsModel getCurrentUsersCollections() {
        return currentUsersCollections;
    }

    /**
     * Metodi palauttaa kokoelmalistauksesta käyttäjän valitseman kokoelman, 
     * tämä on käytössä kun käyttäjä valitsee mitä kokoelmaa haluaa kerrata.
     * 
     * @return juuri nyt valittuna oleva kokoelma
     */
    public FlashcardCollection getCurrentCollection() {
        return currentCollection;
    }

    /**
     * Metodi asettaa listauksesta jonkun kokoelman valituksi kun käyttäjä sen valitsee.
     */
    public void setCurrentCollection() {
        this.currentCollection = this.currentUsersCollections.getCurrentCollection();
    }
    
    
}
