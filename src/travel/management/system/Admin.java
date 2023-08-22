package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Admin extends Dashboard {

    JButton deleteuser, paymentdetails, viewbookedhotels;
    String username;
    
    
    Admin(String username) {
        
        super(username);
        this.username = username;

        deleteuser = new JButton("User details");
        deleteuser.setFont(new Font("Tahoma", Font.BOLD, 19));
        deleteuser.setForeground(new Color(27, 27, 30));
        deleteuser.setBackground(new Color(210, 180, 140));
        deleteuser.setBounds(0, 200, 300, 40);
        deleteuser.setFocusPainted(false);
        deleteuser.setMargin(new Insets(0, 0, 0, 120));
        left.add(deleteuser);

        paymentdetails = new JButton("Payment Details");
        paymentdetails.setFont(new Font("Tahoma", Font.BOLD, 19));
        paymentdetails.setForeground(new Color(27, 27, 30));
        paymentdetails.setBackground(new Color(210, 180, 140));
        paymentdetails.setBounds(0, 240, 300, 40);
        paymentdetails.setFocusPainted(false);
        paymentdetails.setMargin(new Insets(0, 0, 0, 80));
        left.add(paymentdetails);
        
        viewbookedhotels = new JButton("View Booked Hotel");
        viewbookedhotels.setFont(new Font("Tahoma", Font.BOLD, 19));
        viewbookedhotels.setForeground(new Color(27, 27, 30));
        viewbookedhotels.setBackground(new Color(210, 180, 140));
        viewbookedhotels.setBounds(0, 320, 300, 40);
        viewbookedhotels.setFocusPainted(false);
        viewbookedhotels.setMargin(new Insets(0, 0, 0, 60));
        viewbookedhotels.addActionListener(this);
        left.add(viewbookedhotels);

        left.remove(payment);
        left.remove(contactus);

        left.revalidate();
        left.repaint();
    }
    
    public void actionPerformed(ActionEvent e){
        super.actionPerformed(e);
        
        if(e.getSource()== viewbookedhotels){
            new ViewBookedHotels(mainsectionpanel);
        }
    }

    public static void main(String[] args) {
        new Admin("");
    }
}
