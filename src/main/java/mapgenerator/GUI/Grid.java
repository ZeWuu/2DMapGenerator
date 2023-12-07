package main.java.mapgenerator.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Grid extends JPanel {
    private int rowTiles;
    private int colTiles;
    private MapGeneratorGUI panel;
    private JButton[][] buttons;

    public Grid(int rowTiles, int colTiles, MapGeneratorGUI panel) {
        this.rowTiles = rowTiles;
        this.colTiles = colTiles;
        this.panel = panel;

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
        int sizeX = panel.getSize().width;
        int xSize = sizeX / rowTiles;

        setLayout(new GridLayout(rowTiles, colTiles));
        Dimension buttonSize = new Dimension(xSize, xSize);

        for (int i = 0; i < rowTiles; i++) {
            for (int j = 0; j < colTiles; j++) {
                JButton button = buttons[i][j];
                button.setPreferredSize(buttonSize);
                button.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Image originalImage = TilesPanel.getSelectedImage().getImage();
                        Image resizedImage = originalImage.getScaledInstance(
                        buttonSize.width, buttonSize.height, Image.SCALE_SMOOTH);
                        ImageIcon resizedIcon = new ImageIcon(resizedImage);
                
                        button.setBorder(null);
                        button.setIcon(resizedIcon);
                        //button.setIcon(TilesPanel.getSelectedImage());
                    }

                });
                // button.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4,
                // Color.BLACK));
              
                button.setBackground(Color.WHITE);
                add(button);
            }
        }
    }
}
