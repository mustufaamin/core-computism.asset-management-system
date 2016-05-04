package com.core.computism.assasa;

import com.core.computism.assasa.config.TestConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Mustufa Amin on 8/5/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public abstract class BaseUnitTest extends BaseTest {

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
}
