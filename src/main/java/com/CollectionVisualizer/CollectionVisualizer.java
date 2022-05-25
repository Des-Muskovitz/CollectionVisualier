package main.java.com.CollectionVisualizer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionVisualizer <T>{

    public void displayArrayList(int heightOfCell, int widthOfCell, Font fontUsed, Iterable<T> list) {

        Iterator<T> iterator = list.iterator();
        GridLayout gridLayout = new GridLayout(0, 2);

        //Create an ArrayList of JTextArea's and set all properties of them at creation
        List<JTextArea> jTextAreas = new ArrayList<>();

        int length = 0;
        while(iterator.hasNext()){
            T value = iterator.next();
            jTextAreas.add(length, new JTextArea());
            jTextAreas.get(length).setText(value.toString());
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
