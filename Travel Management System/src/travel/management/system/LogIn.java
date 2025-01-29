package travel.management.system;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class LogIn extends JFrame implements ActionListener{
    JTextField tfusername;
    JPasswordField tfpassword;
    JButton login, signup, pass; 
    
    LogIn(){
        setSize(900, 400);
        setLocation(350, 220);
        setLayout(null);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblmenu = new JLabel("LOG IN");
        lblmenu.setBounds(150, 20, 100, 35);
        lblmenu.setForeground(Color.red);
        lblmenu.setFont(new Font("ARIEL", Font.PLAIN, 30));
        p1.add(lblmenu);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("ARIEL", Font.PLAIN, 20));
        p2.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setFont(new Font("Ariel", Font.BOLD, 22));
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 110, 100, 25);
        lblpassword.setFont(new Font("ARIEL", Font.PLAIN, 20));
        p2.add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setFont(new Font("Ariel", Font.BOLD, 22));
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        login = new JButton("Log In");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(133, 233, 133));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133, 233, 133)));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Sign Up");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(133, 233, 133));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133, 233, 133)));
        signup.addActionListener(this);
        p2.add(signup);
        
        pass = new JButton("Forget Password");
        pass.setBounds(150, 250, 130, 30);
        pass.setBackground(new Color(133, 233, 133));
        pass.setForeground(Color.WHITE);
        pass.setBorder(new LineBorder(new Color(133, 233, 133)));
        pass.addActionListener(this);
        p2.add(pass);

        JLabel text = new JLabel("Trouble in Log In...");
        text.setBounds(290, 255, 150, 20);
        text.setForeground(Color.RED);
        p2.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            try{
                String username = tfusername.getText();
                String password = tfpassword.getText();
                
                String query = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                Conn c = new Conn();
                ResultSet res = c.s.executeQuery(query);
                if(res.next()){
                    setVisible(false);
                    new Loading(username);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect password or username");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignUp();
        }
        else if(ae.getSource() == pass){
            setVisible(false);
            new ForgetPassword();
        }
    }
    
    public static void main(String[] args) {
        new LogIn();
    }
}
