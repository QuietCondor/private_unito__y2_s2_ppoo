public class Vehicle {
    private static int _vehicleCounter = 0;

    private int _vehicleId;
    private String _plateNumber;
    private boolean _rented;

    public Vehicle() {
        _vehicleId = _vehicleCounter;
        _vehicleCounter++;
    }

    public Vehicle(String plateNumber, boolean rented) {
        _vehicleId = _vehicleCounter;
        _vehicleCounter++;

        _plateNumber = plateNumber;
        _rented = rented;
    }

    public int getVehicleId() {
        return _vehicleId;
    }

    public String getPlateNumber() {
        return _plateNumber;
    }

    public boolean getRented() {
        return _rented;
    }

    public void setPlateNumber(String plateNumber) {
        _plateNumber = plateNumber;
    }

    public void setRented(boolean rented) {
        _rented = rented;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Vehicle)) {
            return false;
        }

        Vehicle castedObj = (Vehicle) obj;

        return castedObj._vehicleId == this._vehicleId;
    }

    @Override
    public String toString() {
        return String.format("[ID = %s, Plate N. = %s, Rented = %s]", _vehicleId, _plateNumber, _rented);
    }

    public void toggleRentalStatus() {
        _rented = !_rented;
    }

    public static int getTotalVehicles() {
        return Vehicle._vehicleCounter;
    }
}
