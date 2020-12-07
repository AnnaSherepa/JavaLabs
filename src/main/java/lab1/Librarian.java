package lab1;


public class Librarian extends Person {
    private int idContract;
    private String phoneNumber;
    private double salary;
    private int lastContr;


    @Override
    public void show(boolean var) {
        System.out.println("Бібліотекар");
        super.show(var);
        System.out.println("Id контракту: " + idContract);
        System.out.println("Телефон: " + phoneNumber);
        System.out.println("Заробітня плата : " + salary);
    }

    public Librarian(){
        /*lastContr += 1;*/
    }
    public Librarian(String name, String surname, String parent, int age, Sex sex, String phoneNumber, double salary){
        super(name, surname,parent, age, sex);
        this.setIdContract(lastContr);
        this.setPhoneNumber(phoneNumber);
    /*    lastContr += 1;*/
        this.setSalary(salary);
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
    public int getIdContract() {
        return idContract;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}

