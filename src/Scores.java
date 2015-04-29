import java.awt.*;
import javax.swing.*;

public class Scores extends myJPanel {
  
    GButton play;
    JLabel score[];
    Student mostRecent;
    XML_240 xe;
    Student saved[];

    public Scores(Student passed) {
   
        xe = new XML_240();
        score = new JLabel[9];
        saved = new Student[9];
        play = new GButton("play");
        setLayout(null);
        mostRecent = passed;
        add(play);
        
//-----code to initialize XML values--------
//        
//        xe.openWriterXML("xml/scores.xml");
//            for (int i = 0; i<3; i++)
//        {
//            saved[i] = new Student("Easy", "1 minute", "paw", "Nittany", 10);
//            xe.writeObject(saved[i]); 
//        }
//            for (int i = 3; i<6; i++)
//        {
//            saved[i] = new Student("Medium", "1 minute", "logo", "Old Main", 10);
//            xe.writeObject(saved[i]);
//        }
//            for (int i = 6; i<9; i++)
//        {
//            saved[i] = new Student("Hard", "1 minute", "paw", "Bryce Jordan", 10);
//            xe.writeObject(saved[i]); 
//        }
//        xe.closeWriterXML(); 
        //------end of code to initialize XML file
        
       setLayout(null);
       
        mostRecent = passed;
 
        xe.openReaderXML("xml/scores.xml");
        for (int i = 0; i<9; i++)
        {
            score[i] = new JLabel();
            add(score[i]);
            saved[i] = (Student)xe.ReadObject(); 
            score[i].setText(saved[i].getScore());
        }
        xe.closeReaderXML(); 
        
        play.setBounds(new Rectangle(400, 500, 200, 100));
        score[0].setBounds(new Rectangle(40, 205, 175, 50));
        score[1].setBounds(new Rectangle(40, 315, 175, 50));
        score[2].setBounds(new Rectangle(40, 425, 175, 50));
        score[3].setBounds(new Rectangle(255, 205, 175, 50));
        score[4].setBounds(new Rectangle(255, 315, 175, 50));
        score[5].setBounds(new Rectangle(255, 425, 175, 50));
        score[6].setBounds(new Rectangle(470, 205, 175, 50));
        score[7].setBounds(new Rectangle(470, 315, 175, 50));
        score[8].setBounds(new Rectangle(470, 425, 175, 50));
    }
    
    @Override
        public void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
        Image start = Toolkit.getDefaultToolkit().getImage("images/high.png");
        g.drawImage(start, 0, 0, this);
   }
    

    public void calcHighScores(Student passed)
    {
        mostRecent = passed;
   
        xe.openReaderXML("xml/scores.xml");
        for (int i = 0; i<9; i++)
        {
            saved[i] = (Student)xe.ReadObject();
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
           else if (mostRecent.uscore > saved[8].uscore)
           {
               saved[2] = saved[8];
               saved[8] = mostRecent;  
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
        }
        xe.closeWriterXML(); 
       
    }
   
}
