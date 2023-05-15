package com.mycompany.e.trenuri;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Drum {

    private int Id;
    private Statie plecare, sosire;
    private float distanta;
    private float durata;

    public Drum(int Id, Statie plecare, Statie sosire, float distanta, float durata) {
        this.Id = Id;
        this.plecare = plecare;
        this.sosire = sosire;
        this.distanta = distanta;
        this.durata = durata;
    }

    @Override
    public String toString() {
        return "Drum: [" + (plecare != null ? plecare.getNume() : "NONE") + " -> " + (sosire != null ? sosire.getNume() : "NONE") + "] " + distanta + " km/" + durata + " ore";
    }
    public String toShortString() {
        return (plecare != null ? plecare.getNume() : "NONE") + " -> " + (sosire != null ? sosire.getNume() : "NONE");
    }

    public boolean itsId(int id) {
        return this.Id == id;
    }

    public float getDurata() {
        return durata;
    }

    public float getDistanta() {
        return distanta;
    }

    public static ArrayList<Drum> initDrumuri(ArrayList<Statie> statii) {
        ArrayList<Drum> drumuri = new ArrayList<>();
        BufferedReader br;
        try {
            File file = new File(
                    "src\\main\\java\\com\\mycompany\\e\\trenuri\\drumuri.txt");
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fisierul de utilizatori nu a fost gasit", "Error", JOptionPane.ERROR_MESSAGE);
            return drumuri;
        }

        try {
            String st;

            while ((st = br.readLine()) != null) {
                String[] data = st.split(",");

                Statie plecare = null;
                int plecareId = Integer.parseInt(data[1]);
                Statie sosire = null;
                int sosireId = Integer.parseInt(data[2]);
                for (Statie statie : statii) {
                    if (plecare == null && statie.isId(plecareId)) {
                        plecare = statie;
                    }
                    if (sosire == null && statie.isId(sosireId)) {
                        sosire = statie;
                    }
                    if (plecare != null && sosire != null) {
                        break;
                    }
                }
                drumuri.add(new Drum(Integer.parseInt(data[0]), plecare, sosire, Float.parseFloat(data[3]), Float.parseFloat(data[4])));
            }

        } catch (IOException | NumberFormatException e) {
            drumuri.removeAll(drumuri);
            JOptionPane.showMessageDialog(null, "a aparut o eroare la citirea Statiilor din fisier", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return drumuri;

    }

}
