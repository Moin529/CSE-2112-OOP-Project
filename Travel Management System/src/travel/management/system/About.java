package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    About(){
        setBounds(600, 200, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200, 20, 100, 40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Ariel", Font.BOLD, 20));
        add(l1);
        
        String s = "                                                          About Projects          \n  "
                + "\nThe objective of the Travel and Tourism Management System"
                + " project is to develop a system that automates the processes "
                + "and activities of a travel and the purpose is to design a "
                + "system using which one can perform all operations related to "
                + "traveling.\n\n"
                + "This application will help in accessing the information related "
                + "to the travel to the particular destination with great ease. "
                + "The users can track the information related to their tours with "
                + "great ease through this application. The travel agency information "
                + "can also be obtained through this application.\n\n"
                + "Advantages of Project:"
                + "\nGives accurate information"
                + "\nSimplifies the manual work"
                + "\nIt minimizes the documentation related work"
                + "\nProvides up to date information"
                + "\nFriendly Environment by providing warning messages."
                + "\ntravelers details can be provided"
                + "\nbooking confirmation notification"
                + "\n\n\n"
                + "The application was made with full effort of Java coding with the help of swing. "
                + "For storing and using data from the user input, MySQL has been used as it is easy to handle "
                + "large number of datas."
                + "\n\n\n"
                + "Project Makers: \n\n"
                + "1. Md. Mahmudur Rahman Moin\n"
                + "2. Md. Sharif\n"
                + "\nDepartment of Computer Science and Engineering\n"
                + "University of Dhaka\n\n\n"
                + "                                        Thank you for using our application.\n\n"
                ;
        
        TextArea area = new TextArea(s, 10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);
        
        JButton back = new JButton("Back");
        back.setBounds(200, 430, 90, 40);
        back.setForeground(Color.RED);
        back.setFont(new Font("Ariel", Font.BOLD, 20));
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args) {
        new About();
    }
}
