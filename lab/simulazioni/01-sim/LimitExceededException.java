class LimitExceededException extends LiquidityException {
    public LimitExceededException(double liquidity, double wrongAmount, double limit) {
        super(String.format("Limit of %s exceeded for withdraw of %s of %s liquidity", limit, wrongAmount, liquidity));
    }
}