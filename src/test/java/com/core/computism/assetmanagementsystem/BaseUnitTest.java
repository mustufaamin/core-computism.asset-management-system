package com.core.computism.assetmanagementsystem;

import com.core.computism.assetmanagementsystem.config.TestConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Venturedive on 8/5/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public abstract class BaseUnitTest extends BaseTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
}
