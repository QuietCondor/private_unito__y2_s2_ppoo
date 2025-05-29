import java.util.*;

public class GestoreSmart<T extends Elettrodomestico & ISmartControl> {
    private ArrayList<T> _dispositivi = new ArrayList<>();

    public void aggiungiDispositivo(T dispositivo) {
        _dispositivi.add(dispositivo);
    }

    public void connettiTutti(String reteWifi) {
        for (T dis : _dispositivi) {
            dis.connettiRete(reteWifi);
        }
    }

    public void aggiornaTutti() {
        for (T dis : _dispositivi) {
            dis.aggiornaFirmware();
        }
    }

    public void stampaInfo() {
        for (T dis : _dispositivi) {
            System.out.println("descrizione: " + dis);
            System.out.println("funzione principale: " + dis.funzionePrincipale());
        }
    }
}