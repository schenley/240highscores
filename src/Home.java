import java.awt.*;
import javax.swing.*;

public class Home extends myJPanel  
{
    GButton jb1;
    
    public Home () 
    {
        setLayout(null);
        jb1 = new GButton("start");
        add(jb1);
        jb1.setBounds(225, 420, 250, 100);  
        
    }
 
    @Override
   public void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
        Image start = Toolkit.getDefaultToolkit().getImage("images/startnew.png");
        g.drawImage(start, 0, 0, this);
   }


}
