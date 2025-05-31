public class ReservationTest {
    public static void main(String[] args) {
        Reservation res1 = new Reservation("Mario Rossi", 4);
        Reservation res2 = new Reservation("Giulia Bianchi", 2);
        Reservation res3 = new Reservation();

        System.out.println("Res1: " + res1);
        System.out.println("Res2: " + res2);
        System.out.println("Res3: " + res3);

        System.out.println("Res1 equals Res2: " + res1.equals(res2));
        System.out.println("Res1 equals Res1: " + res1.equals(res1));

        res1.updateGuests(5);
        System.out.println("Res1 after update: " + res1);

        System.out.println("Total reservations created: " + Reservation.getTotalReservations());

        VIPReservation vipRes = new VIPReservation("Luca Verdi", 3, "Tavolo vicino alla finestra");
        System.out.println("VIP Reservation: " + vipRes);
    }
}