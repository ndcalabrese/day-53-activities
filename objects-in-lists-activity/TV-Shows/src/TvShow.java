public class TvShow {
    // Declare private variables.
    private String name;
    private int numEpisodes;
    private String genre;

    // Class constructor
    public TvShow(String showName, int showEpisodes, String showGenre) {
        this.name = showName;
        this.numEpisodes = showEpisodes;
        this.genre = showGenre;
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public int getNumEpisodes() {
        return this.numEpisodes;
    }

    public String getGenre() {
        return this.genre;
    }

    @Override
    public String toString() {
        return ("The name of the show is " + this.getName()
                + " with " + this.getNumEpisodes() + " episodes. The genre is "
                + this.getGenre());
    }

}
