/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

import java.awt.event.*;
import dao.BiodataDao;

/**
 *
 * @author ghifarullah19
 */
public class BiodataButtonUbahActionListener implements ActionListener {
    private final BiodataFrame biodataFrame;
    private final BiodataDao biodataDao;

    public BiodataButtonUbahActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
        this.biodataFrame = biodataFrame;
        this.biodataDao = biodataDao;
    }

    public void actionPerformed(ActionEvent e) {
        // Jika table sedang diedit dan user mengklik button ubah

        // Variable row untuk menyimpan nilai baris yang dipilih
        int row = this.biodataFrame.getTable().getSelectedRow();

        // Variable column untuk menyimpan nilai kolom yang dipilih
        int column = this.biodataFrame.getTable().getSelectedColumn();
        // Variable newValue untuk menyimpan nilai dari table yang diedit

        String newValue = (String) this.biodataFrame.getTable().getModel().getValueAt(row, column);
        String id = "";

        System.out.println(newValue);

        if (column == 0) {
            id = this.biodataDao.selectByName(newValue).getId();
            this.biodataFrame.getNamaTextField().setText(this.biodataDao.selectByName(newValue).getNama());
            this.biodataFrame.getNoTeleponTextField().setText(this.biodataDao.selectByName(newValue).getNoTelepon());

            if (this.biodataDao.selectByName(newValue).getJenisKelamin().equals("Laki-Laki")) {
                this.biodataFrame.getJenisLaki().setSelected(true);
            } else {
                this.biodataFrame.getJenisPerempuan().setSelected(true);
            }

            this.biodataFrame.getAlamatTextField().setText(this.biodataDao.selectByName(newValue).getAlamat());
        } else if (column == 1) {
            id = this.biodataDao.selectByTelephone(newValue).getId();
            this.biodataFrame.getNamaTextField().setText(this.biodataDao.selectByTelephone(newValue).getNama());
            this.biodataFrame.getNoTeleponTextField()
                    .setText(this.biodataDao.selectByTelephone(newValue).getNoTelepon());

            if (this.biodataDao.selectByTelephone(newValue).getJenisKelamin().equals("Laki-Laki")) {
                this.biodataFrame.getJenisLaki().setSelected(true);
            } else {
                this.biodataFrame.getJenisPerempuan().setSelected(true);
            }

            this.biodataFrame.getAlamatTextField().setText(this.biodataDao.selectByTelephone(newValue).getAlamat());
        } else if (column == 2) {
            id = this.biodataDao.selectByGender(newValue).getId();
            this.biodataFrame.getNamaTextField().setText(this.biodataDao.selectByGender(newValue).getNama());
            this.biodataFrame.getNoTeleponTextField()
                    .setText(this.biodataDao.selectByGender(newValue).getNoTelepon());

            if (this.biodataDao.selectByGender(newValue).getJenisKelamin().equals("Laki-Laki")) {
                this.biodataFrame.getJenisLaki().setSelected(true);
            } else if (this.biodataDao.selectByGender(newValue).getJenisKelamin().equals("Perempuan")) {
                this.biodataFrame.getJenisPerempuan().setSelected(true);
            }

            this.biodataFrame.getAlamatTextField().setText(this.biodataDao.selectByGender(newValue).getAlamat());
        } else if (column == 3) {
            id = this.biodataDao.selectByAddress(newValue).getId();
            this.biodataFrame.getNamaTextField().setText(this.biodataDao.selectByAddress(newValue).getNama());
            this.biodataFrame.getNoTeleponTextField()
                    .setText(this.biodataDao.selectByAddress(newValue).getNoTelepon());

            if (this.biodataDao.selectByAddress(newValue).getJenisKelamin().equals("Laki-Laki")) {
                this.biodataFrame.getJenisLaki().setSelected(true);
            } else {
                this.biodataFrame.getJenisPerempuan().setSelected(true);
            }

            this.biodataFrame.getAlamatTextField().setText(this.biodataDao.selectByAddress(newValue).getAlamat());
        }

        BiodataButtonSimpanUbahActionListener simpanUbahListener = new BiodataButtonSimpanUbahActionListener(
                this.biodataFrame,
                this.biodataDao,
                id);
        this.biodataFrame.getButtonSimpanUbah().addActionListener(simpanUbahListener);
    }
}
