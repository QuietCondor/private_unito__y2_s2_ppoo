public class Data {
    private int _giorno;
    private int _mese;
    private int _anno;

    public Data(int giorno, int mese, int anno) {
        _giorno = giorno;
        _mese = mese;
        _anno = anno;
    }

    // #region getters
    public int getGiorno() {
        return _giorno;
    }

    public int getMese() {
        return _mese;
    }

    public int getAnno() {
        return _anno;
    }
    // #endregion

    // #region setters
    public void setGiorno(int giorno) {
        _giorno = giorno;
    }

    public void setMese(int mese) {
        _mese = mese;
    }

    public void setAnno(int anno) {
        _anno = anno;
    }

    // #endregion

    public int differenza(Data d) {
        int annoDiff = d.getAnno() - this.getAnno();
        int meseDiff = d.getMese() - this.getMese();
        int giornoDiff = d.getGiorno() - this.getGiorno();

        return giornoDiff + 30 * meseDiff + 365 * annoDiff;
    }

    public String toString() {
        return _anno + "-" + _mese + "-" + _giorno;
    }
}