package lab4;
import lab1.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class Main {
    public static void main(String [] a)  {

        Library library = new Library();

        //додаю новвих Бібліотекарів
        library.setLibrarians( new Librarian("Олена", "Іванова", "Петрівна", 50, Sex.woman, "+067-063-53-11", 1346.2));
        library.setLibrarians( new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 1756.2));
        library.setLibrarians( new Librarian("Ольга", "Гончар", "Микитівна", 33, Sex.woman, "+067-063-53-11", 1956.2));
        library.setLibrarians( new Librarian("Марія", "Козак", "Назарівна", 45, Sex.woman, "+067-063-32-21", 2056.2));


        library.getLibrarians()
                .forEach(librarian -> {
                    librarian.show(true);
                    System.out.println();
                });
        System.out.println("\n\nВикористання методу filterLibrarian. Фільтрую по статті");
        library.filterLibrarian(librarian -> librarian.getSex() == Sex.man)
                .forEach(librarian -> {
                    librarian.show(true);
                    System.out.println();
                });
        System.out.println("\n\nВикористання методу filterLibrarian. Фільтрую по віку");
        library.filterLibrarian(librarian -> librarian.getAge() > 45)
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

    }

}
