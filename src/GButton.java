
import javax.swing.*;

public class GButton extends JButton
{
    
ImageIcon imageName, rollover;


    public GButton(String name)
    {	
        super();
        
        imageName = new ImageIcon("images/"+name+".png");
        rollover = new ImageIcon("images/"+name+"2.png");
        setIcon(imageName);
        setBorder(null); 
        setContentAreaFilled(false);
        setRolloverIcon(rollover);
    }
}