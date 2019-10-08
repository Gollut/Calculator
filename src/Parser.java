import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class Parser {
    private List<String> values = new ArrayList<>();
    private List res = new ArrayList();
    Stack<String> stack = new Stack();

    public Parser(String st) {
        makeList(st);
        reversePolishNotation();
    }

    public void reversePolishNotation() {
        for (String symb : values) {
            if (isNumber(symb)) {
                res.add(symb);
            } else if (isOperator(symb)) {
                if (stack.empty() || symb.equals("(")) {
                    stack.push(symb);
                } else if (symb.equals(")")) {
                    stackToResBracket();
                } else {
                    String last = stack.pop();
                    if (checkPriority(last, symb)) {
                        res.add(last);
                        stack.push(symb);
                    } else {
                        stack.push(last);
                        stack.push(symb);
                    }
                }
            }
        }
        while (!stack.empty()) {
            res.add(stack.pop());
        }
    }

    public boolean isNumber(String symb) {
        if (Pattern.matches("[0-9]*", symb)) {
            return true;
        }
        return false;
    }

    private boolean isOperator(String symb) {
        if (symb.equals("*") || symb.equals("+") || symb.equals("-") || symb.equals("/") || symb.equals("(") || symb.equals(")")) {
            return true;
        }
        return false;
    }

    private boolean checkPriority(String s1, String s2) { //s1 from stack
        if ((s1.equals("(")) || ((s1.equals("-") || s1.equals("+")) && (s2.equals("*") || s2.equals("/")))) {
            return false;
        }
        return true; //priority in stack
    }

    private void stackToResBracket() {
        String symb = stack.pop();
        while (!symb.equals("(")) {
            res.add(symb);
            symb = stack.pop();
        }
    }

    private void makeList(String st) {
        int index = 0;
        while (index <= st.length() - 1) {
            if (isOperator(Character.toString(st.charAt(index)))) {
                values.add(Character.toString(st.charAt(index)));
                index++;
            } else {
                String number = Character.toString(st.charAt(index));
                index++;
                if (index <= st.length() - 1) {
                    while ((index <= st.length() - 1) && (!isOperator(Character.toString(st.charAt(index))))) {
                        number += Character.toString(st.charAt(index));
                        index++;
                    }
                }
                values.add(number);
            }
        }
    }

    public List<String> getRes() {
        return res;
    }
}


