
import java.awt.*;

import javax.swing.*;

public class Credits extends myJPanel {

    JLabel jl1, jl2;
    XML_240 xe;

    private String programmerOneName;
    private String programmerOneTitle;
    private String programmerTwoName;
    private String programmerTwoTitle;
    private String programmerThreeName;
    private String programmerThreeTitle;
    private static String CREDITS_XML_FILE_DIR = "xml/credits.xml";

    public Credits() {
        super();

        xe = new XML_240();

        setLayout(new BorderLayout());
        setBackground(Color.white);
        jl1 = new JLabel("IST 240 Team2 members:");
        add(jl1, "North");
        jl2 = new JLabel();
        //jl2.setBorder(BorderFactory.createTitledBorder("Team Members"));

        readFromXmlFile();
        jl2.setText("<html><body><ul><li>" + getProgrammerOneTitle() + " : " + getProgrammerOneName() + "</li><li>" + getProgrammerTwoTitle() + " : " + getProgrammerTwoName() + "</li><li>" + getProgrammerThreeTitle() + " : " + getProgrammerThreeName() + "</li></ul></html></body>");
        add(jl2, "Center");

    }

    public void readFromXmlFile() {
        xe.openReaderXML(CREDITS_XML_FILE_DIR);
        setProgrammerOneTitle((String) xe.ReadObject());
        setProgrammerOneName((String) xe.ReadObject());
        setProgrammerTwoTitle((String) xe.ReadObject());
        setProgrammerTwoName((String) xe.ReadObject());
        setProgrammerThreeTitle((String) xe.ReadObject());
        setProgrammerThreeName((String) xe.ReadObject());
        xe.closeReaderXML();
    }

    public String getProgrammerOneName() {
        return programmerOneName;
    }

    public void setProgrammerOneName(String programmerOneName) {
        this.programmerOneName = programmerOneName;
    }

    public String getProgrammerOneTitle() {
        return programmerOneTitle;
    }

    public void setProgrammerOneTitle(String programmerOneTitle) {
        this.programmerOneTitle = programmerOneTitle;
    }

    public String getProgrammerTwoName() {
        return programmerTwoName;
    }

    public void setProgrammerTwoName(String programmerTwoName) {
        this.programmerTwoName = programmerTwoName;
    }

    public String getProgrammerTwoTitle() {
        return programmerTwoTitle;
    }

    public void setProgrammerTwoTitle(String programmerTwoTitle) {
        this.programmerTwoTitle = programmerTwoTitle;
    }

    public String getProgrammerThreeName() {
        return programmerThreeName;
    }

    public void setProgrammerThreeName(String programmerThreeName) {
        this.programmerThreeName = programmerThreeName;
    }

    public String getProgrammerThreeTitle() {
        return programmerThreeTitle;
    }

    public void setProgrammerThreeTitle(String programmerThreeTitle) {
        this.programmerThreeTitle = programmerThreeTitle;
    }
}
