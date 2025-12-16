package com.jni;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Simple JNI demo for Linux.
 *
 * How it works:
 *  - Java declares a native method `add(int, int)` implemented in C.
 *  - At runtime we load the shared library `libdemo.so`.
 *  - The native function is named using the JNI-mangled name and compiled with gcc.
 */
public class Demo {

    // Load native library from project build output to avoid relying on LD_LIBRARY_PATH/java.library.path
    private static void loadNativeLibrary() {
        try {
            System.loadLibrary("demo");
            return;
        } catch (UnsatisfiedLinkError ignored) {
            // Fall through to try absolute path
        }

        try {
            Path nativeLib = Paths.get(Demo.class.getProtectionDomain()
                            .getCodeSource().getLocation().toURI())
                    .getParent()
                    .resolve("native/libdemo.so");

            if (!Files.exists(nativeLib)) {
                throw new UnsatisfiedLinkError("Native library not found: " + nativeLib);
            }

            System.load(nativeLib.toString());
        } catch (Exception ex) {
            throw new UnsatisfiedLinkError("Failed to load native library: " + ex.getMessage());
        }
    }

    static {
        loadNativeLibrary();
    }

    // Native method implemented in C (see src/main/native/demo.c)
    public static native int add(int a, int b);

    public static void main(String[] args) {
        int a = 5;
        int b = 35;
        int result = add(a, b);
        System.out.printf("JNI: %d + %d = %d%n", a, b, result);
    }
}