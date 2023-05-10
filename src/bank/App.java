package bank;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bank santander = new Bank("0001");

        while(true) {
            System.out.print("O que deseja fazer? [C = Criar Conta | E = Sair]: ");
            String op = scanner.nextLine().toUpperCase();

            if (op.equals("C")) {
                System.out.print("Digite o seu nome: ");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                santander.insertAccount(account);
                System.out.println(account);
                operateAccount(account); // Aqui a gente chama a conta que a gente acabou de criar
            } else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando Inválido");
            }
        }
        
        List<Account> accountList = santander.getAccounts(); // Loop para imprimit todas as contas
        for (Account cc : accountList) {
            System.out.println("");
            System.out.println(cc);
            System.out.println("");
        }

        santander.outputTotal();
    }

    static void operateAccount(Account account) { // Foi feito isso para que fique mais fácil chamar essa função na hora que for criada a conta. Não só isso quando você sair dessa função de adm a sua conta, você volta para a criação de conta
    // Uma função pode chamar outra função static, pois são da mesma class
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("O que deseja fazer? [D=Deposito | S=Saque | E=Sair da Conta]: ");
            String op = scanner.nextLine().toUpperCase();

            if (op.equals("D")) {
                System.out.print("Qual valor deseja depositar? R$");
                double value = scanner.nextDouble();
                account.deposit(value);
                continue;
            } else if (op.equals("S")) {
                System.out.print("Qual valor deseja sacar? R$");
                double value = scanner.nextDouble();
                account.withDraw(value);
                continue;
            } else if (op.equals("E")) {
                System.out.println("Encerrando programa...");
                break;
            } else {
                System.out.println("Comando Inválido");
            }

            scanner = new Scanner(System.in); // Isso era para evitar que o "Comando Inválido" bug e apareça sempre no terminal, mas não foi possível, então tenho que resolver isso
        }
    }
}
