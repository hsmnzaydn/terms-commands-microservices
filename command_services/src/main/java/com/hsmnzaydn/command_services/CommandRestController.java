package com.hsmnzaydn.command_services;


import com.hsmnzaydn.command_services.model.CommandDTO;
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
    public CommandDTO addCategory(@RequestBody CommandDTO commandDTO) throws ExecutionException, InterruptedException {
        return commandServices.createCommand(commandDTO);
    }

    @GetMapping("/category/{categoryId}")
    public List<CommandDTO> getCommandsOfCategory(@PathVariable int categoryId){
        return commandServices.getCommandsOfCategory(categoryId);
    }


}
