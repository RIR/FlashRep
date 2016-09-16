/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.cards;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raine Rantanen
 */
public class ListOfFlashcardCollections {

    private List<FlashcardCollection> flashcardCollections;

    public ListOfFlashcardCollections() {
        flashcardCollections = new ArrayList<>();
    }

    public void addCollection(FlashcardCollection flashcardCollection) {
        this.flashcardCollections.add(flashcardCollection);
    }

    public void removeCollection(FlashcardCollection flashcardCollection) {
        if (this.flashcardCollections.contains(flashcardCollection)) {
            this.flashcardCollections.remove(flashcardCollection);
        }
    }

    public List<FlashcardCollection> getFlashcardCollections() {
        return flashcardCollections;
    }

    public int getAmountOfCollections() {
        return this.flashcardCollections.size();
    }
}
