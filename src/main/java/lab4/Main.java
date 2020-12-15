package lab4;
import lab1.*;

import java.util.*;
import java.util.function.Predicate;


public class Main {
    public static void main(String [] a)  {

        Library library = new Library();

        //додаю новвих Бібліотекарів
        library.setLibrarians( new Librarian("Олена", "Іванова", "Петрівна", 50, Sex.woman, "+067-063-53-11", 1346.2));
        library.setLibrarians( new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 1756.2));
        library.setLibrarians( new Librarian("Ольга", "Гончар", "Микитівна", 33, Sex.woman, "+067-063-53-11", 1956.2));
        library.setLibrarians( new Librarian("Марія", "Козак", "Назарівна", 45, Sex.woman, "+067-063-32-21", 2056.2));

        library.setAuthors(new Author("Іван", "Франко", "Якович", 60, Sex.man, 1874,1916));
        library.setAuthors(new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861));
        library.setAuthors(new Author("Панас", "Мирний","Якович", 70, Sex.man, 1849, 1920));
        library.setAuthors(new Author("Іван", "Білик","Якович", 60, Sex.man, 1845, 1905));

        ArrayList<Author> authors_book = new ArrayList<>();
        authors_book.add(library.searchAuthorBySurname("Мирний"));
        authors_book.add(library.searchAuthorBySurname("Білик"));

        library.setBooks(new Book("Хіба ревуть воли як ясла повні?", authors_book, 3, Type.teacher));
        library.setBooks(new Book("Рокові перехрестя",library.searchAuthorBySurname("Франко") , 1, Type.teacher));
        library.setBooks(new Book("Каменярі",library.searchAuthorBySurname("Франко") , 2, Type.all));

        library.getBooks()
                .forEach(
                        book -> {
                            book.show(true);
                            System.out.println();
                        }
                );

        library.getLibrarians()
                .forEach(librarian -> {
                    librarian.show(true);
                    System.out.println();
                });

        System.out.println("\n\nВикористання методу filterLibrarian. Фільтрую по віку та статті");

        Map<Boolean, ArrayList<Librarian>> filter_value = library.filterLibrarian(librarian -> librarian.getAge() > 45 && librarian.getSex() == Sex.man);
        System.out.println("Бібліотекарі, які задовільняють вказані умови:");
        filter_value.get(Boolean.TRUE)
                .forEach(librarian -> {
                    librarian.show(true);
                    System.out.println();
                });
        System.out.println("Бібліотекарі, які НЕ задовільняють вказані умови:");
        filter_value.get(Boolean.FALSE)
                .forEach(librarian -> {
                    librarian.show(true);
                    System.out.println();
                });


        System.out.println("Сумарна заробітня плата бібліотекарів: " +
                library.getLibrarians()
                        .stream()
                        .mapToDouble(l -> l.getSalary())
                        .reduce((x, y)-> x+y)
                        .getAsDouble()
        );
        System.out.println("Максимальне значення заробітньої плати бібліотекарів: " +
                library.getLibrarians()
                        .stream()
                        .mapToDouble(l -> l.getSalary())
                        .max()
                        .getAsDouble()
        );
        System.out.println("Середнє значення заробітньої плати бібліотекарів: " +
                library.getLibrarians()
                        .stream()
                        .mapToDouble(l -> l.getSalary())
                        .average()
                        .getAsDouble()
        );


        //System.out.println("Доступ до списку авторів для кожної книги");
       if (library.mostPopularAuthor() != null){
           library.mostPopularAuthor().show(true);
       }

    }

}
