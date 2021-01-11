package recommend;
import java.util.*;

public class ThirdRatings {

    //private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        this("data/ratings.csv"); 
    }

    public ThirdRatings( String ratingsfile) {
        FirstRatings rate = new FirstRatings();
        myRaters= rate.loadRaters(ratingsfile);  
                      
    }

    public int getRaterSize() {
        return myRaters.size();
    }

    public double getAverageByID(String id, int minimalRaters) {
        int countRaters=0;
        double sumRating=0;
        for ( Rater r: myRaters) {
            try {
            if (  r.getRating(id)!=-1) {
                sumRating+=r.getRating(id);
                countRaters+=1;
            }
        }
        catch (Exception NullPointerException) {

        }
        }
        double avg=sumRating/countRaters;
        if (countRaters>=minimalRaters) {
            return avg;
        }

        else {
            return 0;
        }

    }

    public ArrayList<Rating> getAverageRatings(int minimalRaters) {
        ArrayList<Rating> ratingsList = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for (String m: movies) {
            //String movieID= m.getID();
            double val = getAverageByID(m, minimalRaters);
            Rating rating = new Rating (m, val);
            if (val>0) {
                ratingsList.add(rating);
            }
        }
        return ratingsList;
    }

    public ArrayList<Rating>  getAverageRatingsByFilter(int minimalRaters,Filter filterCriteria) {
        ArrayList<Rating> ratingsList = new ArrayList<Rating>();
        ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
        for (String m: movies) {
            //String movieID= m.getID();
            double val = getAverageByID(m, minimalRaters);
            Rating rating = new Rating (m, val);
            if (val>0) {
                ratingsList.add(rating);
            }
        }
        return ratingsList;
    }

    
}
