/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

import javax.swing.*;
import java.util.*;
import dao.BiodataDao;
import actionlistener.HapusActionListener;
import actionlistener.SimpanActionListener;
import actionlistener.UbahActionListener;
import actionlistener.CloseWindowActionListener;
import actionlistener.SaveToFileActionListener;

/**
 *
 * @author ghifarullah19
 */
public class BiodataFrame extends JFrame {
    private List<Biodata> biodataList; // Variable biodataList untuk menyimpan biodata
    private final JTextField textFieldNama; // Variable textFieldNama untuk menyimpan input nama
    private final JTextField textFieldHP; // Variable textFieldTelepon untuk menyimpan input telepon
    private final JRadioButton jenisLaki; // Variable jenisLaki untuk menyimpan input laki-laki
    private final JRadioButton jenisPerempuan; // Variable jenisPerempuan untuk menyimpan input perempuan
    private final JTextArea txtOutput; // Variable txtOutput untuk menyimpan input alamat
    private final ModelTable tableModel; // Variable tableModel untuk menyimpan tableModel
    private final JTable table; // Variable table untuk menyimpan table
    private final JButton buttonSimpanUbah; // Variable buttonSimpanUbah untuk menangani simpan ubah
    private final BiodataDao biodataDao; // Variable biodataDao untuk menyimpan biodataDao

