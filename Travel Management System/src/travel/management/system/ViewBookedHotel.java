package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener{
    JLabel lblac, labelac, lblfood, labelfood, lblusername, labelusername, lblhotel, labelhotel, lblperson, labelperson, lbldays, labeldays, lblid, labelid, lblnumber, labelnumber, lblprice, labelprice, lblphone, labelphone;
    JButton back;
    
    ViewBookedHotel(String username){
        setBounds(350, 200, 1000, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Ariel", Font.BOLD, 20));
        text.setBounds(40, 0, 400, 30);
        text.setForeground(Color.red);
        add(text);
        
        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        lblhotel = new JLabel("Hotel Name");
        lblhotel.setBounds(30, 90, 150, 25);
        add(lblhotel);
        
        labelhotel = new JLabel();
        labelhotel.setBounds(220, 90, 150, 25);
        add(labelhotel);
        
        lblperson = new JLabel("Total Persons");
        lblperson.setBounds(30, 130, 150, 25);
        add(lblperson);
        
        labelperson = new JLabel();
        labelperson.setBounds(220, 130, 150, 25);
        add(labelperson);
        
        lbldays = new JLabel("Total Days");
        lbldays.setBounds(30, 170, 150, 25);
        add(lbldays);
        
        labeldays = new JLabel();
        labeldays.setBounds(220, 170, 150, 25);
        add(labeldays);
        
        lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(30, 210, 150, 25);
        add(lblac);
        
        labelac = new JLabel();
        labelac.setBounds(220, 210, 150, 25);
        add(labelac);
        
        lblfood = new JLabel("Food Included");
        lblfood.setBounds(30, 250, 150, 25);
        add(lblfood);
        
        labelfood = new JLabel();
        labelfood.setBounds(220, 250, 150, 25);
        add(labelfood);
        
        lblid = new JLabel("ID");
        lblid.setBounds(30, 290, 150, 25);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(220, 290, 150, 25);
        add(labelid);
        
        lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 330, 150, 25);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(220, 330, 150, 25);
        add(labelnumber);
        
        lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 370, 150, 25);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(220, 370, 150, 25);
        add(labelphone);
        
        lblprice = new JLabel("Total Price");
        lblprice.setBounds(30, 410, 150, 25);
        add(lblprice);
        
        labelprice = new JLabel();
        labelprice.setBounds(220, 410, 150, 25);
        add(labelprice);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 460, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 370, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 20, 450, 370);
        add(image);
        
        try{
            Conn conn = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet res = conn.s.executeQuery(query);
            while(res.next()){
                labelusername.setText(res.getString("username"));
                labelhotel.setText(res.getString("name"));
                labelperson.setText(res.getString("person"));
                labeldays.setText(res.getString("days"));
                labelac.setText(res.getString("ac"));
                labelfood.setText(res.getString("food"));
                labelid.setText(res.getString("id"));
                labelnumber.setText(res.getString("number"));
                labelphone.setText(res.getString("phone"));
                labelprice.setText(res.getString("price"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new ViewBookedHotel("");
    }
}
