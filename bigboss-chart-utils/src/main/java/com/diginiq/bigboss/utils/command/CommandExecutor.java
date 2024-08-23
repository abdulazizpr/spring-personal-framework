package com.diginiq.bigboss.utils.command;

import com.diginiq.bigboss.utils.command.model.response.request.CommandRequest;
import reactor.core.publisher.Mono;

/**
 * @author Abdul Aziz Priatna
 * @since 16/08/2024 (Tomorrow Independence Day from Indonesia ありがとう)
 */
public interface CommandExecutor {
    <T, R extends CommandRequest> Mono<T> execute(Class<? extends Command<T, R>> commandClass, R request);
}