import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AdminPage extends JFrame implements ActionListener{
   
    Connection con;
   JLabel adminname=new JLabel("Username");
        JLabel pass=new JLabel("Password");
	TextField t1=new TextField();
	JTextField t2=new JTextField();
	JButton login=new JButton("Login");
   AdminPage(){
	setSize(500,300);
	setLocation(300,300);
	setTitle("Admin Login Page");
	
         adminname.setBounds(100,60,80,30);
		pass.setBounds(100,120,80,30);
		t1.setBounds(200,60,150,30);	
		t2.setBounds(200,120,150,30);
		login.setBounds(150,200,200,40);
		login.addActionListener(this);
	setVisible(true);
	setResizable(false);
	setLayout(null);
	add(adminname);
	add(pass);
	add(login);
	add(t1);
	add(t2);
	  try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1821");



	  }
	  catch(Exception e){
            e.printStackTrace();
	  }
       }

       public void actionPerformed(ActionEvent ae){
       	if (ae.getActionCommand().equals("Login")){
       		 try{Statement st1 = con.createStatement();
                String un = t1.getText();
                String pwd = t2.getText();

                Statement st = con.createStatement();
                String strcmd = "select admin_pass from admin_data where admin_user='" + un + "'";
                ResultSet rs = st1.executeQuery(strcmd);
                rs.next();
                if (rs.getString(1).equals(pwd)) {
                    adminpage2 ap2=new adminpage2();
					dispose();
                } else {
                    Dashb1 b = new Dashb1("Login failed");
                }
             }
             catch(Exception e){
             	System.out.println(e);
             }


       	}
       }

     
 }
	
         
	