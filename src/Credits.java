
import java.awt.*;
import javax.swing.*;

public class Credits extends myJPanel {

    JLabel jl1, jl2;
    XML_240 xe;
    JTextArea textArea;
    GButton2 jbtitle;

    private String programmerOneName, programmerOneTitle, programmerTwoName, programmerTwoTitle,
            programmerThreeName, programmerThreeTitle;

    public Credits() {
        super();
        
        setLayout(null);
        setBackground(Color.white);
        
        xe = new XML_240();
        jbtitle = new GButton2("creditstitle");
        add(jbtitle);
        jbtitle.setBounds(new Rectangle(-10,0,700,150));
        
        jl1 = new JLabel("IST 240 Team2 members:");
        add(jl1);
        jl1.setBounds(new Rectangle(20,160,200,20));
        
        jl2 = new JLabel();

        readFromXmlFile();
        jl2.setText("<html><body><ul><li>" + getProgrammerOneTitle() + " : " + getProgrammerOneName() + "</li><li>" + getProgrammerTwoTitle() + " : " + getProgrammerTwoName() + "</li><li>" + getProgrammerThreeTitle() + " : " + getProgrammerThreeName() + "</li></ul></html></body>");
        add(jl2);
        jl2.setBounds(new Rectangle(0,180,350,100));

         textArea = new JTextArea("Font\n" +
        "http://www.fontspace.com/codeman38/press-start-2p\n" +
        "Copyright (c) 2011, Cody \"CodeMan38\" Boisclair (cody@zone38.net),\n" +
        "with Reserved Font Name \"Press Start\".\n" +
        "\n" +
        "Image Sources:\n" +
        "\n" +
        "Lion logo\n" +
        "http://upload.wikimedia.org/wikipedia/en/3/36/Penn_State_Nittany_Lions.svg\n" +
        "\n" +
        "Pawprint\n" +
        "http://img.ecomplatform.com/scs/images/products/15/large/penn_state_car_magnet_large_new_paw_nittany_lions_psu_p5574.jpg\n" +
        "\n" +
        "Mascot\n" +
        "http://img.ecomplatform.com/scs/images/products/15/large/penn_state_nittany_lion_mascot_car_magnet_3_5_inch_nittany_lions_psu_p4374.jpg\n" +
        "\n" +
        "THON logo\n" +
        "http://onwardstate.com/wp-content/uploads/2010/05/THON-Logo.jpg\n" +
        "\n" +
        "Java book\n" +
        "http://proquestcombo.safaribooksonline.com.ezaccess.libraries.psu.edu/book/programming/java/9780132841641\n" +
        "\n" +
        "Pizza\n" +
        "by Schenley\n" +
        "\n" +
        "Ice cream\n" +
        "http://pabook.libraries.psu.edu/palitmap/Creamery.html\n" +
        "\n" +
        "coffee\n" +
        "http://www.amazon.com/State-Nittany-Lions-Steel-Travel/dp/B00A3NZYWI\n" +
        "\n" +
        "bed\n" +
        "http://cliparts.co/clipart/2436222\n" +
        "\n" +
        "football\n" +
        "http://www.clipartpanda.com/clipart_images/downloads-1422434\n" +
        "\n" +
        "stadium\n" +
        "https://www.e-education.psu.edu/geosc10/l10.html\n" +
        "\n" +
        "ramen\n" +
        "http://i.huffpost.com/gadgets/slideshows/321384/slide_321384_3015740_free.jpg\n" +
        "\n" +
        "textbooks \n" +
        "http://www.tgslc.org/blog/post.cfm/textbooks-challenges-and-solutions-to-unexpected-expenses\n" +
        "\n" +
        "");
      //  add(textArea);
    //=====================================
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setOpaque(false);
        textArea.setEditable(false); 
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        scrollPane.setBounds(new Rectangle(0,300,680,325));
                
    }

    public void readFromXmlFile() {
        xe.openReaderXML("xml/credits.xml");
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

