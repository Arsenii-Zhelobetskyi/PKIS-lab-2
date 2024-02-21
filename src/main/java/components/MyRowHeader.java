package components;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;


/*
 * вертикальний хедер
 *
 */
public class MyRowHeader {
    JList list;// Об'явлення змінної типу JList для зберігання списку  рядків

    /**
     * Конструктор класу
     *
     * @param table таблиця
     */
    public MyRowHeader(MyJTable table) {
        ListModel listModel = new AbstractListModel() {// Створення ListModel для надання даних для JList

            @Override
            public int getSize() { // Перевизначення методу getSize для повернення кількості рядків у таблиці
                return table.rows.length;
            }

            @Override
            public Object getElementAt(int i) { // Перевизначення методу getElementAt для повернення даних для конкретного рядка
                return table.rows[i];
            }
        };
        list = new JList(listModel); // Створення JList на основі ListModel
        list.setFixedCellWidth(40); // Встановлення фіксованої ширини для комірок списку
        list.setBackground(table.getTableHeader().getBackground()); // Встановлення фону списку таким же, як у заголовку таблиці
        list.setFixedCellHeight(table.getRowHeight()); // Встановлення фіксованої висоти для комірок списку
        list.setCellRenderer(new RowRenderer(table)); // Встановлення рендерера для комірок списку
    }

    public JList getList() { // Метод для отримання списку
        return list;
    }

    /**
     * Клас виконує функцію рендерингу елементів(вертикального хедеру) таблиці
     */
    private class RowRenderer extends JLabel implements ListCellRenderer {
        public RowRenderer(JTable table) {
            // встановлюємо властивості відображення такі ж, як й у заголовку таблиці
            JTableHeader header = table.getTableHeader();
            setOpaque(true); // встановлюємо прозорість (true - непрозорий, false - прозорий)
            setBorder(UIManager.getBorder("TableHeader.cellBorder")); // встановлюємо рамку для комірки.
            // UIManager - це клас, який надає доступ до різних ресурсів, таких як кольори, шрифти, розміри, тощо.
            // "TableHeader.cellBorder" - це ключ, який вказує на стиль рамки для комірки заголовку таблиці.
            // Цей метод, дозволяє встановити рамку для комірки вертикального хедеру, яка буде такою ж, як і рамка комірки заголовку таблиці.
            setHorizontalAlignment(CENTER);
            setForeground(header.getForeground()); // встановлюємо колір тексту
            setBackground(header.getBackground()); // встановлюємо колір фону
            setFont(header.getFont()); // встановлюємо шрифт
        }

        /**
         * Реалізація методу інтерфейсу ListCellRenderer.
         * <p>
         * Цей метод викликається під час рендерингу кожного елемента списку,
         * у випадку коли MyRowHeader використовується як рендерер для списку.
         * <p>
         * У даному випадку, цей метод встановлює текст для кожного елемента списку,
         * який відображається у вертикальному хедері таблиці. Він перевіряє значення value, яке представляє об'єкт,
         * який потрібно відобразити, та встановлює текст елемента списку на основі цього значення.
         * Якщо значення null, то встановлюється пустий рядок.
         *
         * @param list         список, для якого викликається метод
         * @param value        об'єкт, який потрібно відобразити
         * @param index        індекс поточного елемента списку
         * @param isSelected   вказує, чи обраний елемент списку
         * @param cellHasFocus вказує, чи має фокус поточний елемент списку
         * @return Component  повертається екземпляр компоненту, який відображається у списку
         */
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            setText((value == null) ? "" : value.toString());

            return this;
        }

    }
}




