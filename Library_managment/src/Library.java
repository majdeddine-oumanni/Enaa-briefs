import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    ArrayList<Book> books = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void add(){
        System.out.print("enter title of the book: ");
        String title = sc.nextLine();
        System.out.print("enter name of the author: ");
        String authorName = sc.nextLine();
        System.out.print("enter the isbn: ");
        String  isbn = sc.nextLine();
        System.out.print("enter the availability (true/false): ");
        boolean isAvailable = sc.nextBoolean();
        books.add(new Book(title, authorName, isbn, isAvailable));
        System.out.println("book added succefuly!");
    }
    public void display(){
        for (Book book : books) {
            System.out.println(book);
        }
    }
    public void search() {
        ArrayList<Book> foundedBook = new ArrayList<>();
        System.out.print("Enter the ISBN, title, or author name of the book: ");
        String research = sc.nextLine();

        books.forEach(book -> {
            if (book.getIsbn().equalsIgnoreCase(research) || book.getTitle().equalsIgnoreCase(research) || book.getAuthorName().equalsIgnoreCase(research)) {
                foundedBook.add(book);
            }
        });
        for (Book myBook : foundedBook) {
            System.out.println(myBook);
        }
        if (foundedBook.isEmpty()) {
            System.out.println("Book with details '" + research + "' not found!");
        }
    }
    public void delete(){
        ArrayList<Book> foundedBook = new ArrayList<>();
        System.out.print("Enter the ISBN of the book you want to delete: ");
        String research = sc.nextLine();

        books.forEach((Book book) -> {
            if (book.getIsbn().equalsIgnoreCase(research)) {
                foundedBook.add(book);
            }
        });
        if (!foundedBook.isEmpty()) {
            books.removeAll(foundedBook);
            System.out.println("book removed successfuly.");
        }else {
            System.out.println("Book with details '" + research + "' not found!");
        }
    }
    public void update(){
        System.out.print("Enter the ISBN of the book: ");
        String research = sc.nextLine();
        boolean found = false;
        for (Book book : books){
            if (book.getIsbn().equalsIgnoreCase(research)) {
                found = true;
                System.out.println("1: Update Title\n2: Update Author\n3: Update Availability");
                System.out.print("Enter your choice: ");
                int updateChoice = sc.nextInt();
                sc.nextLine();

                switch (updateChoice) {
                    case 1:
                        System.out.print("Enter new title: ");
                        String newTitle = sc.nextLine();
                        book.setTitle(newTitle);
                        break;
                    case 2:
                        System.out.print("Enter new author: ");
                        String newAuthorName = sc.nextLine();
                        book.setAuthorName(newAuthorName);
                        break;
                    case 3:
                        System.out.print("Is the book available? (true/false): ");
                        boolean isAvailable = sc.nextBoolean();
                        book.setAvailable(isAvailable);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        return;
                }
            }
        };


        if (!found) {
            System.out.println("Book with details '" + research + "' not found!");
        }

    }
    public void borrowBook() {
        System.out.print("Enter the ISBN of the book you want to borrow: ");
        String isbnSearch = sc.nextLine();
        boolean bookFound = false;

        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbnSearch)) {
                bookFound = true;
                if (book.isAvailable) {
                    System.out.println("The book is available and can be borrowed.");
                    book.setAvailable(false);
                } else {
                    System.out.println("The book exists but is currently not available.");
                }
                return;
            }
        }

        if (!bookFound){
            System.out.println("Book with ISBN " + isbnSearch + " not found.");
        }
    }
    public void returnBook() {
        System.out.print("Enter the ISBN of the book you want to return: ");
        String isbnSearch = sc.nextLine();
        boolean bookFound = false;

        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbnSearch)) {
                bookFound = true;
                if (!book.isAvailable) {
                    System.out.println("The book was borrowed now it's available.");
                    book.setAvailable(true);
                } else {
                    System.out.println("The book exists but is currently not available.");
                }
                return;
            }
        }

        if (!bookFound){
            System.out.println("Book with ISBN " + isbnSearch + " not found.");
        }
    }

    public void showBooksAvailability(){
        System.out.println("---available books---");
        int availableBooks = 0, unavailableBooks = 0;
        for (Book book : books) {
            if(book.isAvailable){
                System.out.println(book);
                availableBooks ++;
            }
        }
        if (availableBooks == 0){
            System.out.println("there is no available books");
        }

        System.out.println("---borrowed books---");
        for (Book book : books) {
            if (!book.isAvailable){
                System.out.println(book);
                unavailableBooks ++;
            }
        }
        if (unavailableBooks == 0){
            System.out.println("there is no borrowed books");
        }
    }
}
