package com.zach.budget.conversion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zach.budget.entities.LineItemEntity;
import com.zach.budget.models.LineItem;

@Component
public class LineItemMapper {

    @Autowired
    public AccountMapper accountMapper;

    @Autowired
    public CategoryMapper categoryMapper;

    public List<LineItem> toModels(List<LineItemEntity> entities) {
        List<LineItem> models = new ArrayList<>();
        for(LineItemEntity entity : entities) {
            models.add(toModel(entity));
        }
        return models;
    }

    public LineItem toModel(LineItemEntity entity) {
        LineItem lineItem = new LineItem(
             entity.getName(), 
             entity.getPlannedAmount(), 
             entity.getNextDue(), 
             entity.getFrequency(), 
             entity.getIsAutoPay(), 
             accountMapper.toModel(entity.getAccount()), 
             categoryMapper.toModel(entity.getCategory()));

        lineItem.setId( entity.getId() );

        return lineItem;
    }

    public List<LineItemEntity> toEntities(List<LineItem> models) {
        List<LineItemEntity> entities = new ArrayList<>();
        for(LineItem model : models) {
            entities.add(toEntity(model));
        }
        return entities;
    }

    public LineItemEntity toEntity(LineItem model) {
        if ( model == null ) {
            return null;
        }

        LineItemEntity lineItemEntity = new LineItemEntity();

        lineItemEntity.setId( model.getId() );
        lineItemEntity.setName( model.getName() );
        lineItemEntity.setPlannedAmount(model.getPlannedAmount());
        lineItemEntity.setIsAutoPay( model.getIsAutoPay() );
        lineItemEntity.setFrequency( model.getFrequency() );
        lineItemEntity.setAccount( accountMapper.toEntity( model.getAccount() ) );
        lineItemEntity.setCategory( categoryMapper.toEntity( model.getCategory() ) );

        return lineItemEntity;
    }

}
