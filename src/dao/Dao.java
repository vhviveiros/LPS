package dao;

import model.Model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Dao<T extends Model> {
    Connection CONNECTION = new Connection();

    void insert(T model) throws SQLException;

    void remove(T model) throws SQLException;

    void alter(T oldValue, T newValue) throws SQLException;

    T getItem(String[] args) throws SQLException;

    ArrayList<T> getList(String[] args) throws SQLException;

    interface RunnableStmt<T> {
        T run(java.sql.Connection conn) throws SQLException;
    }

    /**
     * Executa o sql statement, e em seguida fecha a conexão automaticamente
     *
     * @param stmt
     * @throws SQLException
     */
    default <S> S executeStmt(RunnableStmt<S> stmt) throws SQLException {
        try {
            return stmt.run(CONNECTION.getConnection());
        } finally {
            CONNECTION.disconnect();
        }
    }
}
