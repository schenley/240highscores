import java.awt.*;
import javax.swing.*;

public class Scores extends myJPanel {

    GButton2 jbtitle;
    JButton score[];
    Student mostRecent;
    XML_240 xe;
    Student saved[];

    public Scores(Student passed) {
        jbtitle = new GButton2("scorestitle");
        add(jbtitle);
        xe = new XML_240();
        score = new JButton[9];
        saved = new Student[9];
        
//-----code to initialize XML values--------
        
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
        
        setBackground(Color.white);
      
        mostRecent = passed;
 
        xe.openReaderXML("xml/scores.xml");
        for (int i = 0; i<9; i++)
        {
            score[i] = new JButton();
            add(score[i]);
            score[i].setBackground(Color.white);
            saved[i] = (Student)xe.ReadObject(); 
            score[i].setText(saved[i].getScore());
        }
        xe.closeReaderXML();   
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
