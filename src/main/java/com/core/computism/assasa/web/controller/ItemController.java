package com.core.computism.assasa.web.controller;

import com.core.computism.assasa.domain.ItemDto;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.service.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by VD on 2/20/2016.
 */
@Controller
@RequestMapping(value = "/item/",produces = {MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8"} )
public class ItemController {

    private static final Logger LOGGER = Logger.getLogger(ItemController.class);

    @Autowired private ItemService itemService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    @ResponseBody
    public Long add(@RequestBody ItemDto itemDto) throws PosBusinessException {

        LOGGER.info("Adding item ...");
        return itemService.addItem(itemDto);
    }
}
