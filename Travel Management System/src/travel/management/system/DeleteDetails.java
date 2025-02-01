package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteDetails extends JFrame implements ActionListener{
    JLabel lblusername, labelusername, lblid, labelid, lblnumber, labelnumber, lblname, labelname, lblgender, labelgender, lblcountry, labelcountry, lbladdress, labeladdress, lblphone, labelphone, lblemail, labelemail;
    JButton delete;
    String username;
    DeleteDetails(String username){
        this.username = username;
        setBounds(350, 120, 870, 625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        lblid = new JLabel("Id");
        lblid.setBounds(30, 100, 150, 25);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setBounds(220, 100, 150, 25);
        add(labelid);
        
        lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 150, 150, 25);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(220, 150, 150, 25);
        add(labelnumber);
        
        lblname = new JLabel("Name");
        lblname.setBounds(30, 200, 150, 25);
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220, 200, 150, 25);
        add(labelname);
        
        lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 250, 150, 25);
        add(lblgender);
        
        labelgender = new JLabel();
        labelgender.setBounds(220, 250, 150, 25);
        add(labelgender);
        
        lblcountry = new JLabel("Country");
        lblcountry.setBounds(500, 50, 150, 25);
        add(lblcountry);
        
        labelcountry = new JLabel();
        labelcountry.setBounds(690, 50, 150, 25);
        add(labelcountry);
        
        lbladdress = new JLabel("Address");
        lbladdress.setBounds(500, 100, 150, 25);
        add(lbladdress);
        
        labeladdress = new JLabel();
        labeladdress.setBounds(690, 100, 150, 25);
        add(labeladdress);
        
        lblphone = new JLabel("Phone Number");
        lblphone.setBounds(500, 150, 150, 25);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(690, 150, 150, 25);
        add(labelphone);
        
        lblemail = new JLabel("Email");
        lblemail.setBounds(500, 200, 150, 25);
        add(lblemail);
        
        labelemail = new JLabel();
        labelemail.setBounds(690, 200, 150, 25);
        add(labelemail);
        
        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.RED);
        delete.setBounds(350, 300, 100, 25);
        delete.addActionListener(this);
        add(delete);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 400, 600, 200);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 400, 600, 200);
        add(image2);
        
        try{
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet res = conn.s.executeQuery(query);
            while(res.next()){
                labelusername.setText(res.getString("username"));
                labelid.setText(res.getString("id"));
                labelnumber.setText(res.getString("number"));
                labelname.setText(res.getString("name"));
                labelgender.setText(res.getString("gender"));
                labelcountry.setText(res.getString("country"));
                labeladdress.setText(res.getString("address"));
                labelphone.setText(res.getString("phone"));
                labelemail.setText(res.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c = new Conn();
            c.s.executeUpdate("delete from account where username = '"+username+"'");
            c.s.executeUpdate("delete from customer where username = '"+username+"'");
            c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
            c.s.executeUpdate("delete from bookhotel where username = '"+username+"'");
            
            JOptionPane.showMessageDialog(null, "Data Deleted Successfully!");
            
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new DeleteDetails("");
    }
}
