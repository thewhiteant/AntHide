import com.mysql.jdbc.CommunicationsException;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;


public  class Design_Main {



    private JFrame frame;
    private  JTextField usr;
    private  JPasswordField pass;
    private String fbook = "" ,instra = "",mails = "" ,twet = "",link1 = "",link2 = "";


    String DeepEncrpt(String key){
        if(key.isEmpty()) return  "";
        Functionalities Fn = new Functionalities();
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;

        for (int i = 0;i<randomNum;i++){
            key = Fn.en(key);
        }
        return  key;
    }

    int Design(String uname) {
        Functionalities Fn = new Functionalities();


        //Data Load
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/anthide","root", "");
            String quary = "SELECT * FROM logins WHERE username = '"+ Fn.en(uname)+"'";
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(quary);
            while (rs.next()){
                fbook = rs.getString("fb"); //Encrypted ones
                instra = rs.getString("ins");
                mails = rs.getString("mail");
                twet = rs.getString("twt");
                link1 = rs.getString("lnk1");
                link2 = rs.getString("lnk2");
            }


        } catch (CommunicationsException ex){
            System.out.println("oooo mere bhai db chaira lo to");
        }
        catch (Exception exx){
            System.out.println(exx);
        }


        int h = 640;
        int w = 800;
        frame = new JFrame();
        frame.setSize(w, h);
        frame.setTitle("AntHide Login");
        Image icon = Toolkit.getDefaultToolkit().getImage("sources/icon.png");
        frame.setIconImage(icon);
        ImageIcon img = new ImageIcon("sources/MainBG.png");
        JLabel picLabel = new JLabel(img);
        picLabel.setBounds(0, -20, w, h);



        JLabel unam = new JLabel(uname);
        unam.setBounds(570,-67,200,200);
        unam.setFont(new Font(Font.MONOSPACED,Font.BOLD,18));
        picLabel.add(unam);



        JButton logiout = new JButton("LOGOUT");
//        logiout.setEnabled(false
        logiout.setBounds(670,40,100,20);
        logiout.setBackground(new Color(230,233,237));
        logiout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Design_Login().Design();
            }
        });

        picLabel.add(logiout);


