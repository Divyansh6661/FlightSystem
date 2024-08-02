import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Dashb1 implements ActionListener {
    private JFrame frame;
    private JButton okBtn;
    private JLabel lok;

    Dashb1(String label) {
        frame = new JFrame("Dashboard");
        okBtn = new JButton("OK");
        lok = new JLabel(label);

        lok.setBounds(140, 35, 250, 40);
        okBtn.setBounds(150, 100, 80, 25);

        frame.setLayout(null);
        frame.add(okBtn);
        frame.add(lok);
        frame.setSize(400, 200);
        frame.setResizable(false);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        okBtn.addActionListener(this);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okBtn) {
            frame.setVisible(false);
        }
    }

    
}
