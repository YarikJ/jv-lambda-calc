package core.basesyntax;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private static final double DELTA = 0.0;


    @Test
    public void sumOperationTest() {
        Assert.assertEquals(7, Calculator.calculate(5, 2, '+'), DELTA);
        Assert.assertEquals(7, Calculator.calculate(2, 5, '+'), DELTA);
        Assert.assertEquals(-7, Calculator.calculate(-2, -5, '+'), DELTA);
    }

    @Test
    public void subtractionOperationTest() {
        Assert.assertEquals(3, Calculator.calculate(5, 2, '-'), DELTA);
        Assert.assertEquals(-3, Calculator.calculate(2, 5, '-'), DELTA);
        Assert.assertEquals(3, Calculator.calculate(-2, -5, '-'), DELTA);
    }

    @Test
    public void multiplyOperationTest() {
        Assert.assertEquals(10, Calculator.calculate(5, 2, '*'), DELTA);
        Assert.assertEquals(10, Calculator.calculate(2, 5, '*'), DELTA);
        Assert.assertEquals(10, Calculator.calculate(-2, -5, '*'), DELTA);
        Assert.assertEquals(-10, Calculator.calculate(-2, 5, '*'), DELTA);
    }

    @Test
    public void divisionOperationTest() {
        Assert.assertEquals(5, Calculator.calculate(10, 2, '/'), DELTA);
        Assert.assertEquals(2, Calculator.calculate(10, 5, '/'), DELTA);
        Assert.assertEquals(2, Calculator.calculate(-10, -5, '/'), DELTA);
        Assert.assertEquals(-2, Calculator.calculate(-10, 5, '/'), DELTA);
    }

    @Test
    public void powOperationTest() {
        Assert.assertEquals(100, Calculator.calculate(10, 2, '^'), DELTA);
        Assert.assertEquals(32, Calculator.calculate(2, 5, '^'), DELTA);
        Assert.assertEquals(-0.125, Calculator.calculate(-2, -3, '^'), DELTA);
        Assert.assertEquals(-100000, Calculator.calculate(-10, 5, '^'), DELTA);
        Assert.assertEquals(1, Calculator.calculate(-10, 0, '^'), DELTA);
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
