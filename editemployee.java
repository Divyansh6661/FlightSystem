import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class editemployee extends JFrame implements ActionListener {
    JLabel en = new JLabel("Employee Name:");
    JLabel l1 = new JLabel("ENTER EMPLOYEE ID:");
    JTextField t1 = new JTextField();

    JLabel id = new JLabel("Employee ID:");
    JLabel age = new JLabel("Age:");
    JLabel post = new JLabel("Post:");
    JLabel year = new JLabel("Year of joining:");
    JLabel type = new JLabel("Gender:");
    JButton submit = new JButton("Submit");
    JTextField en1 = new JTextField();
    JTextField id1 = new JTextField();
    JTextField age1 = new JTextField();
    JTextField post1 = new JTextField();
    JTextField year1 = new JTextField();
    JRadioButton ra1 = new JRadioButton("Male");
    JRadioButton ra2 = new JRadioButton("Female");
    ButtonGroup bg = new ButtonGroup();
    String s1, s2, s3, s4, s5, s6, strcmd, s7;
    Connection con = null;

    editemployee() {
        setTitle("Edit Employee Details");
        setSize(1000, 800);
        setLocation(100, 100);

        l1.setBounds(140, 60, 120, 30);
        t1.setBounds(280, 60, 120, 30);
        en.setBounds(60, 110, 120, 30);
        en1.setBounds(180, 110, 150, 30);
        id.setBounds(60, 150, 120, 30);
        id1.setBounds(180, 150, 150, 30);
        age.setBounds(60, 190, 120, 30);
        age1.setBounds(180, 190, 150, 30);
        post.setBounds(500, 110, 120, 30);
        post1.setBounds(620, 110, 150, 30); 
        year.setBounds(500, 150, 120, 30);
        year1.setBounds(620, 150, 150, 30);
        type.setBounds(500, 190, 120, 30);
        ra1.setBounds(620, 190, 80, 30); 
        ra2.setBounds(720, 190, 80, 30); 
        submit.setBounds(410, 290, 80, 30);

        bg.add(ra1);
        bg.add(ra2);

        setLayout(null);
        add(l1);
        add(t1);
        add(id);
        add(id1);
        add(en);
        add(en1);
        add(age);
        add(age1);
        add(post);
        add(post1);
        add(year);
        add(year1);
        add(type);
        add(submit);
        add(ra1);
        add(ra2);
        submit.addActionListener(this);

        setVisible(true);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1821");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ra1.isSelected()) {
            s5 = "Male";
        } else {
            s5 = "Female";
        }

        if (ae.getActionCommand().equals("Submit")) {
            s7 = t1.getText();
            s1 = id1.getText();
            s2 = en1.getText();
            s3 = age1.getText();
            s4 = post1.getText();
            s6 = year1.getText();

            try {
                Statement st = con.createStatement();
                strcmd = "UPDATE employee_data SET name = '" + s2 + "', age = '" + s3 + "', post = '" + s4 + "', year_of_join = '" + s6 + "', gender = '" + s5 + "' WHERE NAME = '" + s7 + "'";

                int ch = st.executeUpdate(strcmd);
                if (ch != 0) {
                    JOptionPane.showMessageDialog(this, "Employee Detail updated successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Employee Detail not updated");
                }
            } catch (Exception ee) {
                System.out.println(ee);
            }
        }
    }

}
