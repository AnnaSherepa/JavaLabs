import lab1.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class LibraryTest {
    private static Library library;
    private static Reader reader;
    private static Author author1, author2, author3;
    private static Librarian librarian;
    private static Book book1, book2;

    @BeforeClass
    public static void setUp(){
        library = new Library();
        reader = new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all);
        author1 = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
        author2 = new Author("Іван", "Франко", "Якович", 60, Sex.man, 1874,1916);
        author3 = new Author("Леся", "Українка","Петрівна", 47, Sex.woman, 1840, 1861);
        librarian = new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2);
        library.setLibrarians( new Librarian("Ольга", "Гончар", "Микитівна", 33, Sex.woman, "+067-063-53-11", 1956.2));
        library.setLibrarians( new Librarian("Марія", "Козак", "Назарівна", 45, Sex.woman, "+067-063-32-21", 2056.2));

        book1 = new Book("Перебендя", author1, 3, Type.teacher);
        book2 = new Book("Кобзар", author1, 1, Type.teacher);

        library.setAuthors(author1);
        library.setAuthors(author2);
        //library.setAuthors(author3);

        library.setBooks(book2);
        //library.setBooks(book1);
        library.setLibrarians(librarian);

        library.setReaders(reader);

    }
    @Test
    public void searchLibrarianByIdGetLibrarian() {
        Librarian actual = library.searchLibrarianById(0);
        Assert.assertEquals(librarian, actual);
    }

    @Test
    public void searchBookByNameGetBook() {
        Book actual = library.searchBookByName("Кобзар");
        Assert.assertEquals(book2, actual);

    }
    @Test
    public void searchBookByNameReturnNULL() {
        Book actual = library.searchBookByName("Перебендя");
        Assert.assertNull(actual);
    }

    @Test
    public void searchAuthorBySurnameGetAuthor() {
        Author actual = library.searchAuthorBySurname("Шевченко");
        Assert.assertEquals(actual, author1);
    }


    @Test
    public void searchAuthorBySurnameReturnNULL() {
        Author actual = library.searchAuthorBySurname("Українка");
        Assert.assertNull(actual);
    }

    @Test
    public void searchLibrarianByIdReturnNULL() {
        Librarian actual = library.searchLibrarianById(-1);
        Assert.assertNull(actual);
    }

    @Test
    public void searchReaderByNameGetReader() {
        Reader actual = library.searchReaderByName("Анна");
        Assert.assertEquals(reader, actual);
    }

    @Test
    public void searchReaderByNameReturnNULL() {

        Reader actual = library.searchReaderByName("Марія");
        Assert.assertNull(actual);
    }

    @Test
    public void searchReaderByIdReturnReader() {
        Reader actual = library.searchReaderById(0);
        Assert.assertEquals(reader, actual);
    }

    @Test
    public void searchReaderByIdReturnNULL() {
        Reader actual = library.searchReaderById(-1);
        Assert.assertNull(actual);
    }


    @Test
    public void showListOfBooksShow() {
        library.setBooks(book2);

        library.showListOfBooks();
    }

    @Test
    public void showListOfBooksShowNULLlist() {
        Library l = new Library();
        l.showListOfBooks();
    }

    @Test
    public void showListOfAuthorsShow() {
        library.showListOfAuthors();
    }


    @Test
    public void showListOfAuthorsShowNULL() {
        Library l = new Library();
        l.showListOfAuthors();
    }

    @Test
    public void showListOfReadersShow() {
        library.setReaders(reader);
        library.showListOfReaders();
    }


    @Test
    public void showListOfReadersShowNULLList() {
        Library l = new Library();
        l.showListOfReaders();
    }


    @Test
    public void showListOfLibrarianShow() {
        library.showListOfLibrarian();
    }


    @Test
    public void showListOfLibrarianShowNULL() {
        Library l = new Library();
        l.showListOfLibrarian();
    }

    @Test
    public void setRecordAddToLibrary() {
        library.setRecord(library.searchReaderById(0), library.searchBookByName("Кобзар"), library.searchLibrarianById(0));
    }

    @Test
    public void deleteRecordRemoveFromLibrary() {
        library.setRecord(library.searchReaderById(0), library.searchBookByName("Кобзар"), library.searchLibrarianById(0));
        Reader r = library.getReaders().get(0);
        r.show(true);
        library.deleteRecord(library.searchReaderById(0), 0);
        r.show(true);

    }

    @Test
    public void filterLibrarianTryToFind(){

        ArrayList<Librarian> expected = library.getLibrarians().stream().filter(librarian -> librarian.getAge() > 45).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Librarian> actual = library.filterLibrarian(librarian -> librarian.getAge() > 45);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void filterLibrarianIfFalse(){
        Library library = new Library();
        int actual = library.filterLibrarian(librarian -> false).size();
        Assert.assertEquals(0, actual);

    }
}