    public BiodataFrame(BiodataDao biodataDao) {
        // Inisialisasi biodataDao dengan biodataDao
        this.biodataDao = biodataDao;
        // Inisialisasi biodataList dengan biodataDao.findAll()
        this.biodataList = this.biodataDao.findAll();
        
        // Instansiasi JLabel dengan nama labelNama yang diberikan nilai "Form Biodata:"
        // dan diletakan di tengah frame
        JLabel labelHeader = new JLabel("Form Biodata", JLabel.CENTER);
        // Atur ukuran panjang dan lebar serta posisi x dan y
        labelHeader.setBounds(0, 20, 350, 10);

        // Instansiasi JLabel dengan nama labelNama yang diberikan nilai "Nama:"
        JLabel labelNama = new JLabel("Nama: ");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        labelNama.setBounds(15, 40, 350, 10);

        // Instansiasi JTextField dengan nama textFieldNama
        textFieldNama = new JTextField();
        // Atur ukuran panjang dan lebar serta posisi x dan y
        textFieldNama.setBounds(15, 60, 350, 30);

        // Instansiasi JLabel dengan nama labelTelepon yang diberikan nilai "Nomor
        // Telepon:"
        JLabel labelHP = new JLabel("Nomor HP: ");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        labelHP.setBounds(15, 100, 350, 10);

        // Instansiasi JTextField dengan nama textFieldTelepon
        textFieldHP = new JTextField();
        // Atur ukuran panjang dan lebar serta posisi x dan y
        textFieldHP.setBounds(15, 120, 350, 30);

        // Instansiasi JLabel dengan nama labelInput yang diberikan nilai "Jenis
        // Kelamin:"
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        labelRadio.setBounds(15, 160, 350, 10);

        // Instansiasi JRadioButton dengan nama radioButton1 dengan pesan "Laki-Laki"
        // dan selected dengan nilai true
        jenisLaki = new JRadioButton("Laki-Laki", true);
        // Atur ukuran panjang dan lebar serta posisi x dan y
        jenisLaki.setBounds(15, 180, 350, 30);

        // Instansiasi JRadioButton dengan nama radioButton1 dengan pesan "Perempuan"
        jenisPerempuan = new JRadioButton("Perempuan");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        jenisPerempuan.setBounds(15, 210, 350, 30);

        // Instansiasi ButtonGroup dengan nama bg
        ButtonGroup bg = new ButtonGroup();
        // Masukan radioButton1 ke objek bg
        bg.add(jenisLaki);
        // Masukan radioButton2 ke objek bg
        bg.add(jenisPerempuan);

        JLabel labelAlamat = new JLabel("Alamat: ");
        labelAlamat.setBounds(15, 240, 350, 30);

        // Instansiasi JCheckBox dengan nama checkBox dengan pesan "Warga Asing"
        txtOutput = new JTextArea("");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        txtOutput.setBounds(15, 270, 350, 100);

        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan"
        JButton button = new JButton("Simpan");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        button.setBounds(15, 380, 100, 40);

        // Instansiasi JButton dengan nama buttonUbah yang diberikan nilai "Ubah"
        JButton buttonUbah = new JButton("Ubah");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        buttonUbah.setBounds(125, 380, 100, 40);

        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan"
        JButton buttonHapus = new JButton("Hapus");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        buttonHapus.setBounds(235, 380, 100, 40);

        // Instansiasi JButton dengan nama buttonSimpanUbah yang diberikan nilai "Simpan Ubah"
        buttonSimpanUbah = new JButton("Simpan Ubah");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        buttonSimpanUbah.setBounds(345, 380, 150, 40);

        // Instansiasi JButton dengan nama refresh yang diberikan nilai "Refresh"
        JButton refresh = new JButton("Refresh");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        refresh.setBounds(15, 650, 100, 40);

        // Menambahkan action listener ke button refresh
        refresh.addActionListener(e -> {
            // Panggil method refreshBiodataTable
            refreshBiodataTable();
        });

        // Instansiasi JTable dengan nama table
        table = new JTable();
        // Instansiasi JScrollPane dengan nama scrollableTable yang diberikan ke objek
        // table
        JScrollPane scrollableTable = new JScrollPane(table);
        // Atur ukuran panjang dan lebar serta posisi x dan y
        scrollableTable.setBounds(15,
                440,
                500,
                200);

        // Instansiasi ModelTable dengan nama tableModel
        tableModel = new ModelTable(biodataList);
        // Atur model dari table dengan objek tableModel
        table.setModel(tableModel);

        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan"
        JButton buttonFile = new JButton("Simpan ke File");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        buttonFile.setBounds(345, 650, 150, 40);

        // Instansiasi SimpanActionListener dengan nama simpanListener
        SimpanActionListener simpanListener = new SimpanActionListener(this,
        biodataDao);
        // Menambahkan action listener ke button
        button.addActionListener(simpanListener);

        // Instansiasi UbahActionListener dengan nama ubahListener
        UbahActionListener ubahListener = new UbahActionListener(this,
                biodataDao);
        // Menambahkan action listener ke buttonUbah
        buttonUbah.addActionListener(ubahListener);

        // Instansiasi HapusActionListener dengan nama hapusListener
        HapusActionListener hapusListener = new HapusActionListener(this,
                biodataDao);
        // Menambahkan action listener ke buttonHapus
        buttonHapus.addActionListener(hapusListener);

        // Instansiasi SaveToFileActionListener dengan nama saveToFileListener
        SaveToFileActionListener saveToFileListener = new SaveToFileActionListener(this, biodataList);
        // Menambahkan action listener ke button file
        buttonFile.addActionListener(saveToFileListener);

        // Instansiasi CloseWindowActionListener dengan nama closeWindowListener
        CloseWindowActionListener closeWindowListener = new CloseWindowActionListener(this);
        // Menambahkan window listener ke frame
        this.addWindowListener(closeWindowListener);

        // Menambahkan objek labelHeader ke frame
        this.add(labelHeader);
        // Menambahkan objek labelNama ke frame
        this.add(labelNama);
        // Menambahkan objek textFieldNama ke frame
        this.add(textFieldNama);
        // Menambahkan objek labelTelepon ke frame
        this.add(labelHP);
        // Menambahkan objek textFieldTelepon ke frame
        this.add(textFieldHP);
        // Menambahkan objek labelRadio ke frame
        this.add(labelRadio);
        // Menambahkan objek radioButton1 ke frame
        this.add(jenisLaki);
        // Menambahkan objek radioButton2 ke frame
        this.add(jenisPerempuan);
        // Menambahkan objek checkBox ke frame
        this.add(labelAlamat);
        // Menambahkan objek txtOutput ke frame
        this.add(txtOutput);
        // Menambahkan objek button ke frame
        this.add(button);
        // Menambahkan objek buttonUbah ke frame
        this.add(buttonUbah);
        // Menambahkan objek buttonHapus ke frame
        this.add(buttonHapus);
        // Menambahkan objek buttonFile ke frame
        this.add(buttonFile);
        // Menambahkan objek scrollableTable ke frame
        this.add(scrollableTable);
        this.add(refresh);
        // Menambahkan objek buttonUbah ke frame
        this.add(buttonSimpanUbah);

        // Atur ukuran frame menjadi 400 x 600
        this.setSize(550, 1000);
        // Atur layout frame menjadi null
        this.setLayout(null);
    }

    // Method untuk mendapatkan nilai dari textFieldNama
    public String getNama() {
        // Kembalikan nilai dari textFieldNama
        return textFieldNama.getText();
    }

    // Method untuk mendapatkan textFieldNama
    public JTextField getNamaTextField() {
        // Kembalikan nilai dari textFieldNama
        return textFieldNama;
    }

