
import javax.swing.*;
import java.awt.*;

public class Instructions extends myJPanel {

    private String instructions, instructionsLineItemOne, instructionsLineItemTwo, instructionsLineItemThree,
            instructionsLineItemFour, instructionsLineItemFive, instructionsLineItemSix, instructionsLineItemSeven;
    JLabel jl;
    XML_240 xe;
    GButton2 jbtitle, targets;
    
    public Instructions() {
        super();
        jbtitle = new GButton2("insttitle");
        add(jbtitle);
        xe = new XML_240();
        
        setBackground(Color.white);

        readFromXmlFile();
        JLabel jl = new JLabel();

        jl.setText("<html><body><ul><li>" + getInstructionsLineItemOne() + " </li><li> " + getInstructionsLineItemTwo()
                + "</li><li>" + getInstructionsLineItemThree() + "</li><li>" + getInstructionsLineItemFour() + "</li><li>" + getInstructionsLineItemFive()
                + "</li><li>" + getInstructionsLineItemSix() + " </li><li>" + getInstructionsLineItemSeven() + "</ul></html></body>");

        setBackground(Color.white);
        add(jl);
        targets = new GButton2("targetsinfo");
        add(targets);
        

    }

     public void readFromXmlFile() {
        xe.openReaderXML("xml/instructions.xml");
        setInstructionsLineItemOne((String) xe.ReadObject());
        setInstructionsLineItemTwo((String) xe.ReadObject());
        setInstructionsLineItemThree((String) xe.ReadObject());
        setInstructionsLineItemFour((String) xe.ReadObject());
        setInstructionsLineItemFive((String) xe.ReadObject());
        setInstructionsLineItemSix((String) xe.ReadObject());
        setInstructionsLineItemSeven((String) xe.ReadObject());
        xe.closeReaderXML();
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getInstructionsLineItemOne() {
        return instructionsLineItemOne;
    }

    public void setInstructionsLineItemOne(String instructionsLineItemOne) {
        this.instructionsLineItemOne = instructionsLineItemOne;
    }

    public String getInstructionsLineItemTwo() {
        return instructionsLineItemTwo;
    }

    public void setInstructionsLineItemTwo(String instructionsLineItemTwo) {
        this.instructionsLineItemTwo = instructionsLineItemTwo;
    }

    public String getInstructionsLineItemThree() {
        return instructionsLineItemThree;
    }

    public void setInstructionsLineItemThree(String instructionsLineItemThree) {
        this.instructionsLineItemThree = instructionsLineItemThree;
    }

    public String getInstructionsLineItemFour() {
        return instructionsLineItemFour;
    }

    public void setInstructionsLineItemFour(String instructionsLineItemFour) {
        this.instructionsLineItemFour = instructionsLineItemFour;
    }

    public String getInstructionsLineItemFive() {
        return instructionsLineItemFive;
    }

    public void setInstructionsLineItemFive(String instructionsLineItemFive) {
        this.instructionsLineItemFive = instructionsLineItemFive;
    }

    public String getInstructionsLineItemSix() {
        return instructionsLineItemSix;
    }

    public void setInstructionsLineItemSix(String instructionsLineItemSix) {
        this.instructionsLineItemSix = instructionsLineItemSix;
    }

    public String getInstructionsLineItemSeven() {
        return instructionsLineItemSeven;
    }

    public void setInstructionsLineItemSeven(String instructionsLineItemSeven) {
        this.instructionsLineItemSeven = instructionsLineItemSeven;
    }
}
