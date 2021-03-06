package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private java.sql.Connection conn;

    public Connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb?" +
                    "user=root&password=0912");
        } catch (SQLException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public java.sql.Connection getConnection() {
        return conn;
    }
}
