/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import biodata.Biodata;

/**
 *
 * @author ghifarullah19
 */

// Class BiodataDao untuk mengatur CRUD dari biodata
public class BiodataDao {
    // Fungsi untuk menambahkan data ke database
    public int insert(Biodata biodata) {
        // Variable result untuk menyimpan nilai dari eksekusi query apakah berhasil atau tidak
        int result = -1;

        // Try with resources untuk membuat koneksi ke database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk memasukkan data ke database
            PreparedStatement statement = connection.prepareStatement(
                    "Insert into biodata(id, nama, no_telepon, jenis_kelamin, alamat) values (?, ?, ?, ?, ?)");

            // Set nilai dari parameter yang ada di query
            statement.setString(1, biodata.getId()); // id
            statement.setString(2, biodata.getNama()); // nama
            statement.setString(3, biodata.getNoTelepon()); // no_telepon
            statement.setString(4, biodata.getJenisKelamin()); // jenis_kelamin
            statement.setString(5, biodata.getAlamat()); // alamat
            
            // Eksekusi query
            result = statement.executeUpdate();

            // Print data yang dimasukkan ke database
            System.out.println("Insert data: " + biodata.getId() + " " + biodata.getNama() + " "
                    + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());
        } catch (SQLException e) {
            // Print error jika terjadi error
            e.printStackTrace();
        }

        // Kembalikan nilai result
        return result;
    }

    // Fungsi untuk mengubah data di database
    public int update(Biodata biodata) {
        // Variable result untuk menyimpan nilai dari eksekusi query apakah berhasil atau tidak
        int result = -1;

        // Try with resources untuk membuat koneksi ke database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk mengubah data di database
            PreparedStatement statement = connection.prepareStatement(
                    "update biodata set nama = ?, no_telepon = ?, jenis_kelamin = ?, alamat = ? where id = ?");

            // Set nilai dari parameter yang ada di query
            statement.setString(1, biodata.getNama()); // nama
            statement.setString(2, biodata.getNoTelepon()); // no_telepon
            statement.setString(3, biodata.getJenisKelamin()); // jenis_kelamin
            statement.setString(4, biodata.getAlamat()); // alamat
            statement.setString(5, biodata.getId()); // id

            // Eksekusi query
            result = statement.executeUpdate();

            // Print data yang diubah di database
            System.out.println("Update data: " + biodata.getId() + " " + biodata.getNama() + " "
                    + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());

        } catch (SQLException e) {
            // Print error jika terjadi error
            e.printStackTrace();
        }

        // Kembalikan nilai result
        return result;
    }

    // Fungsi untuk menghapus data di database
    public int delete(Biodata biodata) {
        // Variable result untuk menyimpan nilai dari eksekusi query apakah berhasil atau tidak
        int result = -1;

        // Try with resources untuk membuat koneksi ke database
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            // Membuat PreparedStatement untuk menghapus data di database
            PreparedStatement statement = connection.prepareStatement("delete from biodata where id = ?");

            // Set nilai dari parameter yang ada di query
            statement.setString(1, biodata.getId()); // id

            // Eksekusi query
            result = statement.executeUpdate();

            // Print data yang dihapus di database
            System.out.println("Delete data: " + biodata.getId() + " " + biodata.getNama() + " "
                    + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());
        } catch (SQLException e) {
            // Print error jika terjadi error
            e.printStackTrace();
        }

        // Kembalikan nilai result
        return result;
    }

    // Fungsi untuk mendapatkan semua data dari database
    public List<Biodata> findAll() {
        // Membuat list untuk menyimpan semua data
        List<Biodata> list = new ArrayList<>();

        // Try with resources untuk membuat koneksi ke database
        try (
                // Membuat koneksi ke database
                Connection connection = MySqlConnection.getInstance().getConnection();
                // Membuat statement untuk mengirim query ke database
                Statement statement = connection.createStatement();) {

            // Membuat ResultSet untuk menyimpan hasil dari eksekusi query
            try (ResultSet resultSet = statement.executeQuery("select * from biodata")) {
                // Looping untuk mengambil semua data dari database
                while (resultSet.next()) {
                    // Membuat object biodata untuk menyimpan data
                    Biodata biodata = new Biodata();

                    // Set nilai dari object biodata
                    biodata.setId(resultSet.getString("id")); // id
                    biodata.setNama(resultSet.getString("nama")); // nama
                    biodata.setNoTelepon(resultSet.getString("no_telepon")); // no_telepon
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin")); // jenis_kelamin
                    biodata.setAlamat(resultSet.getString("alamat")); // alamat

                    // Menambahkan biodata ke list
                    list.add(biodata);
                }
            } catch (SQLException e) {
                // Print error jika terjadi error
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // Print error jika terjadi error
            e.printStackTrace();
        }

        // Kembalikan nilai list
        return list;
    }

    // Fungsi untuk mendapatkan data dari database berdasarkan column dan value
    public Biodata select(String column, String value) {
        // Membuat object biodata untuk menyimpan data
        Biodata biodata = new Biodata();

        // Try with resources untuk membuat koneksi ke database
        try (
                // Membuat koneksi ke database
                Connection connection = MySqlConnection.getInstance().getConnection();
                // Statement untuk mengirim query ke database
                Statement statement = connection.createStatement();
            ) {
            // Membuat ResultSet untuk menyimpan hasil dari eksekusi query
            try (ResultSet resultSet = statement.executeQuery("select * from biodata where " + column+ " = '" + value + "'");) {
                // Looping untuk mengambil semua data dari database
                while (resultSet.next()) {
                    // Set nilai dari object biodata
                    biodata.setId(resultSet.getString("id")); // id
                    biodata.setNama(resultSet.getString("nama")); // nama
                    biodata.setNoTelepon(resultSet.getString("no_telepon")); // no_telepon
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin")); // jenis_kelamin
                    biodata.setAlamat(resultSet.getString("alamat")); // alamat
                }
            } catch (SQLException e) {
                // Print error jika terjadi error
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // Print error jika terjadi error
            e.printStackTrace();
        }

        // Kembalikan nilai biodata
        return biodata;
    }
}