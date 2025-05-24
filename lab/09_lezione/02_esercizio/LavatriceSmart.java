public class LavatriceSmart extends Lavatrice implements ISmartControl {
    public LavatriceSmart(String modello, int potenza) {
        super(modello, potenza);
    }

    @Override
    public void connettiRete(String reteWifi) {
        System.out.println("connessa a rete Wifi: " + reteWifi);
    }

    @Override
    public void aggiornaFirmware() {
        System.out.println("firmware lavatrice aggiornato");
    }

    @Override
    public void accendi(String modalita) {
        System.out.println(String.format("%s %s", this.modello, "versione smart-accensione lavatrice"));
    }
}
