import java.awt.*;
import javax.swing.*;
   class addbooking extends JFrame{
		addbooking(){
			setTitle("Add Booking Details");
			setSize(1000,800);
			setLocation(100,100);
			
			JLabel bn=new JLabel("Booking Number:");
			JLabel dt=new JLabel("Departure Time:");
			JLabel date=new JLabel("Date:");
		        JLabel from=new JLabel("From:");
			JLabel to=new JLabel("To:");
			JLabel type=new JLabel("Gender:");
			JButton submit=new JButton("Submit");
			JTextField bn1=new JTextField();
			JTextField dt1=new JTextField();
			JTextField date1=new JTextField();
			JTextField from1=new JTextField();
			JTextField to1=new JTextField();
		
			String option[]={"Male","Female","Others"};
			JComboBox<String> combo=new JComboBox<>(option);
			combo.setSelectedIndex(0);
			bn.setBounds(60,60,120,30);
			bn1.setBounds(180,60,150,30);
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
			
			add(bn);
			add(bn1);
			add(date);
			add(date1);
  			add(from);
			add(from1);
			add(to);
			add(to1);
			add(type);
			add(combo);
			add(submit);
         //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
		}
			public static void main(String ar[]){
				addbooking ab=new addbooking();
			}
		}
