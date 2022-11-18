package ru.molokoin.j110.lab02.task1;

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
