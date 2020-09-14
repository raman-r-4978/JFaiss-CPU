package com.vectorsearch.faiss;

import com.vectorsearch.faiss.swig.IndexFlatL2;
import com.vectorsearch.faiss.swig.IndexIVFPQ;
import com.vectorsearch.faiss.swig.floatArray;
import com.vectorsearch.faiss.swig.longArray;
import org.junit.Test;

import java.util.logging.Logger;

import static com.vectorsearch.faiss.utils.IndexHelper.makeRandomFloatArray;
import static com.vectorsearch.faiss.utils.IndexHelper.show;

public class ThreeIVFPQ extends FaissTestCase {

    private static final Logger LOGGER = Logger.getLogger(ThreeIVFPQ.class.getName());
    private static final int dimension = 64;            // dimension of the vector
    private static final int inputRowCount = 100000;    // no of input vectors
    private static final int queryRowCount = 10000;     // no of of query vectors
    private static final int nlist = 100;               // no of clusters
    private static final int m = 8;

    private final floatArray inputVectors;
    private final floatArray queryVectors;
    private final IndexFlatL2 quantizer;
    private final IndexIVFPQ index;

    public ThreeIVFPQ() {
        inputVectors = makeRandomFloatArray(inputRowCount, dimension, random);
        queryVectors = makeRandomFloatArray(queryRowCount, dimension, random);
        quantizer = new IndexFlatL2(dimension);
        index = new IndexIVFPQ(quantizer, dimension, nlist, m, 8);
    }

    @Override
    public void train() {
        index.train(inputRowCount, inputVectors.cast());
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
        index.setNprobe(10);
        index.search(queryRowCount, queryVectors.cast(), rn, distances.cast(), indices.cast());
        LOGGER.info(show(distances, 5, rn));
        LOGGER.info(show(indices, 5, rn));
    }

    @Test
    public void threeIVFPQTest() {
        final ThreeIVFPQ threeIVFPQ = new ThreeIVFPQ();
        LOGGER.info("****************************************************");
        LOGGER.info("Training index..");
        threeIVFPQ.train();
        LOGGER.info("Searching index..");
        threeIVFPQ.search();
        LOGGER.info("****************************************************");
        assert true;
    }
}
