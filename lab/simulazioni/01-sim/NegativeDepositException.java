class NegativeDepositException extends LiquidityException {
    public NegativeDepositException(double liquidity, double wrongDeposit) {
        super(
                String.format(
                        "Cannot deposit a negative amount."
                                + "Liquidity = %s |" +
                                "Deposit inserted = %s",
                        liquidity, wrongDeposit));
    }
}