package flashrep.flashrep.cards;

import java.util.Objects;

/**
 * @author Raine Rantanen
 */
/**
 * Luokka tarjoaa metodeita kortin käsittelyyn.
 */
public class Flashcard implements Comparable<Flashcard> {

    private String question;
    private String answer;
    private int rating;
    private static int idLaskuri = 0;
    private int id;

    /**
     * Luokan konstruktori, asettaa kortille annetun kysymyksen ja vastauksen.
     *
     * @param question parametrina kortille annettava kysymys
     * @param answer parametrina kortille annettava vastaus
     */
    public Flashcard(String question, String answer) {
        ++this.idLaskuri;
        this.question = question;
        this.answer = answer;
        this.rating = 1;
        this.id = idLaskuri;

    }

    /**
     * Metodi palauttaa kortille asetetun kysymyksen.
     *
     * @return kysymys
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Metodi palauttaa kortille asetetun vastauksen.
     *
     * @return vastaus
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Metodi asettaa kortille annetun kysymyksen.
     *
     * @param question kortille annettava kysymys
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Metodi asettaa kortille annetun vastauksen.
     *
     * @param answer parametrina kortille annettava vastaus
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Metodi palauttaa kortille asetetun luokituksen.
     *
     * @return kortin luokitus
     */
    public int getRating() {
        return rating;
    }

    /**
     * Metodi asettaa kortille luokituksen Annettava arvo oltava välillä 1-5.
     *
     * @param rating parametrina kortille annettava luokitus
     */
    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        }
    }

    /**
     * Metodi palauttaa kortin id-tunnuksen.
     *
     * @return kortin id-tunnus
     */
    public int getId() {
        return this.id;
    }

    /**
     * Metodi vaihtaa kortille asetetun kysymyksen ja vastauksen keskenään.
     */
    public void swap() {
        String question = this.question;
        String answer = this.answer;

        this.question = answer;
        this.answer = question;
    }

    /**
     * Metodi vertailee metodia käyttävää korttia ja parametrina annettua
     * korttia keskenään tarkistaakseen ovatko ne sama kortti.
     *
     * @param flashcard Parametrina annettu toinen kortti johon tämän
     * kortin tietoja verrataan
     * @return true, jos kortit ovat keskenään samat tai false jos kortit eivät
     * ole samat.
     */
    @Override
    public boolean equals(Object flashcard) {
        if (flashcard == null) {
            return false;
        }
        if (this.getClass() != flashcard.getClass()) {
            return false;
        }
        if (this.question == null || this.question.isEmpty() || this.answer == null || this.answer.isEmpty()) {
            return false;
        }
        Flashcard thatFlashcard = (Flashcard) flashcard;

        return this.question.equals(thatFlashcard.question) && this.answer.equals(thatFlashcard.answer);
    }

    /**
     * Metodi antaa kortille hajautusarvon ja palauttaa sen.
     *
     * @return kortin hajautusarvo
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.question);
        hash = 67 * hash + Objects.hashCode(this.answer);
        return hash;
    }

    /**
     * Metodi vertailee metodia käyttävän kortin ja parametrina annettavan kortin
     * keskinäistä järjestystä käyttäen korttien luokitusta ja niiden
     * id-tunnuksia. Järjestyksellä on merkitystä erityisesti
     * toistovälikertauksessa.
     *
     * @param f2 parametrina annettava toinen kortti
     * @return negatiivinen arvo, jos metodia käyttävä kortti on
     * järjestyksessä aikaisempi, 0 jos kortit ovat järjestykseltään samat ja
     * positiivinen arvo jos parametrina annettu kortti on järjestyksessä
     * aikaisempi.
     */
    @Override
    public int compareTo(Flashcard f2) {
        if ((f2.getRating() - this.rating) == 0) {
            return this.id - f2.id;
        }
        return f2.getRating() - this.rating;
    }
}
