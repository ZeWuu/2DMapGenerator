package main.java.mapgenerator.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.swing.JButton;
import main.java.mapgenerator.TILES.Tiles;

public class SaveButton extends JButton {
    Grid panel;

    public SaveButton(Grid panel) {

        this.panel = panel;
        this.setText("Save");
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveMap();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void saveMap() throws IOException {
        PrintWriter out = new PrintWriter("Map.txt");
        JButton[][] buttonsArray = panel.getButtons();
        Map<JButton, Tiles> tiles = panel.getTiles();
        for (int i = 0; i < buttonsArray.length; i++) {
            for (int j = 0; j < buttonsArray[i].length; j++) {
                if (tiles.get(buttonsArray[i][j]) != null) {
                    out.print(tiles.get(buttonsArray[i][j]).getValue());
                } else {
                    out.print("#");
                }
            }
            out.println();

        }
        out.close();
    }
}
