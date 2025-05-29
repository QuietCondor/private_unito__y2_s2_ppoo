public class BankAccountTest extends BaseTestClass {
    private static void bankAccountTests() {
        BankAccount b1 = new BankAccount("Mario");
        BankAccount b2 = new BankAccount("Luigi", 100);
        printDivider();
        printf("BankAccount b1 = new('Mario');");
        printf("toString: TEST 1 => b1.toString() \n\t OUT: '%s' \n\t EXP: '%s'", b1.toString(),
                "[Id = 0, Nome = 'Mario', Liquidita = 0.0]");
        printf("getNome:  TEST 1 => b1.getNome() \n\t OUT: '%s' \n\t EXP: '%s'", b1.getNome(),
                "'Mario'");
        printf("getLiquidita:  TEST 1 => b1.getLiquidita() \n\t OUT: '%s' \n\t EXP: '%s'", b1.getLiquidita(),
                "'0.0'");
        b1.setNome("Mario2");
        printf("getLiquidita:  TEST 1 => b1.setNome('Mario2');b1.getNome() \n\t OUT: '%s' \n\t EXP: '%s'",
                b1.getNome(),
                "'Mario2'");
        printf("equals:  TEST 1 => b1.equals(b1); \n\t OUT: '%s' \n\t EXP: '%s'",
                b1.equals((Object) b1),
                "true");
        printf("equals:  TEST 1 => b1.equals(new Object()); \n\t OUT: '%s' \n\t EXP: '%s'",
                b1.equals(new Object()),
                "false");
        printf("equals:  TEST 1 => b1.equals(b2); \n\t OUT: '%s' \n\t EXP: '%s'",
                b1.equals((Object) b2),
                "false");
        printf("equals:  TEST 1 => b1.equals(null); \n\t OUT: '%s' \n\t EXP: '%s'",
                b1.equals((Object) null),
                "false");
        printDivider();
        printf("BankAccount b2 = new('Luigi', 100);");
        printf("toString: TEST 2 => b2.toString() \n" +
                "\t OUT: '%s' \n\t EXP: '%s'", b2.toString(),
                "[Id = 1, Nome = 'Luigi', Liquidita = 100.0]");
        printf("getNome:  TEST 2 => b2.getNome() \n\t OUT: '%s' \n\t EXP: '%s'", b2.getNome(),
                "'Luigi'");
        printf("getLiquidita:  TEST 2 => b2.getLiquidita() \n\t OUT: '%s' \n\t EXP: '%s'", b2.getLiquidita(),
                "'100.0'");
        b2.setNome("Luigi2");
        printf("getLiquidita:  TEST 2 => b2.setNome('Luigi2');b2.getNome() \n\t OUT: '%s' \n\t EXP: '%s'",
                b2.getNome(),
                "'Luigi'");
        printf("equals:  TEST 2 => b2.equals(b2); \n\t OUT: '%s' \n\t EXP: '%s'",
                b2.equals((Object) b2),
                "true");
        printf("equals:  TEST 2 => b2.equals(new Object()); \n\t OUT: '%s' \n\t EXP: '%s'",
                b2.equals(new Object()),
                "false");
        printf("equals:  TEST 2 => b2.equals(b1); \n\t OUT: '%s' \n\t EXP: '%s'",
                b2.equals((Object) b1),
                "false");
        printf("equals:  TEST 2 => b2.equals(null); \n\t OUT: '%s' \n\t EXP: '%s'",
                b2.equals((Object) null),
                "false");

        printf("deposit:  TEST 2 => b2.deposit(-100);b2.getLiquidita();");
        try {
            b2.deposit(-100);
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NOT SUPPOSED TO PRINT THIS", "new NegativeDepositException()");
        } catch (NegativeDepositException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NegativeDepositException", "NegativeDepositException");
        }

        printf("withdraw:  TEST 2 => b2.deposit(100);b2.getLiquidita();");
        try {
            b2.deposit(100);
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    b2.getLiquidita(), "200.0");
        } catch (NegativeDepositException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "FALSE", "TRUE");
        }

        printf("withdraw:  TEST 2 => b2.withdraw(-100);b2.getLiquidita();");
        try {
            b2.withdraw(-100);
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NOT SUPPOSED TO PRINT THIS", "NegativeWithdrawException()");
        } catch (NegativeWithdrawException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NegativeWithdrawException", "NegativeWithdrawException");
        } catch (LiquidityException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NOT SUPPOSED TO PRINT THIS", "NegativeWithdrawException()");
        }

        printf("withdraw:  TEST 2 => b2.withdraw(500);b2.getLiquidita();");
        try {
            b2.withdraw(500);
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NOT SUPPOSED TO PRINT THIS", "ExcessiveWithdrawException()");
        } catch (ExcessiveWithdrawException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "ExcessiveWithdrawException", "ExcessiveWithdrawException");
        } catch (LiquidityException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NOT SUPPOSED TO PRINT THIS", "ExcessiveWithdrawException()");
        }

        printf("withdraw:  TEST 2 => b2.withdraw(50);b2.getLiquidita();");
        try {
            b2.withdraw(50);
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    b2.getLiquidita(), "150.0");
        } catch (LiquidityException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NOT SUPPOSED TO PRINT THIS", "ExcessiveWithdrawException()");
        }
        printDivider();

        printf("getNumAccounts:  TEST 3 => BankAccount.getNumAccounts(); \n\t OUT: '%s' \n\t EXP: '%s'",
                BankAccount.getNumAccounts(),
                "2");
    }

    private static void bankAccountYoungTests() {
        printDivider();
        BankAccountYoung by = new BankAccountYoung("Mimmo", 100, 40);
        printf("BankAccountYoung by = new BankAccountYoung(\"Luigi\", 100, 40)");
        printf("toString: TEST 1 => b1.toString() \n\t OUT: '%s' \n\t EXP: '%s'", by.toString(),
                "[Id = 2, Nome = 'Mimmo', Liquidita = 100.0, Limit = 40.0]");
        printf("toString: TEST 1 => b1.getLimit() \n\t OUT: '%s' \n\t EXP: '%s'", by.getLimit(),
                "40");
        printDivider();

        printf("withdraw:  TEST 2 => by.withdraw(50);b2.getLiquidita();");
        try {
            by.withdraw(50);
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    by.getLiquidita(), "150.0");
        } catch (LimitExceededException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "LimitExceededException", "LimitExceededException");
        } catch (LiquidityException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NOT SUPPOSED TO PRINT THIS", "LiquidityException");
        }

        printf("withdraw:  TEST 2 => by.withdraw(-100);b2.getLiquidita();");
        try {
            by.withdraw(-100);
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NOT SUPPOSED TO PRINT THIS", "NegativeWithdrawException()");
        } catch (NegativeWithdrawException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NegativeWithdrawException", "NegativeWithdrawException");
        } catch (LiquidityException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NOT SUPPOSED TO PRINT THIS", "NegativeWithdrawException()");
        }

        printf("withdraw:  TEST 2 => by.withdraw(500);b2.getLiquidita();");
        try {
            by.withdraw(500);
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NOT SUPPOSED TO PRINT THIS", "ExcessiveWithdrawException()");
        } catch (ExcessiveWithdrawException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "ExcessiveWithdrawException", "ExcessiveWithdrawException");
        } catch (LiquidityException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NOT SUPPOSED TO PRINT THIS", "ExcessiveWithdrawException()");
        }

        printf("withdraw:  TEST 2 => by.withdraw(10);b2.getLiquidita();");
        try {
            by.withdraw(10);
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    by.getLiquidita(), "90.0");
        } catch (LiquidityException ex) {
            printf("\t OUT: '%s' \n\t EXP: '%s'",
                    "NOT SUPPOSED TO PRINT THIS", "ExcessiveWithdrawException()");
        }

        printDivider();
    }

    public static void main(String[] args) {
        bankAccountTests();
        bankAccountYoungTests();
    }
}
