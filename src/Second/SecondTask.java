package Second;

import Second.Task9.*;
import Second.Task10.*;

import java.util.ArrayList;
import java.util.List;

public class SecondTask {
    public static void main(String[] args) {

        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 9");
        System.out.println("Условие:");
        System.out.println("Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов\n");
        System.out.println("interface Мебель <- abstract class Шкаф <- class Книжный Шкаф. \n");
        System.out.println("-------------------------\n");

        FurnitureItem bookcase = new Bookcase("Acme Furniture", "Oak", 2, 5);

        System.out.println("Вывод информации о созданном книжном шкафе:");
        System.out.println("Книжный шкаф:");
        System.out.println("Производитель: " + bookcase.getName());
        System.out.println("Цвет: " + bookcase.getColor());
        System.out.println("Количество дверей: " + ((Cabinet) bookcase).getNumberOfDoors());
        System.out.println("Количество полок: " + ((Bookcase) bookcase).getNumberOfShelves());
        System.out.println("Площадь: " + ((Bookcase) bookcase).getArea() + " квадратный метров");
        System.out.println("Объем: " + ((Cabinet) bookcase).getVolume() + " кубических метров");
        System.out.println();

        FurnitureItem[] furniture = new FurnitureItem[]{
                new Bookcase("Acme Furniture", "Oak", 2, 5),
                new Bookcase("IKEA", "Birch", 1, 3),
                new Bookcase("Billy Bookcase", "White", 1, 2),
                new Bookcase("Kallax Shelving Unit", "Black", 0, 4)
        };

        System.out.println("Вывод информации об общих площади и объеме новых книжных шкафов:");
        double totalArea = 0;
        double totalVolume = 0;
        for (FurnitureItem item : furniture) {
            totalArea += item.getArea();
            if (item instanceof Cabinet) {
                totalVolume += ((Cabinet) item).getVolume();
            }
        }

        System.out.println("Общая площадь: " + totalArea + " квадратных метров");
        System.out.println("Общий объем: " + totalVolume + " кубических метров");

        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 10");
        System.out.println("Условие:");
        System.out.println("Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов\n");
        System.out.println("interface Фильм <- class Отечественный Фильм <- class Комедия. \n");
        System.out.println("-------------------------\n");

        List<Film> films = new ArrayList<>();

        films.add(createComedyFilm("Комедия ГОДА", 2020, "Романтика", "Комедия"));

        films.add(new DomesticFilm() {
            {
                setTitle("Просто Драмма");
                setReleaseYear(2019);
            }

            @Override
            protected void playInternal() {
                System.out.println("Играет фильм: " + getTitle() + ", выпущен в: " + getReleaseYear());
            }
        });

        for (Film film : films) {
            film.play();
        }
    }
    private static Comedy createComedyFilm(String title, int releaseYear, String... genres) {
        Comedy comedy = new Comedy();
        comedy.setTitle(title);
        comedy.setReleaseYear(releaseYear);
        for (String genre : genres) {
            comedy.addGenre(genre);
        }
        return comedy;
    }
}
