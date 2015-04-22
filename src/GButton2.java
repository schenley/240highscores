
import javax.swing.*;

public class GButton2 extends JButton
{
    
ImageIcon imageName;


    public GButton2(String name)
    {	
        super();
        
        imageName = new ImageIcon("images/"+name+".png");
        setIcon(imageName);
        setBorder(null); 
        setContentAreaFilled(false);

    }
}