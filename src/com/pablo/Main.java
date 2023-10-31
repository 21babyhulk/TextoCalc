package com.pablo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        double result = Calc.calc(TextParser.parseText(input));

        System.out.println(result);
    }
}
