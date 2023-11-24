package Pertemuan9.Membership.dao;

import Pertemuan9.Membership.db.MySqlConnection;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import Pertemuan9.Membership.jenis_member.JenisMember;

public class JenisMemberDao {
    public int insert(JenisMember jenisMember) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO jenis_member (id, nama) VALUES (?, ?)");
            statement.setString(1, jenisMember.getId());
            statement.setString(2, jenisMember.getNama());
            
            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int update(JenisMember jenisMember) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE jenis_member SET nama = ? WHERE id = ?");
            statement.setString(1, jenisMember.getNama());
            statement.setString(2, jenisMember.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(JenisMember jenisMember) {
        int result = -1;
        try(Connection connection = MySqlConnection.getInstance().getConnection(); ) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM jenis_member WHERE id = ?");
            statement.setString(1, jenisMember.getId());

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<JenisMember> findAll() {
        List<JenisMember> list = new ArrayList<>();
        try(Connection connection = MySqlConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();) {
            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM jenis_member");) {
                while(resultSet.next()) {
                    JenisMember jenisMember = new JenisMember();
                    jenisMember.setId(resultSet.getString("id"));
                    jenisMember.setNama(resultSet.getString("nama"));

                    list.add(jenisMember);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
