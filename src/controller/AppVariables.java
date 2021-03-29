package controller;

import model.User;

public class AppVariables {
    public static User currentUser;

    public static final SupplyController SUPPLY_SERVICE = new SupplyController();

    public static final CredentialsController CREDENTIALS_SERVICE = new CredentialsController();

    public static final BookingController BOOKING_SERVICE = new BookingController();

    public static final ClientController CLIENT_SERVICE = new ClientController();

    public static final CleanerController CLEANER_SERVICE = new CleanerController();

    public static final AddressController ADDRESS_SERVICE = new AddressController();
}
