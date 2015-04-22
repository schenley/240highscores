
import java.awt.*;
import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class myJFrame extends JFrame {

    myJTabbedPane mjp;

    public myJFrame() {
        super("Our Awesome Game");
        mjp = new myJTabbedPane();

        getContentPane().add(mjp, "Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);

        mjp.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (e.getSource() instanceof JTabbedPane) {
                    JTabbedPane pane = (JTabbedPane) e.getSource();
                    /*
                     if (pane.getSelectedIndex() == 2) {

                     }
                     if (pane.getSelectedIndex() == 1) {

                     }
                     */
                }
            }

        });

    }
}
