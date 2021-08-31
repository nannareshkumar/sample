package codereview;

public enum Denomination {
    ONE_HUNDRED(100.00f),
    FIFTY( 50.00f),
    TWENTY( 20.00f),
    TEN( 10.00f),
    FIVE(  5.00f),
    TWO(  2.00f),
    ONE(  1.00f),
    HALF_DOLLAR(  0.50f),
    QUARTER(  0.25f),
    DIME(  0.10f),
    NICKEL(  0.05f),
    PENNY(  0.01f);

    private final float value;
    private final String description;

    Denomination(float value) {
        this.value = value;
        this.description = this.name().replace("_", " ");
    }

    public float getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.description;
    }
}