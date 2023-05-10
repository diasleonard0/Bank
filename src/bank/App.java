package bank;

public class App {
    public static void main(String[] args) {
        // criar uma conta de usuário (agência, conta, nome)
        Account account = new Account("0001", "123", "Roger Guedes");


        // sacar/depositar valores
        account.withDraw(500);
        
        // Esse ! antes de qualquer condição nega o valor booleano ou seja se a condição for false ele executa o if
        
        account.deposit(100);
        account.deposit(200);
        account.deposit(300);

        account.withDraw(50);
        account.withDraw(500);
        account.withDraw(100);

        System.out.println(account);
        
    }
}
