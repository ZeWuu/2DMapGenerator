package main.java.mapgenerator.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

import main.java.mapgenerator.tiles.Tile;

public class MapGeneratorGUI extends JPanel {
    
    final int panelWidth = 800;//1280;
    final int panelHeight = 800; //800;
    final int rowTiles = 64;
    final int colTiles = 64;
  
    public Tile selectedTile;
    public JPanel mapPanel;
    private Grid gr= new Grid(rowTiles, colTiles, this);
    //private ScrollBars sb = new ScrollBars(this);

    public MapGeneratorGUI(){
        selectedTile = null;

        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        setLayout(new BorderLayout());
        add(gr);
        //add(gr,BorderLayout.CENTER);

        //add(sb.getScrollBarV(), BorderLayout.EAST);
        //add(sb.getScrollBarH(), BorderLayout.SOUTH);
        

    }
}
