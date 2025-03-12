class Metropolitana {
    private String numeroMatricola;
    private int linea;
    private int prossimaStazione;

    public Metropolitana(String numeroMatricola, int linea, int prossimaStazione) {
        this.numeroMatricola = numeroMatricola;
        this.linea = linea;
        this.prossimaStazione = prossimaStazione;
    }

    public void aggiornaProssimaStazione() {
        prossimaStazione = (prossimaStazione + 1) % 10;
    }

    public int getProssimaStazione() {
        return this.prossimaStazione;
    }
}

public class MetropolitanaTest {
    public static void main(String[] args) {
        Metropolitana m1 = new Metropolitana("M1", 1, 9);
        Metropolitana m2 = new Metropolitana("M2", 2, 6);

        for (int i = 0; i <= 1; i++) {
            m1.aggiornaProssimaStazione();
            m2.aggiornaProssimaStazione();
        }

        System.out.println("Prossima stazione M1: " + m1.getProssimaStazione() + " expected 1");
        System.out.println("Prossima stazione M1: " + m2.getProssimaStazione() + " expected 8");
    }
}