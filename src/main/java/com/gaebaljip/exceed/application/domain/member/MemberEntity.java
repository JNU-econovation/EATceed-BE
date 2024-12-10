package com.gaebaljip.exceed.application.domain.member;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.ColumnDefault;

import com.gaebaljip.exceed.adapter.out.jpa.member.GenderConvert;
import com.gaebaljip.exceed.application.domain.agreement.AgreementEntity;
import com.gaebaljip.exceed.common.BaseEntity;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = MemberEntity.ENTITY_PREFIX + "_TB")
@Builder(toBuilder = true)
public class MemberEntity extends BaseEntity {

    public static final String ENTITY_PREFIX = "MEMBER";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(name = ENTITY_PREFIX + "_HEIGHT")
    private Double height;

    @Convert(converter = GenderConvert.class)
    @Column(name = ENTITY_PREFIX + "_GENDER", columnDefinition = "tinyint")
    private Gender gender;

    @Column(name = ENTITY_PREFIX + "_AGE")
    private Integer age;

    @Column(name = ENTITY_PREFIX + "_EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = ENTITY_PREFIX + "_PASSWORD", nullable = false)
    private String password;

    @Column(name = ENTITY_PREFIX + "_CHECKED", nullable = false)
    @ColumnDefault("false")
    @Builder.Default
    private Boolean checked = false;

    @Column(name = ENTITY_PREFIX + "_ETC")
    private String etc;

    @Enumerated(EnumType.STRING)
    @Column(name = ENTITY_PREFIX + "_ACTIVITY")
    private Activity activity;

    @Enumerated(EnumType.STRING)
    @Column(name = ENTITY_PREFIX + "_ROLE", nullable = false)
    @Builder.Default
    private MemberRole role = MemberRole.MEMBER;

    @Column(name = ENTITY_PREFIX + "_WEIGHT")
    private Double weight;

    @Column(name = ENTITY_PREFIX + "_TARGET_WEIGHT")
    private Double targetWeight;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AGREEMENT_FK", nullable = false)
    private AgreementEntity agreementEntity;

    public static MemberEntity createMember(
            String email, String password, AgreementEntity agreementEntity) {
        return MemberEntity.builder()
                .email(email)
                .password(password)
                .agreementEntity(agreementEntity)
                .build();
    }

    public void updateChecked() {
        this.checked = true;
    }

    public void updateMember(
            double height,
            Gender gender,
            int age,
            Activity activity,
            String etc,
            double weight,
            double targetWeight) {
        this.height = height;
        this.gender = gender;
        this.age = age;
        this.activity = activity;
        this.weight = weight;
        this.targetWeight = targetWeight;
        this.etc = etc;
    }

    public void updateWeight(Double weight, Double targetWeight) {
        this.weight = weight;
        this.targetWeight = targetWeight;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public boolean isSignUp() {
        return checked;
    }

    public boolean isOnBoarding() {
        return this.getWeight() != null
                && this.getHeight() != null
                && this.getAge() != null
                && this.getActivity() != null
                && this.getGender() != null
                && this.getTargetWeight() != null;
    }

    public boolean isBeforeSignUpDate(LocalDateTime checkDateTime, LocalDateTime createdAt) {
        return checkDateTime.isBefore(createdAt);
    }

    public boolean isBeforeSignUpMonth(LocalDate checkDate, LocalDateTime createdDateTime) {
        LocalDate comparisonDate = createdDateTime.toLocalDate().withDayOfMonth(1);
        return checkDate.isBefore(comparisonDate);
    }

    @Override
    public String toString() {
        return "MemberEntity{"
                + "id="
                + id
                + ", height="
                + height
                + ", gender="
                + gender
                + ", age="
                + age
                + ", email='"
                + email
                + '\''
                + ", password='"
                + password
                + '\''
                + ", checked="
                + checked
                + ", etc='"
                + etc
                + '\''
                + ", activity="
                + activity
                + ", role="
                + role
                + ", weight="
                + weight
                + ", targetWeight="
                + targetWeight
                + '}';
    }
}
