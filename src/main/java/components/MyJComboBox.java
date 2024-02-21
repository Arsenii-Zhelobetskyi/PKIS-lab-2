package components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // Import ActionListener from java.awt.event
import java.util.function.Consumer;
import java.util.function.Function;

public class MyJComboBox extends JComboBox {
    Object[]data;
    public MyJComboBox(int num, Function<Integer, Integer> method, MyJTable table, JList rowheader, int... sizes) {
        super();

        for (int i = 0; i <= num; i++) {
            this.addItem(i);
        }
        this.setSelectedItem(5);
        this.setBounds(sizes[0], sizes[1], sizes[2], sizes[3]);



        // Add ActionListener to listen for selection changes
        this.addActionListener(e -> {
            // Perform actions when selection changes
            JComboBox comboBox = (JComboBox) e.getSource();
            int selectedValue =(int) comboBox.getSelectedItem();

//            setData.accept(selectedValue);
//            data = new Object[selectedValue];
//            for (int i = 0; i < selectedValue; i++) {
//                data[i] = i+1;
//                System.out.println(data[i]);
//            }
            System.out.println("Selected: " + selectedValue);

//            table.setColumns(selectedValue);
            method.apply(selectedValue);
            table.newModel();
            table.revalidate();
            table.repaint();
            rowheader.repaint();
        });
    }
}
