package com.gaebaljip.exceed.application.domain.meal;

public class GStrategy implements MeasureStrategy {
    @Override
    public double measure(double value, Unit unit, double servingSize) {
        return (value / servingSize) * unit.getG();
    }
}
