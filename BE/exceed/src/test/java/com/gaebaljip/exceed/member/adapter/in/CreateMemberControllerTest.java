package com.gaebaljip.exceed.member.adapter.in;

import com.gaebaljip.exceed.common.CommonApiTest;
import com.gaebaljip.exceed.member.application.CreateMemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CreateMemberController.class)
class CreateMemberControllerTest extends CommonApiTest {

    @MockBean
    private CreateMemberService createMemberService;

    @Test
    @DisplayName("회원가입 성공")
    void createMember() throws Exception {
        //given

        CreateMemberTestRequest request = new CreateMemberTestRequest(
                171, true, 61, 25, "NOT_ACTIVE", "뭐든 잘 먹습니다.");

        //when
        ResultActions resultActions = mockMvc.perform(
                post("/v1/members")
                        .content(om.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON));


        //then
        resultActions.andExpect(status().isOk());
    }


}