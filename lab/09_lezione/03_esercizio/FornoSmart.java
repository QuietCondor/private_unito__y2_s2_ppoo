public class FornoSmart extends Forno implements ISmartControl {
    public FornoSmart(String modello, int potenza) {
        super(modello, potenza);
    }

    @Override
    public void connettiRete(String reteWifi) {
        System.out.println("connesso a rete Wifi: " + reteWifi);
    }

    @Override
    public void aggiornaFirmware() {
        System.out.println("firmware forno aggiornato");
    }

    @Override
    public void accendi(String modalita) {
        System.out.println(String.format("%s %s", this.modello, "versione smart-accensione forno"));
    }
}
