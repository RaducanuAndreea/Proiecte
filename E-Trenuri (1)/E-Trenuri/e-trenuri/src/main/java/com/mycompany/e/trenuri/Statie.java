
package com.mycompany.e.trenuri;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Statie {
    
    public Statie(int id, String name){
        this.id = id;
        this.nume = name;
    }
    private int id;
    private String nume;
    
    public String getNume() {
        return nume;
    }
    public boolean isId(int id){
        return this.id == id;
    }

    @Override
    public String toString() {
        return "Statie(id: "+ id +", Nume: "+ nume+")"; 
    }
    
    public static ArrayList<Statie> initStatii() {
        ArrayList<Statie> statii = new ArrayList<>();
        BufferedReader br;
        try {
            File file = new File(
                    "src\\main\\java\\com\\mycompany\\e\\trenuri\\statii.txt");
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fisierul de utilizatori nu a fost gasit", "Error", JOptionPane.ERROR_MESSAGE);
            return statii;
        }

        try {
            String st;

            while ((st = br.readLine()) != null) {
                String[] data = st.split(",");
                statii.add(new Statie(Integer.parseInt(data[0]), data[1]));
            }

        } catch (IOException | NumberFormatException e) {
            statii.removeAll(statii);
            JOptionPane.showMessageDialog(null, "a aparut o eroare la citirea Statiilor din fisier", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return statii;

    }
    
    
}


