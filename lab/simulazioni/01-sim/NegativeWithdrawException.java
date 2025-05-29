class NegativeWithdrawException extends LiquidityException {
    public NegativeWithdrawException(double liquidity, double wrongWithdraw) {
        super(
                String.format(
                        "Cannot withdraw a negative amount."
                                + "Liquidity = %s |" +
                                "Deposit inserted = %s",
                        liquidity, wrongWithdraw));
    }
}