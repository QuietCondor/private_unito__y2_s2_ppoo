public class BankAccountYoung extends BankAccount {
    private double _limit;

    public BankAccountYoung(String nome, double liquidita, double limit) {
        super(nome, liquidita);
        _limit = limit;
    }

    public double getLimit() {
        return _limit;
    }

    @Override
    public String toString() {
        return String.format("[Id = %s, Nome = %s, Liquidita = %s, Limit = %s]", _id, _nome, _liquidita, _limit);
    }

    @Override
    public void withdraw(double amount) throws LiquidityException {
        LiquidityException exception = super.checkWithdraw(amount);
        if (exception != null) {
            throw exception;
        }

        if (_limit < amount) {
            throw new LimitExceededException(_liquidita, amount, _limit);
        }
        super.withdraw(amount);

    }
}