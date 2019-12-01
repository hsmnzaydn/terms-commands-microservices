package com.hsmzaydn.category_services.services;


import com.hsmnzaydn.core_api.events.CreateCommandEvent;
import com.hsmzaydn.category_services.models.CategoryBean;
import com.hsmzaydn.category_services.models.CommandBean;
import com.hsmzaydn.category_services.repository.CategoryDao;
import com.hsmzaydn.category_services.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public CategoryDao createCategory(CategoryBean categoryBean) {
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.setCategoryTitle(categoryBean.getCategoryTitle());
        //  commandGateway.send(new CategoryCreatedCommand(categoryBean.getCategoryId(), categoryBean.getCategoryTitle()));
        // kafkaTemplate.send("test","aaa");
        return categoryRepository.save(categoryDao);
    }

    @KafkaListener(
            topics = "createCommand",
            containerFactory = "commandKafkaListenerContainerFactory"
    )
    public void commandListener(CreateCommandEvent createCommandEvent) {

        CategoryDao categoryDao = categoryRepository.findById(createCommandEvent.getCategoryId()).get();
        CommandBean commandBean = new CommandBean();
        commandBean.setCommandId(createCommandEvent.getCommandId());
        categoryDao.getCommands().add(commandBean);
        categoryRepository.save(categoryDao);
        // process greeting message
    }

    @Override
    public CategoryDao getCategory(int categoryId)  {

        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public List<CategoryDao> getCategories() {
        return categoryRepository.findAll();
    }
}
