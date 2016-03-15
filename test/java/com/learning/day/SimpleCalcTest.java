package com.learning.day;

import org.junit.Assert;
import org.junit.Test;
import java.util.Scanner;

public class SimpleCalcTest {

    @Test(expected = NumberFormatException.class)
    public void calculatorShouldThrowAnExceptionForEmptyInput() throws Exception {
        Scanner inScanner = new Scanner("\n");
        new SimpleCalc().runCalculations(inScanner);
    }

    @Test(expected = NumberFormatException.class)
    public void calculatorShouldThrowAnExceptionForIncorrectInput() throws Exception {
        Scanner inScanner = new Scanner("$\n");
        new SimpleCalc().runCalculations(inScanner);
    }

    @Test
    public void calculatorCanAddTwoNumbers() throws Exception {
        Scanner inScanner = new Scanner("1+2");
        double expected = 3d;
        double actual = new SimpleCalc().runCalculations(inScanner);
        Assert.assertEquals(expected, actual, 0d);
    }

    @Test
    public void calculatorCanSubstractTwoNumbers() throws Exception {
        Scanner inScanner = new Scanner("2-1");
        double expected = 1d;
        double actual = new SimpleCalc().runCalculations(inScanner);
        Assert.assertEquals(expected, actual, 0d);
    }

    @Test
    public void calculatorCanMultipleTwoNumbers() throws Exception {
        Scanner inScanner = new Scanner("2*3");
        double expected = 6d;
        double actual = new SimpleCalc().runCalculations(inScanner);
        Assert.assertEquals(expected, actual, 0d);
    }

    @Test
    public void calculatorCanDivideTwoNumbers() throws Exception {
        Scanner inScanner = new Scanner("8/2");
        double expected = 4d;
        double actual = new SimpleCalc().runCalculations(inScanner);
        Assert.assertEquals(expected, actual, 0d);
    }

}