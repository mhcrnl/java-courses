import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Artur Vakhrameev
 * @version 1.00
 */
class InteractRunner {
    private static boolean isExit=false;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            calculation(calc);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        finally {
            System.out.println("Good bye!");
        }
    }

    /**
     * @param calc Calculator object
     * @throws IOException if /by zero
     */
    private static void calculation(Calculator calc) throws IOException {
        System.out.println("Enter the first argument");
        String firstArg = reader.readLine();
        calc.setResult(Integer.parseInt(firstArg));
        while (!(isExit)) {
            System.out.println("What to do with \"" + calc.getResult() + "\"?");
            String input = reader.readLine();
            if (controlWordsCheck(calc,input))calc.calculate(input);
            System.out.println("Result is \""+calc.getResult()+"\"");
        }
    }

    /**
     * @param calc  Calculator object
     * @param input will be checked for the presence of the control words
     * @return true - if control words haven't been entered, else - returns false
     */
    private static boolean controlWordsCheck(Calculator calc, String input) {
        boolean doCalculate=true;
        switch (input) {
            case "clean":
                calc.cleanResult();
                System.out.println("Result have been reset");
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
        return doCalculate;
    }
}
