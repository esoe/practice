package ru.molokoin.j110.lab02.task1;
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
