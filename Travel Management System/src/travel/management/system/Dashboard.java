package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton DeletePersonalDetails, calc, about, addPersonalDetails, ViewPersonalDetails, UpdatePersonalDetails, checkPackage, bookPackage, viewPackage, viewHotels, bookHotels, viewBookedHotel, destinations, logout;
    Dashboard(String username){
        this.username = username;
        //setBounds(0, 0, 1600, 1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);
        
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Ariel", Font.BOLD, 30));
        p1.add(heading);
        
        logout = new JButton("Log Out");
        logout.setBounds(1380, 10, 200, 50);
        logout.setForeground(Color.RED);
        logout.setFont(new Font("Ariel", Font.BOLD, 20));
        logout.addActionListener(this);
        p1.add(logout);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 102, 102));
        p2.setBounds(0, 65, 320, 900);
        add(p2);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(10, 10, 300, 50);
        addPersonalDetails.setForeground(Color.RED);
        addPersonalDetails.setFont(new Font("Ariel", Font.BOLD, 20));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        UpdatePersonalDetails = new JButton("Update Personal Details");
        UpdatePersonalDetails.setBounds(10, 70, 300, 50);
        UpdatePersonalDetails.setForeground(Color.RED);
        UpdatePersonalDetails.setFont(new Font("Ariel", Font.BOLD, 20));
        UpdatePersonalDetails.addActionListener(this);
        p2.add(UpdatePersonalDetails);
        
        ViewPersonalDetails = new JButton("View Personal Details");
        ViewPersonalDetails.setBounds(10, 130, 300, 50);
        ViewPersonalDetails.setForeground(Color.RED);
        ViewPersonalDetails.setFont(new Font("Ariel", Font.BOLD, 20));
        ViewPersonalDetails.addActionListener(this);
        p2.add(ViewPersonalDetails);
        
        DeletePersonalDetails = new JButton("Delete Current Account");
        DeletePersonalDetails.setBounds(10, 190, 300, 50);
        DeletePersonalDetails.setForeground(Color.RED);
        DeletePersonalDetails.setFont(new Font("Ariel", Font.BOLD, 20));
        DeletePersonalDetails.addActionListener(this);
        p2.add(DeletePersonalDetails);
        
        checkPackage = new JButton("Check Package");
        checkPackage.setBounds(10, 250, 300, 50);
        checkPackage.setForeground(Color.RED);
        checkPackage.setFont(new Font("Ariel", Font.BOLD, 20));
        checkPackage.addActionListener(this);
        p2.add(checkPackage);
        
        bookPackage = new JButton("Book Package");
        bookPackage.setBounds(10, 310, 300, 50);
        bookPackage.setForeground(Color.RED);
        bookPackage.setFont(new Font("Ariel", Font.BOLD, 20));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);
        
        viewPackage = new JButton("View Package");
        viewPackage.setBounds(10, 370, 300, 50);
        viewPackage.setForeground(Color.RED);
        viewPackage.setFont(new Font("Ariel", Font.BOLD, 20));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);
        
        viewHotels = new JButton("View Hotels");
        viewHotels.setBounds(10, 430, 300, 50);
        viewHotels.setForeground(Color.RED);
        viewHotels.setFont(new Font("Ariel", Font.BOLD, 20));
        viewHotels.addActionListener(this);
        p2.add(viewHotels);
        
        bookHotels = new JButton("Book Hotel");
        bookHotels.setBounds(10, 490, 300, 50);
        bookHotels.setForeground(Color.RED);
        bookHotels.setFont(new Font("Ariel", Font.BOLD, 20));
        bookHotels.addActionListener(this);
        p2.add(bookHotels);
        
        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(10, 550, 300, 50);
        viewBookedHotel.setForeground(Color.RED);
        viewBookedHotel.setFont(new Font("Ariel", Font.BOLD, 20));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);
        
        destinations = new JButton("Destinations");
        destinations.setBounds(10, 610, 300, 50);
        destinations.setForeground(Color.RED);
        destinations.setFont(new Font("Ariel", Font.BOLD, 20));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        calc = new JButton("Calculator");
        calc.setBounds(10, 670, 300, 50);
        calc.setForeground(Color.RED);
        calc.setFont(new Font("Ariel", Font.BOLD, 20));
        calc.addActionListener(this);
        p2.add(calc);
        
        about = new JButton("About");
        about.setBounds(10, 730, 300, 50);
        about.setForeground(Color.RED);
        about.setFont(new Font("Ariel", Font.BOLD, 20));
        about.addActionListener(this);
        p2.add(about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);
        
        JLabel text = new JLabel("Travel and Tourism Management System");
        text.setBounds(430, 70, 1200, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Ariel", Font.BOLD, 55));
        image.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        }
        else if(ae.getSource() == ViewPersonalDetails){
            new ViewCustomer(username);
        }
        else if(ae.getSource() == UpdatePersonalDetails){
            new UpdateCustomer(username);
        }
        else if(ae.getSource() == checkPackage){
            new CheckPackage();
        }
        else if(ae.getSource() == bookPackage){
            new BookPackage(username);
        }
        else if(ae.getSource() == viewPackage){
            new ViewPackage(username);
        }
        else if(ae.getSource() == viewHotels){
            new CheckHotels();
        }
        else if(ae.getSource() == destinations){
            new Destination();
        }
        else if(ae.getSource() == bookHotels){
            new BookHotel(username);
        }
        else if(ae.getSource() == viewBookedHotel){
            new ViewBookedHotel(username);
        }
        else if(ae.getSource() == logout){
            setVisible(false);
            new LogIn();
        }
        else if(ae.getSource() == about){
            new About();
        }
        else if(ae.getSource() == DeletePersonalDetails){
            new DeleteDetails(username);
        }
        else if(ae.getSource() == calc){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        new Dashboard("");
    }
}
