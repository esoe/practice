package ru.molokoin.j120.lab01.task3.person;

public enum Stage {
    bachelor {
        @Override
        public String getStage() {
            return "bachelor";
        }
    },
    master {
        @Override
        public String getStage() {
            return "master";
        }
    };
    public abstract String getStage();
}
