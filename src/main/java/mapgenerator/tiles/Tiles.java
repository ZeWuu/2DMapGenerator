package main.java.mapgenerator.TILES;


public enum Tiles {
    GOLDEN_GRASS(0),
    GOLDEN_TREE(1),
    WATER(2),
    BRICK_WALL(3),
    SAND(4),
    ROAD(5);

    private final int value;

    Tiles(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
