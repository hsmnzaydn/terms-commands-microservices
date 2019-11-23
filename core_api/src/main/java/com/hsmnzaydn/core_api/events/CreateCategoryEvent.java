package com.hsmnzaydn.core_api.events;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class CreateCategoryEvent {
    @TargetAggregateIdentifier
    private final int categoryId;

    private final String categoryName;

    public CreateCategoryEvent(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}
