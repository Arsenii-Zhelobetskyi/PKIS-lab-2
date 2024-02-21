package main;


import components.MyJComboBox;
import components.MyJLabel;
import components.MyJTable;
//import components.RowRenderer;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
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
            ListModel lm = new AbstractListModel() {



                @Override
                public int getSize() {
                    return table.rows.length;
                }

                @Override
                public Object getElementAt(int i) {
                    return table.rows[i];
                }
            };
            DefaultTableModel dm = new DefaultTableModel(lm.getSize(),5);
            JList rowHeader = new JList(lm);
            rowHeader.setFixedCellWidth(50);
            rowHeader.setBackground(table.getTableHeader().getBackground());
            rowHeader.setFixedCellHeight(table.getRowHeight());
            rowHeader.setCellRenderer(new RowRenderer(table));
            this.add(new MyJLabel("Множник", JLabel.CENTER, 200, 100, 100, 50));
            this.add(new MyJLabel("Множене", JLabel.CENTER, 200, 150, 100, 50));
            this.add(new MyJComboBox(100, MyJTable::setColumns, table, 300, 115, 100, 25));
            this.add(new MyJComboBox(100, MyJTable::setRows, table, 300, 165, 100, 25));


            JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scroll.setBounds(50, 200, 500, 300);
            scroll.setRowHeaderView(rowHeader);
//            scroll.setBackground(Color.WHITE);
//            scroll.getViewport().setBackground(Color.WHITE);
            this.add(scroll);


            this.setVisible(true);
            this.setResizable(false);


//            JTableHeader header =  rowHeader.getTableHeader();
//            header.setBackground(Color.WHITE);
//            header.getParent().setBackground(Color.WHITE);


        }

        class RowRenderer extends JLabel implements ListCellRenderer {
            RowRenderer(JTable table) {
                JTableHeader header = table.getTableHeader();
                setOpaque(true);
                setBorder(UIManager.getBorder("TableHeader.cellBorder"));
                setHorizontalAlignment(CENTER);
                setForeground(header.getForeground());
                setBackground(header.getBackground());
                System.out.println(header.getBackground());
                setFont(header.getFont());
            }
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                setText((value == null) ? "" : value.toString());

                return this;
            }

        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyApp::new);

    }
}





