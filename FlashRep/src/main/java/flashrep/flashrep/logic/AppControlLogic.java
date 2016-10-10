package flashrep.flashrep.logic;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import flashrep.flashrep.gui.CollectionsModel;
import flashrep.flashrep.gui.GUI;
import flashrep.flashrep.useraccounts.User;
import flashrep.flashrep.useraccounts.Users;
import javax.swing.SwingUtilities;

/**
 * Luokka joka käynnistää käyttöliittymän ja jonka avulla käyttöliittymä saa
 * käyttöönsä ohjelman käyttäjä-, kortti- ja logiikkapakettien luokkia ja
 * toimintoja.
 *
 */
public class AppControlLogic {

    Users users;
    User currentUser;
    AllFlashcardCollections allFlashcardCollections;
    FlashcardCollection currentCollection;
    Flashcard currentCard;
    RepetitionLogic repetitionLogic;
    CollectionsModel currentUsersCollections;

    /**
     * Luokan konstruktori.
     */
    public AppControlLogic() {
        this.users = new Users();
        this.currentUser = new User("", "");
        this.allFlashcardCollections = new AllFlashcardCollections();
        this.currentUsersCollections = new CollectionsModel(this.allFlashcardCollections.getCollections());
        this.currentCollection = new FlashcardCollection("");
    }

    /**
     * Metodi käynnistää ohjelman käyttämän käyttöliittymän.
     */
    public void start() {
        GUI gui = new GUI(this);
        SwingUtilities.invokeLater(gui);
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
        User prospectUser = new User(username, String.valueOf(password));
        if (!this.users.containsUser(prospectUser)) {
            this.users.addUser(prospectUser);
            this.currentUser = prospectUser;
            this.currentUsersCollections = new CollectionsModel(this.currentUser.getOwnCollections());
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
            this.currentUsersCollections = new CollectionsModel(this.currentUser.getOwnCollections());
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
     * Metodi palauttaa JListin mallina toimivan käyttäjän kokoelmalistauksen.
     *
     * @return CollectionsModel joka perii AbstractListModel-luokan ominaisuudet
     * @see AbstractListModel
     */
    public CollectionsModel getCurrentUsersCollections() {
        return this.currentUsersCollections;
    }

    /**
     * Metodi palauttaa kokoelmalistauksesta käyttäjän valitseman kokoelman.
     *
     * @return juuri nyt valittuna oleva kokoelma
     */
    public FlashcardCollection getCurrentCollection() {
        return this.currentCollection;
    }

    /**
     * Metodi asettaa listauksesta jonkun kokoelman valituksi kun käyttäjä sen
     * valitsee.
     */
    public void setCurrentCollection() {
        this.currentCollection = this.currentUsersCollections.getCurrentCollection();
    }

    public void startNewRepetition() {
        repetitionLogic = new SpacedRepetition(currentCollection);
    }

    public void quitRepetition() {
        this.currentCollection = this.repetitionLogic.getFlashcardCollection();
    }

    public RepetitionLogic getRepetitionLogic() {
        return repetitionLogic;
    }

    public Flashcard getCurrentCard() {
        return currentCard;
    }

    public void setCurrentCard() {
        this.currentCard = this.repetitionLogic.showCard();
    }

}
