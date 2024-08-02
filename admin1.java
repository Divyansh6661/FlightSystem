import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FlightSystem extends JFrame implements ActionListener {
    FlightSystem() {
        setSize(1366, 565);
        setLocation(100, 100);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Added for closing the window properly
        setVisible(true);
        ImageIcon il = new ImageIcon("ar4.jpg");
        Image i2 = il.getImage().getScaledInstance(1366, 565, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        JLabel name = new JLabel("AIRLINE RESERVATION SYSTEM");
        JLabel name2 = new JLabel("WELCOME TO");
        JButton next = new JButton("Next>>");
        next.setFocusable(false);
        setTitle("GO FLIGHT");

        name.setBounds(20, 450, 1000, 100);
        next.addActionListener(this);
        name2.setBounds(85, 420, 1000, 100);
        setLayout(null);
        next.setBounds(1150, 450, 150, 50);
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        name.setFont(new Font("Serif", Font.BOLD, 25));
        name2.setFont(new Font("Serif", Font.BOLD, 25));
        img.add(next);
        img.add(name);
        img.add(name2);
        add(img);
        img.setBounds(0, 0, 1366, 565);
        ImageIcon icon = new ImageIcon("flight_icon.png");
         Image image = icon.getImage();
         setIconImage(image);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Next>>")) {
            // Assuming 'group' is a class with an 'Input' method
            group gr = new group();
             gr.input();
            
            dispose(); // Close the current window
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FlightSystem fr = new FlightSystem();
            }
        });
    }
}

		