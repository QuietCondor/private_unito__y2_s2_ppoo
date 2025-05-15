public class VacanzaInternazionale extends Vacanza {
    private String _paese;

    public VacanzaInternazionale(String luogo, Data dataPartenza, Data dataRientro, String paese) {
        super(luogo, dataPartenza, dataRientro);
        _paese = paese;
    }

    public void setPaese(String paese) {
        _paese = paese;
    }

    public String getPaese() {
        return _paese;
    }

    public String toString() {
        String baseString = super.toString();
        return String.format("Paese: '%s' | %s", _paese, baseString);
    }
}
