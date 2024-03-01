package First;

import java.util.ArrayList;
import java.util.List;

public class CinemaChain {
    public static class CinemaInfo {
        private String address;
        private List<Movie> movies = new ArrayList<>();
        private List<Showtime> showtimes;

        public CinemaInfo(String address, List<Showtime> showtimes) {
            this.address = address;
            this.showtimes = showtimes;
            for (Showtime showtime : showtimes) {
                this.movies.add(showtime.getMovie());
            }
        }
        public String getAddress() {
            return address;
        }
        public List<Movie> getMovies() {
            return movies;
        }

        public List<Showtime> getShowtimes() {
            return showtimes;
        }
    }

    public static class Movie {
        private String title;
        private String runtime;

        public Movie(String title, String runtime) {
            this.title = title;
            this.runtime = runtime;
        }

        public String getTitle() {
            return title;
        }
        public String getRuntime() {
            return runtime;
        }
    }

    public static class Showtime {
        private Movie movie;
        private String time;

        public Showtime(Movie movie, String time) {
            this.movie = movie;
            this.time = time;
        }
        public String getTime() {
            return time;
        }
        public Movie getMovie() {
            return movie;
        }
    }

    private CinemaInfo[] cinema;

    public CinemaChain(CinemaInfo[] cinema) {
        this.cinema = cinema;
    }

    public int getCinemaCount() {
        return cinema.length;
    }

    public CinemaInfo getCinema(int index) {
        return cinema[index];
    }
}