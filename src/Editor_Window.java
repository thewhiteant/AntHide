import com.mysql.jdbc.CommunicationsException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Editor_Window {
    private JFrame frame;

    void  Main(String oldone,String usrername,String data){
        int h = 240;
        int w = 430;
        frame = new JFrame();
        frame.setSize(w, h);
        frame.setTitle("Editor Window");
        Image icon = Toolkit.getDefaultToolkit().getImage("sources/icon.png");
        frame.setIconImage(icon);

        ImageIcon img = new ImageIcon("sources/editWindow.png");
        JLabel picLabel = new JLabel(img, JLabel.LEFT);
        picLabel.setBounds(0, -19, w, h);

        JTextField passw = new JTextField(oldone);
        passw.setBorder(BorderFactory.createCompoundBorder(passw.getBorder(),BorderFactory.createEmptyBorder(0,15, 0, 15)));
        passw.setBounds(130,90,250,25);

        JButton lbtn = new JButton("Add");
        lbtn.setBackground(new Color(230,233,237));
        lbtn.setBounds(130,130,100,35);
        lbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passwordforCng = passw.getText();
                if(oldone !=passwordforCng) {
                    try {
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection c = DriverManager.getConnection("jdbc:mysql://localhost/anthide","root", "");
                       PreparedStatement stmt = c.prepareStatement("UPDATE logins SET "+data+" = '"+ passwordforCng +"' WHERE logins . username = '" + usrername + "'");
                       stmt.executeUpdate();


                    } catch (CommunicationsException ex){
                        System.out.println("oooo mere bhai db chaira lo to");
                    }
                    catch (Exception exx){
                        System.out.println(exx);
                    }
                }

                frame.dispose();
                new Design_Main().Design(usrername);
            }
        });


        JButton delbtn = new JButton("Delete");
        delbtn.setBackground(new Color(230,233,237));
        delbtn.setBounds(260,130,100,35);
        delbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection c = DriverManager.getConnection("jdbc:mysql://localhost/anthide","root", "");
                    PreparedStatement stmt = c.prepareStatement("UPDATE logins SET "+data+" = '' WHERE logins . username = '" + usrername + "'");
                    stmt.executeUpdate();

                } catch (CommunicationsException ex){
                    System.out.println("oooo mere bhai db chaira lo to");
                }
                catch (Exception exx){
                    System.out.println(exx);
                }
                frame.dispose();
                new Design_Main().Design(usrername);
            }
        });


        picLabel.add(passw);
        picLabel.add(lbtn);
        picLabel.add(delbtn);

        frame.add(picLabel);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
