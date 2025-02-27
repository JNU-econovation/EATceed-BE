package com.gaebaljip.exceed.common;

public class MailTemplate {
    public static final String SIGN_UP_TEMPLATE = "signup";
    public static final String FIND_PASSWORD_TEMPLATE = "findPassword";
    public static final String WITHDRAW_TEMPLATE = "withdraw";
    public static final String SIGN_UP_TITLE = "Eatceed 회원가입 인증 메일";
    public static final String FIND_PASSWORD_TITLE = "Eatceed 비밀번호 찾기 메일";

    public static final String SIGN_UP_MAIL_CONTEXT = "signupLink";
    public static final String WITHDRAW_TITLE = "회원 탈퇴 완료 안내";
    public static final String POLICY_MAIL_CONTEXT = "policyLink";
    public static final String CONTACT_MAIL_CONTEXT = "contactEmail";
    public static final String FIND_PASSWORD_MAIL_CONTEXT = "findPasswordLink";
    public static final String SIGN_UP_CODE = "code";
    public static final String SIGN_UP_EMAIL = "email";
    public static final String FIND_PASSWORD_EMAIL = "email";
    public static final String REPLY_TO_SIGN_UP_MAIL_URL = "/v1/signUp-redirect";
    public static final String REPLY_TO_FIND_PASSWORD_MAIL_URL = "/v1/findPassword-redirect";
    public static final String FIND_PASSWORD_CODE = "code";
}
