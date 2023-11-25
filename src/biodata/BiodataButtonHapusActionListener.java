package biodata;

import java.awt.event.*;
import dao.BiodataDao;

public class BiodataButtonHapusActionListener implements ActionListener {
  private final BiodataFrame biodataFrame;
  private final BiodataDao biodataDao;

  public BiodataButtonHapusActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
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
      Biodata id = new Biodata();

      if (column == 0) {
        id = this.biodataDao.selectByName(newValue);
      } else if (column == 1) {
        id = this.biodataDao.selectByTelephone(newValue);
      } else if (column == 2) {
        id = this.biodataDao.selectByGender(newValue);
      } else if (column == 3) {
        id = this.biodataDao.selectByAddress(newValue);
      }

      int confirmation = this.biodataFrame.showConfirmation("hapus");
      if (confirmation == 1) {
        this.biodataFrame.showAlertFailed("tidak dihapus");
        return;
      } else {
        this.biodataFrame.deleteBiodata(id);
        this.biodataDao.delete(id);
        this.biodataFrame.showAlertSuccess("dihapus");
      }
    }
  }
}
