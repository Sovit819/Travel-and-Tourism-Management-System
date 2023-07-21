package travel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField usernamefield;
    JPasswordField passwordfield;
    JButton signin, signup;
    
    Login(){
        
        setLayout(null);
        
        int screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int framewidth = 800;
        int frameheight = 500;
        setSize(framewidth,frameheight);
        setLocation((screenwidth-framewidth)/2, (screenheight-frameheight)/2);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
                        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(222,219,211));
        p1.setBounds(5,5,350,455);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/test.png"));
        Image i1 = i.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(i1);
        JLabel image = new JLabel(img);
        image.setBounds(50,100,250,200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setBounds(350,5,432,455);
        p2.setBackground(new Color(27,27,30));
        p2.setLayout(null);
        add(p2);
        
        JLabel username = new JLabel("Username :");
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Calibri", Font.BOLD, 18));
        username.setBounds(50,132,100,20);
        p2.add(username);
        
        usernamefield = new JTextField();
        usernamefield.setFont(new Font("Arial", Font.BOLD, 18));
        usernamefield.setBounds(150,130,220,25);
        p2.add(usernamefield);
        
        JLabel password = new JLabel("Password  :");
        password.setForeground(Color.white);
        password.setFont(new Font("Calibri", Font.BOLD, 18));
        password.setBounds(50,177,100,20);
        p2.add(password);
        
        passwordfield = new JPasswordField();
        passwordfield.setFont(new Font("Arial", Font.BOLD, 18));
        passwordfield.setBounds(150,173,220,25);
        p2.add(passwordfield);
        
        signup = new JButton("Sign-up");
        signup.setForeground(Color.BLACK);
        signup.setBackground(new Color(222,219,211));
        signup.setFont(new Font("Arial", Font.BOLD, 16));
        signup.setBounds(50,240,120,30);
        signup.addActionListener(this);
        p2.add(signup);
        
        signin = new JButton("Sign-in");
        signin.setForeground(Color.BLACK);
        signin.setBackground(new Color(222,219,211));
        signin.setFont(new Font("Arial", Font.BOLD, 16));
        signin.setBounds(250,240,120,30);
        signin.addActionListener(this);
        p2.add(signin);
        
        JLabel forgot = new JLabel("<html><u>Forgot Password</u></html>");
        forgot.setFont(new Font("Calibri", Font.BOLD, 16));
        forgot.setForeground(Color.WHITE);
        forgot.setBounds(150,300,150,30);
        forgot.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgot.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent m){
                JLabel sourcelabel = (JLabel)m.getSource();
                sourcelabel.setForeground(Color.RED);
                
                setVisible(false);
                new ForgetPassword().setVisible(true);
            }
        });
        p2.add(forgot);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == signup){
            setVisible(false);
            new SignUp().setVisible(true);
        }
        else if(e.getSource()==signin){
            
            try{
                String Username = usernamefield.getText();
                char pass[] = passwordfield.getPassword();
                String Password = String.valueOf(pass);
                
                if(Username.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter the Username", "Empty Username", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else if(Password.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter password");
                    return;
                }            
                else{
                    Connec c = new Connec();
                    String query = "SELECT * FROM Accountdetails WHERE Username ='"+Username+"' and Password ='"+Password+"'";
                    ResultSet result = c.s.executeQuery(query);

                    if(result.next()){
                        String name;                  
                        setVisible(false);
                        if(Username.equalsIgnoreCase("admin")){
                            name = "Admin";
                            new LoadingPage(name).setVisible(true);
                        }
                        else{
                            name=result.getString("Name");
                            new LoadingPage(name).setVisible(true);                
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect Username or Password", "INVALID",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                
            }catch(Exception e3){
                e3.printStackTrace();
            }
            
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}