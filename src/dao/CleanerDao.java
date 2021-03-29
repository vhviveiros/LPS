package dao;

import model.Cleaner;
import controller.AppVariables;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CleanerDao extends UserDao<Cleaner> {
    /**
     * @param args 0=cpf, 1=rg
     * @throws SQLException
     */
    @Override
    public Cleaner getItem(String[] args) throws SQLException {
        PreparedStatement ps = CONNECTION.getConnection().prepareStatement(
                "SELECT FIRST FROM tbl_address WHERE cpf="+ "\"" + args[0]+ "\"" + "&& identity="+ "\"" + args[1]+ "\"");
        ResultSet rs = ps.executeQuery();

        return new Cleaner(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getBoolean("gender"),
                new java.util.Date(rs.getDate("birthdate").getTime()),
                rs.getLong("cpf"),
                rs.getLong("identity"),
                AppVariables.ADDRESS_SERVICE.getItem(args),
                AppVariables.CREDENTIALS_SERVICE.getItem(args)
        );
    }

    @Override
    protected boolean isClient() {
        return false;
    }
}
