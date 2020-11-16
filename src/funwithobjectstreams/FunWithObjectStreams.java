/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funwithobjectstreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pgn
 */
public class FunWithObjectStreams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FunWithObjectStreams fwos = new FunWithObjectStreams();
        fwos.serializeAddress("Spangsbjerg Kirkevej 103", "Denmark");
    }

    public void serializeAddress(String street, String country) {

        Address address = new Address();
        address.setStreet(street);
        address.setCountry(country);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\stegg\\Desktop\\New folder\\address.ser"))) {
            oos.writeObject(address);
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\stegg\\Desktop\\New folder\\address2.ser")))
        {
            oos.writeObject(address);
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        Address add1 = null;
        Address add2 = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\stegg\\Desktop\\New folder\\address.ser")))
        {

            add1 = (Address) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FunWithObjectStreams.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\stegg\\Desktop\\New folder\\address2.ser")))
        {
            add2 = (Address) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(FunWithObjectStreams.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        boolean isEqual = add1 == add2;
        System.out.println(isEqual);
    }

}
