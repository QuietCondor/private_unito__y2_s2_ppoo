import java.time.LocalDate;

public class StudentLoan extends LibraryLoan {
    private int _maxRenewals;

    public StudentLoan(String bookTitle, LocalDate loanDate, int maxRenewals) {
        super(bookTitle, loanDate);
        _maxRenewals = maxRenewals;
    }

    public StudentLoan(int maxRenewals) {
        super();
        _maxRenewals = maxRenewals;
    }

    @Override
    public void renewLoan() {
        if (_maxRenewals <= 0) {
            System.out.println("Cannot renew");
            return;
        }

        _maxRenewals--;
        super.renewLoan();
    }

    @Override
    public String toString() {
        return String.format("[Id: %s, book title = '%s', loan date = '%s', max ren. = '%s']", super.getLoanId(),
                super.getBookTitle(),
                super.getLoanDate(), this._maxRenewals);
    }
}
