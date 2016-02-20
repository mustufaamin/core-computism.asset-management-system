package com.core.computism.assasa.web.controller;

import com.core.computism.assasa.BaseControllerTest;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Venturedive on 8/10/2015.
 */
public class BrainControllerTest extends BaseControllerTest {

    @InjectMocks
    private BrainController controller;

    @Override
    protected Object getControllers() {
        return controller;
    }

    @Test
    public void testPrintWelcome() throws Exception {
        this.mockMvc.perform(get("/brain/", 0))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("default"));
    }
}
