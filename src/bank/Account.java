package bank;

public class Account {
    final static int MAX_LENGTH = 12; // Número máximo de letras
    
    private String ag; // Número da Agência
    private String cc; // Número da Conta
    private String name; // Nome do Usuário
    
    private double balance;  // Balanço da Conta 

    private Log logger; // Propriedade do Log

    // construtor
    public Account(String ag, String cc, String name) {
        this.ag = ag;
        this.cc = cc;
        setName(name);
        logger = new Log(); // criação do objeto logger
    }

    public void deposit(double value) {
        balance += value;
        logger.out("Valor do Depósito R$ " + value);
        logger.out("Depósito feito com sucesso!");
        logger.out("Sua conta agora é de R$ " + balance);
    }

    public void withDraw(double value) {
        logger.out("Valor do Saque R$ " + value);
        if (value > balance) {
            logger.out("Saque não realizado. Por motivos de saldo insuficiente!");
            logger.out("Sua conta agora é de R$ " + balance);
        } else {
            balance -= value;
            logger.out("Saque efetuado com Sucesso!");
            logger.out("Sua conta agora é de R$ " + balance);
        }
    }

    // Getters => Retornar algo
    

    // Setters => Não tem retorno

    public void setName(String name) {
        if (name.length() > MAX_LENGTH) {
            System.out.println("O nome ficou muito grande, ele vai ser cortado na 12º letra!");
            this.name = name.substring(0, MAX_LENGTH); // substring corta a String entre o primeiro parâmetro e o último
        } else {
            this.name = name;
        }
    }

    @Override // É importante usar isso, pois fala que eu estou mudando algo padrão
    public String toString() {
        return "Conta Bancária\n" + "Agência: " + ag + "\n" + "Conta Corrente: " + cc + "\n" + "Nome: " + name + "\n" + "Saldo: R$ " + balance;
    }

}
