package com.gaebaljip.exceed.common.event.handler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;

import com.gaebaljip.exceed.application.domain.member.Code;
import com.gaebaljip.exceed.application.port.out.member.CodePort;
import com.gaebaljip.exceed.application.port.out.member.EmailPort;
import com.gaebaljip.exceed.common.MailTemplate;
import com.gaebaljip.exceed.common.event.IncompleteSignUpEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InCompleteSignUpMemberEventListener {

    private final EmailPort emailPort;
    private final CodePort codePort;

    @Value("${exceed.url}")
    private String URL;

    private Long expiredTime = 600000L;

    @EventListener(classes = IncompleteSignUpEvent.class)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Async
    public void handle(IncompleteSignUpEvent event) {
        codePort.saveWithExpiration(event.getEmail(), Code.create(), expiredTime);
        Context context = new Context();
        context.setVariable(
                MailTemplate.SIGN_UP_MAIL_CONTEXT, URL + MailTemplate.REPLY_TO_SIGN_UP_MAIL_URL);
        context.setVariable(MailTemplate.SIGN_UP_EMAIL, "?email=" + event.getEmail());
        emailPort.sendEmail(
                event.getEmail(),
                MailTemplate.SIGN_UP_TITLE,
                MailTemplate.SIGN_UP_TEMPLATE,
                context);
    }
}
