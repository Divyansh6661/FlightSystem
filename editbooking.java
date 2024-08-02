import java.awt.*;
import javax.swing.*;
   class editbooking extends JFrame{
		editbooking(){
			setTitle("Edit Booking Details");
			setSize(1000,800);
			setLocation(100,100);
			
			JLabel titleb=new JLabel("Edit Flight Details");
			JLabel insb=new JLabel("*This detail cannot be changed.");
			JLabel bne=new JLabel("Booking Number*:");
			JLabel dte=new JLabel("Departure Time:");
			JLabel date=new JLabel("Date:");
		        JLabel from=new JLabel("From:");
			JLabel to=new JLabel("To:");
			JLabel type=new JLabel("Gender:");
			JButton submit=new JButton("Submit");
			JTextField bne1=new JTextField();
			JTextField dte1=new JTextField();
			JTextField date1=new JTextField();
			JTextField from1=new JTextField();
			JTextField to1=new JTextField();
		
			String option[]={"Male","Female","Others"};
			JComboBox<String> combo=new JComboBox<>(option);
			combo.setSelectedIndex(0);
			bne.setBounds(60,60,120,30);
			titleb.setBounds(410,10,200,30);
			bne1.setBounds(180,60,150,30);
			dte.setBounds(60,120,120,30);
			dte1.setBounds(180,120,150,30);
			date.setBounds(60,180,120,30);
			date1.setBounds(180,180,150,30);
			from.setBounds(500,60,120,30);
			from1.setBounds(560,60,150,30);
		  	to.setBounds(500,120,120,30);
			to1.setBounds(560,120,150,30);
			type.setBounds(500,180,120,30);
			combo.setBounds(560,180,150,30);
			submit.setBounds(410,270,80,30);
			insb.setBounds(20,320,200,30);
			setLayout(null);
			add(dte);
			add(dte1);
			add(insb);
			add(bne);
			add(bne1);
			add(date);
			add(date1);
  			add(from);
			add(from1);
			add(to);
			add(to1);
			add(type);
			add(combo);
			add(submit);
			
			setVisible(true);
		}
			
		}
