package com.gaebaljip.exceed.application.domain.meal;

import static com.gaebaljip.exceed.application.domain.meal.MealFoodEntity.ENTITY_PREFIX;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.gaebaljip.exceed.common.exception.meal.InvalidMultipleAndGException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Unit {
    @Column(name = ENTITY_PREFIX + "_G")
    private Integer g;

    @Column(name = ENTITY_PREFIX + "_MULTIPLE")
    private Double multiple;

    @Enumerated(EnumType.STRING)
    @Column(name = ENTITY_PREFIX + "_UNIT_TYPE", nullable = false)
    private UnitType unitType;

    public static Unit createUnit(Integer g, Double multiple) {
        if (Objects.nonNull(g)) {
            return new Unit(g, multiple, UnitType.G);
        }
        if (Objects.nonNull(multiple)) {
            return new Unit(g, multiple, UnitType.MULTIPLE);
        }
        throw InvalidMultipleAndGException.EXCEPTION;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return Objects.equals(g, unit.g) && Objects.equals(multiple, unit.multiple);
    }

    @Override
    public int hashCode() {
        return Objects.hash(g, multiple);
    }
}
