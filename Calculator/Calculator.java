package Calculator;

/**
 * @author Artva 15/07/2015
 */
class Calculator {
    /**
     * current calculation result
     */
    private int result;

    /**
     * @param firstArg Setting first argument
     */
    public Calculator(int firstArg){
        this.result=firstArg;
    }

    /**
     * @param args Array of input arguments, which will be added to result
     */
    private void plus(int... args){
        for (int arg:args){
            this.result+=arg;
        }
    }

    /**
     * @param args Array of arguments, which will be deducted from result
     */
    private void minus(int... args){
        for (int arg:args){
            this.result-=arg;
        }
    }

    /**
     * @param args Array of arguments, which will be multiplied to result
     */
    private void multiple(int... args){
        for (int arg:args){
            this.result*=arg;
        }
    }

    /**
     * @param args Array of arguments, which will be divisible by result
     */
    private void divide(int... args){
        for (int arg:args){
            this.result/=arg;
        }
    }

    /**
     * @param arg Argument, which will be squared
     */
    void square(int arg){
        this.result=arg*arg;
    }

    /**
     * @param input includes type of arithmetic operation as first character and operation's argument as next character.
     *              For example, entering "/5" will call divide method with an argument equals .
     */
    void calculate(String input){
        int arg = Integer.parseInt(input.substring(1));
        char operation = input.charAt(0);
            switch(operation){
                case '+': plus(arg);
                    break;
                case '-': minus(arg);
                    break;
                case '*': multiple(arg);
                    break;
                case '/': divide(arg);
                    break;
            }
        }

    /**
     * @return current calculation result
     */
    public int getResult(){
        return this.result;
    }

    /**
     * reset result to 0
     */
    public void cleanResult(){
        this.result=0;
    }

}