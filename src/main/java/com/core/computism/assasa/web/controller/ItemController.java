package com.core.computism.assasa.web.controller;

import com.core.computism.assasa.domain.ItemDto;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.service.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by VD on 2/20/2016.
 */
@RestController
@RequestMapping(value = "item/")
public class ItemController extends BaseController{

    private static final Logger LOGGER = Logger.getLogger(ItemController.class);

    @Autowired private ItemService itemService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public Long add(@RequestBody ItemDto itemDto) throws PosBusinessException {

        LOGGER.info("Adding item ...");
        return itemService.addItem(itemDto);
    }
    @RequestMapping(value = "addType/{typeName}", method = RequestMethod.POST)
    public Long addType(@PathVariable String typeName) throws PosBusinessException {
        LOGGER.info("Adding item ...");
        return itemService.addItemType(typeName);
    }
}
