package com.gaebaljip.exceed.common.event.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;

import com.gaebaljip.exceed.application.domain.food.FoodEntity;
import com.gaebaljip.exceed.application.domain.meal.MealEntity;
import com.gaebaljip.exceed.application.domain.meal.MealFoodEntity;
import com.gaebaljip.exceed.application.domain.member.HistoryEntity;
import com.gaebaljip.exceed.application.domain.member.MemberEntity;
import com.gaebaljip.exceed.application.domain.notify.NotifyEntity;
import com.gaebaljip.exceed.application.port.out.food.FoodPort;
import com.gaebaljip.exceed.application.port.out.meal.MealFoodPort;
import com.gaebaljip.exceed.application.port.out.meal.MealPort;
import com.gaebaljip.exceed.application.port.out.member.EmailPort;
import com.gaebaljip.exceed.application.port.out.member.HistoryPort;
import com.gaebaljip.exceed.application.port.out.notify.NotifyPort;
import com.gaebaljip.exceed.common.MailTemplate;
import com.gaebaljip.exceed.common.event.DeleteMemberEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteMemberEventListener {
    private final HistoryPort historyPort;
    private final FoodPort foodPort;
    private final MealPort mealPort;
    private final MealFoodPort mealFoodPort;
    private final NotifyPort notifyPort;
    private final EmailPort emailPort;

    @Value("${exceed.deepLink.policy}")
    private String POLICY_URL;

    @Value("${exceed.contact.email}")
    private String CONTACT_EMAIL;

    @EventListener(classes = DeleteMemberEvent.class)
    @Transactional
    public void handle(DeleteMemberEvent event) {
        mealFoodPort.deleteByAllByIdInQuery(findMfIdsByMemberEntity(event.getMemberEntity()));
        mealPort.deleteByAllByIdInQuery(findMIdsByMemberEntity(event.getMemberEntity()));
        foodPort.deleteByAllByIdInQuery(findFIdsByMemberEntity(event.getMemberEntity()));
        historyPort.deleteByAllByIdInQuery(findHIdsByMemberEntity(event.getMemberEntity()));
        notifyPort.deleteByAllByIdInQuery(findNIdsByMemberEntity(event.getMemberEntity()));
        sendEmail(event.getMemberEntity());
    }

    private List<Long> findNIdsByMemberEntity(MemberEntity memberEntity) {
        List<NotifyEntity> notifyEntities = notifyPort.findByMemberEntity(memberEntity);
        return notifyEntities.stream().map(NotifyEntity::getId).toList();
    }

    private List<Long> findMfIdsByMemberEntity(MemberEntity memberEntity) {
        List<MealFoodEntity> mealFoodEntities = mealFoodPort.findByMemberEntity(memberEntity);
        return mealFoodEntities.stream().map(MealFoodEntity::getId).toList();
    }

    private List<Long> findMIdsByMemberEntity(MemberEntity memberEntity) {
        List<MealEntity> mealEntities = mealPort.findByMemberEntity(memberEntity);
        return mealEntities.stream().map(MealEntity::getId).toList();
    }

    private List<Long> findFIdsByMemberEntity(MemberEntity memberEntity) {
        List<FoodEntity> foodEntities = foodPort.findByMemberEntity(memberEntity);
        return foodEntities.stream().map(FoodEntity::getId).toList();
    }

    private List<Long> findHIdsByMemberEntity(MemberEntity memberEntity) {
        List<HistoryEntity> historyEntities = historyPort.findByMemberEntity(memberEntity);
        return historyEntities.stream().map(HistoryEntity::getId).toList();
    }

    private void sendEmail(MemberEntity memberEntity) {
        Context context = new Context();
        context.setVariable(MailTemplate.POLICY_MAIL_CONTEXT, POLICY_URL);
        context.setVariable(MailTemplate.CONTACT_MAIL_CONTEXT, CONTACT_EMAIL);
        emailPort.sendEmail(
                memberEntity.getEmail(),
                MailTemplate.WITHDRAW_TITLE,
                MailTemplate.WITHDRAW_TEMPLATE,
                context);
    }
}
