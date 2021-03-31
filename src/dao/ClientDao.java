package dao;

import model.Client;
import controller.ControllerSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao extends UserDao<Client> {
    /**
     * @param args 0=cpf, 1=rg
     * @return
     * @throws SQLException
     */
    @Override
    public Client getItem(String[] args) throws SQLException {
        return executeStmt(conn -> {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM tbl_user WHERE cpf=? && identity=?");
            ps.setString(1, args[0]);
            ps.setString(2, args[1]);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return new Client(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("gender"),
                        new java.util.Date(rs.getDate("birthdate").getTime()),
                        rs.getLong("cpf"),
                        rs.getLong("identity"),
                        ControllerSingleton.ADDRESS_CONTROLLER.getItem(args),
                        ControllerSingleton.CREDENTIALS_CONTROLLER.getItem(args)
                );
            throw new SQLException();
        });
    }

    @Override
    protected boolean isClient() {
        return true;
    }
}
