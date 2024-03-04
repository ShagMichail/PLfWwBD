import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BankAccount {
    private int id;
    private double balance;
    private final Random random;

    public BankAccount() {
        this.id = 101;
        this.balance = 0;
        this.random = new Random();
    }

//    synchronized - необходим для захвата мьютекса, чтобы задача выполнелась потоком, и только потом
//    продолжелось выполнения другими потоками
    public synchronized void deposit(int amount) {
        this.balance += amount;
        System.out.printf("Вклад: %d, Баланс: %.2f, Номер счета: %d\n", amount, this.balance, this.id);
    }

    public synchronized void withdraw(int amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.printf("Снятие: %d, Баланс: %.2f, Номер счета: %d\n", amount, this.balance, this.id);
        } else {
            System.out.printf("Недостаточный баланс, невозможно вывести: %d, Баланс: %.2f, Номер счета: %d\n", amount, this.balance, this.id);
        }
    }
}