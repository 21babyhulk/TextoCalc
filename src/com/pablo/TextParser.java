package com.pablo;

import java.util.*;

public class TextParser {
    public static NumAndOper parseText(String text) {
        // return an operation object that have two queues with numbers and operations
        Deque<String> numsAndOper = new LinkedList<String>(Arrays.asList(text.split(" ")));
        Deque<Double> nums = new LinkedList<Double>();
        Deque<String> oper = new LinkedList<String>();

        while (!numsAndOper.isEmpty()) {
            String n = numsAndOper.remove();
            try {
                nums.addLast(Double.parseDouble(n));
            }
            catch (NumberFormatException e) {
                oper.addLast(n);
            }
        }

        return new NumAndOper(nums, oper);
    }
}
