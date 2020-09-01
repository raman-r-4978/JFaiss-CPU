package com.vectorsearch.faiss;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        OneFlat.class,
        TwoIVFFlat.class,
        ThreeIVFPQ.class
})
public class FaissTestSuite {
}
