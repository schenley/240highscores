
import javax.swing.*;

public class Student extends JButton {

    String udiff;
    String ulength;
    String uav;
    String uname;
    Integer uscore = 0;

    public Student(String a, String b, String c, String n, Integer d) {
        super();
        udiff = a;
        ulength = b;
        uav = c;
        setUname(n);
        uscore = d;
        
        ImageIcon img = new ImageIcon("images/" + uav + ".png");
        setIcon(img);
        setBorder(null);
        setContentAreaFilled(false);
    }

    public Student() {

    }
  
    public String getUdiff() {
        return udiff;
    }

    public void setUdiff(String udiff) {
        this.udiff = udiff;
    }

    public String getUlength() {
        return ulength;
    }

    public void setUlength(String ulength) {
        this.ulength = ulength;
    }

    public String getUav() {
        return uav;
    }

    public void setUav(String uav) {
        this.uav = uav;
    }

    public Integer getUscore() {
        return uscore;
    }

    public void setUscore(Integer uscore) {
        this.uscore = uscore;
    }

    String getInfo() {
        return "Difficulty: " + udiff + ", Play Length: " + ulength + ", Avatar: " + uav;
    }
    String getScore() {
        return uname + ": "+ uscore;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
