package recommend;

public class Main {
    public static void main(String[] args) {
        //FirstRatings rate = new FirstRatings();
        //rate.testLoadMovies();
        //rate.testLoadRaters();

        //MovieRunnerAverage mAvg = new MovieRunnerAverage();        
        //mAvg.printAverageRatings();
        //mAvg.getAverageRatingOneMovie();

        //ThirdRatings rate1 = new ThirdRatings();
        //System.out.println(rate1.getAverageRatings(50));

        MovieRunnerWithFilters mf = new MovieRunnerWithFilters ();
        //mf.printAverageRatings();
        //mf.printAverageRatingsByYear();
        //mf.printAverageRatingsByGenre();
        //mf.printAverageRatingsByMinutes();
        //mf.printAverageRatingsByDirectors();
        //mf.printAverageRatingsByYearAfterAndGenre();
        mf.printAverageRatingsByDirectorsAndMinutes();

    }

}
