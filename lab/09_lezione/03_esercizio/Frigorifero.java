public class Frigorifero extends Elettrodomestico {
    public Frigorifero(String modello, int potenza) {
        super(modello, potenza);
    }

    @Override
    public String funzionePrincipale() {
        return "Conservazione degli alimenti";
    }
}
