package ru.molokoin.j120.lab01.task3.person;

import java.util.ArrayList;
import java.util.List;

public class Personable extends Person{
    Personable(String name, Gender gender, String department, Role role){
        super(name, gender, department, role);
    }
    Personable(String name, Gender gender, String department, Role role, String thesisTitle){
        super(name, gender, department, role);
    }
    Personable(String name, Gender gender, String department, Role role, Degree degree, String speciality) {
        super(name, gender, department, role, degree, speciality);
    }
    Personable(String name, Gender gender, String department, Role role, Stage stage, String course){
        super(name, gender, department, role, stage, course);
    }
    
    public static List<Personable> initPersonables(){
        List<Personable> list = new ArrayList<>();
        list.add(new Personable("Ronald Turner", Gender.MALE, "Computer science", 
        Role.TEACHER, Degree.PhD, "Programming paradigms"));

        list.add(new Personable("Ruth Hollings", Gender.FEMALE, "Jurisprudence", 
        Role.TEACHER, Degree.MSc, "Domestic arbitration"));

        list.add(new Personable("Leo Wilkinson", Gender.MALE, "Computer science", Role.STUDENT, Stage.bachelor, "III"));

        list.add(new Personable("Anna Cunningham", Gender.FEMALE, "World economy", Role.STUDENT, Stage.bachelor, "I"));

        list.add(new Personable("Jill Lundqvist", Gender.FEMALE, "Jurisprudence", Role.STUDENT, Stage.master, "I"));

        list.add(new Personable("Ronald Correa", Gender.MALE, "Computer science", Role.ASPIRANT, "Design of a functional programming language."));
        return list;
    }
    
}
