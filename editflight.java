import javax.print.DocFlavor.STRING;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
   class editflight extends JFrame implements ActionListener {
	Connection con;
	JLabel title=new JLabel("Edit Flight Details");
			JLabel ins=new JLabel("*This detail cannot be changed.");
			JLabel fne=new JLabel("Flight Number *:");
			JLabel dte=new JLabel("Departure Time:");
			JLabel datee=new JLabel("Date:");
		        JLabel frome=new JLabel("From:");
			JLabel toe=new JLabel("To;");
			JLabel type=new JLabel("Type:");
			JButton submit=new JButton("Submit");
			JButton search=new JButton("Search");
			JTextField fne1=new JTextField();
			JTextField dte1=new JTextField();
			JTextField datee1=new JTextField();
			JTextField frome1=new JTextField();
			JTextField toe1=new JTextField();
		editflight(){
			setTitle("Edit Flight Details");
			setSize(1000,800);
			setLocation(100,100);
			
			
			String option[]={"International","Domestic"};
			JComboBox<String> combo=new JComboBox<>(option);
			combo.setSelectedIndex(0);
			fne.setBounds(60,60,120,30);
			title.setBounds(410,10,200,30);
			fne1.setBounds(180,60,150,30);
			dte.setBounds(60,120,120,30);
			dte1.setBounds(180,120,150,30);
			datee.setBounds(60,180,120,30);
			datee1.setBounds(180,180,150,30);
			frome.setBounds(500,60,120,30);
			frome1.setBounds(560,60,150,30);
		  	toe.setBounds(500,120,120,30);
			toe1.setBounds(560,120,150,30);
			type.setBounds(500,180,120,30);
			combo.setBounds(560,180,150,30);
			search.setBounds(330,270,80,30);
			search.addActionListener(this);
			submit.setBounds(470,270,80,30);
			submit.addActionListener(this);

			ins.setBounds(20,320,200,30);
			setLayout(null);
			add(dte);
			add(ins);
			add(title);
			add(dte1);
			add(fne);
			add(fne1);
			add(datee);
			add(datee1);
  			add(frome);
			add(frome1);
			add(toe);
			add(toe1);
			add(type);
			add(combo);
			add(search);
			add(submit);
			
         setVisible(true);
		 try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "1821");
        } catch (Exception e) {
            e.printStackTrace();
        }

		}
		public void actionPerformed(ActionEvent ae) {
			
			if (ae.getActionCommand().equals("Search")) {
				try {
					Statement st1 = con.createStatement();
					String num = fne1.getText();
					Statement st = con.createStatement();
					String strcmd = "select * from flight_data where FLIGHT_NO='" + num + "'";
					ResultSet rs = st1.executeQuery(strcmd);
					while(rs.next())
					{
					    int  column1 = rs.getInt(1);
                      String column2 = rs.getString(2);
					  String column3 = rs.getString(3);
					  String column4 = rs.getString(4);
					  String column5 = rs.getString(5);
					  String column6 = rs.getString(6);
					  dte1.setText(column5);
                      datee1.setText(column4);
					  frome1.setText(column2);
					  toe1.setText(column3);
				    } 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(ae.getActionCommand().equals("Submit"))
			try {
					Statement st2 = con.createStatement();
					String num = fne1.getText();
					String ufr= frome1.getText();
				    String uto = toe1.getText();
					String udate = datee1.getText();
					String udt = dte1.getText();
					int ch=st2.executeUpdate("UPDATE FLIGHT_DATA set FR='"+ufr+"',DESTI='"+uto+"',DT= '"+udate+"',DEPARTURE_TIME='"+udt+"' where FLIGHT_NO='"+ num +"'");
                    if (ch!=0){
						Dashb1 d=new Dashb1("FLIGHT DATA MODIFIED");
                              }
                    else{
						Dashb1 d=new Dashb1("UNABLE TO MODIFY");
                        } 

			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
			
		}
