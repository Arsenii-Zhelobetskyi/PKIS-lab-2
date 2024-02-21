package components;

import javax.swing.*;

/**
 * Клас, який виконує функцію реалізації власного класу JLabel
 *
 */
public class MyJLabel extends JLabel {

    /**
     * Конструктор класу MyJLabel
     *
     * @param text  текст, який відображається на label
     * @param horizontalAlignment  вирівнювання тексту
     * @param sizes  розміри етикетки
     */
    public MyJLabel(String text, int horizontalAlignment, int...sizes) {
        super(text, horizontalAlignment);
        this.setBounds(sizes[0], sizes[1], sizes[2], sizes[3]);
    }
}
