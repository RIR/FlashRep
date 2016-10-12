/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.io;

import flashrep.flashrep.logic.AppControlLogic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class DataHandlerTest {

    private AppControlLogic controller;
    private DataHandler dataHandler;

    public DataHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        controller = new AppControlLogic();
        dataHandler = new DataHandler(controller);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void hello() {
    }

    @Test
    public void saveDataWorks() {
        dataHandler.saveData();
        File file = new File("flashRep.ser");
        assertEquals(true, file.exists());
    }

    @Test
    public void readDataWorks() {
        dataHandler.readData();
        try {
            FileInputStream fis = new FileInputStream("flashRep.ser");
            ObjectInputStream in = new ObjectInputStream(fis);
            assertEquals(controller.getClass(), in.readObject().getClass());
            in.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
