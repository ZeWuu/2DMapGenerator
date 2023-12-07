package main.java.mapgenerator.GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.java.mapgenerator.TILES.Tile;
import main.java.mapgenerator.TILES.Tiles;

public class TilesPanel extends JPanel{
    
    final int panelWidth = 500;
    final int panelHeight = 800; 
    Map<Tiles, Tile> tiles = new HashMap<Tiles, Tile>();
    private static ImageIcon selectedImage;
    
    public TilesPanel(){
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        getTileImage();
        iconButtons();
  
    }
    public void getTileImage() {
        try {
            tiles.put(Tiles.GOLDEN_GRASS, new Tile.builder()
                    .image(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("./main/resources/tiles/GoldenGrass.png")))
                    .build());
            tiles.put(Tiles.GOLDEN_TREE, new Tile.builder()
                    .image(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("./main/resources/tiles/GoldenTree.png")))
                    .build());
            tiles.put(Tiles.WATER, new Tile.builder()
                    .image(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("./main/resources/tiles/Water.png")))
                    .build());
            tiles.put(Tiles.BRICK_WALL, new Tile.builder()
                    .image(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("./main/resources/tiles/BrickWall.png")))
                    .build());
            tiles.put(Tiles.SAND, new Tile.builder()
                    .image(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("./main/resources/tiles/Sand.png")))
                    .build());
            tiles.put(Tiles.ROAD, new Tile.builder()
                    .image(new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("./main/resources/tiles/Road.png")))
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void iconButtons(){
     
        Dimension buttonSize = new Dimension(50, 50);
        for (Tiles tile : Tiles.values()) {
            Tile tileData = tiles.get(tile);
            if (tileData != null && tileData.image != null) {
                Image originalImage = tileData.image.getImage();
                Image resizedImage = originalImage.getScaledInstance(
                    buttonSize.width, buttonSize.height, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);
                
                JButton button = new JButton(resizedIcon);
                button.setPreferredSize(buttonSize);
                button.addActionListener(e -> selectedImage = resizedIcon);
                add(button);
            }    
            }
        }
    
    public static ImageIcon getSelectedImage(){
        return selectedImage;
    }

    
}
