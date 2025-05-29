class ExcessiveWithdrawException extends LiquidityException {
    public ExcessiveWithdrawException(double liquidity, double wrongWithdraw) {
        super(
                String.format(
                        "Cannot withdraw the amount specified."
                                + "Liquidity = %s |" +
                                "Deposit inserted = %s",
                        liquidity, wrongWithdraw));
    }
}