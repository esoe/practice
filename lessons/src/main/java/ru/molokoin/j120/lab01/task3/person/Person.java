package ru.molokoin.j120.lab01.task3.person;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Gender gender;
    private String department;
    private Role role;
    //для аспиранта
    private String thesisTitle;
    //для преподавателя
    private Degree degree;
    private String speciality;
    //для студента
    private Stage stage;
    private String course;

    /**
     * Создаем персону
     * @param name
     * @param gender
     * @param department
     * @param role
     */
    Person(String name, Gender gender, String department, Role role){
        setName(name);
        setGender(gender);
        setDepartment(department);
        setRole(role);
    }
    /**
     * Создаем аспиранта
     * @param name
     * @param gender
     * @param department
     * @param role
     * @param thesisTitle
     */
    Person(String name, Gender gender, String department, Role role, String thesisTitle){
        this(name, gender, department, role);
        setThesisTitle(thesisTitle);
    }

    /**
     * Создаем преподавателя
     * @param name
     * @param gender
     * @param department
     * @param role
     * @param degree
     * @param speciality
     */
    Person(String name, Gender gender, String department, Role role, Degree degree, String speciality){
        this(name, gender, department, role);
        setDegree(degree);
        setSpeciality(speciality);
    }

    /**
     * Создаем студента
     * @param name
     * @param gender
     * @param department
     * @param role
     * @param stage
     * @param course
     */
    Person(String name, Gender gender, String department, Role role, Stage stage, String course){
        this(name, gender, department, role);
        setStage(stage);
        setCourse(course);
    }

    public static Person[] initDefaults(){
        Person[] defaultList = new Person[6];
        
        defaultList[0] = new Person("Ronald Turner", Gender.MALE, "Computer science", 
            Role.TEACHER, Degree.PhD, "Programming paradigms");

        defaultList[1] = new Person("Ruth Hollings", Gender.FEMALE, "Jurisprudence", 
            Role.TEACHER, Degree.MSc, "Domestic arbitration");

        defaultList[2] = new Person("Leo Wilkinson", Gender.MALE, "Computer science", Role.STUDENT, Stage.bachelor, "III");

        defaultList[3] = new Person("Anna Cunningham", Gender.FEMALE, "World economy", Role.STUDENT, Stage.bachelor, "I");

        defaultList[4] = new Person("Jill Lundqvist", Gender.FEMALE, "Jurisprudence", Role.STUDENT, Stage.master, "I");

        defaultList[5] = new Person("Ronald Correa", Gender.MALE, "Computer science", Role.ASPIRANT, "Design of a functional programming language.");

        return defaultList;
    }
    public static List<Person> initPersons(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("Ronald Turner", Gender.MALE, "Computer science", 
        Role.TEACHER, Degree.PhD, "Programming paradigms"));

        list.add(new Person("Ruth Hollings", Gender.FEMALE, "Jurisprudence", 
        Role.TEACHER, Degree.MSc, "Domestic arbitration"));

        list.add(new Person("Leo Wilkinson", Gender.MALE, "Computer science", Role.STUDENT, Stage.bachelor, "III"));

        list.add(new Person("Anna Cunningham", Gender.FEMALE, "World economy", Role.STUDENT, Stage.bachelor, "I"));

        list.add(new Person("Jill Lundqvist", Gender.FEMALE, "Jurisprudence", Role.STUDENT, Stage.master, "I"));

        list.add(new Person("Ronald Correa", Gender.MALE, "Computer science", Role.ASPIRANT, "Design of a functional programming language."));
        return list;
    }
    /**
     * Выводит общие данные в консоль
     */
    public void print(){
        System.out.println("This is " + getName() + " " + 
            getGender().getPronoun() + " " +
            getRole().getVerb() + " at " + getDepartment());
        //преподаватели
        if (getRole().equals(Role.TEACHER)){
            System.out.println(getGender().getPronoun() + " has " + 
            getDegree() + " degree in " + 
            getSpeciality() + ".");
            System.out.println();
        }
        //студенты
        if (getRole().equals(Role.STUDENT)){
            System.out.println(getGender().getPronoun() + " is " + 
                getCourse() + "‘th year " + getStage() + " student.");
            System.out.println();
        }

        //аспиранты
        if (getRole().equals(Role.ASPIRANT)){
            System.out.println(getGender().getPronounOwn() + " thesis title is " + getThesisTitle() + ".");
            System.out.println();
        }
    }
    /**
     * Выводит полный набор данных в консоль<p>
     * @param persons массив элементов Person, для печати в консоль
     */
    public static void printAll(Person[] persons){
        int i = 0;
        while (i < persons.length){
            persons[i].print();
            i++;
        }
    }
    /**
     * Метод принимает параметризованную коллекцию,
     * перебирает foreach все элементы и вызывает методы print() у каждого элемента.
     * !!!чтобы передавать параметризованную коллекцию, ее нужно заранее создать
     */
    public static void printAll(List<? extends Person> list){
        for (Person person : list) {
            person.print();
        }
    }

    /**
     * Устанавливает значение поля name/Фамилия, Имя и Отчество человека
     * @param name
     * не может быть пустым, если передано пустое значение, устанавливается значение noname
     */
    public void setName(String name) {
        this.name = name;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }
    public void setDegree(Degree degree) {
        this.degree = degree;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    /**
     * Возвращает имя человека,
     * TODO имя не может быть пустым полем или отсутствовать
     * @return
     */
     public String getName() {
        return name;
    }
    /**
     * возвращает пол/gender человека мужской/male или женский/female
     * @return
     * 
     */
    public Gender getGender() {
        return gender;
    }
    /**
     * Возвращает наименование департамента, в котором трудится человек (учится или преподает)
     * @return 
     * 
     */
    public String getDepartment() {
        return department;
    }
    public Role getRole() {
        return role;
    }
    public String getThesisTitle() {
        return thesisTitle;
    }
    public Degree getDegree() {
        return degree;
    }
    public String getSpeciality() {
        return speciality;
    }
    public Stage getStage() {
        return stage;
    }
    public String getCourse() {
        return course;
    }
    public static void main(String[] args) {
        System.out.println("----------------------------");
        System.out.println("Печать из массива ...");
        Person.printAll(Person.initDefaults());
        System.out.println("----------------------------");
        System.out.println("Печать из параметризованного списка >>>Persons<<<");
        Person.printAll(Person.initPersons());
        System.out.println("----------------------------");
        System.out.println("Печать из параметризованного списка >>>Personable<<<");
        Person.printAll(Personable.initPersonables());
    }
}
