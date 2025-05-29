public abstract class Elettrodomestico {
    protected String modello;
    private int potenza;

    public static String ACCENSIONE_STANDARD = "accensione standard";

    public abstract String funzionePrincipale();

    public Elettrodomestico(String modello, int potenza) {
        this.modello = modello;
        this.potenza = potenza;
    }

    public void accendi() {
        System.out.println(String.format("%s %s", modello, ACCENSIONE_STANDARD));
    }

    public void accendi(String modalitaAccensione) {
        assert modalitaAccensione != null : "La modalita' di accensione non deve essere nulla";
        System.out.println(String.format("%s %s %s", modello, "accensione", modalitaAccensione));
    }

    @Override
    public String toString() {
        return String.format("[modello = '%s', potenza = '%s']", modello, potenza);
    }
}
