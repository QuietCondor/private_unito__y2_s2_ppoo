public class SetTest {
    // #region print reducers -> Java peggior boilerplate del pianeta terra <<< C#
    private static void println(String s) {
        System.out.println(s);
    }

    private static void printf(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

    private static void printDivider() {
        println("---------------------------------------------------------");
    }

    private static void printTestStart(String testName) {
        printDivider();
        println("START test for: " + testName);
        printDivider();
    }

    private static void printTestEnd(String testName) {
        printDivider();
        println("END test for: " + testName);
        printDivider();
    }
    // #endregion

    private static void testIntegers() {
        printTestStart("Integers");

        println("Tests for => setOne = Set()");
        Set<Integer> setOne = new Set<>();
        printf("TST: Set(); Set != null => %s [Expected: true]", setOne != null);
        printDivider();

        println("Tests for => size(), add(), empty()");
        printf("TST: setOne.size() => %s [Expected: 0]", setOne.size());
        printf("TST: setOne.empty() => %s [Expected: true]", setOne.empty());

        setOne.add(1);
        println("setOne.add(1);");

        printf("TST: setOne.size() => %s [Expected: 1]", setOne.size());
        printf("TST: setOne.empty() => %s [Expected: false]", setOne.empty());

        printDivider();
        println("Tests for => contains(), remove(), size()");
        printf("TST: setOne.contains(1) => %s [Expected: true]", setOne.contains(1));
        printf("TST: setOne.contains(2) => %s [Expected: false]", setOne.contains(2));

        println("setOne.add(2);");
        setOne.add(2);

        printf("TST: setOne.contains(2) => %s [Expected: true]", setOne.contains(2));
        printf("TST: setOne.size() => %s [Expected: 2]", setOne.size());

        println("setOne.remove(1);");
        setOne.remove(1);
        printf("TST: setOne.contains(1) => %s [Expected: false]", setOne.contains(1));
        printf("TST: setOne.size() => %s [Expected: 1]", setOne.size());
        printDivider();

        println("Tests for => subsetOf(), equalsTo()");
        println("setOne.add(1);");
        setOne.add(1);

        println("setOne.add(3);");
        setOne.add(3);

        println("setTwo = new Set<Integer>();");
        Set<Integer> setTwo = new Set<>();

        printf("setOne.toString(); = %s", setOne.toString());
        printf("setTwo.toString(); = %s", setTwo.toString());

        printf("TST: setOne.subsetOf(setTwo) => %s [Expected: false]", setOne.subsetOf(setTwo));
        printf("TST: setTwo.subsetOf(setOne) => %s [Expected: true]", setTwo.subsetOf(setOne));

        println("setTwo.add(1);");
        setTwo.add(1);

        println("setTwo.add(3);");
        setTwo.add(3);

        printf("setOne.toString(); = %s", setOne.toString());
        printf("setTwo.toString(); = %s", setTwo.toString());

        printf("TST: setOne.subsetOf(setTwo) => %s [Expected: false]", setOne.subsetOf(setTwo));
        printf("TST: setTwo.subsetOf(setOne) => %s [Expected: true]", setTwo.subsetOf(setOne));

        println("setTwo.add(5);");
        setTwo.add(5);

        printf("setOne.toString(); = %s", setOne.toString());
        printf("setTwo.toString(); = %s", setTwo.toString());

        printf("TST: setOne.subsetOf(setTwo) => %s [Expected: false]", setOne.subsetOf(setTwo));
        printf("TST: setTwo.subsetOf(setOne) => %s [Expected: false]", setTwo.subsetOf(setOne));

        println("setTwo.remove(5);");
        setTwo.remove(5);

        printf("setOne.toString(); = %s", setOne.toString());
        printf("setTwo.toString(); = %s", setTwo.toString());

        printf("TST: setOne.equalsTo(setTwo) => %s [Expected: false]", setOne.equalsTo(setTwo));
        printf("TST: setTwo.equalsTo(setOne) => %s [Expected: false]", setTwo.equalsTo(setOne));

        println("setTwo.add(2);");
        setTwo.add(2);

        printf("setOne.toString(); = %s", setOne.toString());
        printf("setTwo.toString(); = %s", setTwo.toString());

        printf("TST: setOne.equalsTo(setTwo) => %s [Expected: true]", setOne.equalsTo(setTwo));
        printf("TST: setTwo.equalsTo(setOne) => %s [Expected: true]", setTwo.equalsTo(setOne));

        printDivider();

        println("Tests for => union(), intersection()");

        println("setThree = setOne.union(setTwo);");
        Set<Integer> setThree = setOne.union(setTwo);

        printf("TST: setThree.equalsTo(setTwo) => %s [Expected: true]", setThree.equalsTo(setTwo));
        printf("TST: setThree.equalsTo(setOne) => %s [Expected: true]", setThree.equalsTo(setOne));

        println("setTwo.add(10);");
        setTwo.add(10);

        printf("setOne.toString(); = %s", setOne.toString());
        printf("setTwo.toString(); = %s", setTwo.toString());

        println("setThree = setOne.union(setTwo);");
        setThree = setOne.union(setTwo);

        printf("setThree.toString(); = %s", setThree.toString());

        printf("TST: setThree.equalsTo(setTwo) => %s [Expected: true]", setThree.equalsTo(setTwo));
        printf("TST: setThree.equalsTo(setOne) => %s [Expected: false]", setThree.equalsTo(setOne));

        println("setTwo.remove(1);");
        setTwo.remove(1);

        println("setTwo.remove(3);");
        setTwo.remove(3);

        printf("setOne.toString(); = %s", setOne.toString());
        printf("setTwo.toString(); = %s", setTwo.toString());

        println("setThree = setOne.intersection(setTwo);");
        setThree = setOne.intersection(setTwo);

        printf("TST: setThree.toString(); => %s [Expected: [2]]", setThree.toString());

        printTestEnd("Integers");
    }

    public static void main(String[] args) {
        testIntegers();

        // stessa cosa per Double e Strings dai
        // ho già dedicato più del dovuto a sti esercizi
    }
}
