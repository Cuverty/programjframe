package com.uczeniesie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try{
                    Main window = new Main();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
        });
    }

    public Main() throws HeadlessException{
        this("undefined");
    }

    public Main(String title) throws HeadlessException{
        super(title);
        buildFrame();
    }

    protected void buildFrame(){

        setBounds(550,200,415,440);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        //JFrame.getContentPane().setPreferredSize(new Dimension(Config.FrameWidth, Config.FrameHeight));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mn = new JMenu("Menu");
        menuBar.add(mn);

        JLabel txtLogin = new JLabel("Login");
        JTextField inLogin = new JTextField();
        JLabel txtPass = new JLabel("Pass");
        JTextField inPass = new JPasswordField();
        JButton login = new JButton("Login");
        JButton clear = new JButton("Clear");

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,400,400);
        contentPane.add(panel);

        ArrayList<Account> dataBase = new ArrayList<Account>();

        JMenuItem btnLogin = new JMenuItem("Login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login(inLogin.getText(), inPass.getText(), dataBase, panel);
            }
        });
        mn.add(btnLogin);

        JMenuItem btnClear = new JMenuItem("Clear");
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear(inLogin, inPass, panel);
            }
        });
        mn.add(btnClear);

        JToolBar toolBar = new JToolBar();
        getContentPane().add(toolBar, BorderLayout.NORTH);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login(inLogin.getText(), inPass.getText(), dataBase, panel);
            }
        });
        toolBar.add(loginButton);

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear(inLogin, inPass, panel);
            }
        });
        toolBar.add(clearButton);

        panel.setBackground(Color.GRAY);
        panel.setLayout(null);

        dataBase.add(new Account("aaa","bbb"));
        dataBase.add(new Account("ttt","yyy"));
        dataBase.add(new Account("www","eee"));
        dataBase.add(new Account("mmm","nnn"));
        dataBase.add(new Account("abc","xyz"));

        txtLogin.setBounds(100, 100, 50, 25);
        panel.add(txtLogin);

        inLogin.setBounds(200, 100, 150, 25);
        panel.add(inLogin);

        txtPass.setBounds(100, 170, 50, 25);
        panel.add(txtPass);

        inPass.setBounds(200, 170, 150, 25);
        panel.add(inPass);

        login.setBounds(80, 300, 100, 25);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login(inLogin.getText(), inPass.getText(), dataBase, panel);
            }
        });
        panel.add(login);

        clear.setBounds(220, 300, 100, 25);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear(inLogin, inPass, panel);
            }
        });
        panel.add(clear);
    }

    public void login(String login, String password, ArrayList dataBase, JPanel panel){
        Account test = new Account(login, password);

        for (Object o : dataBase) {
            if (test.equals(o)) {
                panel.setBackground(Color.GREEN);
                return;
            }
        }
        panel.setBackground(Color.RED);
    }

    public void clear(JTextField login, JTextField pass, JPanel panel){
        login.setText("");
        pass.setText("");
        panel.setBackground(Color.GRAY);
    }
}
