package components;

import javax.swing.*;
import java.util.function.Function;


/**
 * Клас, який виконує функцію комбобоксу
 */
public class MyJComboBox extends JComboBox {

    /**
     * Конструктор класу компоненту
     *
     * @param rowColumnNumber  кількість рядків/стовпців
     * @param rowColumnUpdater метод який буде змінювати кількість рядків/стовпців. Для рядку це метод setRows, для стовпця setColumns
     * @param table            таблиця
     * @param rowHeader        вертикальний хедер, який відображається зліва від таблиці. Тут він потрібен, щоб вчасно оновити його
     * @param sizes            розміри комбобоксу
     */
    public MyJComboBox(int rowColumnNumber, Function<Integer, Integer> rowColumnUpdater, MyJTable table, JList rowHeader, int... sizes) {
        super();
        for (int i = 0; i <= rowColumnNumber; i++) { // заповнюємо комбобокс від 0 до rowColumnNumber
            this.addItem(i);
        }
        this.setSelectedItem(5); // значення за замовчуванням
        this.setBounds(sizes[0], sizes[1], sizes[2], sizes[3]);


        /*
         * Додаємо слухача на зміну вибору
         */
        this.addActionListener(e -> {
            JComboBox comboBox = (JComboBox) e.getSource(); // отримуємо того хто викликав подію
            int selectedValue = (int) comboBox.getSelectedItem(); // отримуємо вибране значення

            rowColumnUpdater.apply(selectedValue); // викликаємо метод, який змінює розмір та зміст масиву рядків/стовпців
            table.newModel(); // оновлюємо вміст таблиці

            table.revalidate(); // оновлюємо таблицю
            table.repaint();
            rowHeader.repaint(); // оновлюємо вертикальний хедер
        });
    }
}
