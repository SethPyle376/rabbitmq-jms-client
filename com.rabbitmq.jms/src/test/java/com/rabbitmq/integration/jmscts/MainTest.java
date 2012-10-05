package com.rabbitmq.integration.jmscts;

import java.io.File;

import junit.framework.TestCase;

import org.exolab.jmscts.test.ComplianceTestSuite;
import org.junit.experimental.categories.Category;

import com.rabbitmq.integration.tests.IntegrationTest;

@Category(IntegrationTest.class)
public class MainTest extends TestCase {

    public void testAll() throws Exception {
        if (System.getProperty("basedir")==null) {
            System.setProperty("basedir",".");
        }
        System.setProperty("jmscts.home", System.getProperty("basedir"));
        if (System.getProperty("rabbit.jms.terminationTimeout") == null) {
            System.setProperty("rabbit.jms.terminationTimeout", "5000");
        }
        ComplianceTestSuite.main(new String[] { "-filter",
                                                new File(System.getProperty("basedir"), "config/filter.xml").getAbsolutePath() });
    }

}