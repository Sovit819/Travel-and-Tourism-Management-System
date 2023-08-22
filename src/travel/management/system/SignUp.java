
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignUp extends JFrame implements ActionListener{
    
    JTextField namefield, usernamefield, addressfield, phonefield, answerfield;
    JButton create, back, suggest;
    JPasswordField passwordfield; 
    Choice questions;
    SignUp(){
        
        setLayout(null);
        
        int screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int framewidth = 900;
        int frameheight = 500;
        setSize(framewidth, frameheight);
        setLocation((screenwidth-framewidth)/2, (screenheight-frameheight)/2);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel decorateleft = new JPanel();
        decorateleft.setLayout(null);
        decorateleft.setBackground(new Color(221,195,165));
        decorateleft.setBounds(0,0,550,500);
        add(decorateleft);
        
        JPanel decorateright = new JPanel();
        decorateright.setLayout(null);
        decorateright.setBackground(new Color(165,191,221));
        decorateright.setBounds(550, 4, 332,455);
        add(decorateright);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/adduser.png"));
        Image i1 = i.getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(i1);
        JLabel image = new JLabel(img);
        image.setBounds(70,100,200,200);
        decorateright.add(image);
        
        JLabel name = new JLabel("Name          :");
        name.setFont(new Font("Arial", Font.BOLD, 16));
        name.setBounds(50,50,100,22);
        decorateleft.add(name);
        
        namefield = new JTextField();
        namefield.setFont(new Font("Arial", Font.PLAIN, 16));
        namefield.setBounds(180, 50, 300, 22);
        namefield.setBorder(BorderFactory.createEmptyBorder());
        decorateleft.add(namefield);
        
        JLabel username = new JLabel("Username   :");
        username.setFont(new Font("Arial", Font.BOLD, 16));
        username.setBounds(50,85,100,22);
        decorateleft.add(username);
        
        usernamefield = new JTextField();
        usernamefield.setFont(new Font("Arial", Font.PLAIN, 16));
        usernamefield.setBounds(180,85,250,22);
        usernamefield.setBorder(BorderFactory.createEmptyBorder());
        decorateleft.add(usernamefield);
        
        suggest = new JButton("Suggest");
        suggest.setFont(new Font("Arial", Font.BOLD, 16));
        suggest.setBackground(Color.BLACK);
        suggest.setForeground(Color.CYAN);
        suggest.setBounds(440,83,100,25);
        decorateleft.add(suggest);
         
        JLabel password = new JLabel("Password   :");
        password.setFont(new Font("Arial", Font.BOLD, 16));
        password.setBounds(50, 120, 100, 22);
        decorateleft.add(password);
        
        passwordfield = new JPasswordField();
        passwordfield.setFont(new Font("",Font.BOLD, 16));
        passwordfield.setBounds(180,120,300,22);
        passwordfield.setBorder(BorderFactory.createEmptyBorder());
        decorateleft.add(passwordfield);
        
        JLabel address = new JLabel("Address     :");
        address.setFont(new Font("Arial", Font.BOLD, 16));
        address.setBounds(50, 155, 100, 22);
        decorateleft.add(address);
                
        addressfield = new JTextField();
        addressfield.setFont(new Font("Arial", Font.PLAIN, 16));
        addressfield.setBounds(180,155,300,22);
        addressfield.setBorder(BorderFactory.createEmptyBorder());
        decorateleft.add(addressfield);
        
        JLabel phone = new JLabel("Phone No   :");
        phone.setFont(new Font("Arial", Font.BOLD, 16));
        phone.setBounds(50,190,110,22);
        decorateleft.add(phone);
        
        phonefield = new JTextField();
        phonefield.setFont(new Font("Arial", Font.PLAIN, 16));
        phonefield.setBounds(180,190,300,22);
        phonefield.setBorder(BorderFactory.createEmptyBorder());
        decorateleft.add(phonefield);
        
        JLabel security = new JLabel("Security");
        security.setFont(new Font("Arial", Font.BOLD, 16));
        security.setBounds(50,225,100,22);
        decorateleft.add(security);
        JLabel ques = new JLabel("Question    :");
        ques.setFont(new Font("Arial", Font.BOLD, 16));
        ques.setBounds(50,245,100,22);
        decorateleft.add(ques);
        
        questions = new Choice();
        questions.add("What is your pet name?");
        questions.add("Iron man or Thor");
        questions.add("Favourite athelet");
        questions.add("Birthplace");
        questions.setBounds(180, 245, 300, 25);
        questions.setFont(new Font("Arial", Font.PLAIN, 16));
        decorateleft.add(questions);
        
        JLabel answer = new JLabel("Answer       :");
        answer.setFont(new Font("Arial", Font.BOLD, 16));
        answer.setBounds(50,280, 100,22);
        decorateleft.add(answer);
        
        answerfield = new JTextField();
        answerfield.setFont(new Font("Arial", Font.PLAIN, 16));
        answerfield.setBounds(180,280,300,22);
        answerfield.setBorder(BorderFactory.createEmptyBorder());
        decorateleft.add(answerfield);
        
        create = new JButton("Create");
        create.setBackground(new Color(165,191,221));
        create.setForeground(Color.BLACK);
        create.setFont(new Font("Arial", Font.BOLD, 16));
        create.setBounds(375, 350, 100, 30);
        create.addActionListener(this);
        decorateleft.add(create);
        
        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBackground(new Color(165,191,221));
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.setBounds(200,350,100,30);
        back.addActionListener(this);
        decorateleft.add(back);
        
//        setUndecorated(true);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == back){
            setVisible(false);
            new Login().setVisible(true);
        }
        
        if(e.getSource() == create){
            String Name = namefield.getText();              
            String Username = usernamefield.getText();
            char [] pass = passwordfield.getPassword();
            String Password = String.valueOf(pass);
            String Address =addressfield.getText();
            String Phone_Number = phonefield.getText();
            String Security_Question = questions.getSelectedItem();
            String Answer = answerfield.getText();
            
           
            try{
                if(Name.isBlank()){
                    JOptionPane.showMessageDialog(null, "Please enter name");
                    return;  
                }if(Username.isBlank()){
                    JOptionPane.showMessageDialog(null, "Username cannot be empty");
                    return;
                }if(Password.length()<6){
                    JOptionPane.showMessageDialog(null, "Password should be more than 6 characters", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }if(Answer.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter the answer for Security question");
                    return;
                }
                Connec c = new Connec();
                String query = "SELECT * FROM Accountdetails WHERE Username ='"+Username+"'";
                ResultSet result = c.s.executeQuery(query);

                    if(result.next()){
                       JOptionPane.showMessageDialog(null, "Username already exits", "Invalid Username", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        String query1 = "INSERT INTO Accountdetails values('"+Name+"', '"+Username+"', '"+Password+"', '"+Address+"', '"+Phone_Number+"', '"+Security_Question+"', '"+Answer+"')";
                        c.s.executeUpdate(query1);

                        JOptionPane.showMessageDialog(null, "Account is created successfully");
                        setVisible(false);
                        new Login().setVisible(true);
                    }
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args){
        new SignUp();
    }
    
}
