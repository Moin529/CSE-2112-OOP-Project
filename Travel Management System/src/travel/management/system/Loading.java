package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    
    public void run(){
        try{
            for(int i=1; i<=101; i++){
                int max = bar.getMaximum();
                int value = bar.getValue();
                
                if(value < max){
                    bar.setValue(bar.getValue() + 1);
                }
                else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    Loading(String username){
        this.username = username;
        t = new Thread(this);
        setBounds(500, 220, 700, 400);
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel text = new JLabel("Travel and Tourism Application");
        text.setBounds(100, 20, 500, 40);
        text.setForeground(Color.CYAN);
        text.setFont(new Font("Times New Roman", Font.BOLD, 35));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(140, 100, 400, 35);
        bar.setStringPainted(true);
        bar.setForeground(Color.BLUE);
        add(bar);
        
        
        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(220, 140, 300, 30);
        loading.setForeground(Color.CYAN);
        loading.setFont(new Font("Times New Roman", Font.BOLD, 25));
        add(loading);
        
        JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setBounds(20, 310, 400, 40);
        lblusername.setForeground(new Color(233, 166, 212));
        lblusername.setFont(new Font("Times New Roman", Font.ITALIC, 35));
        add(lblusername);
        
        t.start();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Loading("");
    }
}
