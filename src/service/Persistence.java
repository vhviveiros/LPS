package service;

import dao.Connection;
import model.User;
import service.address.AddressService;
import service.credentials.CredentialsService;
import service.supply.SupplyService;
import service.booking.BookingService;
import service.user.ClientService;
import service.user.CleanerService;

public class Persistence {
    public static User currentUser;

    public static final Connection CONNECTION = new Connection();

    public static final SupplyService SUPPLY_SERVICE = new SupplyService();

    public static final CredentialsService CREDENTIALS_SERVICE = new CredentialsService();

    public static final BookingService BOOKING_SERVICE = new BookingService();

    public static final ClientService CLIENT_SERVICE = new ClientService();

    public static final CleanerService CLEANER_SERVICE = new CleanerService();

    public static final AddressService ADDRESS_SERVICE = new AddressService();
}
