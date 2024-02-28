package Fourth;
import Fourth.Task10.*;
import Fourth.Task9.*;

import java.util.ArrayList;
import java.util.List;

public class FourthTask {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 4, задача 9");
        System.out.println("Условие:");
        System.out.println("Построить модель программной системы.\n");
        System.out.println("Система Интернет-магазин.\n Администратор добавляет информацию о Товаре.\n Клиент делает и оплачивает Заказ на Товары.\n Администратор регистрирует Продажу и может занести неплательщиков в «черный список».\n");
        System.out.println("-------------------------\n");


        // Создаем несколько продуктов
        Product product1 = new Product(234,"Каша", "Хороший продукт", 100.0);
        Product product2 = new Product(453,"Торт", "Вкусный шоколадный",200.0);
        Product product3 = new Product(654,"Яблоко", "Наливные красные",300.0);

        // Создаем магазин
        Shop shop = new Shop();

        //Создаем администратора
        Admin admin = new Admin("Admin","admin", shop);

        // Админ добавляет продукты в магазин
        admin.addProduct(product1);
        admin.addProduct(product2);
        admin.addProduct(product3);

        // Создаем клиента
        Customer client = new Customer(1,"Иван Иванов", "ivan.ivanov@example.com", "password123");

        // Клиент оформляет заказ заказ
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        double totalPrice = product1.getPrice() + product2.getPrice();
        client.placeOrder(shop, products, totalPrice);

        // Обрабатываем заказ
        admin.processOrder(0);
        // Отправляем заказ
        admin.shipOrder(0);
        // Доставляем заказ
        admin.deliverOrder(0);
        // Получаем список заказов клиента
        List<Order> orders = client.getOrders();

        // Выводим информацию о заказах на консоль
        for (Order order : orders) {
            System.out.println("Заказ #" + order.getId());
            System.out.println("Статус заказа: " + order.getStatus());
            System.out.println("Продукты в заказе:");
            for (Product product : order.getProducts()) {
                System.out.println("- " + product.getName() + " (" + product.getPrice() + ")");
            }
            System.out.println("Общая стоимость заказа: " + order.getTotalPrice());
            System.out.println();
        }

        // Админ добавляет клиента в черный список магазина
        admin.addEmailCustomer("ivan.ivanov@example.com");

        // Создаем заказ для занесенного в черный список клиента
        double totalPriceSecond = products.get(0).getPrice() + products.get(1).getPrice();

        // Оформляем заказ занесенного в черный список клиента
        try {
            client.placeOrder(shop, products, totalPrice);
        } catch (RuntimeException e) {
            System.err.println("Ошибка оформления заказа: " + e.getMessage());
        }

        System.out.println("-------------------------");
        System.out.println("Вариант 4, задача 10");
        System.out.println("Условие:");
        System.out.println("Построить модель программной системы.\n");
        System.out.println("Система Железнодорожная касса.\n Пассажир делает Заявку на станцию назначения, время и дату поездки.\n Система регистрирует Заявку и осуществляет поиск подходящего Поезда.\n Пассажир делает выбор Поезда и получает Счет на оплату.\n Администратор вводит номера Поездов, промежуточные и конечные станции, цены.\n");
        System.out.println("-------------------------\n");

        TrainManager trainManager = new TrainManager();

        Station station1 = new Station("Москва_1", "12:00", "24/2/2024");
        Station station2 = new Station("Москва_2", "14:00", "24/2/2024");
        Station station3 = new Station("Москва_3", "16:00", "24/2/2024");

        Station[] routes1 = { station1, station2, station3 };

        Train train = new Train(345, station1, List.of(routes1), 444);

        trainManager.addTrains(train);

        Passenger passenger = new Passenger("Иван Иванов", "ivan.ivanov@example.com", "password123", trainManager);
        System.out.println("Найдем доступные поезда по запросу: 24/2/2024, 11:30, Москва_1");
        passenger.findTrains("25/2/2024", "11:30", "Москва_1");
        passenger.selectionTrain(345);
    }
}