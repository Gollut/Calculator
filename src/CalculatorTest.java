
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    private void testCalculator(){
        Assert.assertEquals(2, calculator.calculate("((6+5)*2-2)/10"));
        Assert.assertEquals(11, calculator.calculate("7+2+1+1"));
    }

    @Test
    private void testInput(){

        Assert.assertEquals(true, calculator.checkString("7+3+3p"));
    }
}

