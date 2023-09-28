package main.java.mapgenerator.GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Grid extends JPanel {
    private int rowTiles;
    private int colTiles;
    private MapGeneratorGUI panel;
    
    public Grid(int rowTiles, int colTiles, MapGeneratorGUI panel){
        this.rowTiles = rowTiles;
        this.colTiles = colTiles;
        this.panel = panel;

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e){
                calculateSize();
            }
        });
    }

    public void calculateSize(){
        int sizeX = panel.getSize().width;
        int xSize = sizeX/rowTiles;

        setLayout(new GridLayout(rowTiles, colTiles));
        Dimension buttonSize = new Dimension(xSize,xSize);
        
        for (int i = 0; i < rowTiles; i++) {
            for(int j = 0; j < colTiles; j++){
            JButton button = new JButton();
            button.setPreferredSize(buttonSize);
            add(button);
            }
        }
    }
}
