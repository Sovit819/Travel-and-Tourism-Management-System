
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener {
     
    JTextField usernamefield,namefield,questionfield,answerfield,passwordfield;
    JButton search,check,back;
    JPanel left;
            
    ForgetPassword(){
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        int framewidth = 780;
        int frameheight =400;
        int screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(framewidth,frameheight);
        setLocation((screenwidth - framewidth)/2, (screenheight - frameheight)/2);
        
        left = new JPanel();
        left.setBounds(5,5,460,353);
        left.setBackground(new Color(222,219,211));
        left.setLayout(null);
        add(left);
        
        JLabel username = new JLabel("Username    :");
        username.setFont(new Font("Arial", Font.BOLD, 16));
        username.setBounds(20,40,120,22);
        left.add(username);
        
        usernamefield = new JTextField();
        usernamefield.setFont(new Font("Arial", Font.PLAIN, 16));
        usernamefield.setBounds(140, 40, 200, 22);
        usernamefield.setBorder(BorderFactory.createEmptyBorder());
        left.add(usernamefield);
        
        search = new JButton("Search");
        search.setForeground(Color.CYAN);
        search.setBackground(Color.BLACK);
        search.setFont(new Font("Arial", Font.BOLD, 16));
        search.setBounds(350,40,100,25);
        search.addActionListener(this);
        left.add(search);
        
        JLabel name = new JLabel("Name           :");
        name.setFont(new Font("Arial", Font.BOLD, 16));
        name.setBounds(20,80,120,22);
        left.add(name);
        
        namefield = new JTextField();
        namefield.setFont(new Font("Arial", Font.PLAIN, 16));
        namefield.setBounds(140, 80, 200, 22);
        namefield.setBorder(BorderFactory.createEmptyBorder());
        left.add(namefield);
        
        JLabel security = new JLabel("Security ");
        security.setFont(new Font("Arial", Font.BOLD, 16));
        security.setBounds(20,120,150,22);
        left.add(security);
        JLabel question = new JLabel("Question     :");
        question.setFont(new Font("Arial", Font.BOLD, 16));
        question.setBounds(20,140,150,22);
        left.add(question);
        
        questionfield = new JTextField();
        questionfield.setFont(new Font("Arial", Font.PLAIN, 16));
        questionfield.setBounds(140, 135, 200, 22);
        questionfield.setBorder(BorderFactory.createEmptyBorder());
        left.add(questionfield);
        
        JLabel answer = new JLabel("Answer        :");
        answer.setFont(new Font("Arial", Font.BOLD, 16));
        answer.setBounds(20,180,120,22);
        left.add(answer);
        
        answerfield = new JTextField();
        answerfield.setFont(new Font("Arial", Font.PLAIN, 16));
        answerfield.setBounds(140, 180, 200, 22);
        answerfield.setBorder(BorderFactory.createEmptyBorder());
        left.add(answerfield);
        
        back = new JButton("Back");
        back.setForeground(Color.CYAN);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Arial", Font.BOLD, 16));
        back.setBounds(140,230,100,25);
        back.addActionListener(this);
        left.add(back);
        
        check = new JButton("Retrieve");
        check.setForeground(Color.CYAN);
        check.setBackground(Color.BLACK);
        check.setFont(new Font("Arial", Font.BOLD, 16));
        check.setBounds(280,230,100,25);
        check.addActionListener(this);
        left.add(check);
        
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/forgotpassword.png"));
        Image i1 = i.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(i1);
        JLabel image = new JLabel(img);
        image.setBounds(490, 70, 200, 200);
        add(image);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent e){
        
        String Username=usernamefield.getText();
        String Answer = answerfield.getText();
        
        if(e.getSource()==search){
            try{
                if(Username.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter Username","Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else{
                    Connec c = new Connec();
                    String query = "SELECT * FROM Accountdetails WHERE Username ='"+Username+"'";
                    ResultSet result = c.s.executeQuery(query);
                    
                    if(result.next()){
                        namefield.setText(result.getString("Name"));
                        questionfield.setText(result.getString("Security_Question"));
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No account is found");
                    }                    
                }
                
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        
        if(e.getSource()==check){
            try{
                if(Answer.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter Username","Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else{
                    Connec c = new Connec();
                    String query = "SELECT * FROM Accountdetails WHERE Answer ='"+Answer+"'";
                    ResultSet result = c.s.executeQuery(query);
                    
                    if(result.next()){
                        JLabel password = new JLabel("Password   :");
                        password.setFont(new Font("Arial", Font.BOLD, 16));
                        password.setBounds(20, 270, 100, 20);
                        left.add(password);
                        
                        passwordfield = new JTextField();
                        passwordfield.setFont(new Font("Arial", Font.PLAIN, 16));
                        passwordfield.setBorder(BorderFactory.createEmptyBorder());
                        passwordfield.setBounds(140, 270, 200, 22);
                        passwordfield.setText(result.getString("Password"));
                        left.add(passwordfield);
                        
                        left.revalidate();
                        left.repaint();
                        if(e.getSource()==back)
                            return;
                        else{
                            Timer returnTimer = new Timer(10000, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    setVisible(false);
                                    new Login().setVisible(true);
                                }
                            });
                            returnTimer.setRepeats(false);
                            returnTimer.start();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No account is found");
                    }                    
                }
                
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        if(e.getSource()==back){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new ForgetPassword();
    }
}
