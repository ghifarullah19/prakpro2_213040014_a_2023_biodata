package actionlistener;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import biodata.BiodataFrame;

// Implementasi dari WindowAdapter untuk button Close
public class CloseWindowActionListener implements WindowListener {
	// Variable biodataFrame untuk menyimpan nilai dari objek biodataFrame
	private final BiodataFrame biodataFrame;

	// Constructor
	public CloseWindowActionListener(BiodataFrame biodataFrame) {
		this.biodataFrame = biodataFrame;
	}

	// Override method windowClosing dari WindowAdapter
	public void windowClosing(WindowEvent e) {
		// Variable confirmation untuk menyimpan nilai dari message dialog konfirmasi
		int confirmation = JOptionPane.showConfirmDialog(this.biodataFrame,
				"Apakah anda yakin ingin keluar aplikasi?\nSemua data yang belum disimpan, tidak akan tersimpan.",
				"Form Biodata",
				JOptionPane.YES_NO_OPTION);

		// Jika confirmation bernilai opsi yes
		if (confirmation == JOptionPane.YES_OPTION) {
			// Keluar dari aplikasi
			System.exit(0);
		} else {
			// Jika batal keluar, kembalikan frame ke kondisi semula
			this.biodataFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}

	/* NOTE: PROSEDUR DI BAWAH INI HARUS DITULIS KARENA MERUPAKAN IMPLEMENTASI DARI ABSTRACT CLASS */
	// Override method windowOpened dari WindowAdapter
	public void windowOpened(WindowEvent e) {
		// Tidak melakukan apa-apa
	}

	// Override method windowClosed dari WindowAdapter
	public void windowClosed(WindowEvent e) {
		// Tidak melakukan apa-apa
	}

	// Override method windowIconified dari WindowAdapter
	public void windowIconified(WindowEvent e) {
		// Tidak melakukan apa-apa
	}

	// Override method windowDeiconified dari WindowAdapter
	public void windowDeiconified(WindowEvent e) {
		// Tidak melakukan apa-apa
	}

	// Override method windowActivated dari WindowAdapter
	public void windowActivated(WindowEvent e) {
		// Tidak melakukan apa-apa
	}

	// Override method windowDeactivated dari WindowAdapter
	public void windowDeactivated(WindowEvent e) {
		// Tidak melakukan apa-apa
	}
}
