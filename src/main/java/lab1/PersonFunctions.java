package lab1;

public interface PersonFunctions {
    void show();
    void show(boolean var);

    void setAge(int age);
    void setName(String name);
    void setSurname(String surname);
    void setSex(Sex sex);

    void setParent(String parent);
    Sex getSex();
    int getAge();
    String getName();
    String getSurname();

    String getParent();
}
