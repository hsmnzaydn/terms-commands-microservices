package com.hsmnzaydn.command_services.services;


import com.hsmnzaydn.core_api.commands.CommandCreatedCommand;
import com.hsmnzaydn.command_services.model.CommandBean;
import com.hsmnzaydn.command_services.repository.CommandDao;
import com.hsmnzaydn.command_services.repository.CommandRepository;
import com.hsmnzaydn.core_api.events.CreateCommandEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandServicesImpl implements CommandServices {


    private final CommandRepository commandRepository;

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;
    private final KafkaTemplate<String, CreateCommandEvent> kafkaTemplate;


    @Autowired
    public CommandServicesImpl(CommandGateway commandGateway, QueryGateway queryGateway, CommandRepository commandRepository,
                               KafkaTemplate<String, CreateCommandEvent> kafkaTemplate) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
        this.commandRepository = commandRepository;
        this.kafkaTemplate = kafkaTemplate;

    }

    @Override
    public CommandDao createCommand(CommandBean commandBean) {
        CommandDao commandDao = new CommandDao();
        commandDao.setCommandTitle(commandBean.getCommandTitle());
        commandDao.setCategoryId(commandBean.getCategoryId());
        commandGateway.send(new CommandCreatedCommand(commandBean.getCategoryId(), commandBean.getCommandTitle()));
        commandDao = commandRepository.save(commandDao);
        CreateCommandEvent createCommandEvent = new CreateCommandEvent();
        createCommandEvent.setCommandId(commandDao.getId());
        createCommandEvent.setCategoryId(commandDao.getCategoryId());
        kafkaTemplate.send("createCommand", createCommandEvent);
        return commandDao;
    }

   /* @KafkaListener(topics = "test", groupId = "term")
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
    }*/
}
