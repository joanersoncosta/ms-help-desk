package com.gitthub.joanerson.emailservice.email.domain.utils;

import java.nio.charset.StandardCharsets;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.context.Context;

import com.gitthub.joanerson.emailservice.ordem.domain.dto.OrdemCriadaResponse;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

@Log4j2
@UtilityClass
public class EmailUtils {
	
    public static void getMimeMessage(MimeMessage message, String process, OrdemCriadaResponse OrdemCriadaResponse, String subject) throws MessagingException {
		log.debug("[start] EmailUtils - getMimeMessage");
    	MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        mimeMessageHelper(process, OrdemCriadaResponse, subject, helper);
		log.debug("[finish] EmailUtils - getMimeMessage");
    }

	private static void mimeMessageHelper(String process, OrdemCriadaResponse OrdemCriadaResponse, String subject,
			MimeMessageHelper helper) throws MessagingException, AddressException {
		log.debug("[start] EmailUtils - mimeMessageHelper");
		helper.setTo(OrdemCriadaResponse.getClienteResponse().email());
        helper.setFrom(new InternetAddress("front3890@gmail.com"));
        helper.setSubject(subject);
        helper.setText(process, true);
		log.debug("[finish] EmailUtils - mimeMessageHelper");
	}

    public static Context getContextOrdemCriada(OrdemCriadaResponse ordemResponse) {
		log.debug("[start] EmailUtils - getContextOrdemCriada");
    	Context context = new Context();

        context.setVariable("nomeCliente", ordemResponse.getClienteResponse().nome());
        context.setVariable("idOrdem", ordemResponse.getOrdemResponse().idOrdem());
        context.setVariable("titlo", ordemResponse.getOrdemResponse().titlo());
        context.setVariable("descricao", ordemResponse.getOrdemResponse().descricao());
        context.setVariable("dataCriacao", ordemResponse.getOrdemResponse().descricao());
        context.setVariable("ordemStatus", ordemResponse.getOrdemResponse().ordemStatus());
        context.setVariable("tecnicoResponsavel", ordemResponse.getTecnicoResponse().nome());
		log.debug("[finish] EmailUtils - getContextOrdemCriada");
        return context;
    }
}