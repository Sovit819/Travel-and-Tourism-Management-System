package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.util.UUID;

public class Destinations implements ActionListener {

    JPanel mainsectionpanel;
    String description[];
    JButton Book1, Book2, Book3, Book4;
    String username;

    Destinations(JPanel mainsectionpanel, String username) {

        this.mainsectionpanel = mainsectionpanel;
        this.username = username;
        description = new String[5];

        description[1] = "<html><p>Duration: 3 days<br><br><b>Description:</b><br> Pashupatinath,Stupas,Chandragiri</p></html>";
        description[2] = "<html><p>Duration: 4 days<br><br><b>Description:</b><br> Complete jungle safari</p></html>";
        description[3] = "<html><p>Duration: 7 days<br><br><b>Description:</b><br> Lumbini,Pokhara Lakeside,Paragliding</p></html>";
        description[4] = "<html><p>Duration: 10 days<br><br><b>Description:</b><br> This is Bike tour</p></html>";

        JPanel tour1 = createPanel(1, "Kathmandu Valley Tour", description[1], "images/front.png", "Cost: Rs.5,000");
        Book1 = new JButton("Book Now");
        Book1.setForeground(Color.BLACK);
        Book1.setBackground(new Color(152, 251, 152));
        Book1.setFont(new Font("Arial", Font.BOLD, 16));
        Book1.setBounds(300, 220, 120, 30);
        Book1.addActionListener(this);
        tour1.add(Book1);
        mainsectionpanel.add(tour1);

        JPanel tour2 = createPanel(2, "Chitwan Jungle Safari", description[2], "images/front.png", "Cost: Rs.8,000");
        Book2 = new JButton("Book Now");
        Book2.setForeground(Color.BLACK);
        Book2.setBackground(new Color(152, 251, 152));
        Book2.setFont(new Font("Arial", Font.BOLD, 16));
        Book2.setBounds(300, 220, 120, 30);
        Book2.addActionListener(this);
        tour2.add(Book2);
        mainsectionpanel.add(tour2);

        JPanel tour3 = createPanel(3, "Lumbini-Pokhara Tour", description[3], "images/front.png", "Cost: Rs.12,000");
        Book3 = new JButton("Book Now");
        Book3.setForeground(Color.BLACK);
        Book3.setBackground(new Color(152, 251, 152));
        Book3.setFont(new Font("Arial", Font.BOLD, 16));
        Book3.setBounds(300, 220, 120, 30);
        Book3.addActionListener(this);
        tour3.add(Book3);
        mainsectionpanel.add(tour3);

        JPanel tour4 = createPanel(4, "Manang-Mustang Tour", description[4], "images/front.png", "Cost: Rs.5,000");
        Book4 = new JButton("Book Now");
        Book4.setForeground(Color.BLACK);
        Book4.setBackground(new Color(152, 251, 152));
        Book4.setFont(new Font("Arial", Font.BOLD, 16));
        Book4.setBounds(300, 220, 120, 30);
        Book4.addActionListener(this);
        tour4.add(Book4);
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
        titlelabel.setBounds(20, 15, 300, 20);
        titlelabel.setFont(new Font("Arial", Font.BOLD, 18));
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
        cost1.setFont(new Font("Tahoma", Font.BOLD, 18));
        cost1.setBounds(30, 260, 150, 22);
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
            int Tour_No = 0;
            String Tour_Name = "";

            if (e.getSource() == Book1) {
                Tour_No = 1;
                Tour_Name = "Kathmandu Valley Tour";
            } else if (e.getSource() == Book2) {
                Tour_No = 2;
                Tour_Name = "Chitwan Jungle Safari";
            } else if (e.getSource() == Book3) {
                Tour_No = 3;
                Tour_Name = "Lumbini-Pokhara Tour";
            } else if (e.getSource() == Book4) {
                Tour_No = 4;
                Tour_Name = "Manang-Mustang Tour";
            }

            Date date = new Date();
            Connec c = new Connec();
            String query1 = "SELECT * FROM Accountdetails WHERE Username ='" + username + "'";
            ResultSet res = c.s.executeQuery(query1);
            if (res.next()) {
                String Username = res.getString("Username");
                String Phone_Number = res.getString("Phone_Number");

                String query2 = "INSERT INTO Destinations_Booking (Username, Phone_Number, Tour_No, Tour_Name, Booking_Date) VALUES('" + Username + "','" + Phone_Number + "','" + Tour_No + "','" + Tour_Name + "','" + date + "' )";
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Your booking is successful", "Booking Successful", JOptionPane.INFORMATION_MESSAGE);
        
            }

        } catch (Exception e3) {
            e3.printStackTrace();
        }

    }
}
