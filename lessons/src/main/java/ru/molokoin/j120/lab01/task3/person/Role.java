package ru.molokoin.j120.lab01.task3.person;

public enum Role {
    STUDENT {
        @Override
        public String getVerb() {
            return "studies";
        }
    },
    ASPIRANT {
        @Override
        public String getVerb() {
            return "studies";
        }
    },
    TEACHER {
        @Override
        public String getVerb() {
            return "teaches";
        }
    };
    public abstract String getVerb();
}
