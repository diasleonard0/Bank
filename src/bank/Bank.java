package bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    
    private String ag;
    private List<Account> accounts;

    private int lastAccount = 1;

    public Bank(String ag) {
        this.ag = ag;
        this.accounts = new ArrayList<>();
    }

    public void insertAccount(Account account) {
        accounts.add(account);
    }

    public Account generateAccount(String name) { // vai gerar uma conta, por isso o retorno de Account
        Account account = new Account(ag, "000" + lastAccount, name); // esse ag é aquele ag que ele mandou quando criou o banco
        lastAccount++;
        return account;
    }

    public void outputTotal() {
        double total = 0;
        for(Account account : accounts) {
            total += account.getBalance();
        }

        System.out.println("Banco possui: R$ " + total);
    }

    // Getters

    public List<Account> getAccounts() {
        return accounts;
    }
}
