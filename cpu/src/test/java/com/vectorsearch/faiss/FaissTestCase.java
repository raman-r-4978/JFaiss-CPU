package com.vectorsearch.faiss;

import com.vectorsearch.faiss.utils.JFaissInitializer;

import java.io.IOException;
import java.util.Random;

import static com.vectorsearch.faiss.utils.JFaissConstants.SUPPORTED_OS;

public abstract class FaissTestCase {
    public static final Random random = new Random(42);

    public abstract void train();

    public abstract void search();

    static {
        try {
            JFaissInitializer.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidOS() {
        return SUPPORTED_OS.contains(System.getProperty("os.name"));
    }
}
