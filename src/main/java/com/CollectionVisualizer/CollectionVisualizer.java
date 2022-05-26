package main.java.com.CollectionVisualizer;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class CollectionVisualizer <T>{

    private Converter converter = new Converter();

    public void displayCollection(int heightOfCell, int widthOfCell, Font fontUsed, Iterable<T> list){
        Map<T, T> passedList = converter.converter(list);
        displayArrayList(heightOfCell, widthOfCell, fontUsed, passedList);
    }

    public void displayCollection(int heightOfCell, int widthOfCell, Font fontUsed, Object[] array){
        Map<T, T> passedArray = converter.converter(List.of(array));
        displayArrayList(heightOfCell, widthOfCell, fontUsed, passedArray);
    }

    public void displayCollection(int heightOfCell, int widthOfCell, Font fontUsed, Map<T,T> map){
        displayArrayList(heightOfCell, widthOfCell, fontUsed, map);
    }

    private void displayArrayList(int heightOfCell, int widthOfCell, Font fontUsed, Map<T, T> map) {

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
        JFrame frame = new JFrame();

        //Set size and default operation for JFrame, and Add jPanel to JFrame
        frame.add(jPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(widthOfCell * length, heightOfCell * length));
        //Display Frame
        frame.setVisible(true);
    }
}
