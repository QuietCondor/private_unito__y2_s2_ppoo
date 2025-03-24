public class ArrayStart {
    public static void main(String[] args) {

        // Allocazione array
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        // iterazione tradizionale
        int i = 0;
        for (; i < 5; i++) {
            System.out.println("normal for: Array[" + i + "] = " + array[i]);
        }

        // iterazione con ciclo foreach
        i = 0;
        for (int item : array) {
            System.out.println(String.format("foreach: Array[%s] = %s", i, item));
            i++;
        }

        System.out.println("---------------------------------------------------");
        System.out.println("Another array:\n");
        int[] second = new int[10];
        for (int c = 0; c < second.length; c++) {
            second[c] = c + 1;
        }

        i = 0;
        for (int item : second) {
            System.out.println(String.format("Array[%s] = %s", i, item));
            i++;
        }
        System.out.println("---------------------------------------------------");
    }
}
