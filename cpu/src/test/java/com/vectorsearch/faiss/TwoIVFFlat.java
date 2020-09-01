package com.vectorsearch.faiss;

import com.vectorsearch.faiss.swig.*;
import org.junit.Test;

import java.util.logging.Logger;

import static com.vectorsearch.faiss.utils.IndexHelper.makeRandomFloatArray;
import static com.vectorsearch.faiss.utils.IndexHelper.show;

public class TwoIVFFlat extends FaissTestCase {
    private static final Logger LOGGER = Logger.getLogger(TwoIVFFlat.class.getName());
    private static final int dimension = 64;            // dimension of the vector
    private static final int inputRowCount = 100000;    // no of input vectors
    private static final int queryRowCount = 10000;     // no of of query vectors
    private static final int nlist = 100;               // no of clusters

    private final floatArray inputVectors;
    private final floatArray queryVectors;
    private final IndexFlatL2 quantizer;
    private final IndexIVFFlat index;

    public TwoIVFFlat() {
        inputVectors = makeRandomFloatArray(inputRowCount, dimension, random);
        queryVectors = makeRandomFloatArray(queryRowCount, dimension, random);
        quantizer = new IndexFlatL2(dimension);
        index = new IndexIVFFlat(quantizer, dimension, nlist, MetricType.METRIC_L2);
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
    public void twoIVFFlatTest() {
        final TwoIVFFlat twoIVFFlat = new TwoIVFFlat();
        LOGGER.info("****************************************************");
        LOGGER.info("Training index..");
        twoIVFFlat.train();
        LOGGER.info("Searching index..");
        twoIVFFlat.search();
        LOGGER.info("****************************************************");
        assert true;
    }
}