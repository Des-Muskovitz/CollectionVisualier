package main.java.com.CollectionVisualizer;


import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String args[]) throws IOException {
        //Set default Size of cells
        final int HEIGHT_OF_CELL = 250;
        final int WIDTH_OF_CELL = 250;

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
        Map<Integer, String> testMap2 = converter.converter(stringArray);


        //Create GridLayout with maximum Columns of 2 and no max row size

        CollectionVisualizer visualizerNoImage = new CollectionVisualizer();
        CollectionVisualizer visualizerWithImage = new CollectionVisualizer("C:\\Users\\Student\\Desktop", "png", "Collection");

        List<Student> list = Arrays.asList(students);
        visualizerWithImage.displayCollection(FONT_USED, students);
    }


}
