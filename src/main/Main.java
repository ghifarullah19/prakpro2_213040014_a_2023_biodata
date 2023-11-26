/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.List;

import javax.swing.*;
import dao.BiodataDao;
import biodata.BiodataFrame;
import biodata.Biodata;
import biodata.ModelTable;

/**
 *
 * @author ghifarullah19
 */
public class Main extends JFrame {
    private final BiodataDao biodataDao;
    private static BiodataFrame biodataFrame;
    private List<Biodata> biodataList;
    private JButton refresh;

    public Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(400, 500);

        this.biodataDao = new BiodataDao();

        refresh = new JButton("Refresh");
        refresh.setBounds(15, 650, 100, 40);
        refresh.addActionListener(e -> {
            showBiodataFrame();
        });

        biodataFrame = new BiodataFrame(biodataDao);
        
        showBiodataFrame();

        biodataFrame.add(refresh);
    }

    public void showBiodataFrame() {
        biodataFrame.setVisible(false);
        this.biodataList = this.biodataDao.findAll();
        biodataFrame = new BiodataFrame(biodataDao);
        biodataFrame.getTable().setModel(new ModelTable(this.biodataList));
        biodataFrame.add(refresh);
        biodataFrame.setVisible(true);

        System.out.println("Table refreshed: ");
        if (biodataList.isEmpty()) {
            System.out.println("Table is empty");
        } else {
            for (Biodata biodata : biodataList) {
                System.out.println(biodata.getNama() + " " + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Method invokeLater dari SwingUtilities untuk menjalankan objek Runnable yang
        // berguna menangani event dan update UI
        SwingUtilities.invokeLater(new Runnable() {
            // Override method run dari Runnable
            public void run() {
                // Instansiasi StudiKasus dengan nama h
                new Main();
            }
        });
    }
}
