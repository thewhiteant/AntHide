import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Design_Login {
        void Design()  {
            int h = 800;
            int w = 1000;
            JFrame frame = new JFrame();
            frame.setSize(w,h);

            ImageIcon img = new ImageIcon("LoginBack.png");
            JLabel picLabel = new JLabel("",img,JLabel.CENTER);
            picLabel.setBounds(0,0,w,h);
            frame.add(picLabel);

            JTextField t1  =new JTextField("Welcome to Javatpoint.");
            t1.setBounds(50,100, 200,30);
            JTextField t2  = new JTextField("AWT Tutorial");
            t2.setBounds(50,150, 200,30);

            frame.add(t1);
            frame.add(t2);





            //Funtionality
            frame.setResizable(false);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
}
