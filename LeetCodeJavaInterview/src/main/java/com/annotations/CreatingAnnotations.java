package com.annotations;

import com.model.CarModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreatingAnnotations {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Cat cat = new Cat("Fifo", "Straycat", 13);
        System.out.println(cat);
        Annotation[] annotations = cat.getClass().getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
        boolean annotationPresent = cat.getClass().isAnnotationPresent(VeryImportant.class);
        if (annotationPresent) {
            System.out.printf("Annotation is present.\nthis %s is Very Important!%n", cat.getClass().getSimpleName());
        }
        cat.run();


        for (Method m : cat.getClass().getMethods()) {
            if (m.isAnnotationPresent(RunImmedialely.class)) {
                System.out.printf("this method is very important: %s%n", m.getName());
                RunImmedialely annotation = m.getAnnotation(RunImmedialely.class);
                for (int i = 0; i < annotation.times(); i++) {
                    m.invoke(cat);
                }
            }
        }

    }
}
