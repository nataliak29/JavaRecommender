package recommend;

import java.util.ArrayList;

public class MovieRunnerAverage {

    public int getSmallestRating(ArrayList<Rating> ratingsList , int from) {
        int minIdx = from;
        for (int i = from +1; i < ratingsList.size(); i++) {
            if (ratingsList.get(i).getValue() < ratingsList.get(minIdx).getValue()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void printAverageRatings() {
        SecondRatings rate = new SecondRatings();
        System.out.println("Number of movies in the file "+String.valueOf(rate.getMovieSize()));
        System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));
        int numberOfRatings=12;
        ArrayList<Rating> ratingsList = rate.getAverageRatings(numberOfRatings);
        System.out.println("Number of movies with more than "+String.valueOf(numberOfRatings)+" ratings :"+String.valueOf(ratingsList.size()));

        for(int i = 0; i < ratingsList.size(); i++) {
            /* find the index of the smallest avg rating*/
            int minIdx = getSmallestRating(ratingsList, i);
            /* swap the ith avg rating with the minIdxth avg rating */
            Rating qi = ratingsList.get(i);
            Rating qmin = ratingsList.get(minIdx);
            ratingsList.set(i, qmin);
            ratingsList.set(minIdx, qi);
        }
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
