
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JButton destinations,checkpackages,viewpackage,checkhotels,viewhotel,payment,contactus,logout;
    JPanel left,frontpage;
    
    Dashboard(){
        setLayout(null);
        int framewidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int frameheight = Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(framewidth,frameheight);
        getContentPane().setBackground(Color.white);
        
        JPanel top = new JPanel();
        top.setLayout(null);
        top.setSize(framewidth, 130);
        top.setBackground(new Color(63,117,198));
        add(top);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/logo.png"));
        Image i1 = i.getImage().getScaledInstance(200, 160, Image.SCALE_AREA_AVERAGING);
        ImageIcon img = new ImageIcon(i1);
        JLabel logo = new JLabel(img);
        logo.setBounds(5,0, 170, 160);
        top.add(logo);
        
        JLabel dashboard = new JLabel("Dashboard");
        dashboard.setFont(new Font("Tahoma", Font.BOLD, 28));
        dashboard.setForeground(Color.BLACK);
        dashboard.setBounds(150,60,300,30);
        top.add(dashboard);

        left = new JPanel();
        left.setLayout(null);
        left.setBackground(new Color(222,219,211));
        left.setBounds(0, 132, 300, frameheight-180);
        add(left);

        destinations = new JButton("Destinations");
        destinations.setFont(new Font("Tahoma", Font.BOLD, 19));
        destinations.setForeground(new Color(27,27,30));
        destinations.setBackground(new Color(210,180,140));
        destinations.setBounds(0, 0, 300, 40);
        destinations.setFocusPainted(false);
        destinations.setMargin(new Insets(0,0,0,112));
        left.add(destinations);

        checkpackages = new JButton("Check Packages");
        checkpackages.setFont(new Font("Tahoma", Font.BOLD, 19));
        checkpackages.setForeground(new Color(27,27,30));
        checkpackages.setBackground(new Color(210,180,140));
        checkpackages.setBounds(0, 40, 300, 40);
        checkpackages.setFocusPainted(false);
        checkpackages.setMargin(new Insets(0,0,0,80));
        left.add(checkpackages);

        viewpackage = new JButton("View Booked Package");
        viewpackage.setFont(new Font("Tahoma", Font.BOLD, 19));
        viewpackage.setForeground(new Color(27,27,30));
        viewpackage.setBackground(new Color(210,180,140));
        viewpackage.setBounds(0, 80, 300, 40);
        viewpackage.setFocusPainted(false);
        viewpackage.setMargin(new Insets(0,0,0,22));
        left.add(viewpackage);

        checkhotels = new JButton("Check Hotels");
        checkhotels.setFont(new Font("Tahoma", Font.BOLD, 19));
        checkhotels.setForeground(new Color(27,27,30));
        checkhotels.setBackground(new Color(210,180,140));
        checkhotels.setBounds(0, 120, 300, 40);
        checkhotels.setFocusPainted(false);
        checkhotels.setMargin(new Insets(0,0,0,106));
        left.add(checkhotels);

        viewhotel = new JButton("View Booked Hotel");
        viewhotel.setFont(new Font("Tahoma", Font.BOLD, 19));
        viewhotel.setForeground(new Color(27,27,30));
        viewhotel.setBackground(new Color(210,180,140));
        viewhotel.setBounds(0, 160, 300, 40);
        viewhotel.setFocusPainted(false);
        viewhotel.setMargin(new Insets(0,0,0,52));
        left.add(viewhotel);
        
        payment = new JButton("Payment");
        payment.setFont(new Font("Tahoma", Font.BOLD, 19));
        payment.setForeground(new Color(27,27,30));
        payment.setBackground(new Color(210,180,140));
        payment.setBounds(0, 200, 300, 40);
        payment.setFocusPainted(false);
        payment.setMargin(new Insets(0,0,0,145));
        left.add(payment);
        
        contactus = new JButton("Contact us");
        contactus.setFont(new Font("Tahoma", Font.BOLD, 19));
        contactus.setForeground(new Color(27,27,30));
        contactus.setBackground(new Color(210,180,140));
        contactus.setBounds(0, 240, 300, 40);
        contactus.setFocusPainted(false);
        contactus.setMargin(new Insets(0,0,0,125));
        left.add(contactus);
        
        logout = new JButton("Logout");
        logout.setFont(new Font("Tahoma", Font.BOLD, 19));
        logout.setForeground(new Color(27,27,30));
        logout.setBackground(new Color(210,180,140));
        logout.setBounds(0, 280, 300, 40);
        logout.setFocusPainted(false);
        logout.setMargin(new Insets(0,0,0,160));
        logout.addActionListener(this);
        left.add(logout);
        
        ImageIcon front = new ImageIcon(ClassLoader.getSystemResource("images/frontpage.jpg"));
        Image front1 = front.getImage().getScaledInstance(1230, 800, Image.SCALE_AREA_AVERAGING);
        ImageIcon frontimg = new ImageIcon(front1);
        frontpage = new JPanel();
        frontpage.setLayout(null);
        frontpage.setBounds(302, 132, 1230, 750);
        add(frontpage);
        
        JLabel label = new JLabel(frontimg);
        label.setBounds(0,0,1230,750);
        frontpage.add(label);
        
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==logout){
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout","Confirmation",JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){            
                setVisible(false);
                new Login().setVisible(true);
            }
            
        }
    }
    
    
    public static void main(String[] args){
        new Dashboard();
    }
}
