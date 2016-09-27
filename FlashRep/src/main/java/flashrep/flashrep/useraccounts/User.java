package flashrep.flashrep.useraccounts;

import flashrep.flashrep.cards.AllFlashcardCollections;
import flashrep.flashrep.cards.Flashcard;
import flashrep.flashrep.cards.FlashcardCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Raine Rantanen
 */
/**
 * Luokka käyttäjän tarjoaa metodeita käyttäjän käsittelyyn.
 */
public class User {

    private String userName;
    private String password;
    private List<FlashcardCollection> ownCollections;

    /**
     * Luokan konstruktori joka asettaa käyttäjälle parametreina annettavat käyttäjätunnuksen ja salasanan.
     * @param userName parametrina annettava käyttäjätunnus
     * @param password parametrina annettava salasana
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.ownCollections = new ArrayList<>();
    }
    
    /**
     * Metodi palauttaa käyttäjän käyttäjätunnuksen.
     * @return käyttäjätunnus
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Metodi asettaa käyttäjälle parametrina annettavan käyttäjätunnuksen.
     * @param userName parametrina annettava käyttäjätunnus
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Metodi palauttaa käyttäjän salasanan.
     * @return käyttäjän salasana
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metodi asettaa käyttäjälle parametrina annettavan salasanan.
     * @param password parametrina annettava salasana
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodi asettaa parametrina annettavalle kortille parametrina annettavan luokituksen.
     * @param flashcard parametrina annettava kortti
     * @param rating parametrina annettava luokitus
     */
    public void rateCard(Flashcard flashcard, int rating) {
        flashcard.setRating(rating);
    }

    /**
     * Metodi lisää parametrina annettavan korttikokoelman käyttäjän omaan kokoelmalistaukseen.
     * @param flashcardCollection parametrina annettava korttikokoelma
     */
    public void addToOwnCollections(FlashcardCollection flashcardCollection) {
        this.ownCollections.add(flashcardCollection);
    }

    /**
     * Metodi poistaa parametrina annettavan korttikokoelman käyttäjän omasta kokoelmalistauksesta.
     * @param flashcardCollection parametrina annettava korttikokoelma
     */
    public void removeFromOwnCollections(FlashcardCollection flashcardCollection) {
        this.ownCollections.remove(flashcardCollection);
    }

    /**
     * Metodi palauttaa käyttäjän kokoelmalistauksen LIST-muodossa.
     * @return käyttäjän kokoelmalistaus LIST-muodossa
     */
    public List<FlashcardCollection> getOwnCollections() {
        return ownCollections;
    }

    /**
     * Metodi asettaa parametrina annettavan kokoelmalistauksen käyttäjän kokoelmalistaukseksi.
     * @param collections parametrina annettava kokoelmalistaus List-muodossa
     */
    public void setOwnCollections(List<FlashcardCollection> collections) {
        this.ownCollections = collections;
    }

    /**
     * Metodi asettaa käyttäjälle hajautusarvon ja palauttaa sen.
     * @return käyttäjän hajautusarvo
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    /**
     * Metodi vertailee metodia käyttävän käyttäjän ja parametrina annettavan käyttäjän yhtäläisyyttä.
     * @param user parametrina annettava käyttäjä
     * @return true, jos käyttäjät ovat sama käyttäjä, false jos käyttäjät eivät ole sama käyttäjä.
     */
    @Override
    public boolean equals(Object user) {
        if (this == user) {
            return true;
        }
        if (user == null) {
            return false;
        }
        if (getClass() != user.getClass()) {
            return false;
        }
        final User other = (User) user;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

}
