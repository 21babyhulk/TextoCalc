package com.pablo;

import java.util.Deque;
import java.util.Queue;

public class NumAndOper {
    private Deque<Double> nums;
    private Deque<String> oper;

    public NumAndOper(Deque<Double> n, Deque<String> o) {
        this.nums = n;
        this.oper = o;
    }

    public boolean numIsEmpty() {
        return this.nums.isEmpty();
    }

    public boolean operIsEmpty() {
        return this.oper.isEmpty();
    }

    public double removeNum() {
        return this.nums.removeFirst();
    }

    public String removeOper() {
        return this.oper.removeFirst();
    }

    public String peekOper() {
        return this.oper.peek();
    }
}