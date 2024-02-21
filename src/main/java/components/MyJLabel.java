package components;

import javax.swing.*;

public class MyJLabel extends JLabel {

    public MyJLabel(String text, int horizontalAlignment, int...sizes) {
        super(text, horizontalAlignment);
        this.setBounds(sizes[0], sizes[1], sizes[2], sizes[3]);
    }
}
