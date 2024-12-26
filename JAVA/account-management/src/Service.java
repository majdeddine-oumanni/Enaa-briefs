import java.util.ArrayList;
import java.util.Scanner;

public class Service {
    ArrayList<User> users = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    String role;
    void add(){
        System.out.print("enter name: ");
        String name = sc.nextLine();
        System.out.print("enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("enter phone number: ");
        String tel = sc.nextLine();
        System.out.print("enter email: ");
        String email = sc.nextLine();
        System.out.print("enter password: ");
        String password = sc.nextLine();
        System.out.print("enter role: ");
        role = sc.nextLine();
        Role userRole = new Role(role);
        users.add(new User(name,age,email,password,tel, userRole));
    }
    Role userRole = new Role(role);
    void display(){
        if (users.isEmpty()){
            System.out.println("No users were added!");
        }else {
            for (User user : users){
                System.out.println(user);
            }
        }
    }
    void search(){
        System.out.print("Enter name: ");
        String searchName = sc.nextLine();
        for (User user : users){
            if (user.getName().equalsIgnoreCase(searchName)){
                System.out.println(user);
                return;
            }
        }
        System.out.printf("%s not found", searchName);
    }
    void delete(){
        System.out.print("Enter name of the user you want to delete: ");
        String searchName = sc.nextLine();
        for (User user : users){
            if (user.getName().equalsIgnoreCase(searchName)){
                users.remove(user);
                System.out.println("user deleted succefully");
                return;
            }
        }
        System.out.printf("%s not found", searchName);
    }
    void update() {
        System.out.print("Enter name of the user you want to update: ");
        String searchName = sc.nextLine();
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(searchName)) {
                System.out.println("1. Update name" + "\n" + "2. Update age" + "3. Update email" + "\n" + "4. Update password" + "5. Update role" + "\n" + "6. Update phone number");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("enter new name: ");
                        user.setName(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("enter new age: ");
                        user.setAge(sc.nextInt());
                        break;
                    case 3:
                        System.out.print("enter new Email: ");
                        user.setEmail(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("enter new Password: ");
                        user.setPassword(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("enter new role: ");
                        userRole.setRole(sc.nextLine());
                        break;
                    case 6:
                        System.out.print("enter new Phone Number");
                        user.setTel(sc.nextLine());
                        break;
                    default:
                        System.out.println("invalid choice");
                }
            }
        }


    }
}
