package actionlistener;

import java.awt.event.*;

import biodata.Biodata;
import biodata.BiodataFrame;
import dao.BiodataDao;

// Implementasi ActionListener untuk button Hapus
public class HapusActionListener implements ActionListener {
  private final BiodataFrame biodataFrame; // Variable biodataFrame untuk menyimpan nilai biodataFrame
  private final BiodataDao biodataDao; // Variable biodataDao untuk menyimpan nilai biodataDao

  // Constructor HapusActionListener
  public HapusActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
    // Inisialisasi nilai dari biodataFrame dan biodataDao
    this.biodataFrame = biodataFrame;
    this.biodataDao = biodataDao;
  }

  public void actionPerformed(ActionEvent e) {
    // Variable row untuk menyimpan nilai baris yang dipilih
    int row = this.biodataFrame.getTable().getSelectedRow();

    // Variable column untuk menyimpan nilai kolom yang dipilih
    int column = this.biodataFrame.getTable().getSelectedColumn();

    if (row == -1 || column == -1) {
      this.biodataFrame.showAlertFailed("dihapus");
      return;
    } else {
      // Variable newValue untuk menyimpan nilai dari table yang diedit
      String newValue = (String) this.biodataFrame.getTable().getModel().getValueAt(row, column);
      // Variable id untuk menyimpan nilai id dari biodata yang akan dihapus
      Biodata id = new Biodata();

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

	  // Set id dengan nilai id dari biodata yang akan dihapus
	  id = this.biodataDao.select(col, newValue);

      // Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
      int confirmation = this.biodataFrame.showConfirmation("hapus");

      // Jika confirmation bernilai 1
      if (confirmation == 1) {
        // Panggil method showAlertFailed pada biodataFrame dengan parameter "tidak dihapus"
        this.biodataFrame.showAlertFailed("tidak dihapus");
        // Batalkan proses
        return;
      } 
      // Jiak confirmation bernilai 0
      else {
        // Hapus tabel biodata berdasarkan id
        this.biodataFrame.deleteBiodata(id);
        // Hapus data biodata berdasarkan id
        this.biodataDao.delete(id);
        // Panggil method showAlertSuccess pada biodataFrame dengan parameter "dihapus"
        this.biodataFrame.showAlertSuccess("dihapus");
      }
    }
  }
}
