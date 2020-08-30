package lt.verbus;

public enum Currency {
    EUR(1.0), USD(1.19), GBP(0.89), DKK(7.44);

    private final double ratioToEur;

    Currency(double ratioToEur) {
        this.ratioToEur = ratioToEur;
    }

    public double getRatioToEur() {
        return ratioToEur;
    }
}
