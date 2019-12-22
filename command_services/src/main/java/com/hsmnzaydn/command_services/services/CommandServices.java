package com.hsmnzaydn.command_services.services;


import com.hsmnzaydn.command_services.model.CommandDTO;

import java.util.List;

public interface CommandServices {

    CommandDTO createCommand(CommandDTO commandDTO);
    List<CommandDTO> getCommandsOfCategory(int categoryId);
}
