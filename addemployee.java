import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class addemployee extends JFrame implements ActionListener {
    JLabel en = new JLabel("Employee Name:");
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
    String s1, s2, s3, s4, s5, s6, strcmd;
    Connection con = null;

    addemployee() {
        setTitle("Add Employee Details");
        setSize(1000, 800);
        setLocation(100, 100);

        en.setBounds(60, 60, 120, 30);
        en1.setBounds(180, 60, 150, 30);
        id.setBounds(60, 120, 120, 30);
        id1.setBounds(180, 120, 150, 30);
        age.setBounds(60, 180, 120, 30);
        age1.setBounds(180, 180, 150, 30);
        post.setBounds(500, 60, 120, 30);
        post1.setBounds(620, 60, 150, 30); // Adjusted the position
        year.setBounds(500, 120, 120, 30);
        year1.setBounds(620, 120, 150, 30);
        type.setBounds(500, 180, 120, 30);
        ra1.setBounds(620, 180, 80, 30); // Adjusted the position
        ra2.setBounds(720, 180, 80, 30); // Adjusted the position
        submit.setBounds(410, 270, 80, 30);

        bg.add(ra1);
        bg.add(ra2);

        setLayout(null);
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
            s1 = id1.getText();
            s2 = en1.getText();
            s3 = age1.getText();
            s4 = post1.getText();
            s6 = year1.getText();

            try {
                Statement st = con.createStatement();
              strcmd = "INSERT INTO employee_data(id_no, name, post, year_of_join, age, gender) VALUES (seq.NEXTVAL, '"+s2+"', '"+s4+"', '"+s6+"', '"+s3+"', '"+s5+"')";

                int ch = st.executeUpdate(strcmd);
                if (ch != 0) {
                    JOptionPane.showMessageDialog(this, "Employee Created");
                } else {
                    JOptionPane.showMessageDialog(this, "Employee Not Created");
                }
            } catch (Exception ee) {
                System.out.println(ee);
            }
        }
    }

    
    
}
