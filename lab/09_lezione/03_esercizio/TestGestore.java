public class TestGestore extends BaseTestClass {
    public static void main(String[] args) {
        printDivider();

        GestoreSmart<FornoSmart> GForno = new GestoreSmart<>();
        println("GestoreSmart<FornoSmart> GForno = new GestoreSmart<>();");

        println("FornoSmart F1 = new FornoSmart('miele', 10);");
        FornoSmart F1 = new FornoSmart("miele", 10);
        println("FornoSmart F1 = new FornoSmart('samsung', 20);");
        FornoSmart F2 = new FornoSmart("samsung", 20);
        println("FornoSmart F1 = new FornoSmart('ok', 30);");
        FornoSmart F3 = new FornoSmart("ok", 30);

        println("GForno.aggiungiDispositivo(F1);");
        println("GForno.aggiungiDispositivo(F2);");
        println("GForno.aggiungiDispositivo(F3);");
        GForno.aggiungiDispositivo(F1);
        GForno.aggiungiDispositivo(F2);
        GForno.aggiungiDispositivo(F3);

        printf("GForno.connettiTutti('Vodafone'); | EXP: '%s' * 3", "connesso a rete Wifi: Vodafone");
        GForno.connettiTutti("Vodafone");

        printf("GForno.aggiornaTutti(); | EXP: '%s' * 3", "firmware forno aggiornato");
        GForno.aggiornaTutti();

        printf("GForno.stampaInfo(); | EXP: \n 1 => '%s'\n 2 => '%s'\n 3 => '%s' * 3",
                "descrizione: [modello = 'miele', potenza = '10']\nfunzione principale: Cottura degli alimenti",
                "descrizione: [modello = 'samsung', potenza = '20']\nfunzione principale: Cottura degli alimenti",
                "descrizione: [modello = 'ok', potenza = '30']\nfunzione principale: Cottura degli alimenti");
        GForno.stampaInfo();

        printDivider();
    }
}
