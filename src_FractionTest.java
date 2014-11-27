/**
 * Created by karolsudol on 24/11/2014.
 */
public class FractionTest {

    public static void main(String[] args) {

        // test divide by zero - should print an error and exit
        new Fraction(1, 0);

        // test multiply
        Fraction a = new Fraction(3,5);
        Fraction b = new Fraction(1,2);
        Fraction c = new Fraction(3,10);
        if (!a.equals(b.multiply(c))) System.out.println("Multiply failed");

        // test equals
        test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
        test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
        test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
        test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
        test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");


        // test add
        Fraction d = new Fraction(19,15);
        Fraction e = new Fraction(3,5);
        Fraction f = new Fraction(2,3);
        if(!d.equals(e.add(f))) System.out.println("Add failed");


        Fraction g = new Fraction(1,6);
        Fraction h = new Fraction(2,3);
        Fraction i = new Fraction(1,2);
        if(!g.equals(h.subtract(i))) System.out.println("Sub failed");

        // test divide
        Fraction j = new Fraction(6,2);
        Fraction k = new Fraction(1,2);
        Fraction l = new Fraction(1,6);
        if(!j.equals(k.divide(l))) System.out.println("Divide failed");

        // test absolute
        Fraction m = new Fraction(-3,7);
        Fraction n = new Fraction(3,7);
        if(!m.equals(n.absValue())) System.out.println("Absolute failed");


        // test negate
        Fraction o = new Fraction(-3,7);
        if(!o.equals(o.negate())) System.out.println("Negate failed");
        Fraction q = o.negate();
        System.out.println(q.getNumerator() + "," + q.getDenominator());

        // test toString
        Fraction s = new Fraction(3, 1);
        System.out.println(s.toString());
        System.out.println(s.toString());
    }

    static void test(Fraction f1, Fraction f2, String msg){
        if (! f1.equals(f2))
            System.out.println(msg);
    }

}
