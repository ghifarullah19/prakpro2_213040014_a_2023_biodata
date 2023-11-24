/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Pertemuan 8
// Berada di package main > biodata
package biodata;

import javax.swing.table.*;
import java.util.List;

/**
 *
 * @author ghifarullah19
 */

// Membuat class ModelTable yang mewarisi class AbstractTableModel untuk membuat
// model tabel
public class ModelTable extends AbstractTableModel {
    // Array columnNames untuk menyimpan nama-nama kolom
    private String[] columnNames = { "Nama", "Nomor HP", "Jenis Kelamin", "Alamat" };
    // Membuat ArrayList dengan nama data yang berisi ArrayList dengan tipe String
    // untuk menyimpan data dari input
    private List<Biodata> data;

    public ModelTable(List<Biodata> data) {
        this.data = data;
    }
    
    // Fungsi untuk menambah jumlah kolom
    public int getColumnCount() {
        // Kembalikan panjang/ukuran dari array columnNames
        return columnNames.length;
    }

    // Fungsi untuk menambah jumlah baris
    public int getRowCount() {
        // Kembalikan jumlah data yang diterima/panjang dari ArrayList data
        return data.size();
    }

    // Fungsi untuk mendapatkan nama dari kolom yang dipilih dari parameter
    public String getColumnName(int col) {
        // Kembalikan elemen columnNames dengan index col
        return columnNames[col];
    }

    // Fungsi untuk mendapatkan nilai dari baris dan kolom tertentu
    public Object getValueAt(int row, int col) {
        // Menyimpan elemen dari ArrayList data dari baris yang dipilih ke List rowItem
        Biodata rowItem = data.get(row);
        String value = "";
        
        switch (col) {
            case 0:
                value = rowItem.getNama();
                break;
            case 1:
                value = rowItem.getNoTelepon();
                break;
            case 2:
                value = rowItem.getJenisKelamin();
                break;
            case 3:
                value = rowItem.getAlamat();
                break;
        }
        
        // Kembalikan elemen rowItem dari index col
        return value;
    }

    // Fungsi untuk mengatur apakah cell bisa diedit atau tidak
    public boolean isCellEditable(int row, int col) {
        // Kembalikan nilai false
        return row >=0 && col >= 0;
    }

    // Method untuk menambah nilai ke table
    public void add(Biodata value) {
        // Menambahkan input user ke ArrayList data
        data.add(value);
        // Menambahkan elemen-elemen ArrayList data ke table
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
    
    public void update(Biodata value) {
        int i = 0;
        for (Biodata b : data) {
            if (b.getId().equals(value.getId())) {
                b = value;
                data.set(i,value);
                fireTableCellUpdated(data.size()-1,
                data.size()-1);
            }
            i++;
        }
    }
}
