package com.hsmnzaydn.command.model;


import lombok.Data;

@Data
public class CommandDTO {
    private Integer categoryId;
    private String commandTitle;

    public CommandDTO(Integer categoryId, String commandTitle) {
        this.categoryId = categoryId;
        this.commandTitle = commandTitle;
    }


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCommandTitle() {
        return commandTitle;
    }

    public void setCommandTitle(String commandTitle) {
        this.commandTitle = commandTitle;
    }
}
