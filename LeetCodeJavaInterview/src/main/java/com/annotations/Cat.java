package com.annotations;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@VeryImportant("cat is very important!")
public class Cat implements Feline {

    private String name;
    private String breed;
    private Integer age;



    @Override
    public void eat() {
        System.out.println("Cat is eating ...");
    }

    @Override
    public void sleep() {
        System.out.println("Cat is sleeping ...");
    }

    @Override
    public void walk() {
        System.out.println("Cat is walking ...");
    }

    @Override
    public void run() {
        System.out.println("Cat is running ...");
    }

    @RunImmedialely(times = 3)
    @Override
    public void play() {
        System.out.println("Cat is playing ...");
    }

    @Override
    public void swim() {
        System.out.println("Cat is swimming ...");
    }
}
