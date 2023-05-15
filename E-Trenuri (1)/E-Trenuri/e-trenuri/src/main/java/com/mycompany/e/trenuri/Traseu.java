package com.mycompany.e.trenuri;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class Traseu {

    private ArrayList<Drum> drumuri = new ArrayList<>();
    private Date oraPlecare;
    private Tren tren;

    public Traseu(ArrayList<Drum> drumuri, Date oraPlecare, Tren tren) {
        this.drumuri = drumuri;
        this.oraPlecare = oraPlecare;
        this.tren = tren;
    }

    @Override
    public String toString() {
        String drum = "Traseu:\n";
        float totalTime = 0.0f;
        float totalLength = 0.0f;
        for (Drum d : drumuri) {
            drum += d.toShortString() + "\n";
            totalTime += d.getDurata();
            totalLength += d.getDistanta();
        }
        drum += ("Total: " + totalLength + "km in " + totalTime + " ore");
        return drum;
    }

    public float getTotaltime() {
        float total = 0.0f;
        for (Drum drum : drumuri) {
            total += drum.getDurata();
        }
        return total;
    }

    public float getTotalLength() {
        float total = 0.0f;
        for (Drum drum : drumuri) {
            total += drum.getDistanta();
        }
        return total;
    }

    public static ArrayList<Traseu> initTrasee(ArrayList<Drum> drumuri, ArrayList<Tren> trenuri) {
        ArrayList<Traseu> trasee = new ArrayList<>();

        BufferedReader br;
        try {
            File file = new File(
                    "src\\main\\java\\com\\mycompany\\e\\trenuri\\trasee.txt");
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fisierul de utilizatori nu a fost gasit", "Error", JOptionPane.ERROR_MESSAGE);
            return trasee;
        }

        try {
            String st;

            while ((st = br.readLine()) != null) {
                String[] data = st.split(",");
                Tren tren = null;
                ArrayList<Drum> d = new ArrayList<>();

                int id = Integer.parseInt(data[1]);
                for (Tren t : trenuri) {
                    if (t.itsId(id)) {
                        tren = t;
                    }
                }

                if (tren == null) {
                    JOptionPane.showMessageDialog(null, "Nu am gasit trenul pentru traseul " + id);
                    continue;
                }

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy/HH/mm");
                Date time;
                try {
                    time = format.parse(data[2]);

                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Nu am gasit timpul pentru traseul " + id);
                    continue;
                }

                for (int i = 3; i < data.length; i++) {
                    int idDrum = Integer.parseInt(data[i]);
                    for (Drum drum : drumuri) {
                        if (drum.itsId(idDrum)) {
                            d.add(drum);
                            break;
                        }
                    }
                }

                trasee.add(new Traseu(d, time, tren));
            }
            return trasee;

        } catch (IOException | NumberFormatException e) {
            drumuri.removeAll(drumuri);
            JOptionPane.showMessageDialog(null, "a aparut o eroare la citirea Statiilor din fisier", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return trasee;
    }
}
