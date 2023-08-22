package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class ViewBookedHotels extends JPanel {

    private JComboBox<String> hotelComboBox;
    private JDateChooser startDateChooser;
    private JDateChooser endDateChooser;
    private JButton showTableButton;
    private JTable dataTable;
    JPanel mainsectionpanel;

    public ViewBookedHotels(JPanel mainsectionpanel) {
        this.mainsectionpanel = mainsectionpanel;
        setLayout(new BorderLayout());

        // Create components
        hotelComboBox = new JComboBox<>(new String[] {"Hotel 1", "Hotel 2"}); // Update with your hotel names
        startDateChooser = new JDateChooser();
        endDateChooser = new JDateChooser();
        showTableButton = new JButton("Show Table");
        dataTable = new JTable();

        showTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                populateTable();
            }
        });

        // Create panel for input components
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Select Hotel:"));
        inputPanel.add(hotelComboBox);
        inputPanel.add(new JLabel("Start Date:"));
        inputPanel.add(startDateChooser);
        inputPanel.add(new JLabel("End Date:"));
        inputPanel.add(endDateChooser);
        inputPanel.add(showTableButton);

        add(inputPanel, BorderLayout.NORTH);
    }

    private void populateTable() {
        java.sql.Date startDate = new java.sql.Date(startDateChooser.getDate().getTime());
        java.sql.Date endDate = new java.sql.Date(endDateChooser.getDate().getTime());

        DefaultTableModel tableModel = new DefaultTableModel();
        dataTable.setModel(tableModel);

        try {
            Connec c = new Connec();
            Connection con = c.getConnection();
            
            String selectedHotel = hotelComboBox.getSelectedItem().toString();
            String query = "SELECT * FROM HotelRoom_Booking WHERE Hotel_Name = ? AND Booking_Date BETWEEN ? AND ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, selectedHotel);
            preparedStatement.setDate(2, startDate);
            preparedStatement.setDate(3, endDate);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Populate the table model with the fetched data
            while (resultSet.next()) {
                String column1Value = resultSet.getString("Hotel_Name");
                String column2Value = resultSet.getString("Username");
                String column3Value = resultSet.getString("Phone_Number");
                String column4Value = resultSet.getString("Room_Type");
                String column5Value = resultSet.getString("Room_Cost");
                String column6Value = resultSet.getString("Booking_Date");
                
               
                tableModel.addRow(new Object[] { column1Value, column2Value, column3Value,column4Value,column5Value,column6Value });
            }
            
            mainsectionpanel.removeAll();
            mainsectionpanel.add(new JScrollPane(dataTable)); // Add the data table to the mainsectionpanel
            mainsectionpanel.revalidate();
            mainsectionpanel.repaint();

            resultSet.close();
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while fetching data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
