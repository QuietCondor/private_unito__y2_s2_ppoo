public class VIPReservation extends Reservation {
    private String _specialGuest;

    public VIPReservation(String specialGuest) {
        super();
        _specialGuest = specialGuest;
    }

    public VIPReservation(String customerName, int numberOfGuests, String specialGuest) {
        super(customerName, numberOfGuests);
        _specialGuest = specialGuest;
    }

    @Override
    public String toString() {
        String baseData = super.toString();
        return String.format("%s [ SpecialGuest = %s ]", baseData, _specialGuest);
    }
}
