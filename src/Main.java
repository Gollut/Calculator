public class Main{
    public static void main(String[] args){
        Reader reader = new Reader();
        String st = reader.readFromFile("input.txt");
        if (st.equals(null)){
            System.out.println("Reading error");
        } else {
            Calculator calculator = new Calculator();
            Double result = calculator.calculate(st);
            System.out.println(result);
        }
    }
}
