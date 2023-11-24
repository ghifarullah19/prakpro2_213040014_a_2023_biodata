/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

import javax.swing.*;
import java.util.*;
import dao.BiodataDao;
import biodata.ModelTable;
//import java.awt.HeadlessException;
//import java.io.FileWriter;
//import java.io.IOException;
//import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ghifarullah19
 */
public class BiodataFrame extends JFrame {
    private final List<Biodata> biodataList;
    private final JTextField textFieldNama;
    private final JTextField textFieldHP;
    private final JRadioButton jenisLaki;
    private final JRadioButton jenisPerempuan;
    private final JTextArea txtOutput;
    private final ModelTable tableModel;
    private final JTable table;
    private final JButton buttonSimpanUbah;
    private final BiodataDao biodataDao;

    public BiodataFrame(BiodataDao biodataDao) {
        this.biodataDao = biodataDao;
        this.biodataList = this.biodataDao.findAll();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan"
        JButton buttonUbah = new JButton("Ubah");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        buttonUbah.setBounds(125, 380, 100, 40);

        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan"
        JButton buttonHapus = new JButton("Hapus");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        buttonHapus.setBounds(235, 380, 100, 40);

        // Instansiasi JButton dengan nama button yang diberikan nilai "Simpan"
        JButton buttonFile = new JButton("Simpan ke File");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        buttonFile.setBounds(345, 380, 150, 40);

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
        buttonSimpanUbah = new JButton("Simpan Ubah");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        buttonSimpanUbah.setBounds(345, 650, 150, 40);

        // Menambahkan action listener ke button
        BiodataButtonSimpanActionListener actionListener = new BiodataButtonSimpanActionListener(this,
                        biodataDao);
        button.addActionListener(actionListener);
        
        BiodataButtonUbahActionListener actionListener2 = new BiodataButtonUbahActionListener(this,
                        biodataDao);
        buttonUbah.addActionListener(actionListener2);
        
        // Menambahkan action listener ke button ubah
//        buttonUbah.addActionListener(new ActionListener() {
//            // Method untuk menerima event
//            public void actionPerformed(ActionEvent e) {
//                // Jika table sedang diedit dan user mengklik button ubah
//                if (table.isEditing()) {
//                    // Hentikan editing pada table
//                    table.getCellEditor().stopCellEditing();
//                }
//
//                // Variable row untuk menyimpan nilai baris yang dipilih
//                int row = table.getSelectedRow();
//                // Variable column untuk menyimpan nilai kolom yang dipilih
//                int column = table.getSelectedColumn();
//                // Variable newValue untuk menyimpan nilai dari table yang diedit
//                String newValue = (String) table.getModel().getValueAt(row, column);
//
//                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
//                int confirmation = JOptionPane.showConfirmDialog(BiodataFrame.this,
//                        "Apakah anda yakin ingin mengubah data?",
//                        "Form Biodata",
//                        JOptionPane.YES_NO_OPTION);
//
//                // Jika confirmation bernilai opsi yes
//                if (confirmation == JOptionPane.YES_OPTION) {
//                    // Ubah nilai dari tableModel dan dt dengan nilai newValue pada baris dan kolom
//                    // yang dipilih
//                    tableModel.setValueAt(newValue, row, column);
//                    dt.setDataRow(row, column, newValue);
//                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
//                    // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
//                    JOptionPane.showMessageDialog(BiodataFrame.this, "Data berhasil diubah", "Perhatian",
//                            JOptionPane.INFORMATION_MESSAGE);
//                } else {
//                    // Jika batal diubah, kembalikan nilai dari tableModel dan dt ke kondisi semula
//                    for (int i = 0; i < dt.getSize(row); i++) {
//                        tableModel.setValueAt(dt.getData(row, i),
//                                row,
//                                i);
//                    }
//                }
//            }
//        });

        // Menambahkan action listener ke button hapus
//        buttonHapus.addActionListener(new ActionListener() {
//            // Method untuk menerima event
//            public void actionPerformed(ActionEvent e) {
//                // Variable row untuk menyimpan nilai baris yang dipilih
//                int row = table.getSelectedRow();
//                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
//                int confirmation = JOptionPane.showConfirmDialog(BiodataFrame.this,
//                        "Apakah anda yakin ingin menghapus data?",
//                        "Form Biodata",
//                        JOptionPane.YES_NO_OPTION);
//
//                // Jika confirmation bernilai opsi yes
//                if (confirmation == JOptionPane.YES_OPTION) {
//                    // Hapus baris yang dipilih dari tableModel dan dt
//                    tableModel.remove(row);
//                    dt.remove(row);
//
//                    // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
//                    // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
//                    JOptionPane.showMessageDialog(BiodataFrame.this, "Data berhasil dihapus", "Perhatian",
//                            JOptionPane.INFORMATION_MESSAGE);
//                }
//            }
//        });

        // Menambahkan action listener ke button file
//        buttonFile.addActionListener(new ActionListener() {
//            // Method untuk menerima event
//            public void actionPerformed(ActionEvent e) {
//                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
//                int confirmation = JOptionPane.showConfirmDialog(BiodataFrame.this,
//                        "Apakah anda yakin ingin menyimpan data ke file?",
//                        "Form Biodata",
//                        JOptionPane.YES_NO_OPTION);
//
//                // Jika confirmation bernilai opsi yes
//                if (confirmation == JOptionPane.YES_OPTION) {
//                    // Instansiasi JFileChooser dengan nama fileChooser
//                    JFileChooser fileChooser = new JFileChooser();
//                    // Atur title dari fileChooser
//                    fileChooser.setDialogTitle("Simpan Data ke File");
//                    // Atur filter dari fileChooser
//                    fileChooser.setFileFilter(new FileNameExtensionFilter("File Teks", "txt"));
//                    // Variable userSelection untuk menyimpan nilai dari fileChooser
//                    int userSelection = fileChooser.showSaveDialog(BiodataFrame.this);
//
//                    // Jika userSelection bernilai opsi approve
//                    if (userSelection == JFileChooser.APPROVE_OPTION) {
//                        try {
//                            // Instansiasi FileWriter dengan nama writer
//                            FileWriter writer = new FileWriter("data.txt");
//
//                            // Dapatkan data dari baris dt
//                            for (int i = 0; i < dt.getSizeAll(); i++) {
//                                // Dapatkan data dari kolom dt
//                                for (int j = 0; j < dt.getSize(i); j++) {
//                                    if (j == 3) {
//                                        // Tulis data dari dt ke file, jika j == 3 maka tambahkan baris baru
//                                        writer.write(dt.getData(i, j).toString() + "\n");
//                                    } else {
//                                        // Tulis data dari dt ke file, jika j != 3 maka tambahkan koma
//                                        writer.write(dt.getData(i, j).toString() + ",");
//                                    }
//                                }
//                            }
//
//                            // Tutup file
//                            writer.close();
//
//                            // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
//                            // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
//                            JOptionPane.showMessageDialog(BiodataFrame.this, "Data berhasil disimpan ke file",
//                                    "Perhatian",
//                                    JOptionPane.INFORMATION_MESSAGE);
//                        } catch (IOException ex) {
//                            // Tampilkan error pada console
//                            ex.printStackTrace();
//                        }
//                    }
//                }
//            }
//        });

        // Menambahkan window listener ke frame
//        this.addWindowListener(new WindowAdapter() {
//            // Override method windowClosing dari WindowAdapter
//            public void windowClosing(WindowEvent e) {
//                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
//                int confirmation = JOptionPane.showConfirmDialog(BiodataFrame.this,
//                        "Apakah anda yakin ingin keluar aplikasi?\nSemua data yang belum disimpan, tidak akan tersimpan.",
//                        "Form Biodata",
//                        JOptionPane.YES_NO_OPTION);
//
//                // Jika confirmation bernilai opsi yes
//                if (confirmation == JOptionPane.YES_OPTION) {
//                    // Dapatkan data dari baris tableModel
//                    for (int i = 0; i < tableModel.getRowCount(); i++) {
//                        // Dapatkan data dari kolom tableModel
//                        for (int j = 0; j < tableModel.getColCount(i); j++) {
//                            // Tulis data dari tableModel dari dt
//                            tableModel.setValueAt(dt.getData(i, j),
//                                    i,
//                                    j);
//                        }
//                    }
//                    // Keluar dari aplikasi
//                    System.exit(0);
//                } else {
//                    // Jika batal keluar, kembalikan frame ke kondisi semula
//                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//                }
//            }
//        });

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
        // Menambahkan objek buttonUbah ke frame
        this.add(buttonSimpanUbah);

        // Atur ukuran frame menjadi 400 x 600
        this.setSize(550, 1000);
        // Atur layout frame menjadi null
        this.setLayout(null);
    }
    
