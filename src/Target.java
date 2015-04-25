import java.awt.*;
import javax.swing.*;

public class Target extends JButton
{
    
ImageIcon imageName;
int points;

    public Target(String name, String time)
    {	
        super();
        
        imageName = new ImageIcon("images/"+name+".png");
        setIcon(imageName);
        setBorder(null); 
        setContentAreaFilled(false);
        setBounds(new Rectangle(RandomNumX(),RandomNumY(),50,50));
        if (time == "day")
        {
            switch (name) {
                case "pizza":
                    points = 3;
                    break;
                case "java":
                    points = 5;
                    break;
                case "thon":
                    points = 20;
                    break;
                case "coffee":
                    points = 1;
                    break;
                case "sleep":
                    points = -5;
                    break;
                case "football":
                    points = 1;
                    break;
                case "icecream":
                    points = 1;
                    break;
                case "ramen":
                    points = 1;
                    break;
                case "study":
                    points = 5;
                    break;
            }
        }
        if (time == "night")
        {
            switch (name) {
                case "pizza":
                    points = 2;
                    break;
                case "java":
                    points = 5;
                    break;
                case "thon":
                    points = 20;
                    break;
                case "coffee":
                    points = -5;
                    break;
                case "sleep":
                    points = 10;
                    break;
                case "football":
                    points = 1;
                    break;
                case "icecream":
                    points = 1;
                    break;
                case "ramen":
                    points = 1;
                    break;
                case "study":
                    points = 5;
                    break;
            }
        }
    }
    public int RandomNumX() 
     {
      
      double r = Math.random();
      int random = (int)(r*630); 
      return (random);
     }
    
     public int RandomNumY() 
     {
      
      double r = Math.random();
      int random = ((int)(r*510)+ 70); 
      return (random);
     }
    
    public String RandomTarget()
    {
        String name = new String();
        double r = Math.random();
        int random = (int)(r*8);
        switch (random) {
            case 0:
                name = "pizza";
                break;
            case 1:
                name = "java";
                break;
            case 2: 
                name = "coffee";
                break;
            case 3: 
                name = "sleep";
                break;
            case 4:
                name = "icecream";
                break;
            case 5:
                name = "football";
                break;
            case 6:
                name = "ramen";
                break;
            case 7:
                name = "study";
                break;
        }
        return name;
    }
    
        public ImageIcon GetPic(String time)
    {
        ImageIcon image = new ImageIcon("images/day.png");
        double r = Math.random();
        int random = (int)(r*3);

        if (time == "day")
        {
         switch (random) 
         {
            case 0:
                image = new ImageIcon("images/day.png");
                break;
            case 1:
                image = new ImageIcon("images/day2.png");
                break;
            case 2:
                image = new ImageIcon("images/day3.png");
                break;
        }
        }
        else if (time == "night")
        {
         switch (random) {
            case 0:
                image = new ImageIcon("images/night.png");
                break;
            case 1:
                image = new ImageIcon("images/night2.png");
                break;
            case 2:
                image = new ImageIcon("images/night3.png");
                break;
        }
        }
        else if (time == "grad")
        {
            image = new ImageIcon("images/gameover.png");
        }
               
        return image;
    }
            
    }