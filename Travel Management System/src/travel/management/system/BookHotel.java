package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    
    Choice chotel, cac, cfood;
    
    JLabel text, lblusername, labelusername, lblhotel, lblperson, lbldays, lblid, lblac, lblfood, labelid, lblnumber, labelnumber, lblphone, labelphone, lbltotal, labeltotal;
    JTextField tfdays, tfperson;
    JButton checkprice, bookhotel, back;
    String username;
    BookHotel(String username){
        this.username = username;
        setBounds(260, 180, 1100, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        text = new JLabel("BOOK HOTEL");
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
        
        lblhotel = new JLabel("Select Hotel");
        lblhotel.setFont(new Font("Ariel", Font.BOLD, 16));
        lblhotel.setBounds(40, 110, 150, 20);
        add(lblhotel);
        
        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);
        
        try{
            Conn c = new Conn();
            ResultSet res = c.s.executeQuery("select * from hotel");
            while(res.next()){
                chotel.add(res.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        lblperson = new JLabel("Total Person");
        lblperson.setFont(new Font("Ariel", Font.BOLD, 16));
        lblperson.setBounds(40, 150, 150, 20);
        add(lblperson);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(250, 150, 200, 25);
        add(tfperson);
        
        lbldays = new JLabel("No. of Days");
        lbldays.setFont(new Font("Ariel", Font.BOLD, 16));
        lbldays.setBounds(40, 190, 150, 20);
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 25);
        add(tfdays);
        
        lblac = new JLabel("AC/ Non-AC");
        lblac.setFont(new Font("Ariel", Font.BOLD, 16));
        lblac.setBounds(40, 230, 150, 20);
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 200, 20);
        add(cac);
        
        lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Ariel", Font.BOLD, 16));
        lblfood.setBounds(40, 270, 150, 20);
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);
        
        lblid = new JLabel("Number");
        lblid.setFont(new Font("Ariel", Font.BOLD, 16));
        lblid.setBounds(40, 310, 150, 20);
        add(lblid);
        
        labelid = new JLabel();
        labelid.setFont(new Font("Ariel", Font.BOLD, 16));
        labelid.setBounds(250, 310, 150, 25);
        add(labelid);
        
        lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Ariel", Font.BOLD, 16));
        lblnumber.setBounds(40, 350, 150, 20);
        add(lblnumber);
        
        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Ariel", Font.BOLD, 16));
        labelnumber.setBounds(250, 350, 150, 25);
        add(labelnumber);
        
        lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Ariel", Font.BOLD, 16));
        lblphone.setBounds(40, 390, 150, 20);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setFont(new Font("Ariel", Font.BOLD, 16));
        labelphone.setBounds(250, 390, 150, 25);
        add(labelphone);
        
        lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Ariel", Font.BOLD, 16));
        lbltotal.setBounds(40, 430, 150, 20);
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setFont(new Font("Ariel", Font.BOLD, 16));
        labeltotal.setBounds(250, 430, 150, 25);
        add(labeltotal);
        
        try{
            Conn conn = new Conn();
            String query1 = "select * from customer where username = '"+username+"'";
            ResultSet res1 = conn.s.executeQuery(query1);
            
            while(res1.next()){
                labelusername.setText(res1.getString("username"));
                labelid.setText(res1.getString("id"));
                labelnumber.setText(res1.getString("number"));
                labelphone.setText(res1.getString("phone"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(200, 490, 120, 25);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 600, 300);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            try{
            Conn c = new Conn();
            ResultSet res = c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
            while(res.next()){
                int cost = Integer.parseInt(res.getString("costperperson"));
                int food = Integer.parseInt(res.getString("foodincluded"));
                int ac = Integer.parseInt(res.getString("acroom"));
                
                int person = Integer.parseInt(tfperson.getText());
                int days = Integer.parseInt(tfdays.getText());
                
                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                if(person * days > 0){
                    int total = 0;
                    if(acselected.equals("AC")){
                        total += ac;
                    }
                    else{
                        total += 0;
                    }
                    if(foodselected.equals("YES")){
                        total += food;
                    }
                    else{
                        total += 0;
                    }
                    total += cost;
                    total = total * person * days;
                    labeltotal.setText("Tk "+ total + "/-");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid Number!");
                }
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == bookhotel){
            try{
                Conn c = new Conn();
                ResultSet res = c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
                while(res.next()){
                int cost = Integer.parseInt(res.getString("costperperson"));
                int food = Integer.parseInt(res.getString("foodincluded"));
                int ac = Integer.parseInt(res.getString("acroom"));
                
                int person = Integer.parseInt(tfperson.getText());
                int days = Integer.parseInt(tfdays.getText());
                
                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                if(person * days > 0){
                    int total = 0;
                    if(acselected.equals("AC")){
                        total += ac;
                    }
                    else{
                        total += 0;
                    }
                    if(foodselected.equals("YES")){
                        total += food;
                    }
                    else{
                        total += 0;
                    }
                    total += cost;
                    total = total * person * days;
                    labeltotal.setText("Tk "+ total + "/-");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please Enter a Valid Number!");
                }
                }
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfperson.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelid.getText()+"', '"+labelnumber.getText()+"', '"+labelphone.getText()+"', '"+labeltotal.getText()+"')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully! Thank You.");
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
        new BookHotel("");
    }
}
