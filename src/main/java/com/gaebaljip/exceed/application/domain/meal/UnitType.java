package com.gaebaljip.exceed.application.domain.meal;

public enum UnitType {
    G {
        @Override
        public double measure(double nutrients, Unit unit, double servingSize) {
            return (unit.getG() / servingSize) * nutrients;
        }
    },
    MULTIPLE {
        @Override
        public double measure(double nutrients, Unit unit, double servingSize) {
            return nutrients * unit.getMultiple();
        }
    };

    abstract double measure(double nutrients, Unit unit, double servingSize);
}
