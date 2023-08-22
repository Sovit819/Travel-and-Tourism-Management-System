package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class CheckHotels implements ActionListener {

    JPanel mainsectionpanel;
    String description[];
    JButton check1, check2, check3, check4;
    String username;

    CheckHotels(JPanel mainsectionpanel, String username) {

        this.mainsectionpanel = mainsectionpanel;
        this.username = username;
        description = new String[5];

        description[1] = "<html><p><b>Description:</b><br>This hotel is located at the center of the<br> Kathmandu city.<br</p></html>";
        description[2] = "<html><p><b>Description:</b><br>If you are looking for a budget friendly<br> luxurious hotel then contact us</p></html>";
        description[3] = "<html><p<b>Description:</b><br>This 5 star resort is located in Pokhara Phewa Lake</p></html>";
        description[4] = "<html><p><b>Description:</b><br>If you want to enjoy the view of Mountains<br>from your sweet bedroom then give us a chance<br> to serve you</p></html>";

        JPanel tour1 = createPanel(1, "The Everest Hotel", description[1], "images/EverestHotel.jpg", "Starting @Rs.5,500");
        check1 = new JButton("Check Hotel");
        check1.setForeground(Color.BLACK);
        check1.setBackground(new Color(152, 251, 152));
        check1.setFont(new Font("Arial", Font.BOLD, 16));
        check1.setBounds(300, 220, 150, 30);
        check1.addActionListener(this);
        tour1.add(check1);
        mainsectionpanel.add(tour1);

        JPanel tour2 = createPanel(2, "Malla Hotel", description[2], "images/MallaHotel.jpeg", "Starting @Rs.4,000");
        check2 = new JButton("Check Hotel");
        check2.setForeground(Color.BLACK);
        check2.setBackground(new Color(152, 251, 152));
        check2.setFont(new Font("Arial", Font.BOLD, 16));
        check2.setBounds(300, 220, 150, 30);
        check2.addActionListener(this);
        tour2.add(check2);
        mainsectionpanel.add(tour2);

        JPanel tour3 = createPanel(3, "Bar Peepal Resort", description[3], "images/Bar_Peepal_Resort.jpg", "Starting@ Rs.8,000");
        check3 = new JButton("Check Hotel");
        check3.setForeground(Color.BLACK);
        check3.setBackground(new Color(152, 251, 152));
        check3.setFont(new Font("Arial", Font.BOLD, 16));
        check3.setBounds(300, 220, 150, 30);
        check3.addActionListener(this);
        tour3.add(check3);
        mainsectionpanel.add(tour3);

        JPanel tour4 = createPanel(4, "Pokhara Grande Hotel", description[4], "images/PokharaGrandeHotel.jpg", "Starting@ Rs.6,999");
        check4 = new JButton("Check Hotel");
        check4.setForeground(Color.BLACK);
        check4.setBackground(new Color(152, 251, 152));
        check4.setFont(new Font("Arial", Font.BOLD, 16));
        check4.setBounds(300, 220, 150, 30);
        check4.addActionListener(this);
        tour4.add(check4);
        mainsectionpanel.add(tour4);
        
        

        mainsectionpanel.revalidate();
        mainsectionpanel.repaint();
    }

    private int lastPanelY = 5;
    private int lastPanelX = 5;

    private JPanel createPanel(int n, String title, String description, String imagepath, String cost) {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(254, 251, 234));

        //For Title of the destination
        JLabel titlelabel = new JLabel(title);
        titlelabel.setBounds(20, 12, 300, 22);
        titlelabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titlelabel);

        //For image
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource(imagepath));
        Image i1 = i.getImage().getScaledInstance(200, 200, Image.SCALE_AREA_AVERAGING);
        ImageIcon img = new ImageIcon(i1);
        JLabel image = new JLabel(img);
        image.setBounds(20, 45, 200, 200);
        panel.add(image);

        //For Cost
        JLabel cost1 = new JLabel(cost);
        cost1.setFont(new Font("Tahoma", Font.BOLD, 16));
        cost1.setBounds(30, 260, 200, 22);
        panel.add(cost1);

        //For description of the places of visit
        JLabel descriptionLabel = new JLabel();
        descriptionLabel.setText("<html><div style='width: 400px;'>" + description + "</div></html>");
        descriptionLabel.setBounds(250, 60, 400, 100); // Adjust the height to accommodate the description
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(descriptionLabel);

        if (n % 2 != 0) {
            lastPanelX = 5;
            panel.setBounds(lastPanelX, lastPanelY, mainsectionpanel.getWidth() / 2, 300);
            lastPanelX += (mainsectionpanel.getWidth() / 2) + 5;
        } else {
            panel.setBounds(lastPanelX, lastPanelY, mainsectionpanel.getWidth() / 2, 300);
            lastPanelY += 305;

        }

        return panel;
    }

    public void actionPerformed(ActionEvent e) {

        try {
            
            if (e.getSource() == check1) {
                new Hotels(username).showHotel1RoomDetails();
            } else if (e.getSource() == check2) {
                new Hotels(username).showHotel2RoomDetails();
            } else if (e.getSource() == check3) {
                new Hotels(username).showHotel3RoomDetails();
            } else if (e.getSource() == check4) {
                new Hotels(username).showHotel4RoomDetails();
            }

            
        } catch (Exception e3) {
            e3.printStackTrace();
        }

    }

}
