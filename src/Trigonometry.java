
public class Trigonometry {

    public double calculate(String st) {
        String operation = st.substring(0, 3);
        String number = st.substring(3);
        switch (operation) {
            case "sin":
                return Math.sin(Double.valueOf(number));
            case "cos":
                return Math.cos(Double.valueOf(number));

        }
        return -1.111111;
    }
}
