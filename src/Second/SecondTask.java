package Second;

public class SecondTask {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 2, задача 9");
        System.out.println("Условие:");
        System.out.println("Создать классы, спецификации которых приведены ниже.\n Определить конструкторы и методы setТип(), getТип(), toString().\n Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. \n");
        System.out.println("Product: id, Наименование, UPC, Производитель, Цена, Срок хранения, Количество.\n Создать массив объектов.\n Вывести:\n a) список товаров для заданного наименования;\n b) список товаров для заданного наименования, цена которых не превосходит заданную;\n c) список товаров, срок хранения которых больше заданного. \n");
        System.out.println("-------------------------\n");

        Product[] products = new Product[5];
        products[0] = new Product(1, "Гречка", "123456789012", "Родная", 10.99, 30, 100);
        products[1] = new Product(2, "Рис", "234567890123", "Заморский", 15.99, 60, 50);
        products[2] = new Product(3, "Молоко", "345678901234", "Домик в деревне", 7.99, 20, 200);
        products[3] = new Product(4, "Молоко", "456789012345", "Столичный", 20.99, 10, 30);
        products[4] = new Product(5, "Хлеб", "567890123456", "Свой", 5.99, 3, 500);

        System.out.println("Выведем список товаров для заданного наименования Молоко:");
        for (Product product : products) {
            if (product.getName().equals("Молоко")) {
                System.out.println(product);
            }
        }

        System.out.println("Выведем список товаров для заданного наименования Молоко, цена которых не превосходит заданную 15:");
        for (Product product : products) {
            if (product.getName().equals("Молоко") && product.getPrice() < 15) {
                System.out.println(product);
            }
        }
        System.out.println("Выведем список товаров, срок хранения которых больше заданного 50:");
        for (Product product : products) {
            if (product.getShelfLife() > 50) {
                System.out.println(product);
            }
        }

        System.out.println("-------------------------");
        System.out.println("Вариант 2, задача 10");
        System.out.println("Условие:");
        System.out.println("Создать классы, спецификации которых приведены ниже.\n Определить конструкторы и методы setТип(), getТип(), toString().\n Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль. \n");
        System.out.println("Train: Пункт назначения, Номер поезда, Время отправления, Число мест (общих, купе, плацкарт, люкс).\n Создать массив объектов.\n Вывести:\n a) список поездов, следующих до заданного пункта назначения;\n b) список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа;\n c) список поездов, отправляющихся до заданного пункта назначения и имеющих общие места.\n");
        System.out.println("-------------------------\n");

        Train[] trains = new Train[5];
        trains[0] = new Train("Москва", 23, "14:30", 1000, 500, 300, 200);
        trains[1] = new Train("Санкт-Петербург", 54, "15:30", 1300, 1200, 70, 30);
        trains[2] = new Train("Нижний Новгород", 95, "16:30", 900, 600, 200, 100);
        trains[3] = new Train("Владивосток", 87, "17:30", 800, 400, 200, 200);
        trains[4] = new Train("Сахалин", 1, "19:30", 12, 0, 0, 12);

        System.out.println("Выведем список поездов, следующих до заданного пункта назначения:");
        for (Train train : trains) {
            if (train.getDestination().equals("Владивосток")) {
                System.out.println(train);
            }
        }

        System.out.println("Выведем список поездов, следующих до заданного пункта назначения и отправляющихся после заданного часа:");
        for (Train train : trains) {
            String input = train.getDepartureTime();
            String[] lines = input.split(":");
            if (train.getDestination().equals("Владивосток") && Integer.parseInt(lines[0]) > 15) {
                System.out.println(train);
            }
        }
        System.out.println("Выведем список поездов, отправляющихся до заданного пункта назначения и имеющих общие места:");
        for (Train train : trains) {
            if (train.getDestination().equals("Сахалин") && train.getTotalSeats() > 0) {
                System.out.println(train);
            }
        }
    }
}