import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
public class Design_signup{

//DB Connection Part

    //Probel_face: Connection Problem For Connector;
//TODO: Download mysqlconnector and place to module
    Connection c;
    private JFrame frame;
    private JLabel picLabel;
    private  JTextField usr;
    private  JPasswordField pass;

    void Design()  {
        int h = 800;
        int w = 1000;
        frame = new JFrame();
        frame.setSize(w,h);
        frame.setTitle("AntHide Signup");
        Image icon = Toolkit.getDefaultToolkit().getImage("sources/icon.png");
        frame.setIconImage(icon);
        ImageIcon img = new ImageIcon("sources/LoginBack.png");
        picLabel = new JLabel("",img,JLabel.CENTER);
        picLabel.setBounds(0,0,w,h);
        usr  =new JTextField();
        usr.setBounds(500,360, 300,40);
        usr.setBackground(new Color(230,233,237));
        usr.setFont(new Font(Font.SERIF,Font.BOLD,18));
        pass  = new JPasswordField();
        pass.setBackground(new Color(230,233,237));
        pass.setBounds(500,441, 300,40);
        picLabel.add(usr);
        picLabel.add(pass);
        JButton loginbtn = new JButton("SignUp");
        loginbtn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        loginbtn.setBounds(280,560,200,40);
        loginbtn.setBackground(new Color(230,233,237));
        loginbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Username = usr.getText();
                String Password = pass.getText();
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    c = DriverManager.getConnection("jdbc:mysql://localhost/anthide","root", "");
                    String quary = "";
                    Statement st = c.createStatement();
                    ResultSet rs = st.executeQuery(quary);
                    if(rs.next()){
                        JOptionPane.showMessageDialog(frame,"Welcome sir");
                    }
                    else {
                        JOptionPane.showMessageDialog(frame,"Wrong Credential");
                    }

                } catch (Exception ex){
                    System.out.println(ex);
                }

                pass.setText("");
            }
        });

        picLabel.add(loginbtn);
        JButton sgnup = new JButton("Already Exist");
        sgnup.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
        sgnup.setBackground(new Color(230,233,237));
        sgnup.setBounds(280,620,200,40);
        picLabel.add(sgnup);
        frame.add(picLabel);
        //W
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
