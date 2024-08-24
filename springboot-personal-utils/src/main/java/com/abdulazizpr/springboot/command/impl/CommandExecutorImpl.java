package com.abdulazizpr.springboot.command.impl;

import com.abdulazizpr.springboot.command.Command;
import com.abdulazizpr.springboot.command.CommandExecutor;
import com.abdulazizpr.springboot.command.model.CommandRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CommandExecutorImpl implements CommandExecutor {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public <RESPONSE, REQUEST extends CommandRequest> Mono<RESPONSE> execute(Class<? extends Command<RESPONSE, REQUEST>> commandClass, REQUEST request) {
        Command<RESPONSE, REQUEST> command = applicationContext.getBean(commandClass);
        return command.execute(request);
    }
}
