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

        //MovieRunnerWithFilters mf = new MovieRunnerWithFilters ();
        //mf.printAverageRatings();
        //mf.printAverageRatingsByYear();
        //mf.printAverageRatingsByGenre();
        //mf.printAverageRatingsByMinutes();
        //mf.printAverageRatingsByDirectors();
        //mf.printAverageRatingsByYearAfterAndGenre();
        //mf.printAverageRatingsByDirectorsAndMinutes();

        //MovieRunnerSimilarRatings mf=new MovieRunnerSimilarRatings();
        //mf.printSimilarRatings();
        //mf.printSimilarRatingsByGenre();
        //mf.printSimilarRatingsByDirector();
        //mf.printSimilarRatingsByGenreAndMinutes();
        //mf.printSimilarRatingsByYearAfterAndMinutes();

        //FourthRatings rate = new FourthRatings();
        //System.out.println(rate.getSimilarities("15"));

        RecommendationRunner rr= new RecommendationRunner();


        System.out.println(rr.getItemsToRate());
        rr.printRecommendationsFor("314");




    }

}
