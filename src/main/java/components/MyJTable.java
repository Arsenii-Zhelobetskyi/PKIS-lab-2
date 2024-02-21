package components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class MyJTable extends JTable {
   public static Object[] columns ={1,2,3,4,5};
   public static Object[] rows ={1,2,3,4,5};

    Object[][] data;
    public MyJTable() {


        data = new Object[rows.length][columns.length];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                data[i][j] = (int) rows[i] * (int) columns[j];
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, columns);
        this.setModel(model);
//        super(data,columns);
//        setTableHeader(null);
        this.columns= columns;
        this.rows = rows;
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < data[0].length; i++) {
            getColumnModel().getColumn(i).setMinWidth(40);
            getColumnModel().getColumn(i).setPreferredWidth(40);
            getColumnModel().getColumn(i).setMaxWidth(40);
        }


    }

   void newModel(){

       System.out.println(columns.length);
       Object[][] data = new Object[rows.length][columns.length];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                data[i][j] = (int) rows[i] * (int) columns[j];
                System.out.print(data[i][j]+" ");
            }
            System.out.println();
        }
       DefaultTableModel newModel = new DefaultTableModel(data, columns);

       this.setModel(newModel);
    }


  public static int setColumns(int n){
        columns = new Object[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i+1;
            System.out.println(columns[i]);
        }
        return 1;
    }
    public static int setRows(int n){
        rows = new Object[n];
        for (int i = 0; i < n; i++) {
            rows[i] = i+1;
        }
        return 1;
    }


    @Override
    public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
    }
}
