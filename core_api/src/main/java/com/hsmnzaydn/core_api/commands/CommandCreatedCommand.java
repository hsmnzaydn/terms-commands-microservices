package com.hsmnzaydn.core_api.commands;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class CommandCreatedCommand {
    @TargetAggregateIdentifier
    private int id;

    private String title;


    public CommandCreatedCommand(int id, String title) {
        this.id = id;
        this.title = title;
    }
}
