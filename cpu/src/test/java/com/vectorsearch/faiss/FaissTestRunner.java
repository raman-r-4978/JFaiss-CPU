package com.vectorsearch.faiss;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static com.vectorsearch.faiss.FaissTestCase.isValidOS;

public class FaissTestRunner {
    @Test
    public void runTest() {
        if (isValidOS()) {
            final Result result = JUnitCore.runClasses(FaissTestSuite.class);
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
            System.out.println(result.wasSuccessful());
        }
    }
}
