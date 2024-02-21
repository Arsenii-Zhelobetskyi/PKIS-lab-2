package components;

import javax.swing.*;

/**
 * Клас, який виконує функцію JScrollPane (рамка, яка надає прокрутку для таблиці
 */
public class MyJScrollPane extends  JScrollPane {
    /**
     * Конструктор класу
     * @param table - таблиця
     * @param rowHeader - вертикальний хедер
     */
    public MyJScrollPane(MyJTable table, MyRowHeader rowHeader, int...sizes){
        super(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setBounds(sizes[0], sizes[1], sizes[2], sizes[3]);
        this.setRowHeaderView(rowHeader.getList()); // встановлюємо вертикальний хедер
    }

}
