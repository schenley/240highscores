
import javax.swing.*;

public class Student2 extends JButton {

    String udiff;
    String uav;
    String uname;
    Integer uscore = 0;

    public Student2(String a, String c, String n, Integer d) {
        super();
        udiff = a;
        uav = c;
        uname = n;
        uscore = d;
        
    }

    public Student2() {

    }
  
    public String getUdiff() {
        return udiff;
    }

    public void setUdiff(String udiff) {
        this.udiff = udiff;
    
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


    String getScore() {
        return uscore + "  -  "+ uname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
