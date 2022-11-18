package ru.molokoin.j110.lab02.task1;

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
