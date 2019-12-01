package com.hsmnzaydn.command_services.services;


import com.hsmnzaydn.command_services.model.CommandBean;
import com.hsmnzaydn.command_services.repository.CommandDao;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface CommandServices {

    CommandDao createCommand(CommandBean commandBean);
    List<CommandDao> getCommandsOfCategory(int categoryId);
}
