package com.roadmap;

public class Leet_000_0000 {
    public static void main(String[] args) {
        Leet_000_0000 leet = new Leet_000_0000();
        // Java
        String version = System.getProperty("java.version");        // e.g., "17.0.8"
        String runtime = System.getProperty("java.runtime.version"); // often more detailed
        String vendor  = System.getProperty("java.vendor");          // e.g., "Oracle Corporation"
        System.out.println(version + " | " + runtime + " | " + vendor);
        Person p = new Person("Eros", "koller", 48);
        System.out.println(p.toString());
    }

}