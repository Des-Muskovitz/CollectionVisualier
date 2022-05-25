package main.java.com.CollectionVisualizer;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

    public static void main(String args[]) throws IOException {
        String imagePath = "src\\main\\java\\com\\CollectionVisualizer\\2.png";
        BufferedImage myPicture = ImageIO.read(new File(imagePath));

        Graphics2D g = (Graphics2D) myPicture.getGraphics();
        g.setColor(Color.BLACK);
        g.setFont(Font.getFont(Font.MONOSPACED));
        g.drawString("Hello World!", 0, 0);

        JLabel picLabel = new JLabel(new ImageIcon(myPicture));

        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(new Dimension(myPicture.getWidth(), myPicture.getHeight()));
        f.add(jPanel);
        f.setVisible(true);
    }
}
