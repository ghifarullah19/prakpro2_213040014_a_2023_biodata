/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

/**
 *
 * @author ghifarullah19
 */
public class Biodata {
    private String id;
    private String nama;
    private String noTelepon;
    private String jenisKelamin;
    private String alamat;
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getId() {
        return this.id;
    } 
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getNama() {
        return this.nama;
    } 
    
    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }
    
    public String getNoTelepon() {
        return this.noTelepon;
    }
    
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    
    public String getJenisKelamin() {
        return this.jenisKelamin;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getAlamat() {
        return this.alamat;
    }
}
