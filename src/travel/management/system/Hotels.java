package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Hotels implements ActionListener {

    JFrame frame;
    JPanel roomDetailsPanel;
    JButton book1, book2;
    String[] roomTypes, roomImages, roomCosts;
    String username, hotelName;

    Hotels(String username) {
        this.username = username;
    }

    public void showHotel1RoomDetails() {
        hotelName = "The Everest Hotel";
        roomTypes = new String[]{"Single_Room", "Double_Room"};
        roomCosts = new String[]{"3000", "5500"}; // Simulated room costs (you can fetch real data)

        roomImages = new String[]{"images/deluxeroom.jpg", "images/deluxeroom.jpg"};
        showRoomDetails(hotelName, roomTypes, roomCosts, roomImages);
    }

    public void showHotel2RoomDetails() {
        hotelName = "Malla Hotel";
        roomTypes = new String[]{"Single_Room", "Double_Room"};
        roomCosts = new String[]{"2500", "4500"}; // Simulated room costs (you can fetch real data)

        roomImages = new String[]{"images/deluxeroom.jpg", "images/deluxeroom.jpg"};

        showRoomDetails(hotelName, roomTypes, roomCosts, roomImages);
    }
    
    public void showHotel3RoomDetails() {
       hotelName = "Bar Peepal Resort";
       roomTypes = new String[]{"Single_Room", "Villa"};
       roomCosts = new String[]{"2500", "8000"}; // Simulated room costs (you can fetch real data)

       roomImages = new String[]{"images/deluxeroom.jpg", "images/deluxeroom.jpg"};

       showRoomDetails(hotelName, roomTypes, roomCosts, roomImages);
    }
     
    public void showHotel4RoomDetails() {
      hotelName = "Pokhara Grande Hotel";
      roomTypes = new String[]{"Single_Room", "Mini_Suite_Room"};
      roomCosts = new String[]{"2500", "6999"}; // Simulated room costs (you can fetch real data)

      roomImages = new String[]{"images/deluxeroom.jpg", "images/deluxeroom.jpg"};

      showRoomDetails(hotelName, roomTypes, roomCosts, roomImages);
    }

    private void showRoomDetails(String hotelName, String[] roomTypes, String[] roomCosts, String[] roomImages) {
        frame = new JFrame(hotelName + " Room Details");
        frame.setSize(650, 650);
        frame.setLayout(null);

        roomDetailsPanel = new JPanel();
        roomDetailsPanel.setBounds(0, 0, 650, 650);
        roomDetailsPanel.setLayout(null);

        book1 = new JButton("Book");
        book1.setPreferredSize(new Dimension(100, 30));
        book1.setBounds(450, 150, 100, 30);
        book1.addActionListener(this);
        roomDetailsPanel.add(book1);

        book2 = new JButton("Book");
        book2.setPreferredSize(new Dimension(100, 30));
        book2.setBounds(450, 450, 100, 30);
        book2.addActionListener(this);
        roomDetailsPanel.add(book2);

        int yPosition = 5;
        for (int i = 0; i < roomTypes.length; i++) {

            JPanel roomPanel = new JPanel();
            roomPanel.setLayout(null);
            roomPanel.setBounds(5, yPosition, 775, 290);
//            roomPanel.setBackground(Color.BLUE);

            JLabel roomTypeLabel = new JLabel(roomTypes[i]);
            roomTypeLabel.setBounds(220, 3, 500, 25);
            roomTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
            roomPanel.add(roomTypeLabel);

            ImageIcon roomImageIcon = new ImageIcon(ClassLoader.getSystemResource(roomImages[i]));
            Image image = roomImageIcon.getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(image);
            JLabel roomImageLabel = new JLabel(scaledImageIcon);
            roomImageLabel.setBounds(10, 30, 400, 300);
            roomPanel.add(roomImageLabel);

            JLabel costLabel = new JLabel("Cost @Rs." + roomCosts[i]);
            costLabel.setFont(new Font("Arial", Font.BOLD, 16));
            costLabel.setBounds(440, 110, 150, 25);
            roomPanel.add(costLabel);

            roomDetailsPanel.add(roomPanel);
            yPosition += 295;
        }

        frame.add(roomDetailsPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {
            Date date = new Date();
            Connec c = new Connec();
            String query1 = "SELECT * FROM Accountdetails WHERE Username ='" + username + "'";
            ResultSet res = c.s.executeQuery(query1);
            if (res.next()) {
                String Username = res.getString("Username");
                String Phone_Number = res.getString("Phone_Number");
                
                if (e.getSource() == book1) {
                    String RoomType = roomTypes[0];
                    String RoomCost = roomCosts[0];
                    CheckAvailability(c,Username, Phone_Number, RoomType, RoomCost, date);
                }
                
                else if (e.getSource() == book2){
                    String RoomType = roomTypes[1];
                    String RoomCost = roomCosts[1];
                    CheckAvailability(c, Username, Phone_Number, RoomType, RoomCost, date);
                }

            }

        } catch (Exception e4) {
            e4.printStackTrace();
        }

    }
    
    private void CheckAvailability(Connec c,String Username, String Phone_Number, String RoomType, String RoomCost,Date date){
        try{
            String query2 = "SELECT Rem_"+RoomType+" FROM Hotels where Hotel_Name='"+hotelName+"'";
            ResultSet result = c.s.executeQuery(query2);
            if(result.next()){
                int remaining = result.getInt("Rem_"+RoomType);
                if (remaining > 0){
                    BookingData(c, Username, Phone_Number, RoomType, RoomCost, date);    
                }
                else if(remaining ==0){
                    JOptionPane.showMessageDialog(null, "Sorry! Room is Not Available", "Booking Not Allowed", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch(Exception e6){
            e6.printStackTrace();
        }
    }

    private void BookingData(Connec c, String Username, String Phone_Number, String RoomType, String RoomCost, Date date) {
        try {
            String query3 = "INSERT INTO HotelRoom_Booking (Username, Phone_Number, Hotel_Name, Room_Type, Room_Cost, Booking_Date) VALUES('" + Username + "','" + Phone_Number + "','" + hotelName + "','" + RoomType + "','" + RoomCost + "','" + date + "' )";
            c.s.executeUpdate(query3);
            String updateQuery = "UPDATE Hotels SET Rem_" + RoomType + " = Rem_" + RoomType + " - 1, Booked_Room = Booked_Room+1, Remaining_Room = Remaining_Room-1 WHERE Hotel_Name = '" + hotelName + "'";
            c.s.executeUpdate(updateQuery);
            JOptionPane.showMessageDialog(null, "Your booking is successful", "Booking Successful", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(false);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        Hotels hotel = new Hotels();
//        hotel.showHotel1RoomDetails();
//      
//    }
}
