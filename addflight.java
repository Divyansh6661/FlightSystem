import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
   class addflight extends JFrame implements ActionListener{
	     Connection con;
		 JLabel fn=new JLabel("Flight Number:");
			JLabel dt=new JLabel("Departure Time:");
			JLabel date=new JLabel("Date:");
		        JLabel from=new JLabel("From:");
			JLabel to=new JLabel("To;");
			JLabel type=new JLabel("Type:");
			JButton submit=new JButton("Submit");
			JTextField fn1=new JTextField();
			JTextField dt1=new JTextField();
			JTextField date1=new JTextField();
			JTextField from1=new JTextField();
			JTextField to1=new JTextField();
		addflight(){
			setTitle("Add Flight Details");
			setSize(1000,500);
			setLocation(100,100);
			
			
			String option[]={"International","Domestic"};
			JComboBox<String> combo=new JComboBox<>(option);
			combo.setSelectedIndex(0);
			fn.setBounds(60,60,120,30);
			fn1.setBounds(180,60,150,30);
			dt.setBounds(60,120,120,30);
			dt1.setBounds(180,120,150,30);
			date.setBounds(60,180,120,30);
			date1.setBounds(180,180,150,30);
			from.setBounds(500,60,120,30);
			from1.setBounds(560,60,150,30);
		  	to.setBounds(500,120,120,30);
			to1.setBounds(560,120,150,30);
			type.setBounds(500,180,120,30);
			combo.setBounds(560,180,150,30);
			submit.setBounds(410,270,80,30);
			setLayout(null);
			add(dt);
			add(dt1);
			add(fn);
			add(fn1);
			add(date);
			add(date1);
  			add(from);
			add(from1);
			add(to);
			add(to1);
			add(type);
			add(combo);
			add(submit);
			submit.addActionListener(this);
			setVisible(true);
			 try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1821");
        }
	  catch(Exception e){
            e.printStackTrace();
	  }
		}
		
	public void actionPerformed(ActionEvent ae){
       	if (ae.getActionCommand().equals("Submit")){
       		 try{Statement st1 = con.createStatement();
                String fl = fn1.getText();
                String ds = dt1.getText();
				String da = date1.getText();
				String fr = from1.getText();
				String too = to1.getText();
                Statement st = con.createStatement();
                String strcmd = "INSERT INTO FLIGHT_DATA(FLIGHT_NO,FR,DESTI,DT,DEPARTURE_TIME,BOOK) VALUES ('"+fl+"','"+fr+"','"+too+"','"+da+"','"+ds+"','BOOK')";
                int ch = st.executeUpdate(strcmd);
                    if(ch!=0){
                        Dashb1 d=new Dashb1("FLIGHT ADDED");
                        
                        
                    } 
                    else{
                        Dashb1 d=new Dashb1("ERROR OCCURS");
                        
                        
                    }
             }
             catch(Exception e){
             	System.out.println(e);
             }


       	}
       }		
}
