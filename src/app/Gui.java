package app;

import javax.swing.*;
import java.awt.*;

public class Gui {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    private JButton button = new JButton();

    public Gui (String titleOfGUI, int width, int height) {
        frame.setName(titleOfGUI);

        panel.setPreferredSize(new Dimension(width, height));
        frame.add(panel);

//        JTextArea textArea = new JTextArea("Text Area");
//        textArea.setPreferredSize(new Dimension(width,height));
//        panel.add(textArea);
    }

    public void addButton(String buttonText, int width, int height) {
        button.setName(buttonText);
        button.setPreferredSize(new Dimension(width,height));
        panel.add(button);
    }

    //Must be used at the end
    public void displayFrame(Boolean trueOrFalse) {
        if (trueOrFalse) {
            frame.pack();
            frame.setVisible(true);
        } else {
            frame.pack();
            frame.setVisible(false);
        }
    }
}
