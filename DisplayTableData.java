import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class DisplayTableData extends JFrame {
    private JTable dataTable;
    private JScrollPane scrollPane;

    public DisplayTableData(String tableName) {
        setTitle("Table Data Display");
        setSize(800, 600);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "1821");

            String query = "SELECT * FROM " + tableName;
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                String[] columnNames = new String[columnCount - 1];
                for (int i = 1; i < columnCount; i++) {
                    columnNames[i - 1] = metaData.getColumnName(i);
                }

                Object[][] data = new Object[100][columnCount - 1];

                int row = 0;
                while (rs.next()) {
                    for (int i = 1; i < columnCount; i++) {
                        data[row][i - 1] = rs.getObject(i);
                    }
                    row++;
                }

                DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
                dataTable = new JTable(tableModel);
                scrollPane = new JScrollPane(dataTable);

                getContentPane().add(scrollPane, BorderLayout.CENTER);

            } // The try-with-resources statement ensures that each resource is closed at the end

            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        setVisible(true);
        
    }

    
}
