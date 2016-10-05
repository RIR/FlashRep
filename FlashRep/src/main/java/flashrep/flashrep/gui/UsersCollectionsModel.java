package flashrep.flashrep.gui;

import flashrep.flashrep.cards.FlashcardCollection;
import flashrep.flashrep.logic.Controller;
import flashrep.flashrep.useraccounts.User;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Raine Rantanen
 */
public class UsersCollectionsModel extends AbstractListModel {

    private List<FlashcardCollection> usersCollections;

    public UsersCollectionsModel(List<FlashcardCollection>  usersCollections) {
        this.usersCollections = usersCollections;
    }

    public void addNewCollection(String collectionName) {
        FlashcardCollection flashcardCollection = new FlashcardCollection(collectionName);
        this.usersCollections.add(flashcardCollection);
        fireContentsChanged(this, 0, getSize());
    }

    public void removeCollection(int index) {
        usersCollections.remove(index);
        fireContentsChanged(this, 0, getSize());
    }

    @Override
    public int getSize() {
        return usersCollections.size();
    }

    @Override
    public Object getElementAt(int index) {
        return usersCollections.get(index);
    }
}
