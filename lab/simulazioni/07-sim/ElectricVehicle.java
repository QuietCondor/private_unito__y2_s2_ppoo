public class ElectricVehicle extends Vehicle {
    private double _batteryLevel;

    public ElectricVehicle(double batteryLevel) {
        super();
        _batteryLevel = batteryLevel;
    }

    public ElectricVehicle(String plateNumber, boolean rented, double batteryLevel) {
        super(plateNumber, rented);
        _batteryLevel = batteryLevel;
    }

    @Override
    public void toggleRentalStatus() {
        super.toggleRentalStatus();
        if (!super.getRented()) {
            _batteryLevel = 100;
        }
    }

    @Override
    public String toString() {
        String base = super.toString();
        return String.format("%s - [Battery LVL = %s]", base, _batteryLevel);
    }
}
