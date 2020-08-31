package com.vectorsearch.faiss;

import com.vectorsearch.faiss.swig.IndexFlatL2;
import com.vectorsearch.faiss.swig.floatArray;
import com.vectorsearch.faiss.swig.longArray;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static com.vectorsearch.faiss.utils.IndexHelper.makeRandomFloatArray;
import static com.vectorsearch.faiss.utils.IndexHelper.show;

public class OneFlatTest extends FaissTest {
    private static final Logger LOGGER = Logger.getLogger(OneFlatTest.class.getName());
    private static final int dimension = 64;         // dimension of the vector
    private static final int inputRowCount = 100000; // no of input vectors
    private static final int queryRowCount = 10000;  // no of of query vectors

    private final floatArray inputVectors;
    private final floatArray queryVectors;
    private final IndexFlatL2 index;

    public OneFlatTest() {
        inputVectors = makeRandomFloatArray(inputRowCount, dimension, random);
        queryVectors = makeRandomFloatArray(queryRowCount, dimension, random);
        index = new IndexFlatL2(dimension);
    }

    @Override
    public void train() {
        index.add(inputRowCount, inputVectors.cast());
        final boolean isTrained = index.getIs_trained();
        final int nTotal = index.getNtotal();
        final String msg = "isTrained = " + isTrained + ", nTotal = " + nTotal;
        LOGGER.info(msg);
    }

    @Override
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
        LOGGER.info("Training index..");
        oneFlat.train();
        LOGGER.info("Searching index..");
        oneFlat.search();
        LOGGER.info("****************************************************");
        assert true;
    }
}