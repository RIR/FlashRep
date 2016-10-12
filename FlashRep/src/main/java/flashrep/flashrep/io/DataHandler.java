package flashrep.flashrep.io;

import flashrep.flashrep.logic.AppControlLogic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Luokka ohjelman tietojen tallentamiseen ja lukemiseen tiedostosta.
 */
public class DataHandler implements Serializable {

    private AppControlLogic controller;
    private final String filename = "flashRep.ser";

    /**
     * Luokan konstruktori joka saa parametrina annettavan kontrollerin joka
     * sitten tallennetaan tiedostoon.
     *
     * @param controller Ohjelman kontrolleriluokka
     */
    public DataHandler(AppControlLogic controller) {
        this.controller = controller;
    }

    /**
     * Metodi tietojen tallennukseen tiedostoon.
     */
    public void saveData() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(this.filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(this.controller);
            out.close();
            fos.close();
        } catch (Exception ex) {
        }
    }

    /**
     * Metodi tietojen lukemiseen tiedostosta.
     */
    public void readData() {
        File file = new File(this.filename);
        FileInputStream fis = null;
        ObjectInputStream in = null;

        if (!file.exists()) {
            saveData();
        }
        try {
            fis = new FileInputStream(this.filename);
            in = new ObjectInputStream(fis);
            controller.getUsers().setUsers(((AppControlLogic) in.readObject()).getUsers().getUsers());
            in.close();
            fis.close();
        } catch (Exception ex) {
        }
    }
}
