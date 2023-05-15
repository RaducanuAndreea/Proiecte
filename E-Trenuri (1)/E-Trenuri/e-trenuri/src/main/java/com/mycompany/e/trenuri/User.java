
package com.mycompany.e.trenuri;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class User {
    private String cnp,tip,nume,prenume,userName,parola;
    private int varsta;

    public User(String cnp, String tip, String nume, String prenume, String userName, String parola, int varsta) {
        this.cnp = cnp;
        this.tip = tip;
        this.nume = nume;
        this.prenume = prenume;
        this.userName = userName;
        this.parola = parola;
        this.varsta = varsta;
    }
    
    public String tryLogin(String username, String password){
        if(username == null ? this.userName != null : !username.equals(this.userName)) return "WUN";
        if(password == null ? this.parola != null : !password.equals(this.parola)) return "WP";
        return "succes";
    };
    
    public static ArrayList<User> initUsers() {
        ArrayList<User> users = new ArrayList<>();
        BufferedReader br;
        try {
            File file = new File(
                    "src\\main\\java\\com\\mycompany\\e\\trenuri\\users.txt");
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fisierul de utilizatori nu a fost gasit", "Error", JOptionPane.ERROR_MESSAGE);
            return users;
        }

        try {
            String st;
            
            while ((st = br.readLine()) != null) {
                String[] data = st.split(",");
                users.add(new User(data[2], data[3], data[4], data[5],
                        data[0], data[1], Integer.parseInt(data[6])));
            }

        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "a aparut o eroare la citirea Userilr din fisier", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return users;

    }
}
