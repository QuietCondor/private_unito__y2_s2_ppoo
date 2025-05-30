import java.time.LocalDate;

public class LibraryLoan {
    /**
     * Definisce num tot. di prestiti + ID libero
     */
    public static int loanCounter;

    private int _loanId;
    private String _bookTitle;
    private LocalDate _loanDate;

    public LibraryLoan(String bookTitle, LocalDate loanDate) {
        _bookTitle = bookTitle;
        _loanDate = loanDate;
        _loanId = loanCounter;
        loanCounter++;
    }

    public LibraryLoan() {
        _loanId = loanCounter;
        loanCounter++;
    }

    public int getLoanId() {
        return this._loanId;
    }

    public String getBookTitle() {
        return this._bookTitle;
    }

    public LocalDate getLoanDate() {
        return this._loanDate;
    }

    public void setBookTitle(String bookTitle) {
        this._bookTitle = bookTitle;
    }

    public void setLoanDate(LocalDate loanDate) {
        this._loanDate = loanDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof LibraryLoan)) {
            return false;
        }

        LibraryLoan castedObj = (LibraryLoan) obj;

        return this._loanId == castedObj._loanId;
    }

    @Override
    public String toString() {
        return String.format("[Id: %s, book title = '%s', loan date = '%s']", this._loanId, this._bookTitle,
                this._loanDate);
    }

    public void renewLoan() {
        _loanDate = LocalDate.now();
    }

    public static int getTotalLoans() {
        return LibraryLoan.loanCounter;
    }
}
