package com.learning.day;

import java.util.Scanner;

public class SimpleCalc {
    public static void main(String args[]) {
        int fnum,snum,anum = 0;
        String strtype;
        char[] testchar;
        char currentchar;
        int machinecode = 0;
        String tempnumstr;
        int operatorloc = 0;
        char[] tempnum = new char[256];
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter The Calculation: ");
        strtype = scan.nextLine();
        testchar = strtype.toCharArray();
        for(int b = 0; b < testchar.length; b++)
        {
            currentchar = testchar[b];
            if(currentchar == '+') {
                machinecode = 1;
                operatorloc = b;
            }
            else if(currentchar == '-') {
                machinecode = 2;
                operatorloc = b;
            }
            else if(currentchar == '*') {
                machinecode = 3;
                operatorloc = b;
            }
            else if(currentchar == '/') {
                machinecode = 4;
                operatorloc = b;
            }
        }
        for(int t = 0;t < operatorloc;t++) {
            tempnum[t] = testchar[t];
        }
        tempnumstr = new String(tempnum).trim();
        fnum = Integer.parseInt(tempnumstr);
        for(int temp = operatorloc;temp < testchar.length;temp++) {
            for(int t = 0;t<(testchar.length-operatorloc-1);t++) {
                tempnum[t] = testchar[temp];
            }
        }
        tempnumstr = new String(tempnum).trim();
        snum = Integer.parseInt(tempnumstr);
        switch(machinecode) {
            case 1:
                anum = fnum + snum;
                break;
            case 2:
                anum = fnum - snum;
                break;
            case 3:
                anum = fnum * snum;
                break;
            case 4:
                anum = fnum / snum;
        }
        System.out.println(anum);
    }
}