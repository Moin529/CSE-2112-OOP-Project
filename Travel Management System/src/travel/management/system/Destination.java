package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Destination extends JFrame{
    
    Destination(){
        setBounds(500, 130, 820, 650);
        getContentPane().setBackground(Color.BLACK);
        
        String[] dest1 = {"Cox's Bazar", "dest1.jpg"};
        String[] dest2 = {"Sajek Valley", "dest2.jpg"};
        String[] dest3 = {"Saint Martin Island", "dest3.jpg"};
        String[] dest4 = {"Sonargaon", "dest4.jpg"};
        String[] dest5 = {"Sundarbans", "dest5.jpg"};
        String[] dest6 = {"Sreemangal", "dest6.jpg"};
        String[] dest7 = {"Bandarban", "dest7.jpg"};
        String[] dest8 = {"Kuakata", "dest8.jpg"};
        String[] dest9 = {"Rangamati", "dest9.jpg"};
        String[] dest10 = {"Raturgul Swamp Forest", "dest10.jpg"};
        
        
        JTabbedPane tab = new JTabbedPane();
        JPanel h1 = createDest(dest1);
        tab.addTab("Spot 1", null, h1);
        
        JPanel h2 = createDest(dest2);
        tab.addTab("Spot 2", null, h2);
        
        JPanel h3 = createDest(dest3);
        tab.addTab("Spot 3", null, h3);
        
        JPanel h4 = createDest(dest4);
        tab.addTab("Spot 4", null, h4);
        
        JPanel h5 = createDest(dest5);
        tab.addTab("Spot 5", null, h5);
        
        JPanel h6 = createDest(dest6);
        tab.addTab("Spot 6", null, h6);
        
        JPanel h7 = createDest(dest7);
        tab.addTab("Spot 7", null, h7);
        
        JPanel h8 = createDest(dest8);
        tab.addTab("Spot 8", null, h8);
        
        JPanel h9 = createDest(dest9);
        tab.addTab("Spot 9", null, h9);
        
        JPanel h10 = createDest(dest10);
        tab.addTab("Spot 10", null, h10);
        
        add(tab);
        
        setVisible(true);
    }
    
    public JPanel createDest(String[] pack){
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
        new Destination();
    }
}
