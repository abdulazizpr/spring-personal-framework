package com.abdulazizpr.springboot.command;

import com.abdulazizpr.springboot.command.model.CommandRequest;
import com.abdulazizpr.springboot.command.execption.CommandValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import reactor.core.publisher.Mono;

import java.util.Set;

@SuppressWarnings("unchecked")
public abstract class AbstractCommand<RESULT, REQUEST extends CommandRequest>
        implements Command<RESULT, REQUEST>, ApplicationContextAware, InitializingBean {

    protected Validator validator;

    protected ApplicationContext applicationContext;

    @Override
    public final void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public final void afterPropertiesSet() throws Exception {
        this.validator = applicationContext.getBean(Validator.class);
    }

    @Override
    public final Mono<RESULT> execute(REQUEST request) {
        Set<ConstraintViolation<REQUEST>> constraintViolations = validator.validate(request);
        if (constraintViolations.isEmpty()) {
            return doExecute(request);
        } else {
            return Mono.error(new CommandValidationException(constraintViolations));
        }
    }

    public abstract Mono<RESULT> doExecute(REQUEST request);
}