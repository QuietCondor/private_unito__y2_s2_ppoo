public class BankAccount {
    protected static int _counter = 0;

    protected int _id;
    protected String _nome;
    protected double _liquidita;

    public BankAccount(String nome, double liquidita) {
        _nome = nome;
        _liquidita = liquidita;
        _id = _counter;
        _counter++;
    }

    public BankAccount(String nome) {
        _nome = nome;
        _id = _counter;
        _counter++;
    }

    public String getNome() {
        return _nome;
    }

    public double getLiquidita() {
        return _liquidita;
    }

    public void setNome(String nome) {
        _nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof BankAccount)) {
            return false;
        }

        BankAccount castedObj = (BankAccount) obj;
        return castedObj._id == this._id;
    }

    @Override
    public String toString() {
        return String.format("[Id = %s, Nome = %s, Liquidita = %s]", _id, _nome, _liquidita);
    }

    public void deposit(double amount) throws NegativeDepositException {
        if (amount < 0) {
            throw new NegativeDepositException(_liquidita, amount);
        }
        _liquidita += amount;
    }

    protected LiquidityException checkWithdraw(double amount) {
        if (amount < 0) {
            return new NegativeWithdrawException(_liquidita, amount);
        }

        if (_liquidita - amount < 0) {
            return new ExcessiveWithdrawException(_liquidita, amount);
        }

        return null;
    }

    public void withdraw(double amount) throws LiquidityException {
        LiquidityException exception = checkWithdraw(amount);
        if (exception != null) {
            throw exception;
        }

        _liquidita = _liquidita - amount;
    }

    public static int getNumAccounts() {
        return _counter;
    }
}
