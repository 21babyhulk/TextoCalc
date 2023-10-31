package com.pablo;


import java.util.Deque;
import java.util.LinkedList;

public class Calc {
    public static double calc(NumAndOper no) {
        // first, take a number, next try to get an operation, treat it, then the next number
        // and put everything in the final result variable
        // i'm using an algorithm to get the number and operation deques and verify when a operator is found
        // when found, will check if the deque that contains the operator is empty or check if the actual operator
        // is of high precedence or lower, if higher, will pop the top operator and pop two number of the num deque
        // by the end, put the actual operator in the deque. now, go trough the deques and calculate the resulting numbers

        Deque<Double> nums = new LinkedList<>();
        Deque<String> oper = new LinkedList<>();
        while (!no.numIsEmpty()) {
            nums.push(no.removeNum());

            if (!no.operIsEmpty()) {
                while (!oper.isEmpty() && precedence(no.peekOper()) <= precedence(oper.peek())) {
                    nums.push(applyOp(oper.pop(), nums.pop(), nums.pop()));
                }
                oper.push(no.removeOper());
            }
        }

        while (nums.size() != 1) {
            nums.push(applyOp(oper.pop(), nums.pop(), nums.pop()));
        }

        return nums.pop();
    }

    private static int precedence(String o) {
        switch (o) {
            case Operations.PLUS:
            case Operations.MINUS:
                return 1;
            case Operations.TIMES:
            case Operations.DIVIDED:
                return 2;
            default:
                return -1;
        }
    }

    private static double applyOp(String op, double b, double a) {
        switch (op) {
            case Operations.PLUS:
                return a + b;
            case Operations.MINUS:
                return a - b;
            case Operations.TIMES:
                return a * b;
            case Operations.DIVIDED:
                if (b == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}
