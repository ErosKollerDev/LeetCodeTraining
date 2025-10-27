package com.solid;

interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class SimplePrinter implements Printer {
    public void print() { /* print only */ }
}

public class __InterfaceSegregationPrinciple {
}
