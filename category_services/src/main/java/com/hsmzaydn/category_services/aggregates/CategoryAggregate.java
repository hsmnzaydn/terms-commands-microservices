package com.hsmzaydn.category_services.aggregates;


import com.hsmnzaydn.core_api.commands.CategoryCreatedCommand;
import com.hsmnzaydn.core_api.events.CreateCategoryEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CategoryAggregate {
    @AggregateIdentifier
    private int categoryId;

    private String categoryTitle;


    public CategoryAggregate() {
    }

    @CommandHandler
    public CategoryAggregate(CategoryCreatedCommand categoryCreatedCommand) {
        AggregateLifecycle.apply(new CreateCategoryEvent(categoryCreatedCommand.getId(), categoryCreatedCommand.getTitle()));
    }


    @EventSourcingHandler
    private void handleCreatedEvent(CreateCategoryEvent event) {
        categoryTitle = event.getCategoryName();
    }
}
