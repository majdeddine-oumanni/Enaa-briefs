import java.util.Scanner;
public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Service program = new Service();
        while (true){
            System.out.println("---Menu---");
            System.out.println("1. Add a person");
            System.out.println("2. display info");
            System.out.println("3. search for a user");
            System.out.println("4. update informations");
            System.out.println("5. delete person");
            System.out.println("0. Exit the program");
            System.out.print("enter you choice: ");


            int choice = program.sc.nextInt();
            program.sc.nextLine();
            switch (choice){
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
                    program.update();
                    break;
                case 5:
                    program.delete();
                    break;
                case 0:
                    System.out.println("Exit!");
                    return;
                default:
                    System.out.println("non valid choice!");
            }
        }
    }
}
