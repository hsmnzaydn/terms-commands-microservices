package com.hsmnzaydn.command_services.services;


import com.hsmnzaydn.command_services.model.CommandDTO;
import com.hsmnzaydn.command_services.repository.Command;
import com.hsmnzaydn.command_services.repository.CommandRepository;
import com.hsmnzaydn.core_api.events.CreateCommandEvent;
import com.hsmnzaydn.core_api.kafka.KafkaTopics;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommandServicesImpl implements CommandServices {


    private final CommandRepository commandRepository;


    private final KafkaTemplate<String, CreateCommandEvent> kafkaTemplate;




    @Override
    public CommandDTO createCommand(CommandDTO commandDTO) {
        Command command = new Command();
        command.setCommandTitle(commandDTO.getCommandTitle());
        command.setCategoryId(commandDTO.getCategoryId());
        command = commandRepository.save(command);
        CreateCommandEvent createCommandEvent = new CreateCommandEvent();
        createCommandEvent.setCommandId(command.getId());
        createCommandEvent.setCategoryId(command.getCategoryId());
        kafkaTemplate.send(KafkaTopics.CREATE_COMMAND, createCommandEvent);
        return commandDTO;
    }

    @Override
    public List<CommandDTO> getCommandsOfCategory(int categoryId) {

       return commandRepository.findByCategoryId(categoryId).stream()
                .map(command -> new CommandDTO(command.getCategoryId(), command.getCommandTitle()))
                .collect(Collectors.toList());

    }


}
