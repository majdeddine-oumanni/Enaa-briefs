import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
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
        books.forEach((Book book) -> {
            System.out.println("\n books title: " + book.title);
            System.out.println("author name: " + book.authorName);
            System.out.println("the ISBN: " + book.isbn);
            System.out.println("availability: " + book.isAvailable + "\n");
        });
    }
    public void search() {
        ArrayList<Book> foundedBook = new ArrayList<>();
        System.out.print("Enter the ISBN, title, or author name of the book: ");
        String research = sc.nextLine();

        books.forEach(book -> {
            if (book.isbn.equalsIgnoreCase(research) || book.title.equalsIgnoreCase(research) || book.authorName.equalsIgnoreCase(research)) {
                foundedBook.add(book);
            }
        });
        foundedBook.forEach((myBook) ->{
            System.out.println("\nBook " + myBook.title);
            System.out.println("Author name: " + myBook.authorName);
            System.out.println("The ISBN: " + myBook.isbn);
            System.out.println("Availability: " + myBook.isAvailable + "\n");
        });
        if (foundedBook.isEmpty()) {
            System.out.println("Book with details '" + research + "' not found!");
        }
    }
    public void delete(){
        ArrayList<Book> foundedBook = new ArrayList<>();
        System.out.print("Enter the ISBN of the book you want to delete: ");
        String research = sc.nextLine();

        books.forEach((Book book) -> {
            if (book.isbn.equalsIgnoreCase(research)) {
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
            if (book.isbn.equalsIgnoreCase(research)) {
                found = true;
                System.out.println("1: Update Title\n2: Update Author\n3: Update Availability");
                System.out.print("Enter your choice: ");
                int updateChoice = sc.nextInt();
                sc.nextLine();

                switch (updateChoice) {
                    case 1:
                        System.out.print("Enter new title: ");
                        String newTitle = sc.nextLine();
                        book.title = newTitle;
                        break;
                    case 2:
                        System.out.print("Enter new author: ");
                        String newAuthorName = sc.nextLine();
                        book.authorName = newAuthorName;
                        break;
                    case 3:
                        System.out.print("Is the book available? (true/false): ");
                        boolean isAvailable = sc.nextBoolean();
                        book.isAvailable = isAvailable;
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
    public static void main(String[] args) {
        Main program = new Main(); // Create an instance of Main
        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = program.sc.nextInt();
            program.sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    program.add();
                    break;
                case 2:
                    program.display();
                    break;
                case 3:
                    program.search();
                    break;
                case 4:
                    program.delete();
                    break;
                case 5:
                    program.update();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
