public abstract class BaseTestClass {
    protected static void println(String s) {
        System.out.println(s);
    }

    protected static void printDivider() {
        println("---------------------------------------------------------");
    }

    protected static void printf(String format, Object... args) {
        System.out.println(String.format(format, args));
    }
}
