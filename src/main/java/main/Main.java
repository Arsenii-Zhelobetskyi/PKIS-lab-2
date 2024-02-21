package main;


import components.MyJComboBox;
import components.MyJLabel;
import components.MyJTable;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.xml.crypto.Data;
import java.awt.*;
import java.util.function.Function;

public class Main {
    public static class MyApp extends JFrame {


        MyJTable table;


        public MyApp() {
            this.setTitle("Таблиця множення");
            this.setSize(600, 600);
            this.setLayout(null);



            table = new MyJTable();

            this.add(new MyJLabel("Множник", JLabel.CENTER, 200, 100, 100, 50));
            this.add(new MyJLabel("Множене", JLabel.CENTER, 200, 150, 100, 50));
            this.add(new MyJComboBox(100,MyJTable::setColumns, table,300,115,100,25));
            this.add(new MyJComboBox(100,MyJTable::setRows, table,300,165, 100, 25));



            JScrollPane scroll = new JScrollPane(table,             JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setBounds(50, 200, 500, 300);
            this.add(scroll);



            this.setVisible(true);
            this.setResizable(false);

        }

//        int setColumns(int n){
//            columns = new Object[n];
//            for (int i = 0; i < n; i++) {
//                columns[i] = i+1;
//                System.out.println(columns[i]);
//            }
//            return 1;
//        }
//        int setRows(int n){
//            rows = new Object[n];
//            for (int i = 0; i < n; i++) {
//                rows[i] = i;
//            }
//            return 1;
//        }
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyApp::new);

    }
}





//       for (int i = 1; i < rows.length; i++) {
//                for (int j = 1; j < columns.length; j++) {
//                    data[i-1][j-1] =(int) rows[i] * (int) columns[j];
//                    System.out.print(data[i-1][j-1] +" ");
//                }
//                System.out.println();
//            }