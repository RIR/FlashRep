/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashrep.flashrep.io;

import flashrep.flashrep.logic.AppControlLogic;
import flashrep.flashrep.useraccounts.Users;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Raine Rantanen
 */
public class dataHandler implements Serializable {

    private AppControlLogic controller;
    private final String filename = "flashrep.ser";

    public dataHandler(AppControlLogic controller) {
        this.controller = controller;
    }

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
            ex.printStackTrace();
        }
    }

    public void readData() {
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try {
            fis = new FileInputStream(this.filename);
            in = new ObjectInputStream(fis);
            controller.getUsers().setUsers(((AppControlLogic) in.readObject()).getUsers().getUsers());
            in.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
