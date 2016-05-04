package com.core.computism.assasa.config;

import com.core.computism.assasa.web.config.WebConfig;
import org.springframework.context.annotation.Import;

/**
 * Created by Mustufa Amin on 8/5/2015.
 */
@Import(WebConfig.class)
public class WebTestConfig extends TestConfig {
}
