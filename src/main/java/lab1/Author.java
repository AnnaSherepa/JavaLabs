package lab1;

import java.util.ArrayList;

public class Author extends Person {
    private int beg_year;
    private int end_year;
    private ArrayList<String> awards;

    public Author(){}
    public Author(String name, String surname, String parent, int age, Sex sex, int beg_year, int end_year){
        super(name, surname,parent, age, sex);
        this.setBeg_year(beg_year);
        this.setEnd_year(end_year);
    }

    public Author(String name, String surname, String parent, int age, Sex sex, int beg_year, int end_year, ArrayList<String> awards){
        super(parent, age, sex);
        this.name = name;
        this.surname = surname;
        this.setBeg_year(beg_year);
        this.setEnd_year(end_year);
        this.setAwards(awards);
    }

    public Author(String name, String surname, String parent, int age, Sex sex, int beg_year, int end_year, String award) {
        super(name, surname,parent, age, sex);
        this.setBeg_year(beg_year);
        this.setEnd_year(end_year);
        this.setAwards(award);
    }

    public void setAwards(String award){ this.awards.add(award); }
    public void setAwards(ArrayList<String> awards) { this.awards.addAll(awards); }
    public void setBeg_year(int beg_year) { this.beg_year = beg_year; }
    public void setEnd_year(int end_year) { this.end_year = end_year; }

    public ArrayList<String> getAwards() { return awards; }
    public int getBeg_year() { return beg_year; }
    public int getEnd_year() { return end_year; }


    @Override
    public void show(boolean var) {
        System.out.println("Автор\n");
        super.show();

        System.out.println("(" + beg_year + " " + end_year + ")");
        if(awards != null){
            System.out.println("Список нагород:");
            for (Object element : awards) {
                System.out.println(" " + element + " ");
            }
        }
    }



    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Author)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Author c = (Author) o;

        // Compare the data members and return accordingly
        System.out.println("Ці об'єкти рівні між собою\n");

        return name.equals(c.getName())  && surname.equals(c.getSurname()) && this.getParent().equals(c.getParent()) && beg_year == c.getBeg_year() && end_year == c.getEnd_year();
    }
}
