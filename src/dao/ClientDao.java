package dao;

import model.Client;
import service.Persistence;

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
        PreparedStatement ps = Persistence.CONNECTION.getConnection().prepareStatement(
                "SELECT * FROM tbl_user WHERE cpf=" + "\"" + args[0] + "\"" + " && identity=" + "\"" + args[1] + "\"");
        ResultSet rs = ps.executeQuery();

        if (rs.next())
            return new Client(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getBoolean("gender"),
                    new java.util.Date(rs.getDate("birthdate").getTime()),
                    rs.getLong("cpf"),
                    rs.getLong("identity"),
                    Persistence.ADDRESS_SERVICE.getItem(args),
                    Persistence.CREDENTIALS_SERVICE.getItem(args)
            );
        throw new SQLException();
    }

    @Override
    protected boolean isClient() {
        return true;
    }
}
