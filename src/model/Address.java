package model;

public class Address extends Model{
    private String address;
    private int number;
    private String city;
    private String state;
    private String district;

    public static final String[] STATES = new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "ES","GO", "MA", "MT", "MS", "MG",
            "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"};

    public Address(int id, String address, int number, String city, String state, String district) {
        super(id);
        this.address = address;
        this.number = number;
        this.city = city;
        this.state = state;
        this.district = district;
    }

    public Address(String address, int number, String city, String state, String district) {
        this.address = address;
        this.number = number;
        this.city = city;
        this.state = state;
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
