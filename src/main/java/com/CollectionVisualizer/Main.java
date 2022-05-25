package main.java.com.CollectionVisualizer;


import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;


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


        String[] stringArray = new String[] {"Hello", "World", "All Strings Showing"};
        Double[] ints = new Double[] {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,90.0};

        Student[] students = new Student[] {new Student(1, "Sam", "123 home", new int[] {1,2,3,4,5})};

        Converter converter = new Converter();

        Map<Integer, String> testMap = converter.converter(test);


        //Create GridLayout with maximum Columns of 2 and no max row size

        CollectionVisualizer visualizer = new CollectionVisualizer();

        List<Student> list = Arrays.asList(students);
        visualizer.displayArrayList(HEIGHT_OF_CELL, WIDTH_OF_CELL, FONT_USED, test);
    }


}
