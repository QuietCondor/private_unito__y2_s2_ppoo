public class VacanzaDemo {
    private static void println(String s) {
        System.out.println(s);
    }

    private static void printDivider() {
        println("---------------------------------------------------------");
    }

    private static void printf(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

    private static void testsData() {
        printDivider();

        // Creazione di due date
        Data data1 = new Data(10, 4, 2023);
        Data data2 = new Data(5, 5, 2025);
        printf("data1 = new Data(10, 4, 2023)");
        printf("data2 = new Data(5, 5, 2025)");

        // Test dei metodi toString e getter
        printf("TEST: %s.toString() => EXP: %s", data1, "2023-4-10"); // Atteso: 2023-4-10
        printf("TEST: %s.toString() => EXP: %s", data2, "2025-5-5"); // Atteso: 2025-5-5

        // Test dei metodi setter
        printf("data1.setGiorno(15)");
        printf("data1.setMese(12)");
        printf("data1.setAnno(2022)");
        data1.setGiorno(15);
        data1.setMese(12);
        data1.setAnno(2022);
        printf("TEST: data1.toString() = %s => EXP: 2022-12-15", data1); // Atteso: 2022-12-15

        // Test del metodo differenza
        int diff = data1.differenza(data2);
        printf("int diff = data1.differenza(data2)");
        printf("TEST: diff = %s => exp 1315", diff);

        // Ulteriore test con data uguale
        printf("Data data3 = new Data(15, 12, 2022)");
        Data data3 = new Data(15, 12, 2022);
        printf("TEST: data1.differenza(data3) = %s => EXP: 0", data1.differenza(data3)); // Atteso: 0
        printDivider();
    }

    private static void testsVacanza() {
        printDivider();

        printf("Data partenza = new Data(10, 6, 2024)");
        printf("Data rientro = new Data(20, 6, 2024)");
        Data partenza = new Data(10, 6, 2024);
        Data rientro = new Data(20, 6, 2024);

        printf("Vacanza vacanza = new Vacanza(\"Sardegna\", partenza, rientro)");
        Vacanza vacanza = new Vacanza("Sardegna", partenza, rientro);
        printf("TEST: vacanza.toString() = %s => EXP: %s", vacanza,
                "Luogo: 'Sardegna' | dataPartenza: '2024-6-10' | dataRientro: '2024-6-20' | mezzi: []");

        printf("TEST: vacanza.getluogo() = %s => EXP: Sardegna", vacanza.getluogo());
        printf("TEST: vacanza.getDataPartenza() = %s => EXP: 2024-6-10", vacanza.getDataPartenza());
        printf("TEST: vacanza.getdataRientro() = %s => EXP: 2024-6-20", vacanza.getdataRientro());

        printf("TEST: vacanza.durata() = %d => EXP: 10", vacanza.durata());

        printf("vacanza.aggiungiMezzo(\"aereo\")");
        vacanza.aggiungiMezzo("aereo");
        printf("vacanza.aggiungiMezzo(\"nave\")");
        vacanza.aggiungiMezzo("nave");
        printf("TEST: vacanza.toString() dopo aggiunta mezzi = %s => EXP: %s", vacanza,
                "Luogo: 'Sardegna' | dataPartenza: '2024-6-10' | dataRientro: '2024-6-20' | mezzi: ['aereo', 'nave']");

        printf("vacanza.rimuoviMezzo(\"aereo\")");
        vacanza.rimuoviMezzo("aereo");
        printf("TEST: vacanza.toString() dopo rimozione 'aereo' = %s => EXP: %s", vacanza,
                "Luogo: 'Sardegna' | dataPartenza: '2024-6-10' | dataRientro: '2024-6-20' | mezzi: ['nave']");

        printf("vacanza.rimuoviMezzo(\"treno\") // mezzo non presente");
        vacanza.rimuoviMezzo("treno");

        printf("vacanza.setluogo(\"Corsica\")");
        vacanza.setluogo("Corsica");
        printf("vacanza.setDataPartenza(new Data(5, 7, 2024))");
        vacanza.setDataPartenza(new Data(5, 7, 2024));
        printf("vacanza.setdataRientro(new Data(12, 7, 2024))");
        vacanza.setdataRientro(new Data(12, 7, 2024));

        printf("TEST: vacanza.toString() dopo modifiche = %s => EXP: %s", vacanza,
                "Luogo: 'Corsica' | dataPartenza: '2024-7-5' | dataRientro: '2024-7-12' | mezzi: ['nave']");

        printDivider();
    }

    public static void main(String[] args) {
        testsData();
        testsVacanza();
        testsVacanzaInternazionale();
    }

    private static void testsVacanzaInternazionale() {
        printDivider();

        printf("Data partenza = new Data(15, 7, 2024)");
        printf("Data rientro = new Data(25, 7, 2024)");
        Data partenza = new Data(15, 7, 2024);
        Data rientro = new Data(25, 7, 2024);

        printf("VacanzaInternazionale vi = new VacanzaInternazionale(\"Barcellona\", partenza, rientro, \"Spagna\")");
        VacanzaInternazionale vi = new VacanzaInternazionale("Barcellona", partenza, rientro, "Spagna");

        printf("TEST: vi.toString() = %s => EXP: %s", vi,
                "Luogo: 'Barcellona' | dataPartenza: '2024-7-15' | dataRientro: '2024-7-25' | mezzi: [] | paese: 'Spagna'");
        printf("TEST: vi.getPaese() = %s => EXP: Spagna", vi.getPaese());
        printf("TEST: vi.getluogo() = %s => EXP: Barcellona", vi.getluogo());
        printf("TEST: vi.getDataPartenza() = %s => EXP: 2024-7-15", vi.getDataPartenza());
        printf("TEST: vi.getdataRientro() = %s => EXP: 2024-7-25", vi.getdataRientro());
        printf("TEST: vi.durata() = %d => EXP: 10", vi.durata());

        printf("vi.setPaese(\"Francia\")");
        vi.setPaese("Francia");
        printf("TEST: vi.getPaese() = %s => EXP: Francia", vi.getPaese());

        printDivider();
    }
}
