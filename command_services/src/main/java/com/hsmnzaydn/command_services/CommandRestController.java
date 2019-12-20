package com.hsmnzaydn.command_services;


import com.hsmnzaydn.command_services.model.CommandDTO;
import com.hsmnzaydn.command_services.services.CommandServices;
import com.hsmnzaydn.core_api.CommonResponse;
import com.hsmnzaydn.core_api.configuration.HystrixConfiguration;
import com.hsmnzaydn.core_api.utility.Utility;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/commands")
public class CommandRestController {

    @Autowired
    CommandServices commandServices;

    @PostMapping
    @HystrixCommand(fallbackMethod = "addCommandError", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HystrixConfiguration.TIME_OUT)
    })
    public ResponseEntity<CommonResponse<CommandDTO>> addCommand(@RequestBody CommandDTO commandDTO) throws ExecutionException, InterruptedException {
       try{
           return ResponseEntity.ok(Utility.commonResponseFactory(commandServices.createCommand(commandDTO)));
       }catch (Exception e){
           return ResponseEntity.status(500).body(Utility.commonErrorResponseFactory());
       }
    }

    @HystrixCommand(fallbackMethod = "getCommandsOfCategoryError", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = HystrixConfiguration.TIME_OUT)
    })
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<CommonResponse<List<CommandDTO>>> getCommandsOfCategory(@PathVariable int categoryId){
       try {
           return ResponseEntity.ok(Utility.commonResponseFactory(commandServices.getCommandsOfCategory(categoryId)));

       }catch (Exception e){
           return ResponseEntity.status(500).body(Utility.commonErrorResponseFactory());
       }
    }

    private ResponseEntity<CommonResponse<CommandDTO>> addCommandError(){
        return ResponseEntity.status(500).body(Utility.commonErrorResponseFactory());
    }

    private ResponseEntity<CommonResponse<CommandDTO>> getCommandsOfCategoryError(){
        return ResponseEntity.status(500).body(Utility.commonErrorResponseFactory());
    }


}
