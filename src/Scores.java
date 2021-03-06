import java.awt.*;
import javax.swing.*;

public class Scores extends myJPanel
{
    GButton play;
    JLabel score[];
    Student2 mostRecent;
    XML_240 xe;
    Student2 saved[];
    GButton2 avatar[];

    public Scores(Student2 passed) {
   
        xe = new XML_240();
        score = new JLabel[9];
        saved = new Student2[9];
        avatar = new GButton2[9];
        play = new GButton("play");
        setLayout(null);
        mostRecent = passed;
        add(play);
        
//-----code to initialize XML values--------
//        
//        xe.openWriterXML("xml/scores.xml");
//            for (int i = 0; i<3; i++)
//        {
//            saved[i] = new Student2("Easy", "paw", "Nittany", 10);
//            xe.writeObject(saved[i]); 
//        }
//            for (int i = 3; i<6; i++)
//        {
//            saved[i] = new Student2("Medium", "logo", "Old Main", 10);
//            xe.writeObject(saved[i]);
//        }
//            for (int i = 6; i<9; i++)
//        {
//            saved[i] = new Student2("Hard", "mascot", "Bryce Jordan", 10);
//            xe.writeObject(saved[i]); 
//        }
//        xe.closeWriterXML(); 
    //    ------end of code to initialize XML file
        
       setLayout(null);
       
        mostRecent = passed;
 
        xe.openReaderXML("xml/scores.xml");
        for (int i = 0; i<9; i++)
        {
            score[i] = new JLabel();
            add(score[i]);
            saved[i] = (Student2)xe.ReadObject(); 
            score[i].setText(saved[i].getScore());
            avatar[i] = new GButton2(saved[i].uav);
            add(avatar[i]);
            
        }
        xe.closeReaderXML(); 
        
        play.setBounds(new Rectangle(400, 500, 200, 100));
         
        score[0].setBounds(new Rectangle(45, 205, 175, 50));
        score[1].setBounds(new Rectangle(45, 315, 175, 50));
        score[2].setBounds(new Rectangle(45, 425, 175, 50));
        score[3].setBounds(new Rectangle(260, 205, 175, 50));
        score[4].setBounds(new Rectangle(260, 315, 175, 50));
        score[5].setBounds(new Rectangle(260, 425, 175, 50));
        score[6].setBounds(new Rectangle(475, 205, 175, 50));
        score[7].setBounds(new Rectangle(475, 315, 175, 50));
        score[8].setBounds(new Rectangle(475, 425, 175, 50));
        
        avatar[0].setBounds(new Rectangle(75, 150, 50, 50));
        avatar[1].setBounds(new Rectangle(75, 260, 50, 50));
        avatar[2].setBounds(new Rectangle(75, 370, 50, 50));
        avatar[3].setBounds(new Rectangle(290, 150, 50, 50));
        avatar[4].setBounds(new Rectangle(290, 260, 50, 50));
        avatar[5].setBounds(new Rectangle(290, 370, 50, 50));
        avatar[6].setBounds(new Rectangle(505, 150, 50, 50));
        avatar[7].setBounds(new Rectangle(505, 260, 50, 50));
        avatar[8].setBounds(new Rectangle(505, 370, 50, 50));
    }
    

    public void calcHighScores(Student2 passed)
    {
        mostRecent = passed;
   
        xe.openReaderXML("xml/scores.xml");
        for (int i = 0; i<9; i++)
        {
            saved[i] = (Student2)xe.ReadObject();
        }
        xe.closeReaderXML();
       
       if (mostRecent.udiff == "Easy"){
           if (mostRecent.uscore > saved[0].uscore)  
           {
               saved[2] = saved[1]; 
               saved[1] = saved[0]; 
               saved[0] = mostRecent;
           }
           else if (mostRecent.uscore > saved[1].uscore)
           {
               saved[2] = saved[1];
               saved[1] = mostRecent;  
           }
           else if(mostRecent.uscore > saved[2].uscore)
           {
               saved[2] = mostRecent;
           }
       }
        if (mostRecent.udiff == "Medium"){
           if (mostRecent.uscore > saved[3].uscore)  
           {
               saved[5] = saved[4]; 
               saved[4] = saved[3]; 
               saved[3] = mostRecent;
           }
           else if (mostRecent.uscore > saved[4].uscore)
           {
               saved[5] = saved[4];
               saved[4] = mostRecent;  
           }
           else if(mostRecent.uscore > saved[5].uscore)
           {
               saved[5] = mostRecent;
           }
       }
        if (mostRecent.udiff == "Hard"){
           if (mostRecent.uscore > saved[6].uscore)  
           {
               saved[8] = saved[7]; 
               saved[7] = saved[6]; 
               saved[6] = mostRecent;
           }
           else if (mostRecent.uscore > saved[7].uscore)
           {
               saved[8] = saved[7];
               saved[7] = mostRecent;  
           }
           else if(mostRecent.uscore > saved[8].uscore)
           {
               saved[8] = mostRecent;
           }
       }
        xe.openWriterXML("xml/scores.xml");
        for (int i = 0; i<9; i++)
        {
           xe.writeObject(saved[i]);
           score[i].setText(saved[i].getScore());
           ImageIcon img = new ImageIcon("images/" + saved[i].uav + ".png");
           avatar[i].setIcon(img);
           avatar[i].setBorder(null);
           avatar[i].setContentAreaFilled(false);
        
           repaint();
        }
        xe.closeWriterXML();    
    }
        @Override
        public void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
        Image start = Toolkit.getDefaultToolkit().getImage("images/high2.png");
        g.drawImage(start, 0, 0, this);
   }
    
}