//        Panel Section
           JTextField l1,l2,l3,l4,l5,l6;


            l1 = new JTextField(DeepEncrpt(fbook));
            l1.setBounds(170,116,370,40);
            l1.setBorder(BorderFactory.createCompoundBorder(l1.getBorder(),BorderFactory.createEmptyBorder(5,15, 5, 15)));
            l1.setEditable(false);
            JButton l1btn = new JButton("Copy");
            l1btn.setBackground(new Color(230,233,237));
            l1btn.setBounds(550,116,100,40);

            l1btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    if(l1.getText().isEmpty()){
                        JOptionPane.showMessageDialog(frame,"Empty");
                    }else {
                        //Stack Overflow Copied From this section
                        StringSelection stringSelection = new StringSelection(Fn.dec(fbook));
                        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                        clpbrd.setContents(stringSelection, null);
                        JOptionPane.showMessageDialog(frame,"Copied!");
                    }
                }
            });

            picLabel.add(l1btn);
            picLabel.add(l1);



            JButton edtbtn1 = new JButton("Edit");
            edtbtn1.setBackground(new Color(230,233,237));
            edtbtn1.setBounds(660,116,100,40);
            picLabel.add(edtbtn1);
            edtbtn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new Editor_Window().Main(fbook,uname,"fb");
                }
            });









        l2 = new JTextField(DeepEncrpt(instra));
        l2.setBounds(170,194,370,40);
        l2.setBorder(BorderFactory.createCompoundBorder(l2.getBorder(),BorderFactory.createEmptyBorder(5,15, 5, 15)));
        l2.setEditable(false);
        JButton l2btn = new JButton("Copy");
        l2btn.setBackground(new Color(230,233,237));
        l2btn.setBounds(550,194,100,40);
        l2btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(l2.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame,"Empty");
                }else {
                    //Stack Overflow Copied From this section
                    StringSelection stringSelection = new StringSelection(Fn.dec(instra));
                    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clpbrd.setContents(stringSelection, null);
                    JOptionPane.showMessageDialog(frame,"Copied!");

                }
            }
        });

        picLabel.add(l2btn);
        picLabel.add(l2);
        JButton edtbtn2 = new JButton("Edit");
        edtbtn2.setBackground(new Color(230,233,237));
        edtbtn2.setBounds(660,194,100,40);
        edtbtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Editor_Window().Main(instra,uname,"ins");
            }
        });
        picLabel.add(edtbtn2);





        l3 = new JTextField(DeepEncrpt(mails));
        l3.setBounds(170,268,370,40);
        l3.setBorder(BorderFactory.createCompoundBorder(l3.getBorder(),BorderFactory.createEmptyBorder(5,15, 5, 15)));
        l3.setEditable(false);
        JButton l3btn = new JButton("Copy");
        l3btn.setBackground(new Color(230,233,237));
        l3btn.setBounds(550,268,100,40);
        l3btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(l3.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame,"Empty");
                }else {
                    //Stack Overflow Copied From this section
                    StringSelection stringSelection = new StringSelection(Fn.dec(mails));
                    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clpbrd.setContents(stringSelection, null);
                    JOptionPane.showMessageDialog(frame,"Copied!");

                }
            }
        });
        picLabel.add(l3btn);
        picLabel.add(l3);
        JButton edtbtn3 = new JButton("Edit");
        edtbtn3.setBackground(new Color(230,233,237));
        edtbtn3.setBounds(660,268,100,40);
        edtbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Editor_Window().Main(mails,uname,"mail");
            }
        });
        picLabel.add(edtbtn3);





        l4 = new JTextField(DeepEncrpt(twet));
        l4.setBounds(170,340,370,40);
        l4.setBorder(BorderFactory.createCompoundBorder(l4.getBorder(),BorderFactory.createEmptyBorder(5,15, 5, 15)));
        l4.setEditable(false);
        JButton l4btn = new JButton("Copy");
        l4btn.setBackground(new Color(230,233,237));
        l4btn.setBounds(550,340,100,40);
        l4btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(l4.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame,"Empty");
                }else {
                    //Stack Overflow Copied From this section
                    StringSelection stringSelection = new StringSelection(Fn.dec(twet));
                    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clpbrd.setContents(stringSelection, null);
                    JOptionPane.showMessageDialog(frame,"Copied!");

                }
            }
        });
        picLabel.add(l4btn);
        picLabel.add(l4);
        JButton edtbtn4 = new JButton("Edit");
        edtbtn4.setBackground(new Color(230,233,237));
        edtbtn4.setBounds(660,340,100,40);
        edtbtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Editor_Window().Main(twet,uname,"twt");


            }
        });
        picLabel.add(edtbtn4);



        l5 = new JTextField(DeepEncrpt(link1));
        l5.setBounds(170,415,370,40);
        l5.setBorder(BorderFactory.createCompoundBorder(l5.getBorder(),BorderFactory.createEmptyBorder(5,15, 5, 15)));
        l5.setEditable(false);
        JButton l5btn = new JButton("Copy");
        l5btn.setBackground(new Color(230,233,237));
        l5btn.setBounds(550,415,100,40);
        l5btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(l5.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame,"Empty");
                }else {
                    //Stack Overflow Copied From this section
                    StringSelection stringSelection = new StringSelection(Fn.dec(link1));
                    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clpbrd.setContents(stringSelection, null);
                    JOptionPane.showMessageDialog(frame,"Copied!");

                }
            }
        });
        picLabel.add(l5btn);
        picLabel.add(l5);

        JButton edtbtn5 = new JButton("Edit");
        edtbtn5.setBackground(new Color(230,233,237));
        edtbtn5.setBounds(660,415,100,40);
        edtbtn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Editor_Window().Main(link1,uname,"lnk1");
            }
        });
        picLabel.add(edtbtn5);



        l6 = new JTextField(DeepEncrpt(link2));
        l6.setBounds(170,460,370,40);
        l6.setBorder(BorderFactory.createCompoundBorder(l6.getBorder(),BorderFactory.createEmptyBorder(5,15, 5, 15)));
        l6.setEditable(false);
        JButton l6btn = new JButton("Copy");
        l6btn.setBackground(new Color(230,233,237));
        l6btn.setBounds(550,460,100,40);
        l6btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(l6.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame,"Empty");
                }else {
                    //Stack Overflow Copied From this section
                    StringSelection stringSelection = new StringSelection(Fn.dec(link2));
                    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clpbrd.setContents(stringSelection, null);
                    JOptionPane.showMessageDialog(frame,"Copied!");

                }
            }
        });
        picLabel.add(l6btn);
        picLabel.add(l6);

        JButton edtbtn6 = new JButton("Edit");
        edtbtn6.setBackground(new Color(230,233,237));
        edtbtn6.setBounds(660,460,100,40);
        edtbtn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Editor_Window().Main(link2,uname,"lnk2");
            }
        });
        picLabel.add(edtbtn6);
        frame.add(picLabel);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

        return h;
    }

}