package com.core.computism.assasa.service.impl;

import com.core.computism.assasa.domain.ItemDto;
import com.core.computism.assasa.exception.BrainBusinessException;
import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.inventory.Item;
import com.core.computism.assasa.persistence.repository.inventory.ItemRepository;
import com.core.computism.assasa.service.ItemService;
import com.core.computism.assasa.util.builder.ItemBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

/**
 * Created by VD on 2/19/2016.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired private ItemRepository itemRepository;
    @Autowired private ItemBuilder itemBuilder;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public Long addItem(ItemDto itemDto) throws PosBusinessException {

        try {

            if (itemDto == null) {
                throw new PosBusinessException("No DTO Found");
            }

            Item item = new Item();
            item = itemBuilder.buildItemEntity(item, itemDto);

            item = itemRepository.save(item);

            return item.getId();
        } catch(PersistenceException e){
            throw new PosBusinessException(e);
        }

    }
}
