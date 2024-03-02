package main.java.mapgenerator.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

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

        window.add(GUI, BorderLayout.WEST);
        window.add(tilesPanel, BorderLayout.EAST);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
