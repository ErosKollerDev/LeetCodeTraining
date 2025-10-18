package com.practicing01;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        //This Last-In, First-Out (LIFO)
        Stack<String> stack = new Stack<>(); // A new empty stack

        // Push operations
        stack.push("John");
        stack.push("Mary");
        stack.push("Steve");

        stack.pop(); // Pop operation removes 'Steve'
        System.out.println(stack); // Outputs: [John, Mary]
    }
}
