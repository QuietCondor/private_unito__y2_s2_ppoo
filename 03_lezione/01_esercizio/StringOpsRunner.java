public class StringOpsRunner {
    public static String longest(String[] arr) {
        assert arr.length > 0 : "The array cannot be empty";

        String longestStr = arr[0];
        for (String str : arr) {
            if (str.length() > longestStr.length()) {
                longestStr = str;
            }
        }

        return longestStr;
    }

    public static String concatAll(String[] arr) {
        assert arr.length > 0 : "The array cannot be empty";

        String result = "";
        for (String str : arr) {
            result = result.concat(str);
        }

        return result;
    }

    public static String trim(String str) {
        assert str != null : "the given string cannot be NULL";
        assert str.length() > 0 : "the given string cannot be empty";

        int i = 0;
        for (; i < str.length() && str.charAt(i) == ' '; i++) {

        }

        int j = str.length() - 1;
        for (; 0 < j && str.charAt(j) == ' '; j--) {

        }

        String trimmedStr = str.substring(i, j + 1);

        return trimmedStr;
    }

    public static void main(String[] main) {
        System.out.println("===============================================");
        System.out.println("Testing longest() method:");
        String[] longestArr = new String[] { "Ciao", "Pippo", "Spiripippooo", "Hola" };
        System.out.println(
                "\tlongest(['Ciao', 'Pippo', 'Spiripippooo', 'Hola']) = " + longest(longestArr)
                        + " (Should be 'Spiripippooo')");
        System.out.println("===============================================");
        System.out.println("Testing concatAll() method:");
        System.out.println(
                "\toncatAll(['Ciao', 'Pippo', 'Spiripippooo', 'Hola']) = " + concatAll(longestArr)
                        + " (Should be 'CiaoPippoSpiripippoooHola')");
        System.out.println("===============================================");

        System.out.println("===============================================");
        System.out.println("Testing trim() method:");
        System.out.println(
                "\ttrim('   smartworking    ') = " + "'" + trim("   smartworking    ") + "'"
                        + " (Should be 'smartworking')");
        System.out.println("===============================================");
    }
}