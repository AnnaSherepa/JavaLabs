package lab1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Reader extends Person {



    private Type access;//store information about access to some type of books
    private int idTicket;//if student - student ticket, if teacher - work contract
    private static int lastId;
    private ArrayList<Record> records;

    private class Record {
        private Date created;
        private Book book;
        private Librarian librarian;

        public Record(){
            this.book = new Book();
            this.librarian = new Librarian();
        }
        public Record(Date created, Book book, Librarian librarian){
            this.setBook(book);
            this.setCreated(created);
            this.setLibrarian(librarian);
            book.setNum(book.getNum()-1);
        }

        public void show(){
            book.show();
            String date[] = created.toString().split(" ");
            StringBuilder showDate = new StringBuilder();
            showDate.append("День: ")
                    .append(date[2])
                    .append(" ")
                    .append(date[1])
                    .append("\tГод: ")
                    .append(date[3]);
            System.out.println(showDate);
            librarian.show();
    }

        public void setBook(Book book) {
            this.book = new Book();
            this.book = book;
        }
        public void setCreated(Date created) {
            this.created = created;
        }
        public void setLibrarian(Librarian librarian) {
            this.librarian = new Librarian();
            this.librarian = librarian; }

        public Book getBook() { return book; }
        public Date getCreated() { return created; }
        public Librarian getLibrarian() { return librarian; }
    }

    public Reader(){
        this.records = new ArrayList<Record>();
        this.lastId += 1;
    }

    public Reader(String name, String surname, String parent, int age, Sex sex, Type type){
        super(name, surname, parent, age, sex);
        this.records = new ArrayList<Record>();
        this.setIdTicket(this.lastId);
        this.lastId += 1;
        this.setType(type);
    }

    public void setType(Type type) {
        this.access = type;
    }
    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public void setRecord( Book book, Librarian librarian) {
        Date created = new Date();
        if(book.getAccess() == this.access){
            if(book.getNum() > 0){
                this.records.add(new Record(created, book, librarian));
                System.out.println("Книга \"" + book.getName() + "\" була успішно додана");
            }else{
                System.out.println("Книга \"" + book.getName() + "\" відсутня у бібліотеці");
            }

        }else{
            System.out.println("Доступ до книги \""+ book.getName() + "\" відмовлено для поточного користувача. \nНеобхідний тип доступу: " + book.getAccess() + " \t Поточний тип доступу: " + this.access);
        }
    }

    public void deleteRecord(int index){
        try{
            Book temp = records.get(index).getBook();
            temp.setNum(temp.getNum()-1);
            records.remove(index);
            System.out.println("Ваш запис було видалено");
        }catch(IndexOutOfBoundsException e){
            System.out.println("Помилка видалення. ЗАПИСУ з вказаним індексом не існує");
        }


    }

    public int searchRecordId(Book book){
        int i = 0;
        for ( Record r: records) {
            if(r.getBook() == book){
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public void show(boolean var) {
        System.out.format("Читач: %s %s \t\t доступ: %s\n\n", this.getName(), this.getSurname(), this.access);
        if(!records.isEmpty()){
            System.out.println("Список записів:");
            int i = 1;
            Iterator<Record> iterator = records.iterator();
            while (iterator.hasNext()){
                System.out.println("***********************************************************************");
                System.out.format("%2d\t", i++);
                iterator.next().show();
                System.out.println("***********************************************************************");
                System.out.println();
            }
        }
        System.out.println("\n\n\n");
    }

    public int getIdTicket() { return idTicket; }
    public Type getType() { return access; }

}

;
