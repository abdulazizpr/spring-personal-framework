package com.diginiq.bigboss.utils.command;

import com.diginiq.bigboss.utils.command.model.response.request.CommandRequest;
import reactor.core.publisher.Mono;

/**
 * @author Abdul Aziz Priatna
 * @since 19/08/2024 (Tomorrow Independence Day from Indonesia ありがとう)
 */
public interface Command<RESPONSE, REQUEST extends CommandRequest> {
    RESPONSE execute(REQUEST request);
}