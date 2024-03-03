package main.java.mapgenerator.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;


import javax.swing.JFrame;

public class MapGenerator {
    public static void main(String[] args) throws IOException {

        JFrame window = new JFrame();

        Grid GUI = new Grid();
        TilesPanel tilesPanel = new TilesPanel(GUI);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("MapGenerator");
        window.setPreferredSize(new Dimension(1300, 900));
        window.setLayout(new FlowLayout());

        window.add(GUI);
        window.add(tilesPanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