    public String getNama() {
        return textFieldNama.getText();
    }
    
    public JTextField getNamaTextField() {
        return textFieldNama;
    }
    
    public String getNoTelepon() {
        return textFieldHP.getText();
    }
    
    public JTextField getNoTeleponTextField() {
        return textFieldHP;
    }
    
    public JRadioButton getJenisLaki() {
        return jenisLaki;
    }
    
    public JRadioButton getJenisPerempuan() {
        return jenisPerempuan;
    }
    
    public String getAlamat() {
        return txtOutput.getText();
    }
    
    public JTextArea getAlamatTextField() {
        return txtOutput;
    }
    
    public JButton getButtonSimpanUbah() {
        return buttonSimpanUbah;
    }
    
    public ModelTable getTableModel() {
        return this.tableModel;
    }
    
    public JTable getTable() {
        return this.table;
    }
    
    public void addBiodata(Biodata biodata) {
        tableModel.add(biodata);
        textFieldNama.setText("");
    }
    
    public void updateBiodata(Biodata biodata) {
        tableModel.update(biodata);
        textFieldNama.setText("");
    }
    
    public void showAlertAllEmpty() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Nama, telepon dan alamat belum terisi", "Perhatian",
                    JOptionPane.WARNING_MESSAGE);
    }
    
    public void showAlertNameEmpty() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Nama belum terisi", "Perhatian",
                        JOptionPane.WARNING_MESSAGE);
    }
    
    public void showAlertTelephoneEmpty() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Telepon belum terisi", "Perhatian",
                        JOptionPane.WARNING_MESSAGE);
    }
    
    public void showAlertAddressEmpty() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Alamat belum terisi", "Perhatian",
                        JOptionPane.WARNING_MESSAGE);
    }
    
    public void showAlertSuccess() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Data tersimpan", "Perhatian",
                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void showAlertFailed() {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Data tidak tersimpan", "Perhatian",
                    JOptionPane.ERROR_MESSAGE);
    }
    
    public int showConfirmation() {
        return JOptionPane.showConfirmDialog(BiodataFrame.this,
                "Apakah anda yakin ingin menyimpan data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    }
    
}
