import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class adminpage2 extends JFrame implements ActionListener {
    MenuBar mb;
    Menu flight, bookings, employee, ma, report;
    MenuItem addf, delf, editf, allf, addb, delb, editb, allb, addm, delm, rp, adde, edite, dele, alle;

    adminpage2() {
        setTitle("AdminPage");
        setSize(800, 600);
         // Set icon for the JFrame
         ImageIcon icon = new ImageIcon("admin_icon.png");
         Image image = icon.getImage();
         setIconImage(image);
 
         // Load background image
         ImageIcon backgroundImageIcon = new ImageIcon("admin_bgimage.png");
         Image backgroundImage = backgroundImageIcon.getImage();
 
         setLayout(new BorderLayout());
         setContentPane(new JPanel() {
             @Override
             protected void paintComponent(Graphics g) {
                 super.paintComponent(g);
                 g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
             }
         });
        mb = new MenuBar();
        setMenuBar(mb);
        flight = new Menu("Flight");
        bookings = new Menu("Bookings");
        employee = new Menu("Employee");
        ma = new Menu("Manage Admin");
        report = new Menu("Report");
        addf = new MenuItem("Add Flight Details");
        editf = new MenuItem("Edit Flight Details");
        delf = new MenuItem("Delete Flight Details");
        allf = new MenuItem("All Flights");
        addb = new MenuItem("Add Bookings");
        editb = new MenuItem("Edit Bookings");
        delb = new MenuItem("Delete Bookings");
        allb = new MenuItem("All Bookings");
        rp = new MenuItem("Report a Problem");
        adde = new MenuItem("Add Employee Details");
        edite = new MenuItem("Edit Employee Details");
        dele = new MenuItem("Delete Employee Details");
        alle = new MenuItem("All Employee");
        mb.add(flight);
        mb.add(bookings);
        mb.add(employee);
        mb.add(report);
        flight.add(addf);
        addf.addActionListener(this);
        flight.add(editf);
        editf.addActionListener(this);
        flight.add(delf);
        delf.addActionListener(this);
        flight.add(allf);
        allf.addActionListener(this);
        bookings.add(addb);
        addb.addActionListener(this);
        bookings.add(editb);
        editb.addActionListener(this);
        bookings.add(delb);
        delb.addActionListener(this);
        bookings.add(allb);
        allb.addActionListener(this);
        report.add(rp);
        rp.addActionListener(this);
        employee.add(adde);
        adde.addActionListener(this);
        employee.add(edite);
        edite.addActionListener(this);
        employee.add(dele);
        dele.addActionListener(this);
        employee.add(alle);
        alle.addActionListener(this);
        setVisible(true);
        
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        if ("Add Flight Details".equals(command)) {
            addflight af=new addflight();
        } else if ("Edit Flight Details".equals(command)) {
            editflight ef=new editflight();
        } else if ("Delete Flight Details".equals(command)) {
           delflight df=new delflight();
        } else if ("All Flights".equals(command)) {
            SwingUtilities.invokeLater(() -> new DisplayTableData("FLIGHT_DATA"));
        } else if ("Add Bookings".equals(command)) {
            addbooking ab=new addbooking();
        } else if ("Edit Bookings".equals(command)) {
            editbooking ed=new editbooking();
        } else if ("Delete Bookings".equals(command)) {
            delbooking db=new delbooking();
        } else if ("All Bookings".equals(command)) {
            // H
        } else if ("Report a Problem".equals(command)) {
            report r=new report();
        } else if ("Add Employee Details".equals(command)) {
            addemployee aee=new addemployee();
        } else if ("Edit Employee Details".equals(command)) {
            editemployee ep =new editemployee();
        } else if ("Delete Employee Details".equals(command)) {
            delemployee de=new delemployee();
        } else if ("All Employee".equals(command)) {
            SwingUtilities.invokeLater(() -> new DisplayTableData("USER_DATA"));
        }
    }

    
    }

