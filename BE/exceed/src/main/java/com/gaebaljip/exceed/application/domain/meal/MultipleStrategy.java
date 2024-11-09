package com.gaebaljip.exceed.application.domain.meal;

public class MultipleStrategy implements MeasureStrategy {
    @Override
    public double measure(double nutrients, Unit unit, double servingSize) {
        return nutrients * unit.getMultiple();
    }
}
