package flashrep.flashrep.logic;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.useraccounts.Users;

/**
 * Luokka olioiden luontiin eri luokista.
 *
 * @author rairanta@cs
 */
public class Controller {

    Users users;
    AllFlashcardCollections allFlashcardCollections;
    RepetitionLogic repetitionLogic;

    /**
     * Luokan konstruktori.
     */
    public Controller() {
        this.users = new Users();
        this.allFlashcardCollections = new AllFlashcardCollections();
    }

}
