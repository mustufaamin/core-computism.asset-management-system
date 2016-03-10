package com.core.computism.assasa.inventory.service.impl;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.inventory.domain.ItemDto;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.inventory.Item;
import com.core.computism.assasa.persistence.entity.inventory.ItemType;
import com.core.computism.assasa.persistence.entity.inventory.Supplier;
import com.core.computism.assasa.persistence.repository.inventory.ItemRepository;
import com.core.computism.assasa.persistence.repository.inventory.ItemTypeRepository;
import com.core.computism.assasa.persistence.repository.inventory.SupplierRepository;
import com.core.computism.assasa.inventory.service.ItemService;
import com.core.computism.assasa.inventory.builder.ItemBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by VD on 2/19/2016.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired private ItemRepository itemRepository;
    @Autowired private ItemBuilder itemBuilder;
    @Autowired private ItemTypeRepository itemTypeRepository;
    @Autowired private SupplierRepository supplierRepository;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public Long add(ItemDto itemDto) throws PosBusinessException {

        try {
            if (itemDto == null) {
                throw new PosBusinessException("No DTO Found");
            }

            ItemType itemType = itemTypeRepository.findOne(itemDto.getItemType());
            Supplier supplier = supplierRepository.findOne(itemDto.getSupplerId());

            Item item = new Item();
            item = itemBuilder.buildItemEntity(item, itemDto);

            item.setSupplier(supplier);
            item.setItemType(itemType);

            item = itemRepository.save(item);
            return item.getId();
        } catch(PersistenceException e){
            throw new PosBusinessException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public Long update(ItemDto itemDto) throws PosBusinessException {
        try {
            if (itemDto == null) {
                throw new PosBusinessException("No DTO Found");
            }

            ItemType itemType = itemTypeRepository.findOne(itemDto.getItemType());
            Supplier supplier = supplierRepository.findOne(itemDto.getSupplerId());

            Item item = itemRepository.findOne(itemDto.getId());
            item = itemBuilder.buildItemEntity(item, itemDto);

            item.setSupplier(supplier);
            item.setItemType(itemType);

            item = itemRepository.save(item);
            return item.getId();
        } catch(PersistenceException e){
            throw new PosBusinessException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public ItemDto get(Long itemId) throws PosBusinessException {
        try {
            Item item = itemRepository.findOne(itemId);
            if (item == null) {
                throw new PosBusinessException("No Item found having Id " + itemId);
            }
            return itemBuilder.buildItemDto(item);
        }catch (BuilderException e){
            throw new PosBusinessException("Error occurred while fetching Item",e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ItemDto> list() throws PosBusinessException{
        try{
            List<Item> items = itemRepository.findAll();
            return itemBuilder.buildItemDtoList(items);
        }catch (BuilderException e){
            throw new PosBusinessException("Error occurred while fetching Item list",e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public Long addItemType(String typeName) throws PosBusinessException {
        try{
            if(typeName == null){
                throw new PosBusinessException("Null value found");
            }
            ItemType itemType = new ItemType();
            itemType.setName(typeName);
            itemTypeRepository.save(itemType);

            return itemType.getId();
        }catch (PersistenceException e){
            e.printStackTrace();
            throw new PosBusinessException(e);
        }
    }


}
