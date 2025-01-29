package travel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tfusername, tfname, tfphone, tfemail, tfpass;
    JButton search, regain, back;
    
    ForgetPassword(){
        setBounds(350, 200, 850, 380);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580, 70, 200, 200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        p1.setBackground(new Color(200, 212, 233));
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("ARIEL", Font.BOLD, 14));
        lblusername.setBounds(40, 20, 100, 25);
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(170, 20, 200, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        search = new JButton("Search");
        search.setBackground(Color.blue);
        search.setForeground(Color.white);
        search.setFont(new Font("ARIEL", Font.BOLD, 14));
        search.setBounds(380, 20, 100, 25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("ARIEL", Font.BOLD, 14));
        lblname.setBounds(40, 60, 100, 25);
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(170, 60, 200, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setFont(new Font("ARIEL", Font.BOLD, 14));
        lblphone.setBounds(40, 100, 150, 25);
        p1.add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(170, 100, 200, 25);
        tfphone.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setFont(new Font("ARIEL", Font.BOLD, 14));
        lblemail.setBounds(40, 140, 100, 25);
        p1.add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(170, 140, 200, 25);
        tfemail.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfemail);
        
        regain = new JButton("Regain Password");
        regain.setBackground(Color.red);
        regain.setForeground(Color.white);
        regain.setFont(new Font("ARIEL", Font.BOLD, 14));
        regain.setBounds(180, 180, 180, 25);
        regain.addActionListener(this);
        p1.add(regain);
        
        JLabel lblpass = new JLabel("Password");
        lblpass.setFont(new Font("ARIEL", Font.BOLD, 14));
        lblpass.setBounds(40, 220, 100, 25);
        p1.add(lblpass);
        
        tfpass = new JTextField();
        tfpass.setBounds(170, 220, 200, 25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);
        
        back = new JButton("Back");
        back.setBackground(new Color(131, 193, 233));
        back.setForeground(Color.white);
        back.setFont(new Font("ARIEL", Font.BOLD, 14));
        back.setBounds(380, 220, 100, 25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Conn c = new Conn();
                
                ResultSet res = c.s.executeQuery(query);
                while(res.next()){
                    tfname.setText(res.getString("name"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == regain){
            try{
                String query = "select * from account where phone = '"+tfphone.getText()+"' AND email = '"+tfemail.getText()+"'";
                Conn c = new Conn();
                
                ResultSet res = c.s.executeQuery(query);
                while(res.next()){
                    tfpass.setText(res.getString("password"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new LogIn();
        }
    }
    
    public static void main(String[] args) {
        new ForgetPassword();
    }
}
