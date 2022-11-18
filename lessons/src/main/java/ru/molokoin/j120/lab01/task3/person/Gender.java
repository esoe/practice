package ru.molokoin.j120.lab01.task3.person;
/**
 * Перечисление gender,
 * 
 */
public enum Gender {
    MALE {
        public String getPronoun(){
            return "he";
        }

        @Override
        public String getPronounOwn() {
            return "his";
        }
    },
    FEMALE{
        public String getPronoun(){
            return "she";
        }
        @Override
        public String getPronounOwn() {
            return "her";
        }

    },
    TRANS{
        public String getPronoun() {
            return "it";
        }

        @Override
        public String getPronounOwn() {
            return "its";
        }
    };
    public abstract String getPronoun();
    public abstract String getPronounOwn();
}
