package classes;

public class Matita {
    // valori massimi e minimi
    public static final int MIN_STELO = 10;
    public static final int MAX_STELO = 200;
    public static final int MAX_PUNTA = 5;

    // le lunghezze sono in mm
    private int stelo;
    private int punta;

    /**
     * Inizializza una matita data la specifica:
     * (ii) Il costruttore di Matita consente di costruire una
     * matita con punta di lunghezza massima dato lo stelo. Un assert
     * impedisce lunghezze non accettabili dello stelo.
     * 
     * @param stelo Il dato stelo.
     */
    public Matita(int stelo) {
        assert stelo >= MIN_STELO && stelo <= MAX_STELO : "Lo stelo inserito (" + stelo + ") deve essere contenuto fra "
                + MIN_STELO + " e " + MAX_STELO + ".";
        this.stelo = stelo;
        this.punta = MAX_PUNTA;
    }

    // #region Getters
    public int getStelo() {
        return stelo;
    }

    public int getPunta() {
        return punta;
    }
    // #endregion

    public boolean disegna() {
        if (this.punta > 0) {
            this.punta--;
            return true;
        } else
            return false;
    }

    public boolean tempera() {
        boolean puoTemperare = stelo > MIN_STELO;

        if (!puoTemperare) {
            return puoTemperare;
        }

        stelo--;

        if (punta < MAX_PUNTA) {
            punta++;
        }

        return puoTemperare;
    }
}