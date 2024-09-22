package com.gitthub.joanerson.emailservice.ordem.infra;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.gitthub.joanerson.emailservice.ordem.domain.dto.OrdemCriadaResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class OrdemListener {

    @RabbitListener(queues = "ordens.v1.ordem-criada"
           //  = "rk.ordens.create"
    )
    public void ordemListenerCreate(OrdemCriadaResponse ordemResponse){
        log.debug("[start] OrdemListener - ordemListenerCreate");
        try {
            log.debug("[ordemResponse] {}", ordemResponse);

        } catch (Exception e) {
            log.error("[Error] OrdemListener - ordemListenerCreate: {}", e.getMessage(), e);
        }
        log.debug("[finish] OrdemListener - ordemListenerCreate");
    }
}