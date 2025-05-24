public class CasaTest extends BaseTestClass {
    public static void main(String[] args) {
        printDivider();
        println("Test per 'Lavatrice'");
        printf("Lavatrice L = new Lavatrice('Bosh9000', 10)");
        Lavatrice L = new Lavatrice("Bosh9000", 10);
        L.accendi();
        printf("L.accendi() = 'PRINT_PREC' | CORRECT RES: 'Bosh9000 %s'", Elettrodomestico.ACCENSIONE_STANDARD);
        L.accendi("eco");
        printf("L.accendi() = 'PRINT_PREC' | CORRECT RES: 'Bosh9000 %s eco'", "accensione");
        printf("L.toString() = '%s' | CORRECT RES: '%s'", L.toString(), "[modello = 'Bosh9000', potenza = '10']");

        println("Test per 'Lavatrice Smart'");
        printf("LavatriceSmart LS = new LavatriceSmart('Bosh9000', 10)");
        LavatriceSmart LS = new LavatriceSmart("Bosh9000", 10);
        LS.accendi();
        printf("LS.accendi() = 'PRINT_PREC' | CORRECT RES: 'Bosh9000 %s'", "smart-accensione lavatrice");
        LS.accendi("eco");
        printf("LS.accendi() = 'PRINT_PREC' | CORRECT RES: 'Bosh9000 %s eco'", "smart-accensione lavatrice eco");
        printf("LS.toString() = '%s' | CORRECT RES: '%s'", L.toString(), "[modello = 'Bosh9000', potenza = '10']");
        LS.connettiRete("wif");
        printf("LS.connettiRete('wif') = 'PRINT_PREC' | CORRECT RES: '%s'", L.toString(),
                "connessa a rete wifi: wif");
        LS.aggiornaFirmware();
        printf("LS.aggiornaFirmware() = 'PRINT_PREC' | CORRECT RES: '%s'", L.toString(),
                "firmware lavatrice aggiornato");

        printDivider();

        printDivider();
        println("Test per 'Forno'");
        printf("Forno F = new Forno('Fornetto', 20)");
        Forno F = new Forno("Fornetto", 20);
        F.accendi();
        printf("F.accendi() = 'PRINT_PREC' | CORRECT RES: 'Fornetto %s'", Elettrodomestico.ACCENSIONE_STANDARD);
        F.accendi("eco");
        printf("F.accendi() = 'PRINT_PREC' | CORRECT RES: 'Fornetto %s eco'", "accensione");
        printf("F.toString() = '%s' | CORRECT RES: '%s'", F.toString(), "[modello = 'Fornetto', potenza = '20']");
        printDivider();

        printDivider();
        println("Test per 'Frigorifero'");
        printf("Frigorifero Fr = new Frigorifero('Samsung', 30)");
        Frigorifero Fr = new Frigorifero("Samsung", 30);
        Fr.accendi();
        printf("Fr.accendi() = 'PRINT_PREC' | CORRECT RES: 'Samsung %s'", Elettrodomestico.ACCENSIONE_STANDARD);
        Fr.accendi("eco");
        printf("Fr.accendi() = 'PRINT_PREC' | CORRECT RES: 'Samsung %s eco'", "accensione");
        printf("Fr.toString() = '%s' | CORRECT RES: '%s'", Fr.toString(), "[modello = 'Samsung', potenza = '30']");
        printDivider();
    }
}
