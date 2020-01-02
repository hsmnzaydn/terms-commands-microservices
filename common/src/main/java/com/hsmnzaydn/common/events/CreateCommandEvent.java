package com.hsmnzaydn.common.events;

public class CreateCommandEvent {
    private int commandId;

    private int categoryId;


    public void setCommandId(int commandId) {
        this.commandId = commandId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCommandId() {
        return commandId;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
