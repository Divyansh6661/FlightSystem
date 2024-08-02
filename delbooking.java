import java.awt.*;
import javax.swing.*;
   class delbooking extends JFrame{
    		 delbooking(){
			setSize(500,300);
			setTitle("Delete Booking Details");
			
			JLabel bnn=new JLabel("Booking Number:");
			JTextField bnn1=new JTextField();
			JButton delb=new JButton("Delete");
			setLayout(null);
			bnn.setBounds(100,80,120,30);
			bnn1.setBounds(230,80,150,30);
			delb.setBounds(160,150,80,30);
			add(bnn);
			add(bnn1);
			add(delb);

			setVisible(true);
			}
		
     }