/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.*;
import dao.BiodataDao;
import biodata.BiodataFrame;

/**
 *
 * @author ghifarullah19
 */
public class Main extends JFrame {
    private final BiodataDao biodataDao;
    private static BiodataFrame biodataFrame;

    public Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(400, 500);

        this.biodataDao = new BiodataDao();

        this.biodataFrame = new BiodataFrame(biodataDao);

        biodataFrame.setVisible(true);
    }

    public void showBiodataFrame() {
        if (biodataFrame == null) {
            biodataFrame = new BiodataFrame(biodataDao);
        }
        biodataFrame.setVisible(true);
    }

    public static void main(String[] args) {
        // Method invokeLater dari SwingUtilities untuk menjalankan objek Runnable yang
        // berguna menangani event dan update UI
        SwingUtilities.invokeLater(new Runnable() {
            // Override method run dari Runnable
            public void run() {
                // Instansiasi StudiKasus dengan nama h
                Main h = new Main();
                // Tampilkan objek h dengan method setVisible dan parameternya true
                biodataFrame.setVisible(true);
            }
        });
    }
}
