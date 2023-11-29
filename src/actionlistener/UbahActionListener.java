package actionlistener;

import java.awt.event.*;
import biodata.BiodataFrame;
import dao.BiodataDao;

// Implementasi ActionListener untuk button Ubah
public class UbahActionListener implements ActionListener {
    private final BiodataFrame biodataFrame; // Variable biodataFrame untuk menyimpan nilai biodataFrame
    private final BiodataDao biodataDao; // Variable biodataDao untuk menyimpan nilai biodataDao

    public UbahActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
        // Inisialisasi nilai dari biodataFrame dan biodataDao
        this.biodataFrame = biodataFrame;
        this.biodataDao = biodataDao;
    }

    public void actionPerformed(ActionEvent e) {
        // Variable row untuk menyimpan nilai baris yang dipilih
        int row = this.biodataFrame.getTable().getSelectedRow();

        // Variable column untuk menyimpan nilai kolom yang dipilih
        int column = this.biodataFrame.getTable().getSelectedColumn();

        // Variable biodataUbah untuk menyimpan nilai dari table yang diedit
        String biodataUbah = (String) this.biodataFrame.getTable().getModel().getValueAt(row, column);

        // Variable id untuk menyimpan nilai id dari biodata yang akan diubah
        String id = "";

        // Variable col untuk menyimpan nama kolom yang dipilih
        String col = "";

        // Switch case untuk menentukan nama kolom yang dipilih
        switch (column) {
            // Jika kolom bernilai 0
            case 0:
                // Set col dengan nama
                col = "nama";
                break;
            // Jika kolom bernilai 1
            case 1:
                // Set col dengan no_telepon
                col = "no_telepon";
                break;
            // Jika kolom bernilai 2
            case 2:
                // Set col dengan jenis_kelamin
                col = "jenis_kelamin";
                break;
            // Jika kolom bernilai 3
            case 3:
                // Set col dengan alamat
                col = "alamat";
                break;
            // Jika kolom bernilai selain 0, 1, 2, dan 3
            default:
                // Tampilkan pesan kolom tidak ditemukan
                System.out.println("Kolom tidak ditemukan");
                break;
        }

        // Dapatkan id dari biodata yang akan diubah
        id = this.biodataDao.select(col, biodataUbah).getId();
        
        // Set nilai dari textFieldNama dengan biodata yang akan diubah
        this.biodataFrame.getNamaTextField().setText(this.biodataDao.select(col, biodataUbah).getNama());
        // Set nilai dari textFieldTelepon dengan biodata yang akan diubah
        this.biodataFrame.getNoTeleponTextField().setText(this.biodataDao.select(col, biodataUbah).getNoTelepon());

        // Jika jenis kelamin dari biodata yang akan diubah adalah Laki-Laki
        if (this.biodataDao.select(col, biodataUbah).getJenisKelamin().equals("Laki-Laki")) {
            // Set nilai dari jenisLaki menjadi true
            this.biodataFrame.getJenisLaki().setSelected(true);
        } else {
            // Set nilai dari jenisPerempuan menjadi true
            this.biodataFrame.getJenisPerempuan().setSelected(true);
        }

        // Set nilai dari textFieldAlamat dengan biodata yang akan diubah
        this.biodataFrame.getAlamatTextField().setText(this.biodataDao.select(col, biodataUbah).getAlamat());

        // Instansiasi objek SimpanUbahActionListener dengan nama simpanUbahListener
        SimpanUbahActionListener simpanUbahListener = new SimpanUbahActionListener(
                this.biodataFrame,
                this.biodataDao,
                id);

        // Tambahkan action listener pada buttonSimpanUbah
        this.biodataFrame.getButtonSimpanUbah().addActionListener(simpanUbahListener);
    }
}
