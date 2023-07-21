package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Admin extends Dashboard {

    JButton deleteuser, paymentdetails;

    Admin() {

        super();

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

        left.remove(payment);
        left.remove(contactus);

        left.revalidate();
        left.repaint();
    }

    public static void main(String[] args) {
        new Admin();
    }
}
