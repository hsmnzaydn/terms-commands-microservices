package com.hsmnzaydn.core_entity_lib.category;

import com.hsmnzaydn.core_entity_lib.command.Command;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String categoryTitle;

    @Column
    @ElementCollection(targetClass = Command.class)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Command> commands;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }
}