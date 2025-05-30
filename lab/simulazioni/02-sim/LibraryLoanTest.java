import java.time.LocalDate;

public class LibraryLoanTest {
    public static void main(String[] args) {
        LibraryLoan loan1 = new LibraryLoan("Il Signore degli Anelli", LocalDate.of(2025, 5, 10));
        LibraryLoan loan2 = new LibraryLoan("1984", LocalDate.of(2025, 5, 20));
        LibraryLoan loan3 = new LibraryLoan();

        System.out.println("Loan1: " + loan1);
        System.out.println("Loan2: " + loan2);
        System.out.println("Loan3: " + loan3);

        System.out.println("Loan1 equals Loan2: " + loan1.equals(loan2));

        loan1.renewLoan();
        System.out.println("Loan1 after renew: " + loan1);

        System.out.println("Total loans created: " + LibraryLoan.getTotalLoans());

        StudentLoan studentLoan = new StudentLoan("Harry Potter", LocalDate.of(2025, 5, 30), 2);
        System.out.println("StudentLoan before renewals: " + studentLoan);
        studentLoan.renewLoan();
        studentLoan.renewLoan();
        studentLoan.renewLoan(); // this should not renew due to 0 renewals left
        System.out.println("StudentLoan after renewals: " + studentLoan);
    }
}