package Pertemuan9.BiodataDB.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import Pertemuan9.BiodataDB.db.MySqlConnection;
import Pertemuan9.BiodataDB.biodata.Biodata;

public class BiodataDao {
    public int insert(Biodata biodata) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO biodata (nama, no_hp, jenis_kelamin, wna, " +
                    "id, alamat) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, biodata.getNama());
            statement.setString(2, biodata.getNoHp());
            statement.setString(3, biodata.getJenisKelamin());
            statement.setString(4, biodata.getStatus());
            statement.setString(5, biodata.getId());
            statement.setString(6, biodata.getAlamat());

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(Biodata biodata) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE biodata SET nama = ?, no_hp = ?, jenis_kelamin = " +
                    "?, wna = ?, alamat = ? WHERE id = ?");
            statement.setString(1, biodata.getNama());
            statement.setString(2, biodata.getNoHp());
            statement.setString(3, biodata.getJenisKelamin());
            statement.setString(4, biodata.getStatus());
            statement.setString(5, biodata.getAlamat());
            statement.setString(6, biodata.getId());

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(String id) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM biodata WHERE id = ?");
            statement.setString(1, id);

            result = statement.executeUpdate();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Biodata> findAll() {
        List<Biodata> list = new ArrayList<>();
        try (Connection connection = MySqlConnection.getInstance().getConnection();
             Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM biodata");) {
                while (resultSet.next()) {
                    Biodata biodata = new Biodata();
                    biodata.setId(resultSet.getString("id"));
                    biodata.setNama(resultSet.getString("nama"));
                    biodata.setNoHp(resultSet.getString("no_hp"));
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin"));
                    biodata.setStatus(resultSet.getString("wna"));
                    biodata.setAlamat(resultSet.getString("alamat"));
                    list.add(biodata);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
