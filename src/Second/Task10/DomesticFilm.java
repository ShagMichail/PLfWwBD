package Second.Task10;

public abstract class DomesticFilm implements Film {
    private String title;
    private int releaseYear;

    @Override
    public void play() {
        System.out.println("Играет фильм: " + title);
        playInternal();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    protected abstract void playInternal();
}


