public class Vacanza {
    private String _luogo;
    private Data _dataPartenza;
    private Data _dataRientro;
    private Set<String> _mezzi;

    public Vacanza(String luogo, Data dataPartenza, Data dataRientro) {
        assert dataPartenza.differenza(dataRientro) >= 0;

        _luogo = luogo;
        _dataPartenza = dataPartenza;
        _dataRientro = dataRientro;
        _mezzi = new Set<String>();
    }

    // #region setters

    public void setluogo(String luogo) {
        _luogo = luogo;
    }

    public void setDataPartenza(Data dataPartenza) {
        _dataPartenza = dataPartenza;
    }

    public void setdataRientro(Data dataRientro) {
        _dataRientro = dataRientro;
    }

    // #endregion

    // #region getters
    public String getluogo() {
        return _luogo;
    }

    public Data getDataPartenza() {
        return _dataPartenza;
    }

    public Data getdataRientro() {
        return _dataRientro;
    }

    public Set<String> getmezzi() {
        return _mezzi;
    }

    // #endregion

    public int durata() {
        return Math.abs(_dataPartenza.differenza(_dataRientro));
    }

    public void aggiungiMezzo(String mezzo) {
        _mezzi.add(mezzo);
    }

    public void rimuoviMezzo(String mezzo) {
        if (!_mezzi.remove(mezzo)) {
            System.out.println("ERROR: Si è provato a rimuovere il mezzo " + mezzo + " non presente.");
        }
    }

    public String toString() {
        String mezziStr = _mezzi.toString();
        return String.format("Luogo: '%s' | dataPartenza: '%s' | dataRientro: '%s' | mezzi: %s", _luogo, _dataPartenza,
                _dataRientro, mezziStr);
    }
}