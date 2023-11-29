package actionlistener;

import java.awt.event.*;
import biodata.Biodata;
import biodata.BiodataFrame;
import dao.BiodataDao;

// Implementasi ActionListener untuk button Simpan
public class SimpanUbahActionListener implements ActionListener {
    private final BiodataFrame biodataFrame; // Variable biodataFrame untuk menyimpan nilai biodataFrame
    private final BiodataDao biodataDao; // Variable biodataDao untuk menyimpan nilai biodataDao
    private String id; // Variable id untuk menyimpan nilai id dari biodata yang akan diubah

    // Constructor SimpanActionListener
    public SimpanUbahActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao, String id) {
        // Inisialisasi nilai dari biodataFrame, biodataDao, dan id
        this.biodataFrame = biodataFrame;
        this.biodataDao = biodataDao;
        this.id = id;
    }

    public void actionPerformed(ActionEvent e) {
        // Variable jenisKelamin untuk menyimpan nilai dari objek jenisLaki atau jenisPerempuan
        String jenisKelamin = "";

        // Jika jenisLaki diklik
        if (biodataFrame.getJenisLaki().isSelected()) {
            // Maka jenisKelamin akan bernilai Laki-Laki
            jenisKelamin = biodataFrame.getJenisLaki().getText();
            // Kembalikan radio button ke kondisi semula
            biodataFrame.getJenisLaki().setSelected(false);
        }
        // Jika jenisPerempuan diklik
        else if (biodataFrame.getJenisPerempuan().isSelected()) {
            // Maka jenisKelamin akan bernilai Perempuan
            jenisKelamin = biodataFrame.getJenisPerempuan().getText();
            // Kembalikan radio button ke kondisi semula
            biodataFrame.getJenisPerempuan().setSelected(false);
        }

        // Variable nama untuk menyimpan nilai dari objek textFieldNama (nama)
        String nama = this.biodataFrame.getNamaTextField().getText();
        // Variable telepon untuk menyimpan nilai dari objek textFieldTelepon (telepon)
        String telepon = this.biodataFrame.getNoTeleponTextField().getText();
        // Variable alamat untuk menyimpan nilai dari objek txtOutput (alamat)
        String alamat = this.biodataFrame.getAlamatTextField().getText();

        // Jika nama, telepon dan alamat bernilai kosong
        if (nama.equalsIgnoreCase("") && telepon.equalsIgnoreCase("") && alamat.equalsIgnoreCase("")) {
            // Panggil method showAlertAllEmpty pada biodataFrame
            this.biodataFrame.showAlertAllEmpty();
            return;
        } else {
            // Jika nama bernilai kosong
            if (nama.equalsIgnoreCase("")) {
                // Panggil method showAlertNameEmpty pada biodataFrame
                this.biodataFrame.showAlertNameEmpty();
                return;
            }
            // Jika telepon bernilai kosong
            if (telepon.equalsIgnoreCase("")) {
                // Panggil method showAlertTelephoneEmpty pada biodataFrame
                this.biodataFrame.showAlertTelephoneEmpty();
                return;
            }
            // Jika alamat bernilai kosong
            if (alamat.equalsIgnoreCase("")) {
                // Panggil method showAlertAddressEmpty pada biodataFrame
                this.biodataFrame.showAlertAddressEmpty();
                return;
            }
        }

        // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
        int confirmation = this.biodataFrame.showConfirmation("ubah");

        // Jika confirmation berinilai opsi yes
        if (confirmation == 0) {
            // Buat objek biodata untuk menyimpan nilai biodata yang akan diubah
            Biodata biodata = new Biodata();

            // Set id biodata dengan nilai this.id 
            biodata.setId(this.id);
            // Set nama biodata dengan nilai nama
            biodata.setNama(nama);
            // Set telepon biodata dengan nilai telepon
            biodata.setNoTelepon(telepon);
            // Set jenisKelamin biodata dengan nilai jenisKelamin
            biodata.setJenisKelamin(jenisKelamin);
            // Set alamat biodata dengan nilai alamat
            biodata.setAlamat(alamat);

            // Panggil method updateBiodata pada biodataFrame dengan parameter biodata
            this.biodataFrame.updateBiodata(biodata);
            // Panggil method update pada biodataDao dengan parameter biodata
            this.biodataDao.update(biodata);

            // Panggil method showAlertSuccess pada biodataFrame dengan parameter "diubah"
            this.biodataFrame.showAlertSuccess("diubah");

            // Kembalikan nilai id ke kondisi kosong
            this.id = null;
        }
        // Jika confirmation nilai opsi no
        else {
            // Panggil method showAlertFailed pada biodataFrame dengan parameter "diubah"
            this.biodataFrame.showAlertFailed("diubah");
        }

        // Kembalikan isi textFieldNama ke kondisi kosong
        this.biodataFrame.getNamaTextField().setText("");
        // Kembalikan isi textFieldTelepon ke kondisi kosong
        this.biodataFrame.getNoTeleponTextField().setText("");
        // Kembalikan isi textare ke kondisi kosong
        this.biodataFrame.getAlamatTextField().setText("");

        // Hapus action listener dari button simpan ubah
        this.biodataFrame.getButtonSimpanUbah().removeActionListener(this);
    }
}
