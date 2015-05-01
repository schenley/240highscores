
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class myJTabbedPane extends JTabbedPane implements ActionListener {

    Home home;
    Instructions inst;
    Credits credits;
    Scores scores;
    Options options;
    Game game;
    
    Student st1 = new Student();
    String udiff, ulength, uav, uname;
    Integer uscore;
    Boolean gametabopen = false;
    ImageIcon tabH, tabI,tabC, tabS, TabO;
    
    public myJTabbedPane() {
        setBackground(Color.white);
        home = new Home();
        inst = new Instructions();
        credits = new Credits();
        scores = new Scores(st1);
        options = new Options();
        
        addTab("Home", home);
        addTab("Instructions", inst);
        addTab("Credits", credits);
        addTab("High Scores", scores);
        addTab("Options", options);
        
        options.jb1.addActionListener(this);
        home.jb1.addActionListener(this);
        home.jb2.addActionListener(this);
        scores.play.addActionListener(this);
        inst.targets.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        Object obj = event.getSource();
        if (obj == options.jb1) {
            // Code Logic: '||' indicates 'OR' , '&&' indicates 'AND'.
            // Only if all three selections are made, then clicking the 'Play' button switches to the
            // 'Game' Tab
            if ((options.jrbt1.isSelected() || options.jrbt2.isSelected() || options.jrbt3.isSelected())
                    && (options.jrbd1.isSelected() || options.jrbd2.isSelected() || options.jrbd3.isSelected())
                    && (options.jrba1.isSelected() || options.jrba2.isSelected() || options.jrba3.isSelected())) {

                udiff = options.jl1.getText();
                ulength = options.jl2.getText();
                uav = options.jl3.getText();
                uname = options.jtname.getText();
                st1 = new Student(udiff, ulength, uav, uname, uscore);
                game = new Game(st1, scores);

                if (gametabopen == false) {
                    addTab("Game", game);
                    gametabopen = true;
                } else {
                    remove(5);
                    addTab("Game", game);
                    gametabopen = true;
                }

                game.gttotalset.setText("Game Time Option: " + options.jl2.getText());
                game.gtmax = options.lengthchoice;

//switching to the 'Game' Panel - index location no#5.
                setSelectedIndex(5);

            } else {
                //Warning message notifying that the user must choose all three options (one from each category)
                // if the all three selections are NOT made
                options.jl4.setText("Make all three selections");
            }
        }
        if (obj == home.jb1) {
            setSelectedIndex(4);
        }
        if (obj == home.jb2){
            setSelectedIndex(1);
        }
        if (obj == inst.targets){
            setSelectedIndex(4);
        }
        if (obj == scores.play){
            setSelectedIndex(4);
        }
        
    }

public void panelSwitcher(int panel){
    int number = panel;
    setSelectedIndex(number);
}

}
