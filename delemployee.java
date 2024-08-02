import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
   class delemployee extends JFrame implements ActionListener{
   	String s1,strcmd;
   	JTextField idl1=new JTextField();
      Connection con;
   	JButton delid=new JButton("Delete");
    		 delemployee(){
			setSize(500,300);
			setTitle("Delete Employee Details");
			
			JLabel idl=new JLabel("Employee Name:");
			
			
			delid.addActionListener(this);

			setLayout(null);
			idl.setBounds(100,80,120,30);
			idl1.setBounds(230,80,150,30);
			delid.setBounds(160,150,80,30);
			add(idl);
			add(idl1);
			add(delid);

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
       		s1=idl1.getText();



        try{

        	     Statement st = con.createStatement();
                strcmd = "Delete from employee_data where name='"+s1+"'";

                int ch = st.executeUpdate(strcmd);
                if (ch != 0) {
                    JOptionPane.showMessageDialog(this, "Employee Detail deleted successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Employee Detail not deleted");
                }
                }
             
             catch(Exception e){
             	System.out.println(e);
             }
          }
       }
}
      
 


    