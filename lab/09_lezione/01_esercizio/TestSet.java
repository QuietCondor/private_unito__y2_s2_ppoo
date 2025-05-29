public class TestSet {

    public static void main(String[] args) {
        // INSIEMI DI Integer
        // INSIEMI DI Person
        Person p1 = new Person("Mario", "Rossi");
        Person p2 = new Person("Luisa", "Verdi");
        Person p3 = new Person("Carla", "Bianchi");
        Person p4 = new Person("Gino", "Gialli");
        Person p5 = new Person("Paola", "Indaco");
        Set<Person> ps1 = new Set<>();
        Set<Person> ps2 = new Set<>();
        Set<Person> ps3 = new Set<>();
        Set<Person> ps4 = new Set<>();
        ps1.add(p1);
        ps1.add(p2);
        ps1.add(p3);
        ps1.add(p5);
        ps2.add(p2);
        ps2.add(p3);
        ps2.add(p4);
        ps3.add(p1);
        ps3.add(p2);
        ps3.add(p3);
        ps3.add(p4);
        ps4.add(p1);
        ps4.add(p2);
        ps4.add(p3);
        ps4.add(p3);
        ps4.add(p3);
        ps4.add(p3);
        System.out.println("\n===INSIEMI DI Person===");
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);
        System.out.println("p4: " + p4);
        System.out.println("p5: " + p5);

        System.out.println("Insieme ps1: " + ps1.print());
        System.out.println("Insieme ps2: " + ps2.print());
        System.out.println("Insieme ps3: " + ps3.print());
        System.out.println("Insieme ps4: " + ps4.print());

        System.out.println("ps1.size(): " + ps1.size());
        System.out.println("ps2.size(): " + ps2.size());
        System.out.println("ps3.size(): " + ps3.size());
        System.out.println("ps4.size(): " + ps4.size());
        System.out.println("(new Set<Person>()).size(): " + (new Set<Person>()).size());

        System.out.println("ps1.empty(): " + ps1.empty());
        System.out.println("(new Set<Person>()).empty(): " + (new Set<Person>()).empty());

        System.out.println("ps1.contains(p5): " + ps1.contains(p5));// Stampa true
        System.out.println("ps1.contains(new Person(\"Paola\",\"Indaco\")): "
                + ps1.contains(new Person("Paola", "Indaco")));// Stampa false...
        // Questo e` corretto, in quanto il metodo contains(...) in Set
        // e` basato sull'implementazione
        // di default del metodo equals(...) di Java, il quale considera uguali due
        // oggetti se e solo se sono lo stesso oggetto. Questo criterio di uguaglianza
        // e` adatto in questo contesto in cui si confrontano oggetti di tipo
        // Person, in quanto due persone p1 e p2 sono uguali se e solo se
        // sono la stessa persona (e non, ovviamente, se sono due persone diverse,
        // anche se omonime)
        System.out.println("ps1.remove(p5): " + ps1.remove(p5));
        System.out.println("ps1.contains(p5): " + ps1.contains(p5));

        Set<Person> psIntersect = ps1.intersection(ps2);
        System.out.print("Insieme intersezione di ps1 e ps2: ");
        System.out.println(psIntersect);

        Set<Person> psUnion = ps1.union(ps2);
        System.out.print("Insieme unione di ps1 e ps2: ");
        System.out.println(psUnion);

        System.out.println("ps1.subsetOf(ps3): " + ps1.subsetOf(ps3));
        System.out.println("ps3.subsetOf(ps1): " + ps3.subsetOf(ps1));
        System.out.println("(new Set<Person>()).subsetOf(ps1): " + (new Set<Person>()).subsetOf(ps1));
        System.out.println("ps1.subsetOf((new Set<Person>())): " + ps1.subsetOf((new Set<>())));

        System.out.println("ps1.equalsTo(ps4): " + ps1.equalsTo(ps4));
        System.out.println("ps1.equalsTo(ps2): " + ps1.equalsTo(ps2));
        System.out.println(
                "(new Set<Person>()).equalsTo(new Set<Person>()): " + (new Set<Person>()).equalsTo(new Set<>()));
    }
}
