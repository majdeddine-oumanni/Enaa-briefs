public class User extends Person{
    String email;
    String password;
    String tel;
    Role role;



    public void setEmail(String email) {
        this.email = email;
    }


    public void setPassword(String password) {
        this.password = password;
    }



    public void setTel(String tel) {
        this.tel = tel;
    }


    public User(String name, int age, String email, String password, String tel, Role role) {
        super(name, age);
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.role = role;
    }


    @Override
    public String toString() {
        return
                "role= " + role.getRole() + "\n" +
                        "email= " + email + "\n" +
                        "password= " + password + "\n" +
                        "tel= " + tel + "\n" +
                        "name= " + name + "\n" +
                        "age= " + age + "\n" ;
    }
}
