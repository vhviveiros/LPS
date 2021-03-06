package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private java.sql.Connection conn;

    public Connection() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root",
                    "0912");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public java.sql.Connection getConnection() {
        return conn;
    }
}
