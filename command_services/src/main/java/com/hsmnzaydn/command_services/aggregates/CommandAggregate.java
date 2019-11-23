package com.hsmnzaydn.command_services.aggregates;


import com.hsmnzaydn.core_api.commands.CommandCreatedCommand;
import com.hsmnzaydn.core_api.events.CreateCategoryEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CommandAggregate {
    @AggregateIdentifier
    private int categoryId;

    private String categoryTitle;


    public CommandAggregate() {

    }


    @CommandHandler
    public CommandAggregate(CommandCreatedCommand categoryCreatedCommand) {
        System.out.println("sss");

        //  AggregateLifecycle.apply(new CreateCategoryEvent(categoryCreatedCommand.getId(),categoryCreatedCommand.getTitle()));
    }


    @EventSourcingHandler
    private void handleCreatedEvent(CreateCategoryEvent event) {

        categoryId = event.getCategoryId();
    }
}
