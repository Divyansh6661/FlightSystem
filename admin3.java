import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.*;

class group2 implements MouseListener,ActionListener
{	
	JFrame f1; 
	JLabel l1,l2,l3,l4,l5,l6,l7,bgl1,logolabel1;
	JPanel login;
	JButton bt1;
	JCheckBox ck1;
	ImageIcon img,iconlogo;
	JTextField t1,t2;
	//JPasswordField t2;
	public static void main(String ar[])
	{
		group2 app = new group2();
		app.Input();
	}

	group2()
	{	
		
		f1 = new JFrame("Login Page");
		l1 = new JLabel("Username");
		l2 = new JLabel("Password");
		l3 = new JLabel("Forgot Password?");
		l4 = new JLabel("CREATE ACCOUNT");
		l5 = new JLabel("NEED HELP?");
		l6 = new JLabel("Admin Login");
		l7 = new JLabel("Register");
		ck1 = new JCheckBox("Remember me");
		bt1 = new JButton("GET STARTED");	
		t1 = new JTextField("Username");
		//t1.setEditable(false);
		//t2 = new JPasswordField("Password");
		t2 = new JTextField("Password");		
		f1.setLayout(null);
		
		img = new ImageIcon("ar10.jpg");
		Image img2 = img.getImage();
		Image temp_img2 = img2.getScaledInstance(1400,1000,Image.SCALE_SMOOTH);
		img = new ImageIcon(temp_img2);
		
		bgl1 = new JLabel(img);
		//bgl1 = new JLabel("",img,JLabel.CENTER);
		bgl1.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		iconlogo = new ImageIcon("icon.jpg");
		logolabel1 = new JLabel();
		logolabel1.setIcon(iconlogo);
		logolabel1.setBounds(530, 230,iconlogo.getIconWidth(),iconlogo.getIconHeight());
		
	
		
	}
	void Input()
	{
		l1.setBounds(440,300,100,40);
		l2.setBounds(440,360,100,40);
		t1.setBounds(530,300,300,40);
			
		t2.setBounds(530,360,300,40);
		
		bt1.setBounds(530,420,300,40);
		bt1.setFocusable(false);
		bt1.addActionListener(this);
		
		ck1.setBounds(530,480,150,30);
		l3.setBounds(725,480,180,30);
		l3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		l3.addMouseListener(this);
		l4.setBounds(530,520,150,40);
		l4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l4.addMouseListener(this);
		l5.setBounds(760,520,180,40);
		l5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l5.addMouseListener(this);
		l6.setBounds(1110,30,80,40);
		l6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l6.addMouseListener(this);
		l7.setBounds(1200,30,80,40);
		l7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l7.addMouseListener(this);
		t1.addMouseListener(this);
		t2.addMouseListener(this);
		l1.setForeground(Color.white);
		l2.setForeground(Color.white);
		l3.setForeground(Color.blue);
		l4.setForeground(Color.white);
		l5.setForeground(Color.white);
		l6.setForeground(Color.white);
		l7.setForeground(Color.white);
		ck1.setForeground(Color.white);
		
		l1.setFont(new Font("ARIAL",Font.BOLD,15));
		l2.setFont(new Font("ARIAL",Font.BOLD,15));
		l3.setFont(new Font("ARIAL",Font.BOLD,12));
		ck1.setOpaque(false);
		ck1.setFocusable(false);
		bt1.setBackground(Color.BLUE);
		login = new JPanel();
		login.setSize(400,350);
		login.setBackground(Color.YELLOW);
		login.setBounds(500,175,400,350);
		
		
		f1.add(l1);
		f1.add(l2);
		f1.add(l3);
		f1.add(l4);
		f1.add(l5);
		f1.add(l6);
		f1.add(l7);
		f1.add(t1);
		f1.add(t2);
		f1.add(bt1);
		f1.add(ck1);
		f1.add(bgl1);
		f1.add(login);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setSize(1350,1000);
		f1.setVisible(true);
	}
	public void mouseClicked(MouseEvent ae)
	{
		if(ae.getSource()==l3)
		ForgotPassword();
		
		else if(ae.getSource()==l4 || ae.getSource()==l7)
		CreateAccount();
		
		else if(ae.getSource()==l5)
		NeedHelp();
		
		else if(ae.getSource()==l6)
		AdminLogin();
	
		else if(ae.getSource()==t1)
		{
		t1.setEditable(true);
		t1.setText("");
		}
		else if(ae.getSource()==t2)
		t2.setText("");
	}
	private void ForgotPassword()
	{
		JFrame pass = new JFrame();
		pass.setSize(400,400);
		pass.setLocationRelativeTo(null);
		pass.setVisible(true);
	}
	private void CreateAccount()
	{
		JFrame account = new JFrame();
		JButton bta1 = new JButton("CREATE");
		JLabel la1 = new JLabel("First Name");
		JLabel la2 = new JLabel("Last Name");
		JLabel la3 = new JLabel("Phone Number");
		JLabel la4 = new JLabel("Age");
		JLabel la5 = new JLabel("Gender");
		JLabel la6 = new JLabel("Username");
		JLabel la7 = new JLabel("Email");
		JLabel la8 = new JLabel("Password");
		JLabel la9 = new JLabel("Confirm Password");
		
		JTextField ta1 = new JTextField();
		JTextField ta2 = new JTextField();
		JTextField ta3 = new JTextField();
		JTextField ta4 = new JTextField();
		JTextField ta6 = new JTextField();
		JTextField ta7 = new JTextField();
		JTextField ta8 = new JTextField();
		JTextField ta9 = new JTextField();

		JRadioButton ra1 = new JRadioButton("Male");
		JRadioButton ra2 = new JRadioButton("Female");
		ButtonGroup bg = new ButtonGroup();
		bg.add(ra1);
		bg.add(ra2);
	//	JScrollPane scrollPane = new JScrollPane();
	//	JPanel contentpanel = new JPanel();
    	//	contentpanel.setLayout(null);
		account.setLayout(null);
	
		la1.setBounds(480,30,100,20);
		ta1.setBounds(480,60,110,35);
		la2.setBounds(610,30,100,20);
		ta2.setBounds(610,60,110,35);	
		la3.setBounds(480,115,100,20);
		ta3.setBounds(480,145,240,35);
		la4.setBounds(480,200,100,20);
		ta4.setBounds(480,230,50,35);
		la5.setBounds(570,200,50,20);
		ra1.setBounds(570,230,50,35);
		ra2.setBounds(670,230,50,35);
		la6.setBounds(480,285,240,20);
		ta6.setBounds(480,315,240,35);
		la7.setBounds(480,370,240,20);
		ta7.setBounds(480,400,240,35);
		la8.setBounds(480,455,240,20);
		ta8.setBounds(480,485,240,35);
		la9.setBounds(480,540,240,20);
		ta9.setBounds(480,570,240,35);
		
	
		account.add(la1);
		account.add(la2);
		account.add(la3);
		account.add(la4);
		account.add(la5);
		account.add(la6);
		account.add(la7);
		account.add(la8);
		account.add(la9);
		account.add(ta1);
		account.add(ta2);
		account.add(ta3);
		account.add(ta4);
		account.add(ta6);
		account.add(ta7);
		account.add(ta8);
		account.add(ta9);
		account.add(ra1);
		account.add(ra2);      
	//	scrollPane.setViewportView(contentpanel);
	//	account.add(scrollPane);		
		account.setSize(1350,1000);
		account.setLocationRelativeTo(null);
		account.setVisible(true);
		
	}
	private void NeedHelp()
	{
		JFrame help = new JFrame();
		
		help.setSize(400,400);
		help.setLocationRelativeTo(null);
		help.setVisible(true);
	}
	private void AdminLogin()
	{
		JFrame admin = new JFrame();
		admin.setSize(400,400);
		admin.setLocationRelativeTo(null);
		admin.setVisible(true);
	}
	public void mousePressed(MouseEvent ae) {}
        public void mouseReleased(MouseEvent ae) {}
        public void mouseEntered(MouseEvent ae) {}
	public void mouseExited(MouseEvent ae)
	{
		
	}

	public void actionPerformed(ActionEvent ae)
	{
		JFrame start = new JFrame();
		start.setSize(1200,700);
		start.setVisible(true); 
	}		
}