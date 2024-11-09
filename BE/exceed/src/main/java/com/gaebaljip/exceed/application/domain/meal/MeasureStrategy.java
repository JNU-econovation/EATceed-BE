package com.gaebaljip.exceed.application.domain.meal;

public interface MeasureStrategy {
    double measure(double nutrients, Unit unit, double servingSize);
}
