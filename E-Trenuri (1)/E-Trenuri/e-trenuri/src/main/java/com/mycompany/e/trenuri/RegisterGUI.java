package com.mycompany.e.trenuri;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class RegisterGUI extends JFrame {

    private JTextField usernameField;
    private JTextField cnpField;
    private JTextField tipField;
    private JTextField numeField;
    private JTextField prenumeField;
    private JSpinner varstaSpinner;
    private JPasswordField passwordField;
    private JLabel cnpLabel;
    private JLabel tipLabel;
    private JLabel numeLabel;
    private JLabel prenumeLabel;
    private JLabel varstaLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton registerButton;
    private JLabel errorLabel;
    private String errorText;
    private LoginGUI loginGUI;

    public RegisterGUI(LoginGUI frame) throws HeadlessException {
        this.loginGUI = frame;
        init();
    }

    public RegisterGUI(LoginGUI frame, Image icon) throws HeadlessException {
        this.loginGUI = frame;
        this.setIconImage(icon);
        init();
    }

    private void init() {
        this.setTitle("Register");

        errorText = "";

        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.red);
        errorLabel.setHorizontalAlignment(JLabel.CENTER);
        //    errorLabel.setBounds(220, 75, 200, 100);

        passwordField = new JPasswordField();
        //    passwordField.setBounds(100, 75, 100, 30);

        numeLabel = new JLabel("\nFirst Name:");
        numeLabel.setHorizontalAlignment(JLabel.CENTER);
        //    numeLabel.setBounds(20, 20, 80, 30);

        prenumeLabel = new JLabel("Last Name:");
        //   prenumeLabel.setBounds(20, 80, 80, 30);

        tipLabel = new JLabel("Category:");
        //  tipLabel.setBounds(20, 140, 80, 30);

        cnpLabel = new JLabel("CNP:");
        //    cnpLabel.setBounds(20, 200, 80, 30);

        varstaLabel = new JLabel("Age:");
        //   varstaLabel.setBounds(20,295,80,30);

        usernameLabel = new JLabel("Username:");
        //  usernameLabel.setBounds(20, 350, 80, 30);

        passwordLabel = new JLabel("Password:");
        //   passwordLabel.setBounds(20,405,80,30);

        registerButton = new JButton("Register");
        //  registerButton.setBounds(350, 150, 80, 30);

        usernameField = new JTextField();
        //  usernameField.setBounds(100, 130, 100, 30);

        numeField = new JTextField();
        //  numeField.setBounds(100, 185, 100, 30);

        prenumeField = new JTextField();
        //    prenumeField.setBounds(100, 240, 100, 30);

        cnpField = new JTextField();
        //  cnpField.setBounds(100, 295, 100, 30);

        tipField = new JTextField();
        //  tipField.setBounds(100, 350, 100, 30);
        SpinnerModel model = new SpinnerNumberModel(1, 1, 100, 1);
        varstaSpinner = new JSpinner(model);
        //  varstaField.setBounds(100, 405, 100, 30);
        System.out.println("Checkpoint 1");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Checkpoint 3");
                register();
            }
        });

        numeLabel.setHorizontalAlignment(JLabel.CENTER);
        prenumeLabel.setHorizontalAlignment(JLabel.CENTER);
        varstaLabel.setHorizontalAlignment(JLabel.CENTER);
        tipLabel.setHorizontalAlignment(JLabel.CENTER);
        cnpLabel.setHorizontalAlignment(JLabel.CENTER);
        usernameLabel.setHorizontalAlignment(JLabel.CENTER);
        passwordLabel.setHorizontalAlignment(JLabel.CENTER);
        errorLabel.setHorizontalAlignment(JLabel.CENTER);
        
        
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(usernameLabel);
        this.add(usernameField);
        this.add(prenumeLabel);
        this.add(prenumeField);
        this.add(numeLabel);
        this.add(numeField);
        this.add(tipLabel);
        this.add(tipField);
        this.add(cnpLabel);
        this.add(cnpField);
        this.add(varstaLabel);
        this.add(varstaSpinner);
        this.add(errorLabel);
        this.add(registerButton);

        this.setLayout(new GridLayout(0, 2, 35, 35));

        this.setSize(500, 500);
        this.setVisible(true);
    }

    private void register() {

        String line = "\n"+usernameField.getText() + ","
                + String.valueOf(passwordField.getPassword()) + ","
                + cnpField.getText() + ","
                + tipField.getText() + ","
                + numeField.getText() + ","
                + prenumeField.getText() + ","
                + varstaSpinner.getValue();
         System.out.println(line);
        try {
            File file = new File("src\\main\\java\\com\\mycompany\\e\\trenuri\\users.txt");
            FileWriter fr = new FileWriter(file, true);
            fr.write(line);
            fr.close();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this,"nu ti-a iesit :P","Eroare", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(this,"Te-ai inregistrat cu succes! te pup jos");
        this.dispose();
    }

}
