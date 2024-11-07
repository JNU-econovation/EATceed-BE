package com.gaebaljip.exceed.application.domain.meal;

public class MultipleStrategy implements MeasureStrategy {
    @Override
    public double measure(double value, Unit unit, double servingSize) {
        return value * unit.getMultiple();
    }
}
