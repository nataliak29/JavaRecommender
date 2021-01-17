import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerAverage {

    
    public void printAverageRatings() {
        //SecondRatings rate = new SecondRatings("data/ratedmoviesfull.csv", "data/ratings.csv");
        SecondRatings rate = new SecondRatings("data/ratedmovies_short.csv", "data/ratings_short.csv");
        System.out.println("Number of movies in the file "+String.valueOf(rate.getMovieSize()));
        System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));
        int numberOfRatings=0;
        ArrayList<Rating> ratingsList = rate.getAverageRatings(numberOfRatings);
        System.out.println(ratingsList);
        System.out.println("Number of movies with more than "+String.valueOf(numberOfRatings)+" ratings :"+String.valueOf(ratingsList.size()));

        Collections.sort(ratingsList,Collections.reverseOrder());
        
        for (Rating ratingItem : ratingsList) {
            String title =rate.getTitle(ratingItem.getItem());
            if (ratingItem.getValue()>0) {
                System.out.println(String.valueOf(ratingItem.getValue())+" "+title);
            }           
        }  
    }


    public void getAverageRatingOneMovie() {
        String title="Vacation";
        //SecondRatings rate = new SecondRatings("data/ratedmovies_quiz.csv", "data/ratings_quiz.csv");
        SecondRatings rate = new SecondRatings();
        String movieID=rate.getID(title);
        double val=rate.getAverageByID(movieID, 0);
        System.out.println("Average rating for "+title+" is "+String.valueOf(val));

    }
}
