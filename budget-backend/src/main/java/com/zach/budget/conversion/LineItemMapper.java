package com.zach.budget.conversion;

import org.mapstruct.Mapper;

import com.zach.budget.entities.LineItemEntity;
import com.zach.budget.models.LineItem;

@Mapper(componentModel = "spring", uses = {
    CategoryMapper.class,
    AccountMapper.class
})

public interface LineItemMapper {
    LineItem toModel(LineItemEntity entity);
    LineItemEntity toEntity(LineItem model);
}
