package main.java.mapgenerator.TILES;

import javax.swing.ImageIcon;

public class Tile {
 
    public ImageIcon image; 

    public static class builder {
        Tile tile;

        public builder() {
            tile = new Tile();
        }

        public Tile build() {
            return tile;
        }

        public builder image(ImageIcon image) {
            tile.image = image;
            return this;
        }

    }
}
