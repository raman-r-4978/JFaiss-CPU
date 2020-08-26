package com.vectorsearch.faiss;

import com.vectorsearch.faiss.utils.JFaissInitializer;

import java.io.IOException;
import java.util.Random;

public abstract class FaissTest {
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
}
