public class VehicleTest {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("AB123CD", true);
        Vehicle v2 = new Vehicle("EF456GH", false);
        Vehicle v3 = new Vehicle();

        System.out.println("Vehicle 1: " + v1);
        System.out.println("Vehicle 2: " + v2);
        System.out.println("Vehicle 3: " + v3);

        System.out.println("Vehicle 1 equals Vehicle 1: " + v1.equals(v1));
        System.out.println("Vehicle 1 equals Vehicle 2: " + v1.equals(v2));

        v1.toggleRentalStatus();
        System.out.println("Vehicle 1 after toggle: " + v1);

        System.out.println("Total vehicles registered: " + Vehicle.getTotalVehicles());

        ElectricVehicle ev = new ElectricVehicle("EV789JK", true, 45.0);
        System.out.println("Electric Vehicle before toggle: " + ev);
        ev.toggleRentalStatus();
        System.out.println("Electric Vehicle after toggle: " + ev);
    }
}