package com.hsmnzaydn.command_services.repository;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
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
