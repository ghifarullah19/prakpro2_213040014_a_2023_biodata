/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import dao.BiodataDao;

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
        buttonSimpanUbah = new JButton("Simpan Ubah");
        // Atur ukuran panjang dan lebar serta posisi x dan y
        buttonSimpanUbah.setBounds(345, 380, 150, 40);

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

        // Menambahkan action listener ke button
        BiodataButtonSimpanActionListener simpanListener = new BiodataButtonSimpanActionListener(this,
                biodataDao);
        button.addActionListener(simpanListener);

        BiodataButtonUbahActionListener ubahListener = new BiodataButtonUbahActionListener(this,
                biodataDao);
        buttonUbah.addActionListener(ubahListener);

        BiodataButtonHapusActionListener hapusListener = new BiodataButtonHapusActionListener(this,
                biodataDao);
        buttonHapus.addActionListener(hapusListener);

        // Menambahkan action listener ke button file
        buttonFile.addActionListener(new ActionListener() {
            // Method untuk menerima event
            public void actionPerformed(ActionEvent e) {
                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(BiodataFrame.this,
                        "Apakah anda yakin ingin menyimpan data ke file?",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Instansiasi JFileChooser dengan nama fileChooser
                    JFileChooser fileChooser = new JFileChooser();
                    // Atur title dari fileChooser
                    fileChooser.setDialogTitle("Simpan Data ke File");
                    // Atur filter dari fileChooser
                    fileChooser.setFileFilter(new FileNameExtensionFilter("File Teks", "txt"));
                    // Variable userSelection untuk menyimpan nilai dari fileChooser
                    int userSelection = fileChooser.showSaveDialog(BiodataFrame.this);

                    // Jika userSelection bernilai opsi approve
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        try {
                            // Instansiasi FileWriter dengan nama writer
                            FileWriter writer = new FileWriter("data.txt");

                            // Dapatkan data dari baris dt
                            for (int i = 0; i < biodataList.size(); i++) {
                                // Dapatkan data dari kolom dt
                                if (i == biodataList.size() - 1) {
                                    // Tulis data dari dt ke file, jika j == 3 maka tambahkan baris baru
                                    System.out.print(
                                            biodataList.get(i).getNama() + "," + biodataList.get(i).getNoTelepon() + " "
                                                    + biodataList.get(i).getJenisKelamin() + ","
                                                    + biodataList.get(i).getAlamat());
                                    writer.write(biodataList.get(i).getNama() + ",");
                                    writer.write(biodataList.get(i).getNoTelepon() + ",");
                                    writer.write(biodataList.get(i).getJenisKelamin() + ",");
                                    writer.write(biodataList.get(i).getAlamat());
                                } else {
                                    // Tulis data dari dt ke file, jika j != 3 maka tambahkan koma
                                    System.out.print(
                                            biodataList.get(i).getNama() + "," + biodataList.get(i).getNoTelepon() + ","
                                                    + biodataList.get(i).getJenisKelamin() + ","
                                                    + biodataList.get(i).getAlamat() + "\n");
                                    writer.write(biodataList.get(i).getNama() + ",");
                                    writer.write(biodataList.get(i).getNoTelepon() + ",");
                                    writer.write(biodataList.get(i).getJenisKelamin() + ",");
                                    writer.write(biodataList.get(i).getAlamat() + "\n");
                                }
                            }

                            // Tutup file
                            writer.close();

                            // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                            // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                            JOptionPane.showMessageDialog(BiodataFrame.this, "Data berhasil disimpan ke file",
                                    "Perhatian",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException ex) {
                            // Tampilkan error pada console
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        // Menambahkan window listener ke frame
        this.addWindowListener(new WindowAdapter() {
            // Override method windowClosing dari WindowAdapter
            public void windowClosing(WindowEvent e) {
                // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
                int confirmation = JOptionPane.showConfirmDialog(BiodataFrame.this,
                        "Apakah anda yakin ingin keluar aplikasi?\nSemua data yang belum disimpan, tidak akan tersimpan.",
                        "Form Biodata",
                        JOptionPane.YES_NO_OPTION);

                // Jika confirmation bernilai opsi yes
                if (confirmation == JOptionPane.YES_OPTION) {
                    // Keluar dari aplikasi
                    System.exit(0);
                } else {
                    // Jika batal keluar, kembalikan frame ke kondisi semula
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
            }
        });

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

    public ModelTable getTableModel() {
        return this.tableModel;
    }

    public JTable getTable() {
        return this.table;
    }

    public JButton getButtonSimpanUbah() {
        return this.buttonSimpanUbah;
    }

    public void addBiodata(Biodata biodata) {
        tableModel.add(biodata);
        textFieldNama.setText("");
    }

    public void updateBiodata(Biodata biodata) {
        tableModel.update(biodata);
        textFieldNama.setText("");
    }

    public void deleteBiodata(Biodata biodata) {
        tableModel.delete(biodata);
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

    public void showAlertSuccess(String message) {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Data " + message, "Perhatian",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void showAlertFailed(String message) {
        JOptionPane.showMessageDialog(BiodataFrame.this, "Data " + message, "Perhatian",
                JOptionPane.ERROR_MESSAGE);
    }

    public int showConfirmation(String message) {
        return JOptionPane.showConfirmDialog(BiodataFrame.this,
                "Apakah anda yakin ingin " + message + " data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    }

}
