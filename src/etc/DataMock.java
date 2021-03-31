package etc;

import controller.ControllerSingleton;
import dao.*;
import model.*;

import java.sql.SQLException;
import java.util.Date;

/**
 * Classe responsável por criar dados de teste na base de dados
 */
public class DataMock {
    public static Address mockAddress() {
        var address = new Address("Rua Antonio Carlos", 999, "Antonio Carlos", "MG", "Novo Bairro");
        final var addrDao = new AddressDao();

        try {
            addrDao.insert(address);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

        try {
            return addrDao.getItem(new String[]{
                    address.getAddress(),
                    String.valueOf(address.getNumber()),
                    address.getCity(),
                    address.getState(),
                    address.getDistrict()});
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

        return null;
    }

    public static Credentials mockCredentials() {
        var credentials = new Credentials("teste", "teste");
        final var crDao = new CredentialsDao();

        try {
            crDao.insert(credentials);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

        try {
            return crDao.getItem(new String[]{
                    credentials.getUsername(),
                    credentials.getPassword()});
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

        return null;
    }

    private static <T extends User> void mockUser(T user, UserDao<T> userDao) {
        try {
            userDao.insert(user);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

        try {
            var address = user.getAddress();
            var credentials = user.getCredentials();
            user = userDao.getItem(new String[]{String.valueOf(user.getCpf()), String.valueOf(user.getIdentity())});
            user.setAddress(address);
            user.setCredentials(credentials);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }

        ControllerSingleton.currentUser = user;
    }

    public static void mockClient() {
        final var clientDao = new ClientDao();
        var client = new Client("Cliente", true, new Date(), 00000000000, 00000000, mockAddress(), mockCredentials());

        mockUser(client, clientDao);
    }

    public static void mockCleaner() {
        final var cleanerDao = new CleanerDao();
        var cleaner = new Cleaner("Faxineiro", true, new Date(), 00000000000, 00000000, mockAddress(), mockCredentials());
        mockUser(cleaner, cleanerDao);
    }

}
