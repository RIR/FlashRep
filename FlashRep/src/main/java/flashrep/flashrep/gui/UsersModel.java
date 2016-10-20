package flashrep.flashrep.gui;

import flashrep.flashrep.useraccounts.User;
import flashrep.flashrep.useraccounts.Users;
import java.io.Serializable;
import javax.swing.AbstractListModel;

/**
 * Luokka joka luo mallin jonka pohjalta käyttäjälistaus toimii myös graafisessa
 * käyttöliittymässä, luokka perii luokan AbstractListModel ominaisuudet.
 *
 */
public class UsersModel extends AbstractListModel implements Serializable {

    private Users users;
    private User currentUser;

    /**
     * Luokan konstruktori joka asettaa käyttäjälistaukseksi parametrina
     * annettavan listauksen.
     *
     * @param users Annettava käyttäjälistaus
     */
    public UsersModel(Users users) {
        this.users = users;
    }

    /**
     * Metodi poistaa parametrina annettavat indeksin mukaiset käyttäjät
     * käyttäjälistauksesta.
     *
     * @param index Poistettavien käyttäjien indeksit listauksessa
     */
    public void removeUser(int[] index) {
        for (int i = index.length - 1; i >= 0; i--) {
            int user = index[i];
            this.users.getUsers().remove(user);
            fireContentsChanged(this, 0, getSize());
        }
    }

    /**
     * Metodi palauttaa käyttäjien lukumäärän.
     *
     * @return Käyttäjälistauksen käyttäjien lukumäärä
     */
    @Override
    public int getSize() {
        return users.getUsercount();
    }

    /**
     * Metodi palauttaa parametrina annettavan indeksin mukaisen käyttäjän
     * listauksesta.
     *
     * @param index Indeksinumero
     * @return Indeksinumeron mukainen käyttäjä
     */
    @Override
    public Object getElementAt(int index) {
        return users.getUsers().get(index);
    }

    /**
     * Metodi asettaa parametrina annettavan indeksin mukaisen käyttäjän
     * listauksesta valituksi.
     *
     * @param index Indeksinumero
     */
    public void setCurrentUser(int index) {
        this.currentUser = this.users.getUsers().get(index);
    }

    /**
     * Metodi palauttaa listauksesta valituksi asetetun käyttäjän.
     *
     * @return Tällä hetkellä valittu käyttäjä
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Metodi palauttaa tällä hetkellä valitun käyttäjän salasanan Tämä metodi
     * käytössä esim kun käyttäjä unohtanut salasanan ja admin kertoo sen.
     *
     * @param index Valittavan käyttäjän indeksinumero listauksessa
     */
    public String getPassword(int index) {
        setCurrentUser(index);
        return currentUser.getPassword();
    }

    /**
     * Metodi asettaaa tällä hetkellä valitulle käyttäjälle salasanan Tämä
     * metodi käytössä esim kun käyttäjä unohtanut salasanan ja admin vaihtaa
     * sen.
     *
     * @param password Annettava salasana
     * @param index Valittavan käyttäjän indeksinumero listauksessa
     */
    public void setPassword(String password, int index) {
        setCurrentUser(index);
        currentUser.setPassword(password);
        fireContentsChanged(this, 0, getSize());
    }
}
