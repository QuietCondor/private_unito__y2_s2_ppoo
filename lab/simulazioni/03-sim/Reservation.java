public class Reservation {
    private static int _reservationCounter = 0;

    private int _reservationId;
    private String _customerName;
    private int _numberOfGuests;

    public Reservation(String customerName, int numberOfGuests) {
        _customerName = customerName;
        _numberOfGuests = numberOfGuests;
        _reservationId = _reservationCounter;
        _reservationCounter++;
    }

    public Reservation() {
        _reservationId = _reservationCounter;
        _reservationCounter++;
    }

    public int getReservationId() {
        return this._reservationId;
    }

    public String getCustomerName() {
        return this._customerName;
    }

    public int getNumberOfGuests() {
        return this._numberOfGuests;
    }

    public void setCustomerName(String customerName) {
        _customerName = customerName;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        _numberOfGuests = numberOfGuests;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Reservation)) {
            return false;
        }

        Reservation castedObj = (Reservation) obj;
        return this._reservationId == castedObj._reservationId;
    }

    @Override
    public String toString() {
        return String.format("[Reservation ID = %s, Customer Name = %s, N. Guests = %s]", _reservationId, _customerName,
                _numberOfGuests);
    }

    public void updateGuests(int newCount) {
        if (newCount < 0) {
            return;
        }

        _numberOfGuests = newCount;
    }

    public static int getTotalReservations() {
        return Reservation._reservationCounter;
    }
}
