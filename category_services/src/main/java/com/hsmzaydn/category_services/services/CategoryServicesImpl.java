package com.hsmzaydn.category_services.services;


import com.hsmnzaydn.core_api.events.CreateCommandEvent;
import com.hsmnzaydn.core_api.kafka.KafkaTopics;
import com.hsmzaydn.category_services.models.CategoryDTO;
import com.hsmzaydn.category_services.models.CommandBean;
import com.hsmzaydn.category_services.repository.Category;
import com.hsmzaydn.category_services.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServicesImpl implements CategoryServices {


    private final CategoryRepository categoryRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;




    @Override
    public Category createCategory(CategoryDTO categoryBean) {
        Category category = new Category();
        category.setCategoryTitle(categoryBean.getCategoryTitle());
        //  commandGateway.send(new CategoryCreatedCommand(categoryBean.getCategoryId(), categoryBean.getCategoryTitle()));
        // kafkaTemplate.send("test","aaa");
        return categoryRepository.save(category);
    }

    @KafkaListener(
            topics = KafkaTopics.CREATE_COMMAND,
            containerFactory = "commandKafkaListenerContainerFactory"
    )
    public void commandListener(CreateCommandEvent createCommandEvent) {

        Category category = categoryRepository.findById(createCommandEvent.getCategoryId()).get();
        CommandBean commandBean = new CommandBean();
        commandBean.setCommandId(createCommandEvent.getCommandId());
        category.getCommands().add(commandBean);
        categoryRepository.save(category);
    }

    @Override
    public Category getCategory(int categoryId)  {

        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
