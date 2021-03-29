package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private java.sql.Connection conn;

    public Connection() {
        connect();
    }

    public java.sql.Connection getConnection() {
        connect();
        return conn;
    }

    private void connect() {
        if (conn == null)
            try {
                Class.forName("org.gjt.mm.mysql.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false", "root",
                        "0912");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            conn = null;
        }
    }
}
