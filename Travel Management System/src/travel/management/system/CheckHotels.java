package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class CheckHotels extends JFrame{
    
    CheckHotels(){
        setBounds(500, 130, 820, 650);
        getContentPane().setBackground(Color.BLACK);
        
        String[] hotel1 = {"Atlantis Hotel", "hotel1.jpg"};
        String[] hotel2 = {"Sea Pearl Hotel", "hotel2.jpg"};
        String[] hotel3 = {"Four Seasons Hotel", "hotel3.jpg"};
        String[] hotel4 = {"Raddisson Hotel", "hotel4.jpg"};
        String[] hotel5 = {"Hotel Haven", "hotel5.jpg"};
        String[] hotel6 = {"The Bay Club Hotel", "hotel6.jpg"};
        String[] hotel7 = {"Breeze Blow Hotel", "hotel7.jpg"};
        String[] hotel8 = {"Grand Hotel", "hotel8.jpg"};
        String[] hotel9 = {"Dream Hotel", "hotel9.jpg"};
        String[] hotel10 = {"River View Hotel", "hotel10.jpg"};
        
        
        JTabbedPane tab = new JTabbedPane();
        JPanel h1 = createHotels(hotel1);
        tab.addTab("Hotel 1", null, h1);
        
        JPanel h2 = createHotels(hotel2);
        tab.addTab("Hotel 2", null, h2);
        
        JPanel h3 = createHotels(hotel3);
        tab.addTab("Hotel 3", null, h3);
        
        JPanel h4 = createHotels(hotel4);
        tab.addTab("Hotel 4", null, h4);
        
        JPanel h5 = createHotels(hotel5);
        tab.addTab("Hotel 5", null, h5);
        
        JPanel h6 = createHotels(hotel6);
        tab.addTab("Hotel 6", null, h6);
        
        JPanel h7 = createHotels(hotel7);
        tab.addTab("Hotel 7", null, h7);
        
        JPanel h8 = createHotels(hotel8);
        tab.addTab("Hotel 8", null, h8);
        
        JPanel h9 = createHotels(hotel9);
        tab.addTab("Hotel 9", null, h9);
        
        JPanel h10 = createHotels(hotel10);
        tab.addTab("Hotel 10", null, h10);
        
        add(tab);
        
        setVisible(true);
    }
    
    public JPanel createHotels(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.BLACK);
        
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(50, 500, 1000, 70);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Ariel", Font.BOLD, 40));
        p1.add(l1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + pack[1]));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image1 = new JLabel(i3);
        image1.setBounds(0, 0, 800, 600);
        p1.add(image1);
        
        return p1;
    }
    
    public static void main(String[] args) {
        new CheckHotels();
    }
}
