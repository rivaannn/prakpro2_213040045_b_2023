package Pertemuan9.BiodataDB.db;

import java.sql.Connection;
import java.sql.DriverManager;


public class MySqlConnection {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/biodatadb";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "";

    private static Pertemuan9.BiodataDB.db.MySqlConnection instance;

    public static Pertemuan9.BiodataDB.db.MySqlConnection getInstance() {
        if (instance == null) {
            instance = new Pertemuan9.BiodataDB.db.MySqlConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
