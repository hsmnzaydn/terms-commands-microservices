package com.hsmnzaydn.core_entity_lib.command;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Command")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer categoryId;

    private String commandTitle;


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommandTitle() {
        return commandTitle;
    }

    public void setCommandTitle(String commandTitle) {
        this.commandTitle = commandTitle;
    }
}
