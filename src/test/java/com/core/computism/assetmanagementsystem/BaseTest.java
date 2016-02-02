package com.core.computism.assetmanagementsystem;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

/**
 * Created by Venturedive on 9/7/2015.
 */
public abstract class BaseTest {

    protected Logger logger = Logger.getLogger(getClass());

    @Rule
    public TestName name = new TestName();

    @Before
    public void setUp() {
        logger.info("********************************************");
        logger.info("*** Executing test: " + getClass().getSimpleName() + "." + name.getMethodName());
        logger.info("********************************************");
        logger.info("");
    }

    @After
    public void baseTearDown() throws Exception {
        logger.info("********************************************");
        logger.info("*** Finished test: " + getClass().getSimpleName() + "." + name.getMethodName());
        logger.info("");
    }
}
