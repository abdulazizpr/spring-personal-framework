package com.abdulazizpr.springboot.command;

import com.abdulazizpr.springboot.command.model.CommandRequest;
import reactor.core.publisher.Mono;

/**
 * @author Abdul Aziz Priatna
 * @since 19/08/2024 (Tomorrow Independence Day from Indonesia ありがとう)
 */
public interface Command<RESPONSE, REQUEST extends CommandRequest> {
    Mono<RESPONSE> execute(REQUEST request);
}