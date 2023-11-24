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
        
        System.out.println(newValue);
        System.out.println(this.biodataDao.selectByName(newValue).getNama());
        System.out.println(this.biodataDao.selectByName(newValue).getNoTelepon());
        System.out.println(this.biodataDao.selectByName(newValue).getJenisKelamin());
        System.out.println(this.biodataDao.selectByName(newValue).getAlamat());
        
        this.biodataFrame.getNamaTextField().setText(this.biodataDao.selectByName(newValue).getNama());
        this.biodataFrame.getNoTeleponTextField().setText(this.biodataDao.selectByName(newValue).getNoTelepon());
        
        if (this.biodataDao.selectByName(newValue).getJenisKelamin().equals("Laki-Laki")) {
            this.biodataFrame.getJenisLaki().setSelected(true);
        } else {
            this.biodataFrame.getJenisPerempuan().setSelected(true);
        }
        
        this.biodataFrame.getAlamatTextField().setText(this.biodataDao.selectByName(newValue).getAlamat());
        
        BiodataButtonSimpanUbahActionListener simpanUbahListener = new BiodataButtonSimpanUbahActionListener(this.biodataFrame,
                        this.biodataDao);
        
        this.biodataFrame.getButtonSimpanUbah().addActionListener(simpanUbahListener);
    }
}
