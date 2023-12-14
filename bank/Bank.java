package bank;

class Account{
    public String name;
    protected String email;
     public String password;

     public String getpassword() {
         return  this.password;
     }
    public void setpassword(String pass) {
         this.password = pass;
     }
}
public class Bank {

    public static void main(String[] args) {
        Account account1 = new Account();
        account1.name = "apna colleges";
        account1.email = "apna@gmail.com";
        account1.setpassword("abcdef");
        System.out.println(account1.getpassword());
    }
    
}
