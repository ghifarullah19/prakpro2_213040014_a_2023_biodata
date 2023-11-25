/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

import java.awt.event.*;
import java.util.UUID;
import dao.BiodataDao;

/**
 *
 * @author ghifarullah19
 */
public class BiodataButtonSimpanActionListener implements ActionListener {
    private final BiodataFrame biodataFrame;
    private final BiodataDao biodataDao;

    public BiodataButtonSimpanActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
        this.biodataFrame = biodataFrame;
        this.biodataDao = biodataDao;
    }

    public void actionPerformed(ActionEvent e) {
        String jenisKelamin = "";

        // Jika radioButton1 diklik
        if (biodataFrame.getJenisLaki().isSelected()) {
            // Maka jenisKelamin akan bernilai Laki-Laki
            jenisKelamin = biodataFrame.getJenisLaki().getText();
            // Kembalikan radio button ke kondisi semula
            biodataFrame.getJenisLaki().setSelected(false);
        }
        // Jika radioButton2 diklik
        if (biodataFrame.getJenisPerempuan().isSelected()) {
            // Maka jenisKelamin akan bernilai Perempuan
            jenisKelamin = biodataFrame.getJenisPerempuan().getText();
            // Kembalikan radio button ke kondisi semula
            biodataFrame.getJenisPerempuan().setSelected(false);
        }

        // Variable nama untuk menyimpan nilai dari objek textFieldNama (nama)
        String nama = biodataFrame.getNama();
        // Variable telepon untuk menyimpan nilai dari objek textFieldTelepon (telepon)
        String telepon = biodataFrame.getNoTelepon();
        // Variable alamat untuk menyimpan nilai dari objek txtOutput (alamat)
        String alamat = biodataFrame.getAlamat();

        // Jika nama, telepon dan alamat bernilai kosong
        if (nama.equalsIgnoreCase("") && telepon.equalsIgnoreCase("") && alamat.equalsIgnoreCase("")) {
            // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
            // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
            this.biodataFrame.showAlertAllEmpty();
            return;
        } else {
            // Jika nama bernilai kosong
            if (nama.equalsIgnoreCase("")) {
                // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                this.biodataFrame.showAlertNameEmpty();
                return;
            }
            // Jika telepon bernilai kosong
            if (telepon.equalsIgnoreCase("")) {
                // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                this.biodataFrame.showAlertTelephoneEmpty();
                return;
            }
            // Jika alamat bernilai kosong
            if (alamat.equalsIgnoreCase("")) {
                // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
                // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
                this.biodataFrame.showAlertAddressEmpty();
                return;
            }
        }

        // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
        int confirmation = this.biodataFrame.showConfirmation("tambah");

        // Jika confirmation berinilai opsi yes
        if (confirmation == 0) {
            // Tambahkan variable nama, telepon, jenisKelamin, dan wna ke objek ArrayList
            // dan dikirim lagi ke objek tableModel dan dt melalui method add

            Biodata biodata = new Biodata();
            biodata.setId(UUID.randomUUID().toString());
            biodata.setNama(nama);
            biodata.setNoTelepon(telepon);
            biodata.setJenisKelamin(jenisKelamin);
            biodata.setAlamat(alamat);

            this.biodataFrame.addBiodata(biodata);
            this.biodataDao.insert(biodata);
            // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
            // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
            this.biodataFrame.showAlertSuccess("ditambahkan");
        }
        // Jika confirmation nilai opsi no
        else {
            // Tampilkan message dialog pada komponen dari parameter 1 dan pesan pada
            // parameter 2 dengan title pada parameter 3 dan jenis pesan pada parameter 4
            this.biodataFrame.showAlertFailed("ditambahkan");
        }
        // Kembalikan isi textFieldNama ke kondisi kosong
        this.biodataFrame.getNamaTextField().setText("");
        // Kembalikan isi textFieldTelepon ke kondisi kosong
        this.biodataFrame.getNoTeleponTextField().setText("");
        // Kembalikan isi textare ke kondisi kosong
        this.biodataFrame.getAlamatTextField().setText("");
    }
}
