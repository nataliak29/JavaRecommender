package recommend;
import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings {
    

    public  ArrayList<Movie> loadMovies(String filename) {
        FileResource fr = new FileResource(filename);
        ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser) {
            try {
                String anID = record.get(0);          
                String aTitle = record.get(1);
                String aYear = record.get(2);
                String theGenres = record.get(4);
                String aDirector = record.get(5);
                String aCountry = record.get(3);
                String aPoster = record.get(7);
                int theMinutes = Integer.parseInt(record.get(6));

                Movie thisMovie = new Movie(anID, aTitle, aYear, theGenres, aDirector, aCountry, aPoster, theMinutes);
                listOfMovies.add(thisMovie);
            }
            catch (Exception ArrayIndexOutOfBoundsException) {
                String anID = record.get(0);          
                String aTitle = record.get(1);
                Movie thisMovie = new Movie(anID, aTitle, "0","n/a","n/a","n/a","n/a",0);
                listOfMovies.add(thisMovie);

            }
        }
        return listOfMovies;
    }

    public  ArrayList<Rater> loadRaters(String filename) {
        FileResource fr = new FileResource(filename);
        ArrayList<Rater> listOfRaters = new ArrayList<Rater>();
        ArrayList<String> listOfRaterIDs = new ArrayList<String>();
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser) {
            String raterID = record.get(0);
            String item = record.get(1);
            Double val = Double.valueOf(record.get(2));
            EfficientRater thisRater= new EfficientRater(raterID);

            if (listOfRaterIDs.contains(raterID)) {
                for (Rater r: listOfRaters) {
                    if (r.getID().equals(raterID)) {
                    int raterIndex= listOfRaters.indexOf(r); 
                    Rater rater= listOfRaters.get(raterIndex);      
                    rater.addRating(item, val);
                    listOfRaters.set( raterIndex, rater);
                    }
                }               
            }
            else {
                thisRater.addRating(item, val);
                listOfRaters.add(thisRater);
                listOfRaterIDs.add(raterID);
            }
        }
        return listOfRaters;
    }

    public void testLoadMovies() {
        ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
        //listOfMovies = loadMovies("data/ratedmovies_short.csv");
        listOfMovies = loadMovies("data/ratedmoviesfull.csv");
        System.out.println("Number of movies in the file "+String.valueOf(listOfMovies.size()));

        //Count by ganre

        int comedyCount=0;
        for (Movie m : listOfMovies) {
            String genres = m.getGenres();
            if (genres.indexOf("Comedy")!=-1) {
                    comedyCount+=1;
            }
        }
        System.out.println("Number of comedy movies in the file "+String.valueOf(comedyCount));

        //Count by length of the movie

        int longer150Count=0;
        for (Movie m : listOfMovies) {
            int movieLength = m.getMinutes();
            if (movieLength>150) {
                longer150Count+=1;
            }
        }
        System.out.println("Number of movies are greater than 150 minutes in length "+String.valueOf(longer150Count));

        // Max number of movies by any director
        int maxNumByAnyDirector=0;

        HashMap<String, Integer> directorMovieCount = new HashMap<String, Integer>();
        for (Movie m : listOfMovies) {
            String[] directors = m.getDirector().split(",");

            for (String d: directors) {
                if (!directorMovieCount.containsKey(d)) {
                    directorMovieCount.put(d,1);
                }
                else {
                    directorMovieCount.put(d, directorMovieCount.get(d) + 1);
                }           
            }            
        }    
        for (Integer v : directorMovieCount.values()) {
            if (v>=maxNumByAnyDirector) {
                maxNumByAnyDirector=v;
            }
        } 
        System.out.println("Maximum number of movies by any director "+String.valueOf(maxNumByAnyDirector));
        
        //Find directors with max number of movies
        System.out.println("Those directors are: ");

        for (String s : directorMovieCount.keySet()) {
            if (directorMovieCount.get(s)==maxNumByAnyDirector) {
                System.out.println(s); 
            }
        } 
    }

    public void testLoadRaters() {
        
        int maxNumMoviesRated=0;
        ArrayList<Rater> listOfRaters= new ArrayList<Rater>();
        //listOfRaters = loadRaters("data/ratings_short.csv");
        listOfRaters = loadRaters("data/ratings.csv");

        //Number of raters

        System.out.println("Number of raters "+String.valueOf(listOfRaters.size()));

        //Number of ratings of target rater

        String targetRater="193";
        for (Rater r: listOfRaters) {
            int numItemsRated =r.numRatings();
            if (numItemsRated > maxNumMoviesRated) {
                maxNumMoviesRated=numItemsRated;
            }
            if (r.getID().equals(targetRater)) {
                System.out.println("Number of ratings for rater "+targetRater+" : "+String.valueOf(numItemsRated));
            }            
        }

        //Raters with max number of ratings

        ArrayList<String> ratersWithMaxRatings= new ArrayList<String>(); 
        for (Rater r: listOfRaters) {
            int numItemsRated =r.numRatings();
            if (numItemsRated == maxNumMoviesRated) {
                ratersWithMaxRatings.add(r.getID());          
            }
        }
        System.out.println("Maximum number of ratings by rater: "+String.valueOf(maxNumMoviesRated));
        System.out.println("Number of raters have this maximum number of ratings: "+String.valueOf(ratersWithMaxRatings.size()));
        System.out.println("Those rater IDs are:");

        for (String r: ratersWithMaxRatings) {
            System.out.println(r);
        }

        //Number of rating for a target movie
        String targetMovie="1798709";
        ArrayList<String> ratersRatedTargetMovie= new ArrayList<String>(); 
        for (Rater r: listOfRaters) {
            if (r.hasRating(targetMovie)) {
                ratersRatedTargetMovie.add(r.getID());
            }
        }
        System.out.println("Number of raters that rated movie "+targetMovie+" : "+String.valueOf(ratersRatedTargetMovie.size()));
        System.out.println("Those rater IDs are:");
        for (String r: ratersRatedTargetMovie) {
            System.out.println(r);
        } 
        
        //Number of movie rated
        
        ArrayList<String> moviesRated= new ArrayList<String>();
        for (Rater r: listOfRaters) {
            ArrayList<String> itemsRated=r.getItemsRated();
            if (moviesRated.size()==0) {
                moviesRated=itemsRated;
            }
            if (moviesRated.size()!=0) {
                moviesRated.addAll(itemsRated);
                }
            }

        HashSet<String> uniqueMovies = new HashSet<String>();
        uniqueMovies.addAll(moviesRated);
        System.out.println("These raters rated "+String.valueOf(uniqueMovies.size())+" different movies");       

    }
    
}


