/**
 *
 * Copyright � 2003, TopCoder, Inc. All rights reserved
 */
package com.topcoder.util.classassociations.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.TestResult;

/**
 * <p>This test case aggregates all Accuracy test cases.</p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(ClassAssociatorAccuracyTest.class);
        suite.addTestSuite(DefaultAlgorithmAccuracyTest.class);
        return suite;
    }

}
