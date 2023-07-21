
package travel.management.system;
import java.awt.*;
import javax.swing.*;

public class LoadingPage extends JFrame implements Runnable{
    
    Thread thread;
    JProgressBar loading;
    String name;
    
    public void run(){
        try{
            for(int i=1; i<=101; i++){
                int maximum = loading.getMaximum();
                int value = loading.getValue();
                
                if(value < maximum)
                    loading.setValue(value+1);
                else{
                    setVisible(false);
                    if(name.equalsIgnoreCase("Admin"))
                        new Admin().setVisible(true);
                    else
                        new Dashboard().setVisible(true);
                }
                Thread.sleep(30);
            }
            
        }catch(Exception e2){
            e2.printStackTrace();
        }
    }
    
    LoadingPage(String name){
        
        thread = new Thread(this);
        this.name = name;
        
        setLayout(null);
        int framewidth=750;
        int frameheight=500;
        int screenwidth=Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenheight=Toolkit.getDefaultToolkit().getScreenSize().height;
        setSize(framewidth,frameheight);
        setLocation((screenwidth-framewidth)/2, (screenheight-frameheight)/2);
        
        JLabel text = new JLabel("BUTWAL TRAVEL & TOURISM");
        text.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 44));
        text.setBounds(0, 0, 750, 180);
        text.setHorizontalAlignment(JLabel.CENTER);
        add(text);
        
        JLabel text2 = new JLabel("WELCOMES YOU");
        text2.setFont(new Font("Lucida Handwriting", Font.PLAIN, 22));
        text2.setBounds(0, 0, 750, 290);
        text2.setHorizontalAlignment(JLabel.CENTER);
        add(text2);
        
        JLabel text3 = new JLabel(name);
        text3.setFont(new Font("Lucida Calligraphy", Font.BOLD,32));
        text3.setBounds(0, 0, 750 ,420);
        text3.setHorizontalAlignment(JLabel.CENTER);
        add(text3);
                
        loading = new JProgressBar();
        int barlength = 350;
        loading.setBounds((framewidth-barlength)/2, 250, 350, 30);
        loading.setStringPainted(true);
        add(loading);
        
        JLabel waiting = new JLabel("Loading....... ");
        waiting.setFont(new Font("Arial", Font.BOLD,20));
        waiting.setBounds(420, 290, 200, 25);
        add(waiting);
        
        getContentPane().setBackground(new Color(205,210,215));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        thread.start();
    }
    public static void main(String[] args){
        new LoadingPage("");
    }
}
