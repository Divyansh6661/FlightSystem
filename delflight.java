import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
   class delflight extends JFrame implements ActionListener{
          String s1,strcmd;
          
          Connection con;

   	JLabel fnn=new JLabel("Flight Number:");
			JTextField fnn1=new JTextField();
    		 delflight(){
			setSize(500,300);
			setTitle("Delete Flight Details");
			
			
			JButton delf=new JButton("Delete");
			delf.addActionListener(this);
			setLayout(null);
			fnn.setBounds(100,80,120,30);
			fnn1.setBounds(230,80,150,30);
			delf.setBounds(160,150,80,30);
			add(fnn);
			add(fnn1);
			add(delf);
			
         setVisible(true);
         try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1821");



	  }
	  catch(Exception e){

	  }

			}

			public void actionPerformed(ActionEvent ae){
       	if(ae.getActionCommand().equals("Delete")){
       		s1=fnn1.getText();
       		 try{

        	     Statement st = con.createStatement();
                strcmd = "Delete from flight_data where flight_no='"+s1+"'";

                int ch = st.executeUpdate(strcmd);
                if (ch != 0) {
                    JOptionPane.showMessageDialog(this, "flight Detail deleted successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "flight Detail not deleted");
                }
                }
             
             catch(Exception e){
             	System.out.println(e);
             }


       	}}
		
     }