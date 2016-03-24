package com.core.computism.assasa.pos.service.impl;

import com.core.computism.assasa.exception.BuilderException;
import com.core.computism.assasa.pos.domain.ItemDto;
import com.core.computism.assasa.exception.PosBusinessException;
import com.core.computism.assasa.persistence.entity.pos.PosItem;
import com.core.computism.assasa.persistence.entity.pos.PosItemType;
import com.core.computism.assasa.persistence.entity.pos.Supplier;
import com.core.computism.assasa.persistence.repository.pos.PosItemRepository;
import com.core.computism.assasa.persistence.repository.pos.PosItemTypeRepository;
import com.core.computism.assasa.persistence.repository.pos.SupplierRepository;
import com.core.computism.assasa.pos.service.PosItemService;
import com.core.computism.assasa.pos.builder.PosItemBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by M.Mustafa Amin Shah on 2/19/2016.
 */
@Service(value = "posItemService")
public class PosItemServiceImpl implements PosItemService {
    @Autowired private PosItemRepository posItemRepository;
    @Autowired private PosItemBuilder posItemBuilder;
    @Autowired private PosItemTypeRepository posItemTypeRepository;
    @Autowired private SupplierRepository supplierRepository;


    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = PosBusinessException.class)
    public Long add(ItemDto itemDto) throws PosBusinessException {

        try {
            if (itemDto == null) {
                throw new PosBusinessException("No DTO Found");
            }

            PosItemType posItemType = posItemTypeRepository.findOne(itemDto.getItemType());
            Supplier supplier = supplierRepository.findOne(itemDto.getSupplerId());

            PosItem posItem = new PosItem();
            posItem = posItemBuilder.buildItemEntity(posItem, itemDto);

            posItem.setSupplier(supplier);
            posItem.setPosItemType(posItemType);

            posItem = posItemRepository.save(posItem);
            return posItem.getId();
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

            PosItemType posItemType = posItemTypeRepository.findOne(itemDto.getItemType());
            Supplier supplier = supplierRepository.findOne(itemDto.getSupplerId());

            PosItem posItem = posItemRepository.findOne(itemDto.getId());
            posItem = posItemBuilder.buildItemEntity(posItem, itemDto);

            posItem.setSupplier(supplier);
            posItem.setPosItemType(posItemType);

            posItem = posItemRepository.save(posItem);
            return posItem.getId();
        } catch(PersistenceException e){
            throw new PosBusinessException(e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public ItemDto get(Long itemId) throws PosBusinessException {
        try {
            PosItem posItem = posItemRepository.findOne(itemId);
            if (posItem == null) {
                throw new PosBusinessException("No Item found having Id " + itemId);
            }
            return posItemBuilder.buildItemDto(posItem);
        }catch (BuilderException e){
            throw new PosBusinessException("Error occurred while fetching Item",e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<ItemDto> list() throws PosBusinessException{
        try{
            List<PosItem> posItems = posItemRepository.findAll();
            return posItemBuilder.buildItemDtoList(posItems);
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
            PosItemType posItemType = new PosItemType();
            posItemType.setName(typeName);
            posItemTypeRepository.save(posItemType);

            return posItemType.getId();
        }catch (PersistenceException e){
            e.printStackTrace();
            throw new PosBusinessException(e);
        }
    }


}
