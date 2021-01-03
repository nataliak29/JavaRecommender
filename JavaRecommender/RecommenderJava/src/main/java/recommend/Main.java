package recommend;

public class Main {
    public static void main(String[] args) {
        FirstRatings rate = new FirstRatings();
        rate.testLoadMovies();
        rate.testLoadRaters();
        
        MovieRunnerAverage mAvg = new MovieRunnerAverage();        
        mAvg.printAverageRatings();
        mAvg.getAverageRatingOneMovie();
    }

}
