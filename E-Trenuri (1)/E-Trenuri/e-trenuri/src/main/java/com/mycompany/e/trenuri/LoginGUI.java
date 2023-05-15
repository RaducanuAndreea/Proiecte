package com.mycompany.e.trenuri;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.*;

public class LoginGUI extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel errorLabel;
    ArrayList<User> users;

    public LoginGUI(){
        init();
    }

    public LoginGUI(Image icon) {
        this.setIconImage(icon);
        init();
    }

    private void init() {
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        users = User.initUsers();

        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.red);
        errorLabel.setBounds(220, 75, 200, 100);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 75, 100, 30);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 20, 80, 30);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 75, 80, 30);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 120, 80, 30);

        registerButton = new JButton("Register");
        registerButton.setBounds(350, 150, 80, 30);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 100, 30);

        this.add(passwordField);
        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(loginButton);
        this.add(registerButton);
        this.add(usernameField);
        this.add(errorLabel);
        this.setLayout(null);
        loginButton.addActionListener((ActionEvent e) -> {
            User user = login();
            if (user != null) {
                //TO DO: init main page hare
                new MainFrame(user,this.getIconImage());
                
                this.dispose();
            }
        });
        LoginGUI a = this;
        registerButton.addActionListener((ActionEvent e) -> {
            RegisterGUI frame = new RegisterGUI(a);
        });

        this.setSize(500, 500);
        this.setVisible(true);
    }

    private User login() {

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if ("WUN".equals(user.tryLogin(usernameField.getText(), String.valueOf(passwordField.getPassword())))) {
                continue;
            }
            if ("WP".equals(user.tryLogin(usernameField.getText(), String.valueOf(passwordField.getPassword())))) {
                JOptionPane.showMessageDialog(this, "Wrong Password");
                return null;
            }
            return user;
        }
        JOptionPane.showMessageDialog(this, "Wrong Username");
        return null;
    }

    
}
