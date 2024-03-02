package main.java.mapgenerator.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.java.mapgenerator.TILES.Tiles;

public class Grid extends JPanel {

    public JButton[][] buttons;
    public Map<JButton, Tiles> tiles = new HashMap<JButton, Tiles>();
    private int xSize;
    final int panelWidth = 800;
    final int panelHeight = 800;
    final int rowTiles = 64;
    final int colTiles = 64;

    public Grid() {

        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setBackground(Color.white);
        this.setDoubleBuffered(true);
        this.setFocusable(true);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                calculateSize();
            }
        });

        buttons = new JButton[rowTiles][colTiles];
        for (int i = 0; i < rowTiles; i++) {
            for (int j = 0; j < colTiles; j++) {
                buttons[i][j] = new JButton();
            }
        }

    }

    public void calculateSize() {
        int sizeX = this.getSize().width;
        xSize = sizeX / rowTiles;

        setLayout(new GridLayout(rowTiles, colTiles));
        Dimension buttonSize = new Dimension(xSize, xSize);

        for (int i = 0; i < rowTiles; i++) {
            for (int j = 0; j < colTiles; j++) {
                JButton button = buttons[i][j];
                button.setPreferredSize(buttonSize);
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (TilesPanel.getSelectedImage() == null) {
                            tiles.remove(button);
                            button.setIcon(null);
                            button.setBackground(Color.WHITE);
                        } else {
                            if (button.getIcon() != null) {
                                tiles.remove(button);
                            }
                            tiles.put(button, TilesPanel.getSelectedTile());
                            Image originalImage = TilesPanel.getSelectedImage().getImage();
                            Image resizedImage = originalImage.getScaledInstance(
                                    buttonSize.width, buttonSize.height, Image.SCALE_SMOOTH);
                            ImageIcon resizedIcon = new ImageIcon(resizedImage);

                            button.setIcon(resizedIcon);
                            button.setBackground(null);

                        }
                    }

                });
                button.addMouseMotionListener(new MouseMotionListener() {
                    @Override
                    public void mouseDragged(java.awt.event.MouseEvent e) {
                        Point relativeMousePoint = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(),
                                Grid.this);

                        int row = (int) relativeMousePoint.y / xSize - 2;
                        int col = (int) relativeMousePoint.x / xSize - 1;

                        if (row >= 0 && row < rowTiles && col >= 0 && col < colTiles) {
                            JButton button = buttons[row][col];
                            if (TilesPanel.getSelectedImage() == null) {
                                tiles.remove(button);
                                button.setIcon(null);
                                button.setBackground(Color.WHITE);
                            } else {
                                if (button.getIcon() != null) {
                                    tiles.remove(button);
                                }
                                tiles.put(button, TilesPanel.getSelectedTile());
                                Image originalImage = TilesPanel.getSelectedImage().getImage();
                                Image resizedImage = originalImage.getScaledInstance(
                                        buttonSize.width, buttonSize.height, Image.SCALE_SMOOTH);
                                ImageIcon resizedIcon = new ImageIcon(resizedImage);

                                button.setIcon(resizedIcon);
                            }
                        }

                    }

                    @Override
                    public void mouseMoved(java.awt.event.MouseEvent e) {
                    }
                });

                button.setBackground(Color.WHITE);
                add(button);
            }
        }
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public Map<JButton, Tiles> getTiles() {
        return tiles;
    }
}
