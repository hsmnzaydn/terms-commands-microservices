package com.hsmzaydn.category_services.repository;

import com.hsmzaydn.category_services.models.CommandBean;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Category")
public class CategoryDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String categoryTitle;

    @Column
    @ElementCollection(targetClass = CommandBean.class)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CommandBean> commands;


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

    public List<CommandBean> getCommands() {
        return commands;
    }

    public void setCommands(List<CommandBean> commands) {
        this.commands = commands;
    }
}