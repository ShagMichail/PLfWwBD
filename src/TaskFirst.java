import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskFirst {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 1");
        System.out.println("Условие:");
        System.out.println("Реализовать многопоточное приложение “Банк”. \nИмеется банковский счет. \nСделать синхронным пополнение и снятие денежных средств на счет/со счет случайной суммой. \nПри каждой операции (пополнения или снятие) вывести текущий баланс счета. \nВ том случае, если денежных средств недостаточно – вывести сообщение.");
        System.out.println("-------------------------");

        BankAccount account = new BankAccount();
//        Executors.newFixedThreadPool(10); - это статический метод класса Executors,
//        который создает новый экземпляр ExecutorService с фиксированным количеством потоков.
//        В данном случае, количество потоков равно 10.

        ExecutorService executor = Executors.newFixedThreadPool(10);

//        Затем создаются 20 задач (по 10 задач для депозита и 10 задач для снятия),
//        каждая из которых выводит на консоль случайную сумму.

        for (int i = 0; i < 20; i++) {
            final int randomAmount = new Random().nextInt(50) + 1;
            Runnable depositTask = () -> account.deposit(randomAmount);
            Runnable withdrawTask = () -> account.withdraw(randomAmount);

            if (Math.random() > 0.5) {
                executor.execute(depositTask);
            } else {
                executor.execute(withdrawTask);
            }
        }

//        Задачи добавляются в очередь ExecutorService с помощью метода execute().
//        После добавления всех задач в очередь вызывается метод shutdown(),
//        который указывает ExecutorService на необходимость завершить свою работу после выполнения всех задач в очереди.
        executor.shutdown();
    }
}
