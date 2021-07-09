import java.math.BigDecimal;


public class AccountController {

    public AccountController(){
    }

    public void generateAccount1() {
        Account1 account = new Account1("John Doe", 123456789, BigDecimal.valueOf(1000));
        System.out.println(account.getAccountNumber());
        System.out.println(account.getBalance());
        System.out.println(account.name);
        account.deposit(BigDecimal.valueOf(100));
        System.out.println(account.getBalance());
        account.withdraw(BigDecimal.valueOf(99), BigDecimal.valueOf(1));
        System.out.println(account.getBalance());
        account.addInterest();
        System.out.println(account.getBalance());
        System.out.println(account.toString());
    }
 /*   public void printList() {
        int listSize = account.size();

        for (int i = 0; i < listSize; i++) {
            Account1 tmpaccount = account.get(i);
            System.out.println(tmpaccount);
        }
    }

  */
}
