package core.basesyntax;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private static final double delta = 0.0;


    @Test
    public void operationsResultTest() {
        Assert.assertEquals(7, Calculator.calculate(5, 2, '+'), delta);
        Assert.assertEquals(7, Calculator.calculate(2, 5, '+'), delta);
        Assert.assertEquals(14, Calculator.calculate(2, 7, '*'), delta);
        Assert.assertEquals(-14, Calculator.calculate(7, -2, '*'), delta);
        Assert.assertEquals(0.4, Calculator.calculate(2, 5, '/'), delta);
        Assert.assertEquals(32, Calculator.calculate(2, 5, '^'), delta);
        Assert.assertEquals(0, Calculator.calculate(2, 2, '-'), delta);
    }

    @Test
    public void numberOfSupportedOperations() {
        Assert.assertTrue(Calculator.getOPERATIONS().size() >= 5);
    }


    @Test
    public void byZeroDivision() {
        expectedException.expect(ArithmeticException.class);
        expectedException.expectMessage("Division by zero");
        Calculator.calculate(25, 0, '/');
    }

    @Test
    public void notSupportedOperator() {
        expectedException.expect(IllegalArgumentException.class);
        Calculator.calculate(25, 0, '?');
    }

}
