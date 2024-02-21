package components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 * Клас, який виконує функцію таблиці множення
 */
public class MyJTable extends JTable {
    public static Object[] columns = {1, 2, 3, 4, 5}; // масив для зберігання значень стовпців (за замовчуванням 5) (множене)
    public static Object[] rows = {1, 2, 3, 4, 5}; // масив для зберігання значень рядків (за замовчуванням 5) (множників)
    private Object[][] data; // масив для зберігання значень таблиці множення


    /**
     * Конструктор класу
     */
    public MyJTable() {

        data = new Object[rows.length][columns.length]; // створюємо масив для зберігання значень таблиці множення
        for (int i = 0; i < rows.length; i++) { // проходимо по всіх рядках в рамках ініціалізації
            for (int j = 0; j < columns.length; j++) {
                data[i][j] = (int) rows[i] * (int) columns[j];
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, columns); // створюємо модель таблиці
        this.setModel(model); // накінець то закидуємо масив з даними та масив з назвами стовпців у таблицю

        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.setColumnsWidth(this);


    }

    /**
     * Метод, який встановлює ширину стовпців
     *
     * @param table таблиця
     */
    void setColumnsWidth(MyJTable table) {
        for (int i = 0; i < data[0].length; i++) {
            table.getColumnModel().getColumn(i).setMinWidth(40);
            table.getColumnModel().getColumn(i).setPreferredWidth(40);
            table.getColumnModel().getColumn(i).setMaxWidth(40);
        }
    }

    /**
     * Метод, який оновлює модель таблиці, та встановлює нові значення для рядків та стовпців
     */
    void newModel() {

        Object[][] data = new Object[rows.length][columns.length];
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                data[i][j] = (int) rows[i] * (int) columns[j];
            }
        }
        DefaultTableModel newModel = new DefaultTableModel(data, columns);
        this.setModel(newModel);
        setColumnsWidth(this);
    }


    /**
     * Метод, який встановлює значення для стовпців
     *
     * @param n кількість стовпців
     * @return 1
     */
    public static int setColumns(int n) {
        columns = new Object[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i + 1;
            System.out.println(columns[i]);
        }

        return 0;
    }

    /**
     * Метод, який встановлює значення для рядків
     *
     * @param n кількість рядків
     * @return 1
     */
    public static int setRows(int n) {
        rows = new Object[n];
        for (int i = 0; i < n; i++) {
            rows[i] = i + 1;
        }
        return 0;
    }


    /**
     * Метод, який повертає значення стовпців, необхідний щоб користувач не редагував елементи в таблиці.
     *
     * @return масив значень стовпців
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
    }
}
