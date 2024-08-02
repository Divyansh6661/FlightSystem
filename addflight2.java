import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class addflight2 extends JFrame implements ActionListener {
    JTextField fn1, dt1, from1, to1, phn1, date1;
    JButton submit;
    String s1, s2, s3, s4, s6, s7, s8, strcmd;
    Connection con;

    addflight2(String str3, String str4) {
        setTitle("Add Flight Details");
        setSize(1000, 800);
        setResizable(false);
        setLocation(100, 100);
        setVisible(true);

        JLabel fn = new JLabel("Flight Number:");
        JLabel dt = new JLabel("Name");
        JLabel phn=new JLabel("Phone Number:");
        JLabel from = new JLabel("From:");
        JLabel to = new JLabel("To");
        JLabel type = new JLabel("Type:");

        submit = new JButton("Submit");
        fn1 = new JTextField();
        dt1 = new JTextField();
        phn1 = new JTextField();
        from1 = new JTextField(str3);
        to1 = new JTextField(str4);
        date1 = new JTextField();

        fn.setBounds(60, 60, 120, 30);
        fn1.setBounds(180, 60, 150, 30);
        dt.setBounds(60, 120, 120, 30);
        dt1.setBounds(180, 120, 150, 30);
        phn.setBounds(60,180,150,30);
        phn1.setBounds(180, 180, 150, 30);

        from.setBounds(500, 60, 120, 30);
        from1.setBounds(560, 60, 150, 30);
        to.setBounds(500, 120, 120, 30);
        to1.setBounds(560, 120, 150, 30);
        type.setBounds(500, 180, 120, 30);
        submit.setBounds(410, 270, 80, 30);
        date1.setBounds(560, 180, 150, 30);

        submit.addActionListener(this);
        setLayout(null);
        add(dt);
        add(dt1);
        add(fn);
        
        add(phn);
        add(fn1);
        add(from);
        add(from1);
        add(to);
        add(to1);
        add(type);
        add(phn1);
        add(submit);
        add(date1);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1821");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Submit")) {
            s1 = fn1.getText();
            s2 = dt1.getText();
            s3 = from1.getText();
            s4 = to1.getText();
            s6 = phn1.getText();
            s7 = date1.getText();

            try {
                Statement st = con.createStatement();
                strcmd = "INSERT INTO booking_data (booking_no, flight_no, name, fr, t, time, dt) VALUES (sqn.NEXTVAL, '" + s1 + "', '" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s6 + "', '" + s7 + "')";
                int ch = st.executeUpdate(strcmd);
                if (ch != 0) {
                    new Dashb1("Flight booked");
                    setVisible(false);
                } else {
                    new Dashb1("Flight not booked");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    
}
