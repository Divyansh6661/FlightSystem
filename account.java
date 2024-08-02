import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Account1 implements MouseListener, ActionListener {
    JFrame account = new JFrame();
    JButton bta1 = new JButton("CREATE");
    JLabel la1 = new JLabel("CREATE ACCOUNT");
    JLabel la5 = new JLabel("GENDER");
    JTextField ta1 = new JTextField("First Name");
    JTextField ta2 = new JTextField("Last Name");
    JTextField ta3 = new JTextField("Phone Number");
    JTextField ta4 = new JTextField();
    JTextField ta6 = new JTextField("Username");
    JTextField ta7 = new JTextField("Email");
    JTextField ta8 = new JTextField("Password");
    JTextField ta9 = new JTextField("Confirm Password");
    JRadioButton ra1 = new JRadioButton("Male");
    JRadioButton ra2 = new JRadioButton("Female");
    JRadioButton ra3 = new JRadioButton("Others");
    ButtonGroup bg = new ButtonGroup();
    String s1, s2, s3, s4, s5, s7, s6, s8, s9, strcmd, strname;
    Connection con = null;

    Account1() {
        bg.add(ra1);
        bg.add(ra2);
        bg.add(ra3);

        account.setLayout(null);

        la1.setBounds(160, 30, 150, 20);
        ta1.setBounds(50, 65, 150, 35);
        ta1.addMouseListener(this);
        ta2.setBounds(220, 65, 150, 35);
        ta2.addMouseListener(this);

        ta3.setBounds(50, 115, 320, 35);
        ta3.addMouseListener(this);
        ta4.setBounds(590, 230, 50, 35);
        ta4.addMouseListener(this);
        la5.setBounds(50, 160, 80, 20);
        ra1.setBounds(50, 180, 80, 35);
        ra2.setBounds(140, 180, 80, 35);
        ra3.setBounds(245, 180, 80, 35);
        ta6.setBounds(50, 225, 320, 35);
        ta6.addMouseListener(this);
        ta7.setBounds(50, 270, 320, 35);
        ta7.addMouseListener(this);
        ta8.setBounds(50, 315, 320, 35);
        ta8.addMouseListener(this);
        ta9.setBounds(50, 360, 320, 35);
        ta9.addMouseListener(this);
        bta1.setBounds(130, 410, 170, 40);
        bta1.addActionListener(this);

        account.add(la1);
        account.add(la5);
        account.add(ta1);
        account.add(ta2);
        account.add(ta3);
        account.add(ta4);
        account.add(ta6);
        account.add(ta7);
        account.add(ta8);
        account.add(ta9);
        account.add(ra1);
        account.add(ra2);
        account.add(ra3);
        account.add(bta1);
        account.setSize(432, 600);
        account.setLocationRelativeTo(null);
        account.setResizable(false);
        account.setVisible(true);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1821");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void mouseClicked(MouseEvent mee) {
        if (mee.getSource() == ta1)
            ta1.setText("");
        else if (mee.getSource() == ta2)
            ta2.setText("");
        else if (mee.getSource() == ta3)
            ta3.setText("");
        else if (mee.getSource() == ta4)
            ta4.setText("");
        else if (mee.getSource() == ta6)
            ta6.setText("");
        else if (mee.getSource() == ta7)
            ta7.setText("");
        else if (mee.getSource() == ta8)
            ta8.setText("");
        else if (mee.getSource() == ta9)
            ta9.setText("");
    }

    public void mousePressed(MouseEvent mee) {
    }

    public void mouseReleased(MouseEvent mee) {
    }

    public void mouseEntered(MouseEvent mee) {
    }

    public void mouseExited(MouseEvent mee) {
    }

    public void actionPerformed(ActionEvent ae) {
   /* if ((ta1.getText().equals("")) || (ta2.getText().equals("")) || (ta3.getText().equals("")) || (ta4.getText().equals("")) || (ta6.getText().equals("")) || (ta7.getText().equals("")) || (ta8.getText().equals("")) || (ta9.getText().equals(""))) {
            
        } else {}*/
            if (ra1.isSelected()) {
                s5 = "Male";
            } else if (ra2.isSelected()) {
                s5 = "Female";
            } else {
                s5 = "Others";
            }
              

            if (ae.getActionCommand().equals("CREATE")) { 
                s1 = ta1.getText();
                s2 = ta2.getText();
                s3 = ta3.getText();
                s4 = ta4.getText();

                s6 = ta6.getText();
                s7 = ta7.getText();
                s8 = ta8.getText();
                strname = s1 + " " + s2;

                try {
                    Statement st = con.createStatement();
                    strcmd = "INSERT INTO user_data (id_no, name, phone_number, gender, user_name, email, password) VALUES (seq.NEXTVAL, '" + strname + "','" + s3 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                    int ch = st.executeUpdate(strcmd);
                    if(ch!=0){
                        Dashb1 d=new Dashb1("Account Created");
                        account.setVisible(false);
                        
                    } 
                    else{
                        Dashb1 d=new Dashb1("Account Not Created");
                        account.setVisible(false);
                        
                    }
                } catch (Exception ee) {
                    System.out.println(ee);
                }
            }
        }
    }
