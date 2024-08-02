import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

class Homepage extends JFrame implements ActionListener,MouseListener
{
	JLabel bgl1;
	JButton bt1;
	JTextField t1, t2 ,t3, t4, t5, t6,t7,t8;
	JRadioButton b1,b2,b3;
	ImageIcon img;
	String s1,s2,s3;
	
	public static void main(String ar[])
	{
		SwingUtilities.invokeLater(() -> new Homepage());
	}
	
	Homepage()
	{
		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;

		/* l1 = new JLabel("📍 From");
		l2 = new JLabel("📍 To");
		l3 = new JLabel("📆 Depart");
		l4 = new JLabel("📆 Return"); */
		l5 = new JLabel("FIND CHEAP TICKETS - SAVE BIG!");
		l6 = new JLabel("Adults");
		l7 = new JLabel("Seniors");
		l8 = new JLabel("Children");
		l9 = new JLabel("Class");
		
	
		JComboBox<String> c1 = new JComboBox<>();
		JComboBox<String> c2 = new JComboBox<>();
		JComboBox<String> c3 = new JComboBox<>();
		JComboBox<String> c4 = new JComboBox<>();
		
		
		
		t1 = new JTextField("📍 From");
		t1.setCaretColor(Color.WHITE);
		//t1.setBackground(Color.GRAY);
		//t1.setFont(new Font("Consolas", Font.PLAIN, 12));
		t2 = new JTextField("📍 To");
		t2.setCaretColor(Color.WHITE);
		t3 = new JTextField("📆 Depart");
		t3.setCaretColor(Color.WHITE);
		t4 = new JTextField("📆 Return");
		t4.setCaretColor(Color.WHITE);
		t5 = new JTextField("Enter a city or airport");
		t6= new JTextField("Enter a city or airport");
		
		t7 = new JTextField("Pick a date");
		t8 = new JTextField("Pick a date");
		t5.addMouseListener(this);	
		t6.addMouseListener(this);
		t7.addMouseListener(this);
		t8.addMouseListener(this);
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		
		
		
		b1 = new JRadioButton("Round Trip");
		b2 = new JRadioButton("One Way");
		b3 = new JRadioButton("Multiple Cities");
		b1.setFocusable(false);	
		b2.setFocusable(false);
		b3.setFocusable(false);
		b1.setOpaque(false);
		b2.setOpaque(false);
		b3.setOpaque(false);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		
		JPanel p1,p2,p3;

		p1 = new JPanel();
		p1.setLayout(null);


		img = new ImageIcon("back.jpg");
		Image img2 = img.getImage();
		Image temp_img2 = img2.getScaledInstance(1750,1000,Image.SCALE_SMOOTH);
		img = new ImageIcon(temp_img2);

		bgl1 = new JLabel(img);
		bgl1.setBounds(0,0,img.getIconWidth(),img.getIconHeight());

		bt1 = new JButton("SEARCH");
		bt1.setBackground(Color.red);
		bt1.setFocusable(false);
		bt1.addActionListener(this);
		setLayout(null);
		l5.setBounds(160,90,200,70);
		b1.setBounds(80,150,100,40);
		b2.setBounds(210,150,100,40);
		b3.setBounds(330,150,120,40);		
		t1.setBounds(70,200,70,40);	
		t2.setBounds(70,270,70,40);
		t3.setBounds(70,340,70,40);
		t4.setBounds(280,340,70,40);
		t5.setBounds(140,200,320,40);
		t6.setBounds(140,270,320,40);
		t7.setBounds(140,340,110,40);
		t8.setBounds(350,340,110,40);
		l6.setBounds(70,400,60,30);
		c1.setBounds(70,430,90,40);
		l7.setBounds(170,400,60,30);
		c2.setBounds(170,430,90,40);
		l8.setBounds(270,400,60,30);
		c3.setBounds(270,430,90,40);
		l9.setBounds(370,400,90,30);
		c4.setBounds(370,430,90,40);
		bt1.setBounds(180,510,200,40);
		//p1.setBounds(30,50,500,600);
		//p1.setBackground(new Color(0, 0, 139));
		
		
		
		
		c1.addItem("1");
		c1.addItem("2");
		c1.addItem("3");
		c1.addItem("4");
		c1.addItem("5");
		c1.addItem("6");
		c1.addItem("7");
		c1.addItem("8");
		c1.addItem("9");
		c2.addItem("1");
		c2.addItem("2");
		c2.addItem("3");
		c2.addItem("4");
		c2.addItem("5");
		c2.addItem("6");
		c2.addItem("7");
		c2.addItem("8");
		c2.addItem("9");
		c3.addItem("1");
		c3.addItem("2");
		c3.addItem("3");
		c3.addItem("4");
		c3.addItem("5");
		c3.addItem("6");
		c3.addItem("7");
		c3.addItem("8");
		c3.addItem("9");
		c4.addItem("1");
		c4.addItem("2");
		c4.addItem("3");
		c4.addItem("4");
		c4.addItem("5");
		c4.addItem("6");
		c4.addItem("7");
		c4.addItem("8");
		c4.addItem("9");
		
		add(l5);
		add(b1);
		add(b2);
		add(b3);
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		add(t6);
		add(t7);
		add(t8);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(c1);
		add(c2);
		add(c3);
		add(c4);
		add(bt1);
		add(bgl1);
		//add(p1);
		
		
		setSize(1355,1000);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	

		public void mouseClicked(MouseEvent ae)
		{
			if(ae.getSource()==t5 && t5.getText().equals("Enter a city or airport"))
			t5.setText("");
			
			else if(ae.getSource()==t6 && t6.getText().equals("Enter a city or airport"))
			t6.setText("");
		
			else if(ae.getSource()==t7 && t7.getText().equals("Pick a date"))
			t7.setText("");
			
			else if(ae.getSource()==t8 &&t8.getText().equals("Pick a date"))
			t8.setText("");
			
		}

		public void mousePressed(MouseEvent ae) {}
        	public void mouseReleased(MouseEvent ae) {}
       		public void mouseEntered(MouseEvent ae) {}
		public void mouseExited(MouseEvent ae){}
	
		
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==bt1)
			{	 

			   s1=t5.getText();
			   s2=t6.getText();
				 if (isValidFlightDetails() && isRadioButtonSelected())
				{    

					flighttable frame = new flighttable(s1,s2);
					 frame.setVisible(true);
				}


				else
				{
					 JOptionPane.showMessageDialog(null, "Please fill in all flight details.", "Missing Details", JOptionPane.WARNING_MESSAGE);
				}
			}
		}	
		
		
	private boolean isValidFlightDetails() {
    		return !t5.getText().equals("Enter a city or airport") && !t6.getText().equals("Enter a city or airport") &&
           	!t7.getText().equals("Pick a date") && !t8.getText().equals("Pick a date") ;
	}
	private boolean isRadioButtonSelected() {
    	return b1.isSelected() || b2.isSelected() || b3.isSelected();
	}
		

}





/*class ConfirmedFrame extends JFrame
{
	ConfirmedFrame()
 {
        setTitle("Confirmation");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Dispose the frame when closed
        setLocationRelativeTo(null); // Center the frame on the screen

        JLabel confirmationLabel = new JLabel("Booking confirmed!");
        confirmationLabel.setHorizontalAlignment(JLabel.CENTER);
        confirmationLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        add(confirmationLabel);

        setVisible(true);
    
}
}
*/
