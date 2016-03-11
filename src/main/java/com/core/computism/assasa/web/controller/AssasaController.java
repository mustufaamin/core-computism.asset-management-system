package com.core.computism.assasa.web.controller;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Venturedive on 8/5/2015.
 */
@Controller
@RequestMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8"})
public class AssasaController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(AssasaController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        LOGGER.info("BrainController.printWelcome method called.");
        model.addAttribute("message", "Welcome :-)");
        return "default";
    }
}
