import java.awt.*;
import javax.swing.*;
   class report extends JFrame{
		report(){
			setTitle("report");
			setSize(400,200);
			setLocation(100,100);
			JLabel re=new JLabel("Report your problem to:");
			JLabel re1=new JLabel("goflights11@gmail.com");
		        re.setBounds(30,30,200,40);
			re1.setBounds(30,50,200,40);
			setLayout(null);
			
			add(re);
			add(re1);

			setVisible(true);
		}
			
    }	

		