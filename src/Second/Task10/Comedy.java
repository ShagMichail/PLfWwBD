package Second.Task10;

import java.util.ArrayList;
import java.util.List;

public class Comedy extends DomesticFilm {
    private List<String> genres;

    public Comedy() {
        this.genres = new ArrayList<>();
    }

    @Override
    protected void playInternal() {
        System.out.println("Играет фильм: " + getTitle() + ", выпущенный в: " + getReleaseYear());
        System.out.println("Жанр: " + genres);
    }

    public void addGenre(String genre) {
        genres.add(genre);
    }
}
