package com.gaebaljip.exceed.common.event.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.thymeleaf.context.Context;

import com.gaebaljip.exceed.application.domain.member.Code;
import com.gaebaljip.exceed.application.port.out.member.CodePort;
import com.gaebaljip.exceed.application.port.out.member.EmailPort;
import com.gaebaljip.exceed.common.MailTemplate;
import com.gaebaljip.exceed.common.event.SignUpMemberEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SignUpMemberEventListener {

    private final EmailPort emailPort;
    private final CodePort codePort;

    @Value("${exceed.url}")
    private String URL;

    private Long expiredTime = 600000L;

    @TransactionalEventListener(classes = SignUpMemberEvent.class)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Async
    public void handle(SignUpMemberEvent event) {
        int randomCode = createRandom();
        codePort.saveWithExpiration(event.getEmail(), String.valueOf(randomCode), expiredTime);
        Context context = new Context();
        context.setVariable(
                MailTemplate.SIGN_UP_MAIL_CONTEXT, URL + MailTemplate.REPLY_TO_SIGN_UP_MAIL_URL);
        context.setVariable(MailTemplate.SIGN_UP_CODE, randomCode);
        emailPort.sendEmail(
                event.getEmail(),
                MailTemplate.SIGN_UP_TITLE,
                MailTemplate.SIGN_UP_TEMPLATE,
                context);
    }

    private int createRandom() {
        Code code = new Code();
        int random = code.createRandom();
        return random;
    }
}
