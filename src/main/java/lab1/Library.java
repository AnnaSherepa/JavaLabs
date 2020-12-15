package lab1;


import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class Library implements LibraryFunctions {
    private ArrayList<Author> authors;
    private ArrayList<Book> books;
    private ArrayList<Reader> readers;
    private ArrayList<Librarian> librarians;
    private static int idLibrarianContract = 0;

    class ObjectExistInArray extends Exception{
        public ObjectExistInArray(){
            super("Даний об'єкт вже існує в списку");
        }
    }

    public Library(){
        this.librarians = new ArrayList<Librarian>();
        this.readers = new ArrayList<Reader>();
        this.authors = new ArrayList<Author>();
        this.books = new ArrayList<Book>();
    }
    public Library(ArrayList<Author> a, ArrayList<Book> b, ArrayList<Librarian> l, ArrayList<Reader> r){

        this.setAuthors(a);
        this.setBooks(b);
        this.setLibrarians(l);

        this.setReaders(r);
    }


    public void setAuthors(ArrayList<Author> authors) { this.authors.addAll(authors); }
    public void setBooks(ArrayList<Book> books) {
        this.books.addAll(books);
    }
    public void setLibrarians(ArrayList<Librarian> librarians) { this.librarians.addAll(librarians); }
    public void setReaders(ArrayList<Reader> readers) { this.readers.addAll(readers); }

    public void setAuthors(Author authors) {
        try {
            for (Author a: this.authors) {
                if(a.equals(authors)){
                    throw new ObjectExistInArray();
                }
            }

            this.authors.add(authors);
        }catch (ObjectExistInArray e){
            e.getMessage();
        }
    }

    public void setBooks(Book book) {
        this.books.add(book);
    }
    public void setLibrarians(Librarian librarians) {
        librarians.setIdContract(idLibrarianContract);
        idLibrarianContract += 1;

        this.librarians.add(librarians);
        System.out.println("Бібліотекара додано");
    }
    public void setReaders(Reader readers) { this.readers.add(readers); }

    public ArrayList<Author> getAuthors() { return authors; }
    public ArrayList<Book> getBooks() { return books; }
    public ArrayList<Librarian> getLibrarians() { return librarians; }
    public ArrayList<Reader> getReaders() { return readers; }


    public Book searchBookByName(String name){

        for (Book b: this.books){
            if(b.getName().equals(name)){
                return b;
            }
        }
        return null;
    }

    public Author searchAuthorBySurname(String name){

        for (Author b: this.authors){
            if(b.getSurname().equals(name)){
                return b;
            }
        }
        System.out.println("Author "+name+" was not founded");
        return null;
    }

    public Librarian searchLibrarianById(int id){
        for (Librarian b: this.librarians){
            System.out.println("Contract: "+b.getIdContract());
            System.out.println("Searching id = " + id);
            if(b.getIdContract() == id){
                return b;
            }
        }
        System.out.println("Librarian with id = " + id + " was not founded");
        return null;
    }

    public Reader searchReaderByName(String name){
        for (Reader b: this.readers){
            if(b.getName().equals(name)){
                return b;
            }
        }
        System.out.println("Reader " + name + " was not founded");
        return null;
    }
    public Reader searchReaderById(int id){
        for (Reader b: this.readers){
            if(b.getIdTicket() == id){
                return b;
            }
        }
        System.out.println("Reader with id="+id+" was not founded");
        return null;
    }

    public void showListOfBooks(){
        if(books.isEmpty()){
            System.out.println("Список книг порожній");
            return;
        }
        int i = 1;
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()){
            System.out.format("%2d\t", i++);
            iterator.next().show();
        }
        System.out.println("\n\n\n");
    }
    public void showListOfAuthors(){
        if(authors.isEmpty()){
            System.out.println("Список порожній");
            return;
        }
        int i = 1;
        Iterator<Author> iterator = authors.iterator();
        while (iterator.hasNext()){
            System.out.format("%2d\t", i++);
            iterator.next().show();
        }
        System.out.println("\n\n\n");
    }

    public void showListOfReaders(){
        if(readers.isEmpty()){
            System.out.println("Список порожній");
            return;
        }
        int i = 1;
        Iterator<Reader> iterator = readers.iterator();
        while (iterator.hasNext()){
            System.out.format("%2d\t", i++);
            iterator.next().show();
        }
        System.out.println("\n\n\n");
    }

    public void showListOfLibrarian(){
        if(librarians.isEmpty()){
            System.out.println("Список порожній");
            return;
        }
        int i = 1;
        Iterator<Librarian> iterator = librarians.iterator();
        while (iterator.hasNext()){
            System.out.format("%2d\t", i++);
            iterator.next().show();
        }
        System.out.println("\n\n\n");
    }

    public void setRecord(Reader reader, Book book, Librarian librarian){
        reader.show(true);
        book.show(true);
        librarian.show(true);
        this.searchReaderById(reader.getIdTicket()).setRecord(book, librarian);
    }

    public void deleteRecord(Reader reader, int ind){
        this.searchReaderById(reader.getIdTicket()).deleteRecord(ind);
    }

    public void deleteRecord(Reader reader, Book book){
        int i = reader.searchRecordId(book);
        this.searchReaderById(reader.getIdTicket()).deleteRecord(i);
    }

    public Map<Boolean, ArrayList<Librarian>> filterLibrarian(Predicate< ?super Librarian> lib){
        Map<Boolean, ArrayList<Librarian>> return_value = new HashMap<>();
        ArrayList<Librarian> librarians = new ArrayList<Librarian>();
        ArrayList<Librarian> not_librarians = new ArrayList<Librarian>();
        for(Librarian l: this.librarians){
            if (lib.test(l)){
                librarians.add(l);
            }else{
                not_librarians.add(l);
            }
        }

        return_value.put(Boolean.TRUE, librarians);
        return_value.put(Boolean.FALSE, not_librarians);
        return return_value;
    }

    public Author mostPopularAuthor(){
        Map<Author,Integer> map = new HashMap<>();
        ArrayList<Author> authors = new ArrayList<>();
        this.books.forEach(book -> authors.addAll(book.getAuthors()));
        authors.forEach(
                author -> {
                    if(map.containsKey(author)   ) map.put(author, map.get(author) + 1);
                    else map.put(author, 1);
                }
        );

        Set<Map.Entry<Author,Integer>> entrySet=map.entrySet();
        Integer desiredObject= Collections.max(map.values());//что хотим найти

        for (Map.Entry<Author,Integer> pair : entrySet) {
            if (desiredObject.equals(pair.getValue())) {
                return pair.getKey();// нашли наше значение и возвращаем  ключ
            }
        }

       return null;
    }



}