    // Method untuk mendapatkan nilai dari textFieldTelepon
    public String getNoTelepon() {
        // Kembalikan nilai dari textFieldTelepon
        return textFieldHP.getText();
    }

    // Method untuk mendapatkan textFieldTelepon
    public JTextField getNoTeleponTextField() {
        // Kembalikan nilai dari textFieldTelepon
        return textFieldHP;
    }

    // Method untuk mendapatkan nilai dari radioButton1
    public JRadioButton getJenisLaki() {
        // Kembalikan nilai dari radioButton1
        return jenisLaki;
    }

    // Method untuk mendapatkan nilai dari radioButton2
    public JRadioButton getJenisPerempuan() {
        // Kembalikan nilai dari radioButton2
        return jenisPerempuan;
    }

    // Method untuk mendapatkan nilai dari txtOutput
    public String getAlamat() {
        // Kembalikan nilai dari txtOutput
        return txtOutput.getText();
    }

    // Method untuk mendapatkan txtOutput
    public JTextArea getAlamatTextField() {
        // Kembalikan nilai dari txtOutput
        return txtOutput;
    }

    // Method untuk mendapatkan tableModel
    public ModelTable getTableModel() {
        // Kembalikan nilai dari tableModel
        return this.tableModel;
    }

    // Method untuk mendapatkan table
    public JTable getTable() {
        // Kembalikan nilai dari table
        return this.table;
    }

    // Method untuk mendapatkan buttonSimpanUbah
    public JButton getButtonSimpanUbah() {
        // Kembalikan buttonSimpanUbah
        return this.buttonSimpanUbah;
    }

    // Method untuk menambahkan biodata ke tableModel
    public void addBiodata(Biodata biodata) {
        // Tambahkan biodata ke tableModel
        tableModel.add(biodata);
        // Kembalikan isi textFieldNama ke kondisi kosong
        textFieldNama.setText("");
        // Kembalikan isi textFieldTelepon ke kondisi kosong
        textFieldHP.setText("");
        // Kembalikan isi textarea ke kondisi kosong
        txtOutput.setText("");
    }

    // Method untuk mengubah biodata ke tableModel
    public void updateBiodata(Biodata biodata) {
        // Tambahkan biodata ke tableModel
        tableModel.update(biodata);
        // Kembalikan isi textFieldNama ke kondisi kosong
        textFieldNama.setText("");
        // Kembalikan isi textFieldTelepon ke kondisi kosong
        textFieldHP.setText("");
        // Kembalikan isi textarea ke kondisi kosong
        txtOutput.setText("");
    }

    // Method untuk menghapus biodata ke tableModel
    public void deleteBiodata(Biodata biodata) {
        // Tambahkan biodata ke tableModel
        tableModel.delete(biodata);
    }

    public void refreshBiodataTable() {
        this.biodataList = this.biodataDao.findAll();
        this.getTable().setModel(new ModelTable(this.biodataList));

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

    // Method untuk menampilkan alert ketika nama, telepon dan alamat kosong
    public void showAlertAllEmpty() {
        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
        JOptionPane.showMessageDialog(BiodataFrame.this, "Nama, telepon dan alamat belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE);
    }

    // Method untuk menampilkan alert ketika nama kosong
    public void showAlertNameEmpty() {
        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
        JOptionPane.showMessageDialog(BiodataFrame.this, "Nama belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE);
    }

    // Method untuk menampilkan alert ketika telepon kosong
    public void showAlertTelephoneEmpty() {
        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
        JOptionPane.showMessageDialog(BiodataFrame.this, "Telepon belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE);
    }

    // Method untuk menampilkan alert ketika alamat kosong
    public void showAlertAddressEmpty() {
        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
        JOptionPane.showMessageDialog(BiodataFrame.this, "Alamat belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE);
    }

    // Method untuk menampilkan alert ketika data berhasil ditambahkan
    public void showAlertSuccess(String message) {
        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
        JOptionPane.showMessageDialog(BiodataFrame.this, "Data " + message, "Perhatian",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Method untuk menampilkan alert ketika data gagal ditambahkan
    public void showAlertFailed(String message) {
        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
        JOptionPane.showMessageDialog(BiodataFrame.this, "Data " + message, "Perhatian",
                JOptionPane.ERROR_MESSAGE);
    }

    // Method untuk menampilkan konfirmasi
    public int showConfirmation(String message) {
        // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
        return JOptionPane.showConfirmDialog(BiodataFrame.this,
                "Apakah anda yakin ingin " + message + " data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    }

}
