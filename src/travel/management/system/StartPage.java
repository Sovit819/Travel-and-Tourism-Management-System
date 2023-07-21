package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class StartPage extends JFrame implements Runnable {

    Thread thread;

    StartPage() {
        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("images/start.jpeg"));
        Image i1 = i.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
        ImageIcon img = new ImageIcon(i1);
        JLabel image = new JLabel(img);
        add(image);

        setUndecorated(true);
        setVisible(true);

        thread = new Thread(this);
        thread.start();

    }

    public void run() {
        try {
            Thread.sleep(5000);
            setVisible(false);
            new Login().setVisible(true);
        } catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        StartPage frame = new StartPage();

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int frameWidth = 2;
        int frameHeight = 100;

        frame.setSize(frameWidth, frameHeight);
        frame.setLocation((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2);

        for (int i = 0; i <= 500; i += 3) {
            frame.setSize(2 * i, i + 100);
            frame.setLocation((screenWidth - frame.getSize().width) / 2, (screenHeight - frame.getSize().height) / 2);

            try {
                Thread.sleep(3);
            } catch (Exception e) {

            }

        }
    }
}
