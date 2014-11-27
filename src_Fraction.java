import java.util.Scanner;

/**
 * Created by karolsudol on 24/11/2014.
 */
public class Fraction implements FractionInterface {
    private int numerator;
    private int denominator;
    private String operator = "";

    public Fraction(int num, int den) {

        if (den == 0) {
            throw new IllegalArgumentException("Invalid fraction with denominator 0");
        }
        int gcd = myGcd(num, den);
        setNumerator(num / gcd);
        setDenominator(den / gcd);
    }

    public String toString() {
        if (denominator != 1) {
            return "" + getNumerator() + '/' + getDenominator();
        }
        else if (denominator ==1){
            return String.valueOf(getNumerator());
        }
        else {
            return "" + getNumerator();
        }
    }

    // or perhaps it will be easier just to write it as: pls advise???
    /*
    public String toString(){
    return num + "/" + denom;
    }

     */

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String op) {
        operator = op;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other) {

        int num = this.getNumerator() * other.getNumerator();
        int den = this.getDenominator() * other.getDenominator();
        return new Fraction (num, den);
    }

    public Fraction add(Fraction other){

        int num = this.getDenominator() + other.getNumerator();
        int den = this.getDenominator() + other.getDenominator();
        return new Fraction (num, den);
    }

    public Fraction subtract(Fraction other){
        int num = this.getDenominator() - other.getNumerator();
        int den = this.getDenominator() - other.getDenominator();
        return new Fraction (num, den);
    }

    public Fraction divide(Fraction other){

        int num = this.getDenominator() / other.getNumerator();
        int den = this.getDenominator() / other.getDenominator();
        return new Fraction (num, den);
    }

    public Fraction absValue(){
        int num = this.getNumerator();
        int den = this.getDenominator();
        if((num < 0)^(den < 0)){
            num = num * -1;
        }
        return new Fraction (num, den);
    }

    public Fraction negate(){
        int num = this.getNumerator() * -1;
        int den = this.denominator;
        return new Fraction (num, den);
    }

    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public Fraction normalise(int n, int d) {
        int gcd = myGcd(n, d);
        return new Fraction(n / gcd, d / gcd);
    }


    public void clear() {
        this.setDenominator(1);
        this.setNumerator(0);
    }



    public static void help(){
        System.out.println();
        System.out.println("Help menu: signs: Multiply: * , Divide: / , Add: + and Subtract: - ");
        System.out.println("Operators: Abs value: absValue , Negate: negate, Clear: c ");
        System.out.println("to quit press q ");
        System.out.println();
    }

}
