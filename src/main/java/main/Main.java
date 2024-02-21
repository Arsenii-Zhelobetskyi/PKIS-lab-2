package main;


import components.*;
import javax.swing.*;

public class Main {

    /**
     * Клас, який виконує функцію додатку
     */
    public static class MyApp extends JFrame {

        final int COLUMNS_NUMBER= 1000;
        final int ROWS_NUMBER= 1000;

        public MyApp() {
            this.setTitle("Таблиця множення");
            MyJTable table = new MyJTable();
            this.setSize(600, 600);
            this.setLayout(null);

            // створюємо та розташовуємо усі компоненти в додатку
            MyRowHeader rowHeader = new MyRowHeader(table);
            this.add(new MyJLabel("Множник:", JLabel.CENTER, 200, 50, 100, 50));
            this.add(new MyJLabel("Множене:", JLabel.CENTER, 200, 100, 100, 50));
            this.add(new MyJLabel("Таблиця множення:", JLabel.CENTER, 200, 150, 150, 50));
            this.add(new MyJComboBox(COLUMNS_NUMBER, MyJTable::setColumns, table, rowHeader.getList(), 300, 65, 100, 25));
            this.add(new MyJComboBox(ROWS_NUMBER, MyJTable::setRows, table, rowHeader.getList(), 300, 115, 100, 25));
            this.add(new MyJScrollPane(table, rowHeader,0, 200, 585, 360));

            this.setVisible(true);
            this.setResizable(false);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyApp::new); // створюємо та запускаємо додаток
    }
}





