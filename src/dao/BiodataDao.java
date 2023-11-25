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
public class BiodataDao {
    public int insert(Biodata biodata) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "Insert into biodata(id, nama, no_telepon, jenis_kelamin, alamat) values (?, ?, ?, ?, ?)");
            statement.setString(1, biodata.getId());
            statement.setString(2, biodata.getNama());
            statement.setString(3, biodata.getNoTelepon());
            statement.setString(4, biodata.getJenisKelamin());
            statement.setString(5, biodata.getAlamat());
            result = statement.executeUpdate();
            System.out.println("Insert data: " + biodata.getId() + " " + biodata.getNama() + " "
                    + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Biodata biodata) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "update biodata set nama = ?, no_telepon = ?, jenis_kelamin = ?, alamat = ? where id = ?");
            statement.setString(1, biodata.getNama());
            statement.setString(2, biodata.getNoTelepon());
            statement.setString(3, biodata.getJenisKelamin());
            statement.setString(4, biodata.getAlamat());
            statement.setString(5, biodata.getId());

            System.out.println("Update data: " + biodata.getId() + " " + biodata.getNama() + " "
                    + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(Biodata biodata) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from biodata where id = ?");
            statement.setString(1, biodata.getId());
            result = statement.executeUpdate();
            System.out.println("Delete data: " + biodata.getId() + " " + biodata.getNama() + " "
                    + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Biodata> findAll() {
        List<Biodata> list = new ArrayList<>();
        try (
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("select * from biodata")) {
                while (resultSet.next()) {
                    Biodata biodata = new Biodata();
                    biodata.setId(resultSet.getString("id"));
                    biodata.setNama(resultSet.getString("nama"));
                    biodata.setNoTelepon(resultSet.getString("no_telepon"));
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin"));
                    biodata.setAlamat(resultSet.getString("alamat"));

                    list.add(biodata);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Biodata selectByName(String name) {
        Biodata biodata = new Biodata();
        try (
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("select * from biodata where nama = '" + name + "'")) {

                while (resultSet.next()) {
                    biodata.setId(resultSet.getString("id"));
                    biodata.setNama(resultSet.getString("nama"));
                    biodata.setNoTelepon(resultSet.getString("no_telepon"));
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin"));
                    biodata.setAlamat(resultSet.getString("alamat"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return biodata;
    }

    public Biodata selectByTelephone(String telephone) {
        Biodata biodata = new Biodata();
        try (
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement
                    .executeQuery("select * from biodata where no_telepon = '" + telephone + "'")) {

                while (resultSet.next()) {
                    biodata.setId(resultSet.getString("id"));
                    biodata.setNama(resultSet.getString("nama"));
                    biodata.setNoTelepon(resultSet.getString("no_telepon"));
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin"));
                    biodata.setAlamat(resultSet.getString("alamat"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return biodata;
    }

    public Biodata selectByGender(String gender) {
        Biodata biodata = new Biodata();
        try (
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement
                    .executeQuery("select * from biodata where jenis_kelamin = '" + gender + "'")) {

                while (resultSet.next()) {
                    biodata.setId(resultSet.getString("id"));
                    biodata.setNama(resultSet.getString("nama"));
                    biodata.setNoTelepon(resultSet.getString("no_telepon"));
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin"));
                    biodata.setAlamat(resultSet.getString("alamat"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return biodata;
    }

    public Biodata selectByAddress(String address) {
        Biodata biodata = new Biodata();
        try (
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement
                    .executeQuery("select * from biodata where alamat = '" + address + "'")) {

                while (resultSet.next()) {
                    biodata.setId(resultSet.getString("id"));
                    biodata.setNama(resultSet.getString("nama"));
                    biodata.setNoTelepon(resultSet.getString("no_telepon"));
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin"));
                    biodata.setAlamat(resultSet.getString("alamat"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return biodata;
    }

}
