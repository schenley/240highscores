import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Game extends myJPanel implements KeyListener, ActionListener {

    Student st1;
    Student2 scorer;
    Scores scores;
    JLabel jl1, gtlabel, gttotalset, gtscore;
    int x = 100;
    int y = 100;
    int gtmax;

    XML_240 xe;
    String tod;
    myJTabbedPane mjtp;
    
    Target mt1;
    Target[] t;   
    
    ImageIcon sourceImage1, sourceImage2, sourceImage3;
    Image daypic, nightpic, gradpic;

    Timer intervalTime, mover, gtcounter; 
    
    int delay = 1000, gtdelay = 1000;
    int interval = 0, gcinterval = 0, points = 0;

    Boolean[] boolt;     
    Boolean boolmt1 = false, playStopped = false;

    
    public Game(Student passed, Scores passedScores) {
        st1 = passed;
        scores = passedScores;
   
        xe = new XML_240();
        intervalTime = new Timer(setDifficultyLevel(st1.udiff), this);
        intervalTime.start();
        mover = new Timer(5000, this); //high value THON target movement
        mover.start();

        setLayout(null);
        setBackground(Color.white);
        
        tod = "day";
        
        mt1 = new Target("thon", tod);        
        add(mt1);
        
        sourceImage1 = mt1.GetPic("day");
        daypic = sourceImage1.getImage();
        sourceImage2 = mt1.GetPic("night");
        nightpic = sourceImage2.getImage();
        sourceImage3 = mt1.GetPic("grad");
        gradpic = sourceImage3.getImage();

        gttotalset = new JLabel("   ");  //gt stands for game timer, this will show game time option
        gttotalset.setBounds(420, 10, 250, 20);  //this will position gttotalset on the screen
        add(gttotalset);
        gtlabel = new JLabel("Time Elapsed: ");  //this will display the live time counter minutes/seconds
        gtlabel.setBounds(420, 30, 250, 20);
        add(gtlabel);
        gtscore = new JLabel("Your score: ");   // this will display the scores in real time as targets are aquired
        gtscore.setBounds(420, 50, 250, 20);
        add(gtscore);
        gtcounter = new Timer(gtdelay, this);  // gtcounter is game timer in seconds, gtdelay is set at 1 second delay
        gtcounter.start();
        add(st1);
        st1.setBounds(new Rectangle(x, y, 50, 50));  //initial position of the student object, x=y=100

        jl1 = new JLabel(); //this will display all info about the chosen game options: avatar, diff, etc.
        add(jl1);
        jl1.setBounds(new Rectangle(0, 0, 400, 30));
        jl1.setText(st1.getInfo());
        jl1.setForeground(Color.blue);

        setFocusable(true);
        addKeyListener(this);
        

        
        t = new Target[12]; 
        boolt = new Boolean[12];
      
        //these arrays set up Randomized targets and assign the boolean values
        
        for (int i = 0; i<12; i++)
        {
            t[i] = new Target(mt1.RandomTarget(), tod);
            add(t[i]);
            boolt[i] = false;
        }

    }
    

    public int setDifficultyLevel(String diffLevel) {           //sets the difficulty level via the dedicated function, themes will change at a predefined intervals, easy 30 secs, etc
        if (diffLevel.equals("Easy")) {
            interval = 30000;
        } else if (diffLevel.equals("Medium")) {
            interval = 20000;
        } else if (diffLevel.equals("Hard")) {
            interval = 10000;
        }
        return interval;
    }

    //==========================================================================
    @Override
    public void keyPressed(KeyEvent evt) {
        //	the number controls how fast the avatar moves, for example 3 pixels at a time
        int kk = evt.getKeyCode();
        if (kk == evt.VK_LEFT) {
            x = x - 3;
        }
        if (kk == evt.VK_RIGHT) {
            x = x + 3;
        }
        if (kk == evt.VK_UP) {
            y = y - 3;
        }
        if (kk == evt.VK_DOWN) {
            y = y + 3;
        }
        st1.setBounds(new Rectangle(x, y, 50, 50));

//----------statements to make touched targets disappear and add points -------

        for (int i = 0; i<12; i++)
        {
            if ((t[i].getX() <= (st1.getX() + 25) && st1.getX() <= (t[i].getX() + 50)) && (t[i].getY() <= (st1.getY() + 25) && st1.getY() <= (t[i].getY() + 50))) 
                 
            {
                if (boolt[i] == false) {
                    points = (points + t[i].points);
                    gtscore.setText("Your Score: " + points);
                    remove(t[i]);
                    repaint();
                    boolt[i] = true;
                }
            }
        }
        if ((mt1.getX() <= (st1.getX() + 25) && st1.getX() <= (mt1.getX() + 50)) && (mt1.getY() <= (st1.getY() + 25) && st1.getY() <= (mt1.getY() + 50))) 
        {
            if (boolmt1 == false) {
                points = (points + mt1.points);
                gtscore.setText("Your Score: " + points);
                repaint();
                boolmt1 = true;
                remove(mt1);
                repaint();
            }
        }
        if (st1.getX() >= 675)
        {
            st1.setBounds(new Rectangle(0, st1.getY(), 50, 50));
            x = 0;
        }  
        if (st1.getX() <= -25)
        {
            st1.setBounds(new Rectangle(674, st1.getY(), 50, 50));
            x = 674;
        } 
        if (st1.getY() >= 674)
        {
            st1.setBounds(new Rectangle(st1.getX(), 70 , 50, 50));
            y = 70;
        } 
        if (st1.getY() <= 45)
        {
            st1.setBounds(new Rectangle(st1.getX(), 674 , 50, 50));
            y = 674;
        } 
    }


    public void keyReleased(KeyEvent evt) { }

    public void keyTyped(KeyEvent evt) { }

    //============================================================================
    @Override
    public void actionPerformed(ActionEvent event) {
        Object obj = event.getSource();
        if (obj == intervalTime) {  
            // This codes 'refreshes' targets at every theme interval, it removes all existing (remaining) targets and sets new
            for (int i = 0; i<12; i++)
            {
                remove(t[i]);
            }
            
            remove(mt1);

            if (getBackground()== Color.white) {
                setBackground(Color.black);
                tod = "night";
                gtlabel.setForeground(Color.white);
                gtscore.setForeground(Color.white);
                gttotalset.setForeground(Color.white);
            } 
            else if (getBackground() == Color.black) {
                setBackground(Color.white);
                tod = "day";
                gtlabel.setForeground(Color.black);
                gtscore.setForeground(Color.black);
                gttotalset.setForeground(Color.black);
            }

            for (int i = 0; i<12; i++)
            {
                t[i] = new Target(mt1.RandomTarget(), tod);
                add(t[i]);
                boolt[i] = false;
            }

            mt1 = new Target("thon", tod);
            boolmt1 = false;
            add(mt1);
        }


        if (obj == mover) {
            mt1.setBounds(mt1.RandomNumX(), mt1.RandomNumY(), 50, 50);
        }

        if (obj == gtcounter) 
        {
            gcinterval++;
            if (gtmax == gcinterval) 
            {
                gtcounter.stop();
                intervalTime.stop();
                mover.stop();
                for (int i = 0; i<12; i++)
                {
                    remove(t[i]);
                }
                remove(mt1);
                remove(st1);
                remove(jl1);
                
                tod = "grad";
                st1.uscore = points;
                
                repaint();
                playStopped = true;
               scorer = new Student2(st1.udiff, st1.uav, st1.uname, st1.uscore); 
               scores.calcHighScores(scorer);

                // Other code to stop the rest of the game and abort all functions

        
   }
            }
            if (gcinterval < 60) {
                gtlabel.setText("Time elapsed: " + gcinterval + " seconds");
            } else {
                gtlabel.setText("Time elapsed: " + (int) (gcinterval / 60) + " minute(s) " + gcinterval % 60 + " second(s)");
            }
        }
    


    //============================================================================
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
        
        if (tod == "day") {
            g.drawImage(daypic, 0, 70, this);
            g.drawRect(0, 70, 700, 630);
        }
        if (tod == "night") {
            g.drawImage(nightpic, 0, 70, this);
            g.drawRect(0, 70, 700, 630);
        }
        if (tod =="grad"){
            g.drawImage(gradpic, 0, 0, this);
        }

    
    }
}



