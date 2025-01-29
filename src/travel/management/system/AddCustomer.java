package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel lblusername, labelusername, lblid, lblnumber, lblname, labelname, lblgender, lblcountry, lbladdress, lblphone, lblemail, labelphone, labelemail;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress;
    JRadioButton rmale, rfemale;
    JButton add, back;
    
    AddCustomer(String username){
        setBounds(400, 150, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);
        
        lblid = new JLabel("Id");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);
        
        comboid = new JComboBox(new String[] {"National ID", "Birth Certificate", "Student ID", "Passport"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        comboid.setForeground(Color.BLUE);
        add(comboid);
        
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
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(215, 210, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);
        
        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);
        
        ButtonGroup bg = new ButtonGroup(); // For selecting only one of the genders
        bg.add(rmale);
        bg.add(rfemale);
        
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
        
        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(260, 430, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.png"));
        Image i2 = i1.getImage().getScaledInstance(410, 510, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 0, 450, 510);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet res = c.s.executeQuery("select * from account where username = '"+username+"'");
            while(res.next()){
                labelusername.setText(res.getString("username"));
                labelname.setText(res.getString("name"));
                labelphone.setText(res.getString("phone"));
                labelemail.setText(res.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if(rmale.isSelected()){
                gender = "Male";
            }
            else if(rfemale.isSelected()){
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = labelphone.getText();
            String email = labelemail.getText();
            
            try{
                Conn c = new Conn();
                String query = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully!");
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
        new AddCustomer("");
    }
}
