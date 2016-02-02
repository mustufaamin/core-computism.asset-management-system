package com.core.computism.assetmanagementsystem.config;

import com.core.computism.assetmanagementsystem.web.config.WebConfig;
import org.springframework.context.annotation.Import;

/**
 * Created by Venturedive on 8/5/2015.
 */
@Import(WebConfig.class)
public class WebTestConfig extends TestConfig {
}
