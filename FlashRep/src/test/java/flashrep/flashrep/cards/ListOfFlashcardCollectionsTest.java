package flashrep.flashrep.cards;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raine Rantanen
 */
public class ListOfFlashcardCollectionsTest {
    ListOfFlashcardCollections listOfFlashcardCollections;
    List<FlashcardCollection> flashcardCollection;
    
    public ListOfFlashcardCollectionsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        listOfFlashcardCollections=new ListOfFlashcardCollections();
        flashcardCollection=new ArrayList<>();
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void hello() {}
}
