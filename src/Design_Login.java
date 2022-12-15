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
            JTextField usr = new JTextField();
            frame.add(usr);
//            JTextField pass = new JTextField();
//            usr.setPreferredSize(new Dimension(250,40));





//            frame.add(pass);
            //Funtionality
            frame.setResizable(false);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
}
