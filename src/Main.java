import java.util.Scanner;
import java.util.regex.Pattern;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String st = scanner.next();
        scanner.close();
        Calculator calculator = new Calculator();
        Double result = calculator.calculate(st);
        if (result.equals(-1.111111)){
            System.out.println("Неверное выражение");
        } else {
            System.out.println(result);
        }
    }
}