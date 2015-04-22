import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Options extends myJPanel implements ActionListener, MouseListener
{
    JRadioButton jrbd1, jrbd2, jrbd3, jrbt1, jrbt2, jrbt3, jrba1, jrba2,jrba3;
    JLabel jl1, jl2, jl3, jl4, jl5;
    GButton jb1;
    GButton2 jbTitle;
    JButton jb2;
    int lengthchoice;
    JTextField jtname;
    
    public Options () 
    {
        setBackground(Color.white);
        setLayout(null);
        
        jbTitle = new GButton2("optionstitle");
       
        jl1 = new JLabel("Difficulty: ");
        jrbd1 = new JRadioButton("Easy");
        jrbd2 = new JRadioButton("Medium");
        jrbd3 = new JRadioButton("Hard");
        ButtonGroup difficulty = new ButtonGroup();
        difficulty.add(jrbd1);
        difficulty.add(jrbd2);
        difficulty.add(jrbd3);
        
        jl2 = new JLabel("Length of Play: ");
        jrbt1 = new JRadioButton("1 minute");
        jrbt2 = new JRadioButton("3 minutes");
        jrbt3 = new JRadioButton("5 minutes");
        ButtonGroup time = new ButtonGroup();
        time.add(jrbt1);
        time.add(jrbt2);
        time.add(jrbt3);
        
        jl3 = new JLabel("Avatar: ");
        jrba1 = new JRadioButton("logo");
        jrba2 = new JRadioButton("mascot");
        jrba3 = new JRadioButton("paw");
        ButtonGroup avatar = new ButtonGroup();
        avatar.add(jrba1);
        avatar.add(jrba2);
        avatar.add(jrba3);
        
        add(jbTitle);
        
        add(jl1);
        add(jrbd1);
        add(jrbd2);
        add(jrbd3);
        
        add(jl2);
        add(jrbt1);
        add(jrbt2);
        add(jrbt3);
        
        add(jl3);
        add(jrba1);
        add(jrba2);
        add(jrba3);
        
        jrbd1.addActionListener(this);
        jrbd2.addActionListener(this);
        jrbd3.addActionListener(this);
        jrbt1.addActionListener(this);
        jrbt2.addActionListener(this);
        jrbt3.addActionListener(this);
        jrba1.addActionListener(this);
        jrba2.addActionListener(this);
        jrba3.addActionListener(this);
    
        jl5 = new JLabel("Player Name:");
        jtname = new JTextField("");
        add(jl5);
        add(jtname);
        
        jl4 = new JLabel("Select All Three Options");
        jl4.setForeground(Color.red);
        add(jl4);
        
        jb1 = new GButton("play");
        add(jb1); 
        
        
        jb2 = new JButton();
        add(jb2);
        jb2.setBorder(null); 
        jb2.setContentAreaFilled(false);
        
        jbTitle.setBounds(new Rectangle(0,0,700,150));
        jl1.setBounds(new Rectangle(75,175,125,50));
        jrbd1.setBounds(new Rectangle(200,175,125,50));
        jrbd2.setBounds(new Rectangle(325,175,125,50));
        jrbd3.setBounds(new Rectangle(450,175,125,50));
        jl2.setBounds(new Rectangle(75,275,125,50));
        jrbt1.setBounds(new Rectangle(200,275,125,50));
        jrbt2.setBounds(new Rectangle(325,275,125,50));
        jrbt3.setBounds(new Rectangle(450,275,125,50));
        jl3.setBounds(new Rectangle(75,375,125,50));
        jrba1.setBounds(new Rectangle(200,375,125,50));
        jrba2.setBounds(new Rectangle(325,375,125,50));
        jrba3.setBounds(new Rectangle(450,375,125,50));
        jb2.setBounds(new Rectangle(575,375,50,50));
        jl5.setBounds(new Rectangle(75,475,125,50));
        jtname.setBounds(new Rectangle(200,475,125,50));
        jb1.setBounds(new Rectangle(400,475,200,100));
        
        
    }
 

    @Override
    public void actionPerformed(ActionEvent event) 
    {

       	Object obj = event.getSource();
       	 
     	 if (obj == jrbd1)
    	 {
             jl1.setText(event.getActionCommand());      
     	 }
         if (obj == jrbd2)
    	 {
             jl1.setText(event.getActionCommand());
     	 }
         if (obj == jrbd3)
    	 {
             jl1.setText(event.getActionCommand());             
     	 }
         
         if (obj == jrbt1)
    	 {
             jl2.setText(event.getActionCommand());
             lengthchoice = 59;
     	 }
         if (obj == jrbt2)
    	 {
             jl2.setText(event.getActionCommand());
             lengthchoice = 179;
     	 }
         if (obj == jrbt3)
    	 {
             jl2.setText(event.getActionCommand());
             lengthchoice = 299;
     	 }
          
         if (obj == jrba1)
    	 {
             jl3.setText(event.getActionCommand());
             ImageIcon img = new ImageIcon("images/" +event.getActionCommand()+".png");
             jb2.setIcon(img);
     	 }
         if (obj == jrba2)
    	 {
             jl3.setText(event.getActionCommand());
             ImageIcon img = new ImageIcon("images/" +event.getActionCommand()+".png");
             jb2.setIcon(img);
     	 }
         if (obj == jrba3)
    	 {
             jl3.setText(event.getActionCommand());
             ImageIcon img = new ImageIcon("images/" +event.getActionCommand()+".png");
             jb2.setIcon(img);
     	 }
         
    }	

    @Override
    public void mouseClicked(MouseEvent me) { }
    public void mousePressed(MouseEvent me) { }
    public void mouseReleased(MouseEvent me) { }
    public void mouseEntered(MouseEvent me) {  }
    public void mouseExited(MouseEvent me) { }
}