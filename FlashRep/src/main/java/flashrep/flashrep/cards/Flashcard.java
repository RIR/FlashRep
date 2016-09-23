/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.cards;

import java.util.Objects;

/**
 *
 * @author Raine Rantanen
 */
public class Flashcard implements Comparable<Flashcard> {

    private String question;
    private String answer;
    private int rating;
    private int id;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.rating = 1;
        this.id = 0;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void swap() {
        String question = this.question;
        String answer = this.answer;

        this.question = answer;
        this.answer = question;
    }

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.question);
        hash = 67 * hash + Objects.hashCode(this.answer);
        return hash;
    }

    @Override
    public int compareTo(Flashcard f2) {
        if ((f2.getRating() - this.rating) == 0) {
            return this.id - f2.id;
        }
        return f2.getRating() - this.rating;
    }
}
