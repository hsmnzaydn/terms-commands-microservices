package com.hsmnzaydn.command_services;


import com.hsmnzaydn.command_services.model.CommandBean;
import com.hsmnzaydn.command_services.repository.CommandDao;
import com.hsmnzaydn.command_services.services.CommandServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/auth/api/commands")
public class CommandRestController {

    @Autowired
    CommandServices commandServices;

    @PostMapping
    public CommandDao addCategory(@RequestBody CommandBean commandBean) throws ExecutionException, InterruptedException {
        return commandServices.createCommand(commandBean);
    }

    @GetMapping("/category/{categoryId}")
    public List<CommandDao> getCommandsOfCategory(@PathVariable int categoryId){
        return commandServices.getCommandsOfCategory(categoryId);
    }


}
