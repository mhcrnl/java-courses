import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Надежда on 15.07.2015.
 */
public class InteractRunner {
    private static boolean isExit=false;
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            calculateRun(calc);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Good bye!");
        }
    }
    private static void calculateRun(Calculator calc) throws IOException {
        System.out.println("Enter the first argument");
        String input = reader.readLine();
        calc.setResult(Integer.parseInt(input));
        while (!(isExit)) {
            System.out.println("What to do with \"" + calc.getResult() + "\"?");
            input = reader.readLine();
            boolean doCalculate=true;
            switch (input) {
                case "clean":
                    calc.cleanResult();
                    System.out.println("Result have been cleaned");
                    doCalculate=false;
                    break;
                case "square":
                    calc.square(calc.getResult());
                    System.out.println("Square = " + calc.getResult());
                    doCalculate=false;
                    break;
                case "exit":
                    isExit = true;
                    doCalculate=false;
                    break;
            }
            if (doCalculate)calc.calculate(input);
            System.out.println("Result is \""+calc.getResult()+"\"");
        }
    }
    }
