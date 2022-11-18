package ru.molokoin.j110.lab02.task1;

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
