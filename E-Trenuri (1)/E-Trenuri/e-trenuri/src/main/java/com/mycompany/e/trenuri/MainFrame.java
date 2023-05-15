package com.mycompany.e.trenuri;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private User me;
    private ArrayList<Statie> statii;
    private ArrayList<Drum> drumuri;
    private ArrayList<Tren> trenuri;
    private ArrayList<Traseu> trasee;

    public MainFrame(User user) {
        me = user;
        init();
    }

    public MainFrame(User user, Image icon) {
        me = user;
        this.setIconImage(icon);
        init();
    }

    private void init() {
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);

        statii = Statie.initStatii();
        drumuri = Drum.initDrumuri(statii);
        trenuri = Tren.initTrenuri();
        trasee = Traseu.initTrasee(drumuri, trenuri);
        this.setVisible(true);

    }

    public void printData() {

        for (Statie statie : statii) {
            System.err.println(statie);
        }

        for (Drum drum : drumuri) {

            System.err.println(drum);
        }

        for (Tren tren : trenuri) {
            System.err.println(tren);
        }

        for (Traseu traseu : trasee) {
            System.err.println(traseu);
        }

    }

}
