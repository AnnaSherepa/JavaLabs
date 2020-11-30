package lab1;


public class Main {
        public static void main(String args[]) {
            //створюю пустий об'єкт класу Бібліотека
            Type all = Type.another;
            all.show();
            System.out.println(all);

            Library library = new Library();

            //додаю новвих Бібліотекарів
            library.setLibrarians( new Librarian("Олександр", "Мельник", "Іванович", 46, Sex.man, "+067-063-32-21", 456.2));
            library.setLibrarians( new Librarian("Олена", "Іванова", "Петрівна", 40, Sex.woman, "+067-063-53-11", 456.2));


            System.out.println("Перезавантажу метод equals() для класу Author");
            Author author1 = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
            Author author2 = new Author("Тарас", "Шевченко","Григорович", 47, Sex.man, 1840, 1861);
            System.out.println("Автор 1: ");
            author1.show(true);
            System.out.println("\n\nАвтор 2: ");
            author2.show(true);
            if(author1.equals(author2)){
                System.out.println("Метод equals() перевантажено для цього класу");
            }else{
                System.out.println("Ці об'єкти різні");
            }

            //додаю Авторів, Книги яких зберігаються в Бібліотеці
            library.setAuthors(author1);
            //в бібліотеці я встановила обмеження на додавання однакових об'єктів
            //використовую для порівняння перевантажений метод equals
            //звідси слідує, що я не зможу двічі додати author1 у масив.
            System.out.println("\n\n Намагаюся повторно додати author1\n");
            library.setAuthors(author1);
            System.out.println("\n\n");
            library.setAuthors(new Author("Іван", "Франко", "Якович", 60, Sex.man, 1874,1916));

            //для підтвердження виведу список усіх доданих авторів
            System.out.println("Виведу список усіх доданих в бібліотеку авторів");
            for (Author a: library.getAuthors()) {
                a.show();
            }

            //виконаю усі попередні дії з об'єктом Книги. При цьому метод equals я не перезавантажую і відповідно не використовую блок try{}catch для пошуку однакових значень
            //додаю Книги, вказуючи їх назву і Автора. Також важливий параметр - тип доступу
            //Він буде використовуватися для ідентифікації доступності даної Книги
            //Окрім того, вказуємо кількість примірників
            Book book1 = new Book("Кобзар", library.searchAuthorBySurname("Шевченко"), 3, Type.teacher);
            Book book2 = new Book("Кобзар", library.searchAuthorBySurname("Шевченко"), 3, Type.teacher);

            System.out.println("\n\nПорівняю два об'єкта Book з однаковими полями, не перевантажуючи метод equals(): ");
            System.out.println("Книга 1: ");
            book1.show(true);
            System.out.println("\n\nКнига 2: ");
            book2.show(true);
            if(book1.equals(book2)){
                System.out.println("Ці книги однакові");
            }else{
                System.out.println("Це різні книги!");
            }

            library.setBooks(book1);
            library.setBooks(new Book("Перебендя", library.searchAuthorBySurname("Шевченко"), 3, Type.teacher));
            library.setBooks(new Book("Рокові перехрестя",library.searchAuthorBySurname("Франко") , 1, Type.teacher));
            library.setBooks(new Book("Каменярі",library.searchAuthorBySurname("Франко") , 2, Type.all));

            //додаю Читачів до Бібліотеки, обов'язково вказавши тип доступу
            library.setReaders(new Reader("Анна", "Шерепа", "Валеріївна", 19, Sex.woman, Type.all));

            //Симулююємо ситуацію запису книги.
            //Шукаємо відповідного читача по ІД(у кожного буде унікальний). Шкаємо об'єкт Книги серед списку по назві.
            //Також в Запис зберігаємо Бібліотераря, який здійсний запис.
            //При створенні Запису орієнтуємося на типи доступу
            library.setRecord(library.searchReaderById(0), library.searchBookByName("Кобзар"), library.searchLibrarianById(0));
            library.setRecord(library.searchReaderById(0), library.searchBookByName("Каменярі"), library.searchLibrarianById(0));

            //На даному прикладі демонструю, що Запис буде відхилений, оскільки для отримання даного примірника необхідно мати тип доступу teacher
            library.setRecord(library.searchReaderById(0), library.searchBookByName("Рокові перехрестя"), library.searchLibrarianById(0));//access will be denied

            //Викликаємо метод для перегляду детальної інформації про Читача і, відповідно, всі його Записи
            library.searchReaderById(0).show(true);

            //Демонструю можливість видалення Запису, орієнтуючись по його номеру в списку.(При виведенні - нумерація розпочинається з 1, проте у масиві - з 0)

            library.deleteRecord(library.searchReaderById(0), 0);
            library.searchReaderById(0).show(true);

            //Демонструю обмеження Запису, враховуючи кількість примірників в бібліотеці
            library.setRecord(library.searchReaderById(0), library.searchBookByName("Каменярі"), library.searchLibrarianById(0));
            library.setRecord(library.searchReaderById(0), library.searchBookByName("Каменярі"), library.searchLibrarianById(0));
            library.searchReaderById(0).show(true);

            //Можливість видалення запису може бути також здійснення по назві книги.
            library.deleteRecord(library.searchReaderById(0), 10);
            library.searchReaderById(0).show(true);

            //Оскільки Запис - це nested клас, то всі операції, пов'язані з ним, повині бути здійсненні через відповідного Читача
        }

}
