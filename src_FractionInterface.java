/**
 * Created by karolsudol on 25/11/2014.
 */
public interface FractionInterface {

    public abstract String toString();

    public abstract int getNumerator();

    public abstract void setNumerator(int num);

    public abstract int getDenominator();

    public abstract void setDenominator(int num);

    public abstract String getOperator();

    public abstract void setOperator(String op);

    public abstract boolean equals(Object o);

    public abstract int hashCode();

    public abstract Fraction multiply(Fraction fraction);

    public abstract Fraction divide(Fraction fraction);

    public abstract Fraction add(Fraction fraction);

    public abstract Fraction subtract(Fraction fraction);

    public abstract Fraction absValue();

    public abstract Fraction negate();

    public abstract void clear();
}
