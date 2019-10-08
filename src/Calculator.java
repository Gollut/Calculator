import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import static java.lang.System.exit;

public class Calculator {
    private Parser parser;

    public double calculate(String st) {
        if (checkString(st)) {
            parser = new Parser(st);
            List<String> polish = parser.getRes();
            return getValue(polish);
        } else {
            return -1.111111;
        }

    }

    private double getValue(List<String> polish) {
        double val1;
        double val2;
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i <= polish.size() - 1; i++) {
            if (parser.isNumber(polish.get(i))) {
                stack.push(polish.get(i));
            } else {
                val1 = Double.valueOf(stack.pop());
                val2 = Double.valueOf(stack.pop());
                switch (polish.get(i)) {
                    case "+":
                        stack.push(String.valueOf(val2 + val1));
                        break;
                    case "-":
                        stack.push(String.valueOf(val2 - val1));
                        break;
                    case "*":
                        stack.push(String.valueOf(val2 * val1));
                        break;
                    case "/":
                        stack.push(String.valueOf(val2 / val1));
                        break;
                }
            }
        }
        return Double.valueOf(stack.pop());
    }

    public boolean checkString(String st) {
        return Pattern.matches("[[0-9]*\\+*\\-*\\**\\/*\\(*\\)*]*", st);
    }
}

