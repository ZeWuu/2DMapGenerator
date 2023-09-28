package main.java.mapgenerator.tiles;

import javax.swing.ImageIcon;

public class Tile {
    private int id;
    private ImageIcon image;

    public Tile(int id, ImageIcon image){
        this.id = id;
        this.image = image;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public ImageIcon getImage(){
        return image;
    }
    public void setImage(ImageIcon image){
        this.image = image;
    }
}
