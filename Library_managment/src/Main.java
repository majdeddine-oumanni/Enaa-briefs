public class Main {

    public static void main(String[] args) {

        Library library = new Library();

        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. update Book");
            System.out.println("6. check if Book is available");
            System.out.println("7. check if Book is borrowed");
            System.out.println("8. show available books and borrowed books");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = library.sc.nextInt();
            library.sc.nextLine();

            switch (choice) {
                case 1:
                    library.add();
                    break;
                case 2:
                    library.display();
                    break;
                case 3:
                    library.search();
                    break;
                case 4:
                    library.delete();
                    break;
                case 5:
                    library.update();
                    break;
                case 6:
                    library.borrowBook();
                    break;
                case 7:
                    library.returnBook();
                    break;
                case 8:
                    library.showBooksAvailability();
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