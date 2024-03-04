public class SecondTask {
    public static void main(String[] args) {
        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 2");
        System.out.println("Условие:");
        System.out.println("Реализовать многопоточное приложение “Робот”. \nНадо написать робота, который умеет ходить. \nЗа движение каждой его ноги отвечает отдельный поток. \nШаг выражается в выводе в консоль LEFT или RIGHT.\n");
        System.out.println("-------------------------");

        Thread leftLeg = new Thread(new RobotLeg("Left"));
        Thread rightLeg = new Thread(new RobotLeg("Right"));

        leftLeg.start();
        rightLeg.start();
    }
}
