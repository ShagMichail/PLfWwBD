package Second;

import First.CinemaChain;
import First.Park;

import java.util.ArrayList;
import java.util.List;

public class FirstTask {
    public static void main(String[] args) {
        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 9");
        System.out.println("Условие:");
        System.out.println("Создать класс Park (парк) с внутренним классом, с помощью объектов которого \nможно хранить информацию об аттракционах, времени их работы и стоимости.");
        System.out.println("-------------------------\n");

        Park.Attraction rollerCoaster = new Park.Attraction("Roller Coaster", "10:00 - 20:00", 5.0);
        Park.Attraction ferrisWheel = new Park.Attraction("Ferris Wheel", "11:00 - 21:00", 4.0);
        Park.Attraction carousel = new Park.Attraction("Carousel", "11:00 - 19:00", 3.0);

        Park.Attraction[] attractions = {rollerCoaster, ferrisWheel, carousel};
        Park park = new Park(attractions);

        System.out.println("Вывод доступных атракционов в парке:");
        for (int i = 0; i < park.getAttractionCount(); i++) {
            Park.Attraction attraction = park.getAttraction(i);
            System.out.println("Атракцион: " + attraction.getName());
            System.out.println("Время работы: " + attraction.getOperatingHours());
            System.out.println("Стоимость: " + attraction.getCost());
            System.out.println();
        }

        System.out.println("-------------------------");
        System.out.println("Вариант 1, задача 10");
        System.out.println("Условие:");
        System.out.println("Создать класс Cinema (кино) с внутренним классом, с помощью объектов которого \nможно хранить информацию об адресах кинотеатров, фильмах и времени сеансов.");
        System.out.println("-------------------------\n");


        CinemaChain.Movie movie1 = new CinemaChain.Movie("Особо опасен", "120 минут");
        CinemaChain.Movie movie2 = new CinemaChain.Movie("Форсаж 150", "90 минут");

        CinemaChain.Showtime showtime1 = new CinemaChain.Showtime(movie1, "14:30");
        CinemaChain.Showtime showtime2 = new CinemaChain.Showtime(movie2, "16:45");
        CinemaChain.Showtime showtime3 = new CinemaChain.Showtime(movie1, "18:15");

        List<CinemaChain.Showtime> showtimes1 = new ArrayList<>();
        showtimes1.add(showtime1);
        showtimes1.add(showtime2);
        showtimes1.add(showtime3);

        CinemaChain.CinemaInfo cinemaInfo1 = new CinemaChain.CinemaInfo("Москва, Академика Бакулева, 10", showtimes1);

        CinemaChain.Showtime showtime11 = new CinemaChain.Showtime(movie1, "09:30");
        CinemaChain.Showtime showtime22 = new CinemaChain.Showtime(movie2, "11:45");
        CinemaChain.Showtime showtime33 = new CinemaChain.Showtime(movie1, "13:15");

        List<CinemaChain.Showtime> showtimes2 = new ArrayList<>();
        showtimes2.add(showtime11);
        showtimes2.add(showtime22);
        showtimes2.add(showtime33);

        CinemaChain.CinemaInfo cinemaInfo2 = new CinemaChain.CinemaInfo("Москва, Академика Бакулева, 20", showtimes2);

        CinemaChain cinemaChain = new CinemaChain(new CinemaChain.CinemaInfo[]{cinemaInfo1, cinemaInfo2});
        System.out.println("Вывод доступных кинотеатров в сети и доступные в них сеансы с фильмами:");
        for (int i = 0; i < cinemaChain.getCinemaCount(); i++) {
            CinemaChain.CinemaInfo cinema = cinemaChain.getCinema(i);
            System.out.println("Кинотеатр по адресу " + cinema.getAddress());
            System.out.println("Доступные фильмы:");
            for (CinemaChain.Movie movie : cinema.getMovies()) {
                System.out.println("- " + movie.getTitle() + " (" + movie.getRuntime() + ")");
            }
            System.out.println("Доступные сеанты:");
            for (CinemaChain.Showtime showtime : cinema.getShowtimes()) {
                System.out.println("- " + showtime.getTime() + ": " + showtime.getMovie().getTitle());
            }
            System.out.println();


        }
    }
}
