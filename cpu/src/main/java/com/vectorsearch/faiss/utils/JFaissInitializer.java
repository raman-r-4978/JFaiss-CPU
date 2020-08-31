package com.vectorsearch.faiss.utils;

import com.nativeutils.NativeUtils;

import java.io.IOException;

public class JFaissInitializer {

    private static volatile boolean initialized = false;

    public static void initialize() throws IOException {
        if (!initialized) {
            initialized = true;
            NativeUtils.loadLibraryFromJar("/_swigfaiss.so");
        }
    }
}
