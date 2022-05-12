public class TvShow {
    // Declare private variables.
    private String name;
    private int numEpisodes;
    private String genre;

    // Class constructors
    public TvShow(String showName, int showEpisodes, String showGenre) {
        this.name = showName;
        this.numEpisodes = showEpisodes;
        this.genre = showGenre;
    }

    public TvShow(String showName, int showEpisodes) {
        this.name = showName;
        this.numEpisodes = showEpisodes;
    }

    public TvShow(String showName, String showGenre) {
        this.name = showName;
        this.genre = showGenre;
    }

    public TvShow(int showEpisodes, String showGenre) {
        this.numEpisodes = showEpisodes;
        this.genre = showGenre;
    }

    public TvShow(String showName) {
        this.name = showName;
    }

    public TvShow(int showEpisodes) {
        this.numEpisodes = showEpisodes;
    }

    public TvShow() { }

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

    // Setters
    public void setName(String showName) {
        this.name = showName;
    }

    public void setNumEpisodes(int showEpisodes) {
        this.numEpisodes = showEpisodes;
    }

    public void setGenre(String showGenre) {
        this.genre = showGenre;
    }


    @Override
    public String toString() {
        return ("The name of the show is " + this.getName()
                + " with " + this.getNumEpisodes() + " episodes. The genre is "
                + this.getGenre() + ".");
    }

}
