package main.java.com.CollectionVisualizer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class CollectionVisualizer <T>{

    private String pathToSaveImages;
    private String fileType;
    final private static int WIDTH_OF_CELL = 500;
    final private static int HEIGHT_OF_CELL = 500;

    //Constructor with path to save images
    public CollectionVisualizer(String pathToSaveImages, String fileType) {
        this.pathToSaveImages = pathToSaveImages;
        this.fileType = fileType;
    }

    //constructor without path to save images
    public CollectionVisualizer(){
        this.pathToSaveImages = null;
        this.fileType = null;
    }


    //getter for pathToSaveImages
    public String getPathToSaveImages() {
        return pathToSaveImages;
    }

    //setter for pathToSaveImages
    public void setPathToSaveImages(String pathToSaveImages) {
        this.pathToSaveImages = pathToSaveImages;
    }

    //converter for use in converting all passed in collections into a Map<T, T>
    final private Converter converter = new Converter();

    //Public call methods to convert collections and run the code
    public void displayCollection(int heightOfCell, int widthOfCell, Font fontUsed, Iterable<T> list) throws IOException {
        Map<T, T> passedList = converter.converter(list);
        displayArrayList(heightOfCell, widthOfCell, fontUsed, passedList);
    }

    public void displayCollection(int heightOfCell, int widthOfCell, Font fontUsed, Object[] array) throws IOException {
        Map<T, T> passedArray = converter.converter(List.of(array));
        displayArrayList(heightOfCell, widthOfCell, fontUsed, passedArray);
    }

    public void displayCollection(int heightOfCell, int widthOfCell, Font fontUsed, Map<T,T> map) throws IOException {
        displayArrayList(heightOfCell, widthOfCell, fontUsed, map);
    }

    public void displayCollection(Font fontUsed, Iterable<T> list) throws IOException {
        Map<T, T> passedList = converter.converter(list);
        displayArrayList(HEIGHT_OF_CELL, WIDTH_OF_CELL, fontUsed, passedList);
    }

    public void displayCollection(Font fontUsed, Object[] array) throws IOException {
        Map<T, T> passedArray = converter.converter(List.of(array));
        displayArrayList(HEIGHT_OF_CELL, WIDTH_OF_CELL, fontUsed, passedArray);
    }

    public void displayCollection(Font fontUsed, Map<T,T> map) throws IOException {
        displayArrayList(HEIGHT_OF_CELL, WIDTH_OF_CELL, fontUsed, map);
    }

    private void displayArrayList(int heightOfCell, int widthOfCell, Font fontUsed, Map<T, T> map) throws IOException {

        boolean saveImage = this.pathToSaveImages != null;

        GridLayout gridLayout = new GridLayout(0, 2);

        //Create an ArrayList of JTextArea's and set all properties of them at creation
        List<JTextArea> jTextAreas = new ArrayList<>();

        int length = 0;
        Set<T> keySet = map.keySet();
        for(T key : keySet){
            jTextAreas.add(length, new JTextArea());
            jTextAreas.get(length).setText(map.get(key).toString());
            jTextAreas.get(length).setLineWrap(true);
            jTextAreas.get(length).setWrapStyleWord(true);
            jTextAreas.get(length).setFont(fontUsed);
            jTextAreas.get(length).setEditable(false);
            length++;
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
        JFrame frame = new JFrame("Collection Visualizer");

        //Set size and default operation for JFrame, and Add jPanel to JFrame
        frame.add(jPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(widthOfCell * length, heightOfCell * length));
        //Display Frame
        frame.setVisible(true);

        System.out.println(saveImage);
        System.out.println(this.pathToSaveImages);

        if(saveImage){
            BufferedImage collection = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = collection.createGraphics();
            frame.paint(graphics2D);
            try {
                File file = new File(this.pathToSaveImages);
                //file.getParentFile().mkdir();
                ImageIO.write(collection, fileType, file);
            } catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }
    }
}
