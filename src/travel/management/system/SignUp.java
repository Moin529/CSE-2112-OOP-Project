package travel.management.system;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener{
    
    JButton create, back;
    JTextField tfname, tfusername, tfpassword, tfphone, tfemail;
    
    SignUp(){
        setBounds(350, 200, 900, 360);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("ARIEL", Font.BOLD, 14));
        lblusername.setBounds(50, 20, 125, 25);
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(170, 20, 210, 25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("ARIEL", Font.BOLD, 14));
        lblname.setBounds(50, 60, 125, 25);
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(170, 60, 210, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("ARIEL", Font.BOLD, 14));
        lblpassword.setBounds(50, 100, 125, 25);
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(170, 100, 210, 25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setFont(new Font("ARIEL", Font.BOLD, 14));
        lblphone.setBounds(50, 140, 125, 25);
        p1.add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(170, 140, 210, 25);
        tfphone.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setFont(new Font("ARIEL", Font.BOLD, 14));
        lblemail.setBounds(50, 180, 125, 25);
        p1.add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(170, 180, 210, 25);
        tfemail.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfemail);
        
        create = new JButton("Create");
        create.setBounds(70, 250, 150, 25);
        create.setFont(new Font("ARIEL", Font.BOLD, 14));
        create.setBackground(new Color(133, 233, 133));
        create.setForeground(Color.WHITE);
        create.setBorder(new LineBorder(new Color(133, 233, 133)));
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBounds(280, 250, 150, 25);
        back.setFont(new Font("ARIEL", Font.BOLD, 14));
        back.setBackground(new Color(133, 233, 133));
        back.setForeground(Color.WHITE);
        back.setBorder(new LineBorder(new Color(133, 233, 133)));
        back.addActionListener(this);
        p1.add(back);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(212, 212, 233));
        p2.setBounds(500, 0, 500, 260);
        add(p2);
        
        JLabel lblmenu = new JLabel("SIGN UP");
        lblmenu.setFont(new Font("ARIEL", Font.BOLD, 30));
        lblmenu.setForeground(Color.RED);
        lblmenu.setBounds(630, 250, 125, 60);
        add(lblmenu);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 30, 200, 200);
        p2.add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        
        if(ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+phone+"', '"+email+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account Created Successfully!");
                
                setVisible(false);
                new LogIn();
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
        new SignUp();
    }
}
