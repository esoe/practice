package ru.molokoin.j120.lab01.task3.person;

public enum Degree {
    PhD {
        @Override
        public String getDegree() {
            return "PhD";
        }
    },
    MSc {
        @Override
        public String getDegree() {
            return "MSc";
        }
    };
    public abstract String getDegree();
}
