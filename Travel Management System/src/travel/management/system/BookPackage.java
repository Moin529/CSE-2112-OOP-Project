package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    
    JLabel text, lblusername, labelusername, lblpack, lblperson, lblid, labelid, lblnumber, labelnumber, lblphone, labelphone, lbltotal, labeltotal;
    JTextField tfperson;
    JButton checkprice, bookpackage, back;
    String username;
    BookPackage(String username){
        this.username = username;
        setBounds(260, 180, 1100, 500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        text = new JLabel("BOOK PACKAGE");
        text.setBounds(150, 10, 200, 30);
        text.setFont(new Font("Ariel", Font.BOLD, 20));
        text.setForeground(Color.red);
        add(text);
        
        lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Ariel", Font.BOLD, 16));
        lblusername.setBounds(40, 70, 100, 20);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setFont(new Font("Ariel", Font.BOLD, 16));
        labelusername.setBounds(250, 70, 100, 20);
        add(labelusername);
        
        lblpack = new JLabel("Select Package");
        lblpack.setFont(new Font("Ariel", Font.BOLD, 16));
        lblpack.setBounds(40, 110, 150, 20);
        add(lblpack);
        
        cpackage = new Choice();
        cpackage.add("PREMIUM PACKAGE");
        cpackage.add("STANDARD PACKAGE");
        cpackage.add("BASIC PACKAGE");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);
        
        lblperson = new JLabel("Total Person");
        lblperson.setFont(new Font("Ariel", Font.BOLD, 16));
        lblperson.setBounds(40, 150, 150, 20);
        add(lblperson);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(250, 150, 200, 25);
        add(tfperson);
        
        lblid = new JLabel("ID");
        lblid.setFont(new Font("Ariel", Font.BOLD, 16));
        lblid.setBounds(40, 190, 150, 20);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setFont(new Font("Ariel", Font.BOLD, 16));
        labelid.setBounds(250, 190, 200, 20);
        add(labelid);
        
        lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Ariel", Font.BOLD, 16));
        lblnumber.setBounds(40, 230, 150, 20);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Ariel", Font.BOLD, 16));
        labelnumber.setBounds(250, 230, 150, 25);
        add(labelnumber);
        
        lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Ariel", Font.BOLD, 16));
        lblphone.setBounds(40, 270, 150, 20);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("Ariel", Font.BOLD, 16));
        labelphone.setBounds(250, 270, 150, 25);
        add(labelphone);
        
        lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Ariel", Font.BOLD, 16));
        lbltotal.setBounds(40, 310, 150, 20);
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setFont(new Font("Ariel", Font.BOLD, 16));
        labeltotal.setBounds(250, 310, 150, 25);
        add(labeltotal);
        
        try{
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet res = conn.s.executeQuery(query);
            while(res.next()){
                labelusername.setText(res.getString("username"));
                labelid.setText(res.getString("id"));
                labelnumber.setText(res.getString("number"));
                labelphone.setText(res.getString("phone"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 500, 300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int price = 0;
            if(pack.equals("PREMIUM PACKAGE")){
                price += 20000;
            }
            else if(pack.equals("STANDARD PACKAGE")){
                price += 15000;
            }
            else if(pack.equals("BASIC PACKAGE")){
                price += 12000;
            }
            int person = Integer.parseInt(tfperson.getText());
            price *= person;
            labeltotal.setText("Tk " + price + "/-");
        }
        else if(ae.getSource() == bookpackage){
            try{
                String pack = cpackage.getSelectedItem();
                int price = 0;
                if(pack.equals("PREMIUM PACKAGE")){
                    price += 20000;
                }
                else if(pack.equals("STANDARD PACKAGE")){
                    price += 15000;
                }
                else if(pack.equals("BASIC PACKAGE")){
                    price += 12000;
                }
                int person = Integer.parseInt(tfperson.getText());
                price *= person;
                labeltotal.setText("Tk " + price + "/-");
                
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfperson.getText()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotal.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Package Booked Successfully! Thank You.");
                setVisible(false);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new BookPackage("Moin");
    }
}
