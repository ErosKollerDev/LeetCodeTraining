package com.solid;


class Bird {
    void fly() {}
}

class Sparrow extends Bird {
    void fly() { /* works fine */ }
}

/**
 * Bad Liskov
 */
@Deprecated
class Penguin extends Bird {
    void fly() { throw new UnsupportedOperationException(); }
}

public class ___Liskov {
    //Be replaceable
}
