package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel lblusername, labelusername, lblid, lblnumber, lblname, labelname, lblgender, lblcountry, lbladdress, lblphone, lblemail, labelphone, labelemail, text, labelgender;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfid;
    JRadioButton rmale, rfemale;
    JButton update, back;
    
    UpdateCustomer(String username){
        setBounds(500, 150, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(text);
        
        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        lblid = new JLabel("Id");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);
        
        tfid = new JTextField();
        tfid.setBounds(220, 90, 150, 25);
        add(tfid);
        
        lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);
        
        lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);
        
        lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);
        
        labelgender = new JLabel();
        labelgender.setBounds(220, 210, 150, 25);
        add(labelgender);
        
        lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);
        
        lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);
        
        lblphone = new JLabel("Phone Number");
        lblphone.setBounds(30, 330, 150, 25);
        add(lblphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(220, 330, 150, 25);
        add(labelphone);
        
        lblemail = new JLabel("Email");
        lblemail.setBounds(30, 370, 150, 25);
        add(lblemail);
        
        labelemail = new JLabel();
        labelemail.setBounds(220, 370, 150, 25);
        add(labelemail);
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70, 430, 100, 25);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(260, 430, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(350, 420, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 450, 450);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet res = c.s.executeQuery("select * from customer where username = '"+username+"'");
            while(res.next()){
                labelusername.setText(res.getString("username"));
                labelname.setText(res.getString("name"));
                tfid.setText(res.getString("id"));
                tfnumber.setText(res.getString("number"));
                labelgender.setText(res.getString("gender"));
                tfcountry.setText(res.getString("country"));
                tfaddress.setText(res.getString("address"));
                labelphone.setText(res.getString("phone"));
                labelemail.setText(res.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == update){
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = labelgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = labelphone.getText();
            String email = labelemail.getText();
            
            try{
                Conn c = new Conn();
                String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully!");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new UpdateCustomer("");
    }
}
