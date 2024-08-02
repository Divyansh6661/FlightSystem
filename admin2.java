import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class group implements MouseListener, ActionListener {
    private JFrame f1;
    private JLabel l1, l2, l3, l4, l5, l6, l7, bgl1, logolabel1;
    private JButton bt1;
    private JCheckBox ck1;
    private ImageIcon img, iconlogo;
    private JTextField t1;
    private JPasswordField t2;
    private Connection con;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            group app = new group();
            app.input();
        });
    }

    group() {
        f1 = new JFrame("Login Page");
        l1 = new JLabel("Username");
        l2 = new JLabel("Password");
        l3 = new JLabel("Forgot Password?");
        l4 = new JLabel("CREATE ACCOUNT");
        l5 = new JLabel("NEED HELP?");
        l6 = new JLabel("Admin Login");
        l7 = new JLabel("Register");
        ck1 = new JCheckBox("Remember me");
        bt1 = new JButton("GET STARTED");
        t1 = new JTextField("Username");
        t2 = new JPasswordField("Password");

        f1.setLayout(null);

        img = new ImageIcon("ar10.jpg");
        Image img2 = img.getImage();
        Image temp_img2 = img2.getScaledInstance(1750, 1000, Image.SCALE_SMOOTH);
        img = new ImageIcon(temp_img2);

        bgl1 = new JLabel(img);
        bgl1.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        iconlogo = new ImageIcon("icon.jpg");
        logolabel1 = new JLabel();
        logolabel1.setIcon(iconlogo);
        logolabel1.setBounds(530, 230, iconlogo.getIconWidth(), iconlogo.getIconHeight());
    }

    void input() {
        l1.setBounds(540, 300, 100, 40);
        l2.setBounds(540, 360, 100, 40);
        t1.setBounds(630, 300, 300, 40);
        t2.setBounds(630, 360, 300, 40);
        bt1.setBounds(630, 420, 300, 40);
        bt1.setFocusable(false);
        bt1.addActionListener(this);

        ck1.setBounds(630, 480, 150, 30);
        l3.setBounds(825, 480, 180, 30);
        l3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        l3.addMouseListener(this);
        l4.setBounds(630, 520, 150, 40);
        l4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l4.addMouseListener(this);
        l5.setBounds(860, 520, 180, 40);
        l5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l5.addMouseListener(this);
        l6.setBounds(1310, 30, 80, 40);
        l6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l6.addMouseListener(this);
        l7.setBounds(1400, 30, 80, 40);
        l7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l7.addMouseListener(this);
        t1.addMouseListener(this);
        t2.addMouseListener(this);
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.RED);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);
        l6.setForeground(Color.WHITE);
        l7.setForeground(Color.WHITE);
        ck1.setForeground(Color.WHITE);

        l1.setFont(new Font("ARIAL", Font.BOLD, 15));
        l2.setFont(new Font("ARIAL", Font.BOLD, 15));
        l3.setFont(new Font("ARIAL", Font.BOLD, 12));
        ck1.setOpaque(false);
        ck1.setFocusable(false);
        bt1.setBackground(Color.RED);

        f1.add(l1);
        f1.add(l2);
        f1.add(l3);
        f1.add(l4);
        f1.add(l5);
        f1.add(l6);
        f1.add(l7);
        f1.add(t1);
        f1.add(t2);
        f1.add(bt1);
        f1.add(ck1);
        f1.add(bgl1);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setExtendedState(JFrame.MAXIMIZED_BOTH);

        f1.setSize(1350, 1000);
        f1.setVisible(true);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "1821");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mouseClicked(MouseEvent ae) {
        if (ae.getSource() == l3)
            forgotPassword();
        else if (ae.getSource() == l4 || ae.getSource() == l7)
            createAccount();
        else if (ae.getSource() == l5)
            needHelp();
        else if (ae.getSource() == l6)
            adminLogin();
        else if (ae.getSource() == t1)
            t1.setText("");
        else if (ae.getSource() == t2)
            t2.setText("");
    }

    private void forgotPassword() {
       Dashb1 bb=new Dashb1("CURRENT THIS SERVICE IS UNAVAILABLE");
    }

    private void createAccount() {
        Account1 ac = new Account1();
    }

    private void needHelp() {
        needhelp nn=new needhelp();
    }

    private void adminLogin() {
        AdminPage ap = new AdminPage();
    }

    public void mousePressed(MouseEvent ae) {
    }

    public void mouseReleased(MouseEvent ae) {
    }

    public void mouseEntered(MouseEvent ae) {
    }

    public void mouseExited(MouseEvent ae) {
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("GET STARTED")) {
            try {
                Statement st1 = con.createStatement();
                String un = t1.getText();
                String pwd = t2.getText();

                Statement st = con.createStatement();
                String strcmd = "select Password from user_data where user_name='" + un + "'";
                ResultSet rs = st1.executeQuery(strcmd);
                rs.next();
                if (rs.getString(1).equals(pwd)) {
                    Homepage hp=new Homepage();
                } else {
                    Dashb1 b = new Dashb1("Login failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
