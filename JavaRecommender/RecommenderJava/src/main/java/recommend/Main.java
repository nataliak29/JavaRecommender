package recommend;

public class Main {
    public static void main(String[] args) {
        FirstRatings rate = new FirstRatings();
        rate.testLoadMovies();
        rate.testLoadRaters();

        //SecondRatings rate2 = new SecondRatings();

        //System.out.println(rate2.getAverageByID("0790636",0));

        MovieRunnerAverage mAvg = new MovieRunnerAverage();        
        mAvg.printAverageRatings();
        mAvg.getAverageRatingOneMovie();
    }

}
