package main.java.mapgenerator.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MapGenerator {
    public static void main(String[] args) {
        JFrame window = new JFrame();
    
        MapGeneratorGUI GUI = new MapGeneratorGUI();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("MapGenerator");
        window.setPreferredSize(new Dimension(1180, 900));

        //window.setLayout(null);
        window.add(GUI, BorderLayout.WEST);
        
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }
}
