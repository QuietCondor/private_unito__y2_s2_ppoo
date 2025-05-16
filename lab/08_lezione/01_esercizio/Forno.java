public class Forno extends Elettrodomestico {
    public Forno(String modello, int potenza) {
        super(modello, potenza);
    }

    @Override
    public String funzionePrincipale() {
        return "Cottura degli alimenti";
    }
}
