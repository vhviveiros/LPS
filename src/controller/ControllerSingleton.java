package controller;

import model.User;

public class ControllerSingleton {
    public static User currentUser;

    public static final SupplyController SUPPLY_CONTROLLER = new SupplyController();

    public static final CredentialsController CREDENTIALS_CONTROLLER = new CredentialsController();

    public static final BookingController BOOKING_CONTROLLER = new BookingController();

    public static final ClientController CLIENT_CONTROLLER = new ClientController();

    public static final CleanerController CLEANER_CONTROLLER = new CleanerController();

    public static final AddressController ADDRESS_CONTROLLER = new AddressController();
}
