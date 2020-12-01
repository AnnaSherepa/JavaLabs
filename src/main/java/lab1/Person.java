package lab1;

public abstract class Person{
    protected String name;
    protected String surname;
    private String parent;
    private int age;
    private Sex sex;


    public Person(){}
    public Person(String parent, int age, Sex sex){
        this.setName(name);
        this.setSurname(surname);
        this.setParent(parent);
        this.setAge(age);
        this.setSex(sex);
    }

    public Person(String name, String surname, String parent, int age, Sex sex){
        this.setName(name);
        this.setSurname(surname);
        this.setParent(parent);
        this.setAge(age);
        this.setSex(sex);
    }

    public void show(){
        System.out.format("%s %c. %c.\n", surname, name.toCharArray()[0], parent.toCharArray()[0]);


    }
    public void show(boolean var){
        StringBuilder stringBuild = new StringBuilder();
        stringBuild.append("Ім'я: ")
                .append(name)
                .append(" \tПрізвище")
                .append(surname)
                .append("Вік: ")
                .append(age)
                .append(sex);

        System.out.println(stringBuild);
    }

    public void setAge(int age) { this.age = age; }
    public void setName(String name) { this.name = name; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setSex(Sex sex) { this.sex = sex; }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public Sex getSex() { return sex; }
    public int getAge() { return age; }
    public String getName() { return name; }
    public String getSurname() { return surname; }

    public String getParent() {
        return parent;
    }
}

