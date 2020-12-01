package lab1;

import java.util.ArrayList;
import java.util.Iterator;

public class Book {
    private int publishYear;
    private String name;
    private String description;//can be used for quick searching
    private int pages;
    private ArrayList<Author> authors; // can be more, than one
    private String genre;
    private Type access;
    private int num;


    public Book(){
        this.authors = new ArrayList<Author>();
    }
    public Book(String name, Author author, int num, Type access){
        this.authors = new ArrayList<Author>();
        this.setName(name);
        this.setAuthors(author);
        this.setAccess(access);
        this.setNum(num);
    }

    public Book(String name, ArrayList<Author> authors, int num, Type access){
        this.authors = new ArrayList<Author>();
        this.setName(name);
        this.setAuthors(authors);
        this.setAccess(access);
        this.setNum(num);
    }
    public Book(String name, Author author, int num, Type access, String d){
        this.authors = new ArrayList<Author>();
        this.setName(name);
        this.setAuthors(author);
        this.setAccess(access);
        this.setNum(num);
        this.setDescription(d);
    }

    public Book(String name, ArrayList<Author> authors, int num, Type access, String d){
        this.authors = new ArrayList<Author>();
        this.setName(name);
        this.setAuthors(authors);
        this.setAccess(access);
        this.setNum(num);
        this.setDescription(d);
    }

    public Book(String name, ArrayList<Author> authors, int num, Type access, String d, int y, int p, String genre){
        this.authors = new ArrayList<Author>();
        this.setName(name);
        this.setAuthors(authors);
        this.setAccess(access);
        this.setNum(num);
        this.setGenre(genre);
        this.setPublishYear(y);
        this.setPages(p);
        this.setDescription(d);
    }

    public void show(boolean var){
        System.out.format("%40s", name);
        for (Author author: authors) {
            author.show(true);
        }

        System.out.println("\n Опис: " + description);
        System.out.println("Рік видання: " + publishYear);
        System.out.println("Жанр: " + genre);
    }
    public void show(){
        System.out.format("%s\t", name);
        Iterator<Author> iterator = authors.iterator();
        while (iterator.hasNext()){
            iterator.next().show();
        }
        System.out.println();
    }

    public void setAccess(Type access) { this.access = access; }
    public void setName(String name) { this.name = name; }
    public void setAuthors(ArrayList<Author> authors) { this.authors.addAll(authors); }
    public void setAuthors(Author author) { this.authors.add(author); }
    public void setDescription(String description) { this.description = description; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setPages(int pages) { this.pages = pages; }
    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }
    public void setNum(int num) { this.num = num; }

    public int getPages() { return pages; }
    public ArrayList<Author> getAuthors() { return authors; }
    public int getPublishYear() { return publishYear; }
    public String getDescription() { return description; }
    public String getGenre() { return genre; }
    public String getName() { return name; }
    public Type getAccess() { return access; }
    public int getNum() { return num; }

}
