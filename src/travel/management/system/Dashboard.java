
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    JButton destinations,checkpackages,viewpackage,checkhotels,viewhotel,payment,contactus,logout;
    JPanel left,mainsectionpanel;
    String username;
    
    Dashboard(String username){
        
        this.username = username;
        setLayout(null);
        int screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.white);
        
        JPanel top = new JPanel();
        top.setLayout(null);
        top.setSize(screenwidth, 130);
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
        left.setBounds(0, 132, 300, screenheight-180);
        add(left);

        destinations = createButton("Destinations");
        left.add(destinations);

        checkpackages = createButton("Check Packages");
        left.add(checkpackages);

        viewpackage = createButton("View Booked Package");
        left.add(viewpackage);

        checkhotels = createButton("Check Hotels");
        left.add(checkhotels);

        viewhotel = createButton("View Booked Hotel");
        left.add(viewhotel);
        
        payment = createButton("Payment");
        left.add(payment);
        
        contactus = createButton("Contact us");
        left.add(contactus);
        
        logout = createButton("Logout");
        left.add(logout);
        
        mainsectionpanel = createMainsectionpanel();
               
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
    }
    
    private JPanel  createMainsectionpanel(){
        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(null);
        mainpanel.setBounds(302, 132, 1232, 750);
        add(mainpanel);
               
        ImageIcon front = new ImageIcon(ClassLoader.getSystemResource("images/frontpage.jpg"));
        Image front1 = front.getImage().getScaledInstance(1230, 750, Image.SCALE_AREA_AVERAGING);
        ImageIcon frontimg = new ImageIcon(front1);
    
        JLabel mainsection = new JLabel(frontimg);
        mainsection.setBounds(0,0,1230,750);
        mainpanel.add(mainsection);
       
        
        return mainpanel;
        
    }
    
    private int lastButtonY = 0;
    private JButton createButton(String text){
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.BOLD, 19));
        button.setForeground(new Color(27,27,30));
        button.setBackground(new Color(210,180,140));
        button.setFocusPainted(false);
        button.setBounds(0, lastButtonY, 300, 40);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setMargin(new Insets(0,20,0,0));
        button.addActionListener(this);
        lastButtonY += 40;
        return button;
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource()==logout){
            int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout","Confirmation",JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION){            
                setVisible(false);
                new Login().setVisible(true);
            }  
            
        }else if (e.getSource() == destinations) {
            mainsectionpanel.removeAll(); 
            new Destinations(mainsectionpanel,username);
            
        }else if(e.getSource() == checkhotels){
            mainsectionpanel.removeAll();
            new CheckHotels(mainsectionpanel,username);
        }
    }
    
    
    public static void main(String[] args){
        new Dashboard("");
    }
}
