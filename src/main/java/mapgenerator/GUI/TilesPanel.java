package main.java.mapgenerator.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.java.mapgenerator.TILES.Tile;
import main.java.mapgenerator.TILES.Tiles;

public class TilesPanel extends JPanel {

        final int panelWidth = 1300;
        final int panelHeight = 100;
        Map<Tiles, Tile> tiles = new HashMap<Tiles, Tile>();
        private static ImageIcon selectedImage;
        private static Tiles selectedTile;
        Grid panel;

        public TilesPanel(Grid panel) {
                this.panel = panel;
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
                                        .image(new ImageIcon(Thread.currentThread().getContextClassLoader()
                                                        .getResource("./main/resources/tiles/GoldenGrass.png")))
                                        .build());
                        tiles.put(Tiles.GOLDEN_TREE, new Tile.builder()
                                        .image(new ImageIcon(Thread.currentThread().getContextClassLoader()
                                                        .getResource("./main/resources/tiles/GoldenTree.png")))
                                        .build());
                        tiles.put(Tiles.WATER, new Tile.builder()
                                        .image(new ImageIcon(Thread.currentThread().getContextClassLoader()
                                                        .getResource("./main/resources/tiles/Water.png")))
                                        .build());
                        tiles.put(Tiles.BRICK_WALL, new Tile.builder()
                                        .image(new ImageIcon(Thread.currentThread().getContextClassLoader()
                                                        .getResource("./main/resources/tiles/BrickWall.png")))
                                        .build());
                        tiles.put(Tiles.SAND, new Tile.builder()
                                        .image(new ImageIcon(Thread.currentThread().getContextClassLoader()
                                                        .getResource("./main/resources/tiles/Sand.png")))
                                        .build());
                        tiles.put(Tiles.ROAD, new Tile.builder()
                                        .image(new ImageIcon(Thread.currentThread().getContextClassLoader()
                                                        .getResource("./main/resources/tiles/Road.png")))
                                        .build());
                        tiles.put(Tiles.LIGHT_BRICK_ROAD, new Tile.builder()
                                        .image(new ImageIcon(Thread.currentThread().getContextClassLoader()
                                                        .getResource("./main/resources/tiles/LightBrickRoad.png")))
                                        .build());
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        public void iconButtons() {

                Dimension buttonSize = new Dimension(45, 45);
                for (Tiles tile : Tiles.values()) {
                        Tile tileData = tiles.get(tile);
                        if (tileData != null && tileData.image != null) {
                                Image originalImage = tileData.image.getImage();
                                Image resizedImage = originalImage.getScaledInstance(
                                                buttonSize.width, buttonSize.height, Image.SCALE_SMOOTH);
                                ImageIcon resizedIcon = new ImageIcon(resizedImage);

                                JButton button = new JButton(resizedIcon);
                                button.setPreferredSize(buttonSize);
                                button.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(java.awt.event.ActionEvent e) {
                                                selectedImage = tileData.image;
                                                selectedTile = tile;
                                        }

                                });
                                add(button);
                        }
                }
                JButton button = new JButton();
                button.setPreferredSize(buttonSize);
                button.addActionListener(e -> selectedImage = null);
                add(button);
                SaveButton saveButton = new SaveButton(panel);
                add(saveButton);
        }

        public static ImageIcon getSelectedImage() {
                return selectedImage;
        }

        public static Tiles getSelectedTile() {
                return selectedTile;
        }

        public Tile getTileData(Tiles tile) {
                return tiles.get(tile);
        }

}
