package com.gaebaljip.exceed.meal.adapter;

import com.gaebaljip.exceed.common.IntegrationTest;
import com.gaebaljip.exceed.dto.EatMealRequest;
import com.gaebaljip.exceed.meal.adapter.out.MealRepository;
import com.gaebaljip.exceed.meal.application.port.in.EatMealUsecase;
import com.gaebaljip.exceed.meal.application.port.in.GetPreSignedUrlUsecase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class EatMealIntegrationTest extends IntegrationTest {

    @Autowired
    private MealRepository mealRepository;

    @Test
    void eatMeal() throws Exception {
        //given

        long beforeCnt = mealRepository.findAll().stream().count();
        EatMealRequest eatMealRequest = EatMealRequest.builder()
                .mealType("LUNCH")
                .multiple(1.5)
                .foodIds(List.of(1L, 2L))
                .build();

        //when
        ResultActions resultActions = mockMvc.perform(
                post("/v1/meal")
                        .content(om.writeValueAsString(eatMealRequest))
                        .contentType(MediaType.APPLICATION_JSON));


        long afterCnt = mealRepository.findAll().stream().count();

        //then
        resultActions.andExpect(status().isCreated());
        Assertions.assertThat(afterCnt - beforeCnt).isEqualTo(1);
        Assertions.assertThat(afterCnt).isGreaterThan(0);
    }


}
