import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Scores extends myJPanel {

 
    GButton2 jbtitle;
    JButton score1, score2, score3;
   // JButton scoreE1, scoreE2, scoreE3, scoreM1, scoreM2, scoreM3, scoreH1, scoreH2, scoreH3;
    Student mostRecent, saved1, saved2, saved3;
    XML_240 xe;

    public Scores(Student passed) {
        jbtitle = new GButton2("scorestitle");
        add(jbtitle);
        xe = new XML_240();
        
//-----code to initialize XML values--------
//        saved1 = new Student( "Easy", "1 minute", "paw", "Paterno", 100);
//        saved2 = new Student("Hard", "1 minute", "logo", "Nittany", 50);
//        saved3 = new Student("Medium", "1 minute", "mascot", "Old Main", 25);
//        xe.openWriterXML(SCORES_XML_FILE_DIR);
//        xe.writeObject(saved1);
//        xe.writeObject(saved2);
//        xe.writeObject(saved3);
//        xe.closeWriterXML(); 
        
        setBackground(Color.white);

      
        mostRecent = passed;
   
         xe.openReaderXML("xml/scores.xml");
         saved1 = (Student)xe.ReadObject();
         saved2 = (Student)xe.ReadObject();
         saved3 = (Student)xe.ReadObject();

         xe.closeReaderXML();
         
        
   
        score1 = new JButton(saved1.getScore());
        score2 = new JButton(saved2.getScore());
        score3 = new JButton(saved3.getScore());

        add(score1);
        add(score2);
        add(score3); 
    }

    public void calcHighScores(Student passed)
    {


        mostRecent = passed;
   
         xe.openReaderXML("xml/scores.xml");
         saved1 = (Student)xe.ReadObject();
         saved2 = (Student)xe.ReadObject();
         saved3 = (Student)xe.ReadObject();

         xe.closeReaderXML();
         
       if (mostRecent.uscore > saved1.uscore)  
       {
           saved3 = saved2; 
           saved2 = saved1; 
           saved1 = mostRecent;
       }
       else if (mostRecent.uscore > saved2.uscore)
       {
           saved3 = saved2;
           saved2 = mostRecent;  
       }
       else if(mostRecent.uscore > saved3.uscore)
       {
           saved3 = mostRecent;
       }
       
        xe.openWriterXML("xml/scores.xml");
        xe.writeObject(saved1);
        xe.writeObject(saved2);
        xe.writeObject(saved3);
        xe.closeWriterXML(); 
        
        score1.setText(saved1.getScore());
        score2.setText(saved2.getScore());
        score3.setText(saved3.getScore());
    }
   
}
