import javax.swing.*;
import java.awt.*;

public  class Design_Main {
    private JFrame frame;
    private JLabel picLabel;
    private  JTextField usr;
    private  JPasswordField pass;
    void Design() {
        int h = 680;
        int w = 800;
        frame = new JFrame();
        frame.setSize(w, h);
        frame.setTitle("AntHide Login");
        Image icon = Toolkit.getDefaultToolkit().getImage("sources/icon.png");
        frame.setIconImage(icon);
        ImageIcon img = new ImageIcon("sources/MainBG.png");
        picLabel = new JLabel(img);
        picLabel.setBounds(0, 0, w, h);




        //Panel Section
            JLabel l1,l2,l3,l4,l5;

            l1 = new JLabel("Facebook");
            l1.setFont(new Font());
            l1.setBounds(0,0,0,0);
            l2 = new JLabel("Instragram");
            l3 = new JLabel("Gmail");
            l4 = new JLabel("Twitter");
            l5 = new JLabel("Any");

            picLabel.add(l1);
            picLabel.add(l2);
            picLabel.add(l3);
            picLabel.add(l4);
            picLabel.add(l5);











        frame.add(picLabel);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }

}