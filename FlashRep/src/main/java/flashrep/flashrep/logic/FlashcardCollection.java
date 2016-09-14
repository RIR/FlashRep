/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raine Rantanen
 */
public class FlashcardCollection {

    private String name;
    private List<Flashcard> flashcards;

    public FlashcardCollection(String name) {
        this.name = name;
        this.flashcards = new ArrayList<>();
    }

    public void addFlashcardToCollection(Flashcard flashcard) {
        this.flashcards.add(flashcard);
    }

    public void removeFlashcardFromCollection(Flashcard flashcard) {
        if (this.flashcards.contains(flashcard)) {
            this.flashcards.remove(flashcard);
        }
    }

    public List<Flashcard> getFlashcards() {
        return flashcards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return this.flashcards.size();
    }

}
