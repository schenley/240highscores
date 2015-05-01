import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class myJFrame extends JFrame {

    myJTabbedPane mjp;

    public myJFrame() {
        super("PurSUit");
        mjp = new myJTabbedPane();

        getContentPane().add(mjp, "Center");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);

        mjp.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (e.getSource() instanceof JTabbedPane) {
                    JTabbedPane pane = (JTabbedPane) e.getSource();  
                }
            }

        });

    }
}
