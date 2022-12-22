import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class Design_signup{


    Connection c;
    private JFrame frame;
    private JLabel picLabel;
    private  JTextField usr;
    private  JPasswordField pass;
    void Design()  {
        int h = 600;
        int w = 800;
        frame = new JFrame();
        frame.setSize(w,h);
        frame.setTitle("AntHide Signup");
        Image icon = Toolkit.getDefaultToolkit().getImage("sources/icon.png");
        frame.setIconImage(icon);
        ImageIcon img = new ImageIcon("sources/LoginBack.png");
        picLabel = new JLabel("",img,JLabel.CENTER);
        picLabel.setBounds(0,0,w,h);
        usr  =new JTextField();
        usr.setBounds(400,270, 200, 30);
        usr.setBackground(new Color(230,233,237));
        usr.setFont(new Font(Font.SERIF,Font.BOLD,18));
        pass  = new JPasswordField();
        pass.setBackground(new Color(230,233,237));
        pass.setBounds(400,330, 200,30);
        picLabel.add(usr);
        picLabel.add(pass);
        JButton loginbtn = new JButton("SignUp");
        loginbtn.setBounds(220,400,170,30);
        loginbtn.setBackground(new Color(230,233,237));
        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Username = usr.getText();
                String Password = pass.getText();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    c = DriverManager.getConnection("jdbc:mysql://localhost/anthide","root", "");

                    PreparedStatement stmt = c.prepareStatement("INSERT INTO logins (id, username, password) VALUES (NULL,'"+Username+"','"+Password+"')");
                    stmt.executeUpdate();


                } catch (Exception ex){
                    System.out.println(ex);
                }
//
//                frame.dispose();
//                new Design_Login().Design();

                pass.setText("");
            }
        });
        picLabel.add(loginbtn);
        JButton sgnup = new JButton("Already Exists!");
        sgnup.setBackground(new Color(230,233,237));
        sgnup.setBounds(220,440,170,30);
        sgnup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Design_Login().Design();
            }
        });
        picLabel.add(sgnup);
        frame.add(picLabel);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
