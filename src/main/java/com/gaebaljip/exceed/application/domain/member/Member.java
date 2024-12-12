package com.gaebaljip.exceed.application.domain.member;

import com.gaebaljip.exceed.common.exception.member.InvalidGenderException;

import lombok.*;

/**
 * 회원 정보를 바탕으로 BMR, TDEE, 목표 단백질, 탄수화물, 지방등을 결정한다.
 *
 * @author hwangdaesun
 * @version 1.0
 */
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Member {

    private double height;
    private int gender;
    private double weight;
    private int age;
    private Activity activity;
    private double targetWeight;

    double measureBMR() {
        if (gender == 1) {
            return 66.5 + (13.75 * weight) + (5.003 * height) - (6.75 * age);
        } else if (gender == 2) {
            return 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
        } else {
            throw InvalidGenderException.EXECPTION;
        }
    }

    public double measureTDEE() {
        return measureBMR() * activity.getValue();
    }

    public double measureMaintainCarbohydrate() {
        return measureTDEE() * 0.5 / 4;
    }

    public double measureMaintainProtein() {
        return measureTDEE() * 0.2 / 4;
    }

    public double measureMaintainFat() {
        return measureTDEE() * 0.3 / 9;
    }

    public double measureTargetCalorie() {
        return measureTDEE() + 500;
    }

    public double measureTargetCarbohydrate() {
        return measureTargetCalorie() * 0.5 / 4;
    }

    public double measureTargetProtein() {
        return measureTargetCalorie() * 0.2 / 4;
    }

    public double measureTargetFat() {
        return measureTargetCalorie() * 0.3 / 9;
    }
}
