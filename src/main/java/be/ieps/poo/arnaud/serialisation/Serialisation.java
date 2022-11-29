package be.ieps.poo.arnaud.serialisation;


import be.ieps.poo.arnaud.model.Personne;
import be.ieps.poo.arnaud.model.Profession;


import java.io.*;
import java.util.*;

public class Serialisation {

    public void ecriture(HashMap<Profession, ArrayList<Personne>> listeEmploye) {

        {

            {
                try {
                    FileOutputStream fos = new FileOutputStream("Personne.dat");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(listeEmploye);
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public HashMap<Profession, ArrayList<Personne>> lectureFichierPersonne() {
        HashMap<Profession, ArrayList<Personne>> listeEmploye = null;

        try {
            FileInputStream fis = new FileInputStream("Personne.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            listeEmploye = (HashMap<Profession, ArrayList<Personne>>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            System.out.println("la classe ne peut etre trouvée");
            cnfe.printStackTrace();
        }return listeEmploye;
/*        System.out.println("Deserializing  HashMap..");

        // Displaying content in "Personne.dat" using
        // Iterator
        Set set = listeEmploye.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();

            System.out.print("key : " + entry.getKey()
                    + " & Value : ");
            System.out.println(entry.getValue());*/
    }
}
