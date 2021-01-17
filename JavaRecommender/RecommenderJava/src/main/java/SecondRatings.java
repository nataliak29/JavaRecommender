import java.util.*;
public class SecondRatings {

    private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("data/ratedmoviesfull.csv", "data/ratings.csv");
        //this("data/ratedmovies_short.csv", "data/ratings_short.csv");
    }

    public SecondRatings(String moviefile, String ratingsfile) {
        FirstRatings rate = new FirstRatings();
        myMovies=rate.loadMovies(moviefile);
        myRaters= rate.loadRaters(ratingsfile);                
    }

    public int getMovieSize() {
        return myMovies.size();
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
        for (Movie m: myMovies) {
            String movieID= m.getID();
            double val = getAverageByID(movieID, minimalRaters);
            Rating rating = new Rating (movieID, val);
            if (val>0) {
                ratingsList.add(rating);
            }
        }
        return ratingsList;
    }

    public String getTitle(String ID) {
        for (Movie m: myMovies) {
            String movieID= m.getID();
            String movieTitle=m.getTitle();
            if (movieID.equals(ID)) {
                return movieTitle;
            }
        }
        return "MovieID "+ID+ " is not found";
    }

    public String getID(String title) {
        for (Movie m: myMovies) {
            String movieID= m.getID();
            String movieTitle=m.getTitle();
            if (movieTitle.equals(title)) {
                return movieID;
            }
        }
        return "No such title found";
    }



    
    
}
