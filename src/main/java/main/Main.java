package main;


import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;


public class Main {
    public static class MyApp extends JFrame {
        Object[][] data = {
                {"John", "Doe", 30, 30, 30},
                {"Jane", "Doe", 25, 30, 30},
                {"Tom", "Smith", 40, 30, 30},
                {"John", "Doe", 30, 30, 30},
                {"Jane", "Doe", 25, 30, 30},
                {"Tom", "Smith", 40, 30, 30},
                {"John", "Doe", 30, 30, 30},
                {"Jane", "Doe", 25, 30, 30},
                {"Tom", "Smith", 40, 30, 30},
                {"John", "Doe", 30, 30, 30},
                {"Jane", "Doe", 25, 30, 30},
                {"Tom", "Smith", 40, 30, 30},
                {"John", "Doe", 30, 30, 30},
                {"Jane", "Doe", 25, 30, 30},
                {"Tom", "Smith", 40, 30, 30},
                {"John", "Doe", 30, 30, 30},
                {"Jane", "Doe", 25, 30, 30},
                {"Tom", "Smith", 40, 30, 30},
                {"John", "Doe", 30, 30, 30},
                {"Jane", "Doe", 25, 30, 30},
                {"Tom", "Smith", 40, 30, 30},
                {"John", "Doe", 30, 30, 30},
                {"Jane", "Doe", 25, 30, 30},
                {"Tom", "Smith", 40, 30, 30},

        };
        String[] columns = {"First Name", "Last Name", "Age", "Vegetarian", "we"};

        public MyApp() {
            this.setTitle("Таблиця множення");
            this.setSize(600, 600);
            this.setLayout(null);

            JLabel Multiplier = new JLabel("Множник", JLabel.CENTER);
            JLabel Multiplied = new JLabel("Множене", JLabel.CENTER);
            Multiplier.setBounds(200, 100, 100, 50);
            Multiplied.setBounds(200, 150, 100, 50);


            JComboBox MultiplierBox = new JComboBox();
            JComboBox MultipliedBox = new JComboBox();

            for (int i = 1; i <= 100; i++) {
                MultiplierBox.addItem(i);
                MultipliedBox.addItem(i);
            }
            MultiplierBox.setBounds(300, 115, 100, 25);
            MultipliedBox.setBounds(300, 165, 100, 25);

            JPanel TextGrid = new JPanel();
            GridLayout gl = new GridLayout(25, 40);
            TextGrid.setLayout(gl);
            for (int i = 1; i < 1001; i++)
                TextGrid.add(new JTextField(String.valueOf(i), 4));

            JScrollPane scroll = new JScrollPane(new Table(data, columns), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//             JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
            scroll.setBounds(50, 200, 500, 300);
            this.add(scroll);


            this.add(Multiplier);
            this.add(Multiplied);
            this.add(MultiplierBox);
            this.add(MultipliedBox);
            this.setVisible(true);
            this.setResizable(false);
        }
    }

    public static class Table extends JTable {


        public Table(Object[][] data, String[] columns) {
            super(data, columns);
            setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            for (int i = 0; i < columns.length; i++) {

                getColumnModel().getColumn(i).setMinWidth(200);
                getColumnModel().getColumn(i).setPreferredWidth(200);
                getColumnModel().getColumn(i).setMaxWidth(200);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyApp::new);

    }
}