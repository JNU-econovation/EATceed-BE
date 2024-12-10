package com.gaebaljip.exceed.application.domain.meal;

public class GStrategy implements MeasureStrategy {
    @Override
    public double measure(double nutrients, Unit unit, double servingSize) {
        return (unit.getG() / servingSize) * nutrients;
    }
}
