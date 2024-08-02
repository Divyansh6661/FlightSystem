import java.awt.*;
import javax.swing.*;
   class deladmin extends JFrame{
    		 deladmin(){
			setSize(500,300);
			setTitle("Admin Delete");
			setVisible(true);
			JLabel adn=new JLabel("Admin's Username:");
			JTextField adn1=new JTextField();
			JButton delad=new JButton("Delete");
			setLayout(null);
			adn.setBounds(100,80,120,30);
			adn1.setBounds(230,80,150,30);
			delad.setBounds(160,150,80,30);
			add(adn);
			add(adn1);
			add(delad);
			}
		public static void main(String ar[]){
			new deladmin();
			}
     }