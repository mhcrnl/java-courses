class Calculator {
    private int result;
    private void plus(int... args){
        for (int arg:args){
            this.result+=arg;
        }
    }
    private void minus(int... args){
        for (int arg:args){
            this.result-=arg;
        }
    }
    private void multiple(int... args){
        for (int arg:args){
            this.result*=arg;
        }
    }
    private void divide(int... args){
        for (int arg:args){
            this.result/=arg;
        }
    }
    void square(int arg){
        this.result=arg*arg;
    }
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
    public int getResult(){
        return this.result;
    }
    public void cleanResult(){
        this.result=0;
    }
    public void setResult(int arg){
        this.result=arg;
    }
}