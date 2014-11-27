import java.util.Scanner;

/**
 * Created by karolsudol on 25/11/2014.
 */
public class FractionCalculator {

    static Integer temp = 0;

    final private String WElCOME = "Enter your fraction input and press q to exit, and help for help.";

    public void main(String[] args) {
        welcomeMess();
        Fraction calculation = new Fraction(0,1);
        Scanner in = new Scanner(System.in);
        String temp = "";
        do{
            System.out.print(calculation.toString() + " ? ");
            temp = in.nextLine();
            calculation = evaluate(calculation, temp);
        }while(calculation != null);
        in.close();
    }

    private void welcomeMess(){
        System.out.println(WElCOME);
    }

    public Fraction evaluate(Fraction fraction, String s) {
        if (s.toLowerCase().equals("help")){
            Fraction.help();
            return fraction;
        }
        Fraction result = fraction;
        Fraction temp = new Fraction(0,1);
        boolean calc = false;
        String[] element = s.split(" ");
        for(String e : element){
            e = e.toLowerCase();
            if (e.equals("+")){
                result.setOperator("+");
            } else if (e.equals("-")){
                result.setOperator("-");
            } else if (e.equals("*")){
                result.setOperator("*");
            } else if (e.equals("/")){
                result.setOperator("/");
            } else if (e.equals("absValue") || e.equals("a")){
                result = result.absValue();
            } else if (e.equals("negate") || e.equals("n")){
                result = result.negate();
            } else if (e.equals("c") || e.equals("clear")){
                result.clear();
            } else if (e.equals("q") || e.equals("quit")){
                System.out.println("Thank you for using fraction calculator");
                System.out.println("The last result was: " + result);
                return null;
            } else if(e.matches("-?\\d+")){
                int i = Integer.parseInt(e);
                temp = new Fraction(i,1);
                calc = true;
            } else if (e.matches("-?\\d+\\/-?\\d+")){
                String[] t = e.split("/");
                int num = Integer.parseInt(t[0]);
                int den = Integer.parseInt(t[1]);
                temp = new Fraction(num,den);
                calc = true;
            } else if (e.equals("")){
                //Do nothing - just capturing multiple spaces
            } else {
                System.out.println("Can't interpret: " + e);
                result.clear();
                return result;
            }

            //only execute calculation if needed.
            if (calc){
                if(result.getOperator().equals("")){
                    result = temp;
                } else if(result.getOperator().equals("+"))  {
                    result = result.add(temp);
                    result.setOperator("");
                } else if(result.getOperator().equals("-"))  {
                    result = result.subtract(temp);
                    result.setOperator("");
                } else if(result.getOperator().equals("*"))  {
                    result = result.multiply(temp);
                    result.setOperator("");
                } else if(result.getOperator().equals("/"))  {
                    result = result.divide(temp);
                    result.setOperator("");
                }
                temp = new Fraction(0,1);
                calc = false;
            }

        }

        return result;
    }

}