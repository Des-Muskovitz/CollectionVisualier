package main.java.com.CollectionVisualizer;


import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class Main {

    public static void main(String args[]){
//        final int WIDTH_OF_CELL = 100;
//        final int HEIGHT_OF_CELL = 200;
//        FontMetrics fontMetrics;
//
//        String imagePath = "src\\main\\java\\com\\CollectionVisualizer\\2.png";
//        BufferedImage myPicture = ImageIO.read(new File(imagePath));
//
//        List<String> test = new ArrayList<>();
//        test.add("Hello");
//        test.add("World");
//        test.add("This is a proof of concept");
//
//        Graphics2D g = (Graphics2D) myPicture.getGraphics();
//        g.setColor(Color.WHITE);
//
//        g.fillRect(0,0,WIDTH_OF_CELL * test.size(), HEIGHT_OF_CELL * test.size());
//        g.setColor(Color.RED);
//        g.setFont(Font.getFont(Font.MONOSPACED));
//        g.drawString("Hello World", 5, 5);
//        for(int i = 0; i < test.size(); i++){
//            fontMetrics = g.getFontMetrics();
//            int x = (WIDTH_OF_CELL * (i + 1) - fontMetrics.stringWidth(test.get(i)));
//            int y = (HEIGHT_OF_CELL * (i + 1) - fontMetrics.getHeight());
//            g.drawString(test.get(i), x, y);
//        }
//
//
//
//        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
//
//        JPanel jPanel = new JPanel();
//        jPanel.add(picLabel);
//
//        JFrame f = new JFrame();
//        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        f.setSize(new Dimension(WIDTH_OF_CELL * test.size(), HEIGHT_OF_CELL * test.size()));
//        f.add(jPanel);
//        f.setVisible(true);

        //Set default Size of cells
        final int HEIGHT_OF_CELL = 75;
        final int WIDTH_OF_CELL = 150;

        final Font FONT_USED = Font.getFont(Font.MONOSPACED); //Set Default Font

        //Create ArrayList for use in test
        List<String> test = new ArrayList<>();
        test.add("Hello");
        test.add("World");
        test.add("All Strings Showing");
        test.add("test");
        test.add("What happens if I wrap around text, like what happens when this text is too long to fit in a single cell?");

        //Create GridLayout with maximum Columns of 2 and no max row size
        GridLayout gridLayout = new GridLayout(0, 2);

        //Create an ArrayList of JTextArea's and set all properties of them at creation
        List<JTextArea> jTextAreas = new ArrayList<>();
        for(int i = 0; i < test.size(); i++){
            jTextAreas.add(i, new JTextArea());
            jTextAreas.get(i).setText(test.get(i));
            jTextAreas.get(i).setLineWrap(true);
            jTextAreas.get(i).setWrapStyleWord(true);
            jTextAreas.get(i).setFont(FONT_USED);
        }

        //Create a new JPanel using the GridLayout Created earlier
        JPanel jPanel = new JPanel(gridLayout);


        //Insert headers into above each Index and Each Value
        jPanel.add(new JTextArea("Indexes"));
        jPanel.add(new JTextArea("Values"));

        //Iterate through Each created JTextArea and add it into the JPanel
        for(int i = 0; i < jTextAreas.size(); i++){
            jPanel.add(new JTextArea(Integer.toString(i)));
            jPanel.add(jTextAreas.get(i));
        }

        //create the JFrame for displaying data
        JFrame frame = new JFrame();

        //Set size and default operation for JFrame, and Add jPanel to JFrame
        frame.add(jPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(WIDTH_OF_CELL * test.size(), HEIGHT_OF_CELL * test.size()));
        //Display Frame
        frame.setVisible(true);
    }
}
