package com.learning.day;

import java.util.Scanner;

public class SimpleCalc {

    public static void main(String args[]) {
        new SimpleCalc().runCalculations(new Scanner(System.in));
    }

    private int machinecode = 0;
    private int operatorIndex = 0;

    public double runCalculations(Scanner inScanner) {
        int firstNumber, secondNumber,result = 0;
        char currentchar;
        String tempnumstr;
        char[] tempnum = new char[256];
        String strtype = inScanner.nextLine();
        char[] testchar = strtype.toCharArray();
        parseOperator(testchar);
        for(int t = 0; t < operatorIndex; t++) {
            tempnum[t] = testchar[t];
        }
        tempnumstr = new String(tempnum).trim();
        firstNumber = Integer.parseInt(tempnumstr);
        for(int temp = operatorIndex; temp < testchar.length; temp++) {
            for(int t = 0; t<(testchar.length-operatorIndex-1); t++) {
                tempnum[t] = testchar[temp];
            }
        }
        tempnumstr = new String(tempnum).trim();
        secondNumber = Integer.parseInt(tempnumstr);
        result = getAnum(firstNumber, secondNumber);
        System.out.println(result);
        return result;
    }

    private int getAnum(int firstNumber, int snum) {
        switch(machinecode) {
            case 1:
                return firstNumber + snum;
            case 2:
                return firstNumber - snum;
            case 3:
                return firstNumber * snum;
            case 4:
                return firstNumber / snum;
            default:
                throw new UnknownOperationException();
        }
    }

    private void parseOperator(char[] testchar) {
        char currentchar;
        for(int b = 0; b < testchar.length; b++) {
            currentchar = testchar[b];
            if(currentchar == '+') {
                machinecode = 1;
                operatorIndex = b;
            }
            else if(currentchar == '-') {
                machinecode = 2;
                operatorIndex = b;
            }
            else if(currentchar == '*') {
                machinecode = 3;
                operatorIndex = b;
            }
            else if(currentchar == '/') {
                machinecode = 4;
                operatorIndex = b;
            }
        }
    }
}