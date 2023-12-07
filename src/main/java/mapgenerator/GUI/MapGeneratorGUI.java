package main.java.mapgenerator.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import main.java.mapgenerator.TILES.Tile;

public class MapGeneratorGUI extends JPanel {
    
    final int panelWidth = 800;
    final int panelHeight = 800; 
    final int rowTiles = 64;
    final int colTiles = 64;
  
    public Tile selectedTile;
    private Grid gr= new Grid(rowTiles, colTiles, this);


    public MapGeneratorGUI(){
        selectedTile = null;

        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        setLayout(new BorderLayout());
        add(gr);
        
    }
}
