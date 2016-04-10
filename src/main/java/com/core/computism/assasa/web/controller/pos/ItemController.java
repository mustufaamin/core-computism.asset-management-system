package com.core.computism.assasa.web.controller.pos;

import com.core.computism.assasa.pos.domain.PosItemDto;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.pos.service.PosItemService;
import com.core.computism.assasa.util.ServerResponse;
import com.core.computism.assasa.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by M.Mustufa Amin Shah on 2/20/2016.
 */
@RestController
@RequestMapping(value = "/item/")
public class ItemController extends BaseController {

    private static final Logger LOGGER = Logger.getLogger(ItemController.class);

    @Autowired private PosItemService posItemService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ServerResponse<PosItemDto> add(@RequestBody PosItemDto posItemDto) throws PosBusinessException {

        LOGGER.info("Adding item ...");
        ServerResponse<PosItemDto> response = toResponse(posItemService.add(posItemDto));
        return response;
    }
    @RequestMapping(value = "addType/{typeName}", method = RequestMethod.POST)
    public ServerResponse<PosItemDto> addType(@PathVariable String typeName) throws PosBusinessException {
        LOGGER.info("Adding item ...");
//        ServerResponse<PosItemDto> response = toResponse(posItemService.addItemType(typeName));
        return null;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public ServerResponse<PosItemDto> addType(@RequestBody PosItemDto posItemDto) throws PosBusinessException {
        LOGGER.info("Adding item ...");
        ServerResponse<PosItemDto> response = toResponse(posItemService.update(posItemDto));
        return response;
    }
    @RequestMapping(value = "/get/{itemId}", method = RequestMethod.GET)
    public ServerResponse<PosItemDto> getItem(@PathVariable(value = "itemId") Long itemId) throws PosBusinessException {
        LOGGER.info("Get Item....");
        ServerResponse<PosItemDto> response = toResponse(posItemService.get(itemId));
        return response;
    }

}
