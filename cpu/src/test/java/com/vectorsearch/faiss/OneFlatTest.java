package com.vectorsearch.faiss;

import com.vectorsearch.faiss.swig.IndexFlatL2;
import com.vectorsearch.faiss.swig.floatArray;
import com.vectorsearch.faiss.swig.longArray;
import com.vectorsearch.faiss.utils.JFaissInitializer;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import static com.vectorsearch.faiss.utils.IndexHelper.makeRandomFloatArray;
import static com.vectorsearch.faiss.utils.IndexHelper.show;

public class OneFlatTest {
    private static final Logger LOGGER = Logger.getLogger(OneFlatTest.class.getName());
    private static final int dimension = 64;         // dimension of the vector
    private static final int inputRowCount = 100000; // no of input vectors
    private static final int queryRowCount = 10000;  // no of of query vectors

    private final floatArray inputVectors;
    private final floatArray queryVectors;
    private final IndexFlatL2 index;

    static {
        try {
            JFaissInitializer.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public OneFlatTest() {
        final Random random = new Random(42);
        inputVectors = makeRandomFloatArray(inputRowCount, dimension, random);
        queryVectors = makeRandomFloatArray(queryRowCount, dimension, random);
        index = new IndexFlatL2(dimension);
        index.add(inputRowCount, inputVectors.cast());
        final boolean isTrained = index.getIs_trained();
        final int nTotal = index.getNtotal();
        final String msg = "isTrained = " + isTrained + ", nTotal = " + nTotal;
        LOGGER.info(msg);
    }

    public void search() {
        final int rn = 4;
        final floatArray distances = new floatArray(queryRowCount * rn);
        final longArray indices = new longArray(queryRowCount * rn);
        index.search(queryRowCount, queryVectors.cast(), rn, distances.cast(), indices.cast());
        LOGGER.info(show(distances, 5, rn));
        LOGGER.info(show(indices, 5, rn));
    }

    @Test
    public void oneFlatTest() {
        final OneFlatTest oneFlat = new OneFlatTest();
        LOGGER.info("****************************************************");
        final int rn = 4;
        final int qn = 5;
        final floatArray distances = new floatArray(qn * rn);
        final longArray indices = new longArray(qn * rn);
        index.search(qn, inputVectors.cast(), rn, distances.cast(), indices.cast());
        LOGGER.info(show(distances, qn, rn));
        LOGGER.info(show(indices, qn, rn));
        oneFlat.search();
        LOGGER.info("****************************************************");
        assert true;
    }

}