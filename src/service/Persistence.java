package service;

import dao.Connection;
import model.User;
import repository.ListaInsumos;
import repository.ListaReservasServicos;
import service.address.AddressService;
import service.credentials.CredentialsService;
import service.supply.SupplyService;
import service.booking.BookingService;
import service.user.ClientService;
import service.user.CleanerService;

public class Persistence {
    public static final Connection CONNECTION = new Connection();

    public static final ListaInsumos SUPPLIES = new ListaInsumos();

    public static final SupplyService SUPPLY_SERVICE = new SupplyService();

    public static final CredentialsService CREDENTIALS_SERVICE = new CredentialsService();

    public static final ListaReservasServicos BOOKINGS = new ListaReservasServicos();

    public static final BookingService BOOKING_SERVICE = new BookingService();

    public static User user;

    public static final ClientService CLIENT_SERVICE = new ClientService();

    public static final CleanerService CLEANER_SERVICE = new CleanerService();

    public static final AddressService ADDRESS_SERVICE = new AddressService();
}
