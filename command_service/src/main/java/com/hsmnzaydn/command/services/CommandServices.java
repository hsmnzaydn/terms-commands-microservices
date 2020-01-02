package com.hsmnzaydn.command.services;



import com.hsmnzaydn.command.model.CommandDTO;

import java.util.List;

public interface CommandServices {

    CommandDTO createCommand(CommandDTO commandDTO);
    List<CommandDTO> getCommandsOfCategory(int categoryId);
}
