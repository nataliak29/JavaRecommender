package recommend;

import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerSimilarRatings {

    public void printAverageRatings() {
        FourthRatings rate = new FourthRatings();

        System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));

        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        System.out.println("Number of movies in the file "+String.valueOf(movies.size()));
        
        int numberOfRatings=35;
        ArrayList<Rating> ratingsList = rate.getAverageRatings(numberOfRatings);
        System.out.println(ratingsList);
        System.out.println("Number of movies found : "+String.valueOf(ratingsList.size()));
        Collections.sort(ratingsList,Collections.reverseOrder());

        for (Rating ratingItem : ratingsList) {
            String title =MovieDatabase.getTitle(ratingItem.getItem());
            if (ratingItem.getValue()>0) {
                System.out.println(String.valueOf(ratingItem.getValue())+" "+title);
            }           
        }  
        
    }   
    
    public void printAverageRatingsByYearAfterAndGenre() {
        FourthRatings rate = new FourthRatings();

        System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));

        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        System.out.println("Number of movies in the file "+String.valueOf(movies.size()));
        
        AllFilters myFilters = new AllFilters();
        Filter genreFilter = new GenreFilter("Drama");
        Filter yearFilter = new YearAfterFilter(1990);
        myFilters.addFilter(genreFilter);
        myFilters.addFilter(yearFilter);

        int numberOfRatings=8;
        ArrayList<Rating> ratingsList = rate.getAverageRatingsByFilter(numberOfRatings,myFilters);
        System.out.println(ratingsList);
        System.out.println("Number of movies found : "+String.valueOf(ratingsList.size()));
        Collections.sort(ratingsList,Collections.reverseOrder());
        
        for (Rating ratingItem : ratingsList) {
            String title =MovieDatabase.getTitle(ratingItem.getItem());
            String genres =MovieDatabase.getGenres(ratingItem.getItem());
            int year =MovieDatabase.getYear(ratingItem.getItem());
            if (ratingItem.getValue()>0) {
                System.out.println(String.valueOf(ratingItem.getValue())+" "+String.valueOf(year)+" "+title);
                System.out.println(genres);
            }           
        }  
        
    } 

    public void printSimilarRatings() {
        FourthRatings rate = new FourthRatings();
        Filter filter = new TrueFilter();
        System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));
        ArrayList<String> movies = MovieDatabase.filterBy(filter);
        System.out.println("Number of movies in the file "+String.valueOf(movies.size()));

        ArrayList<Rating> ratingsList= rate.getSimilarRatingsByFilter("71", 20, 5,filter);      

        for (Rating ratingItem : ratingsList) {
            String title =MovieDatabase.getTitle(ratingItem.getItem());
            System.out.println(title+"  "+String.valueOf(ratingItem.getValue()));            
        }        
    }   


    public void printSimilarRatingsByGenre() {
        FourthRatings rate = new FourthRatings();
        Filter filter = new GenreFilter("Mystery");
        System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));
        ArrayList<String> movies = MovieDatabase.filterBy(filter);
        System.out.println("Number of movies in the file "+String.valueOf(movies.size()));
        
        ArrayList<Rating> ratingsList= rate.getSimilarRatingsByFilter("964", 20, 5,filter);      

        for (Rating ratingItem : ratingsList) {
            String title =MovieDatabase.getTitle(ratingItem.getItem());
            String genres =MovieDatabase.getGenres(ratingItem.getItem());
            System.out.println(title+"  "+String.valueOf(ratingItem.getValue()));   
            System.out.println(genres);         
        }        
    }   


    public void printSimilarRatingsByDirector() {
        FourthRatings rate = new FourthRatings();
        Filter filter = new DirectorsFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh");
        System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));
        ArrayList<String> movies = MovieDatabase.filterBy(filter);
        System.out.println("Number of movies in the file "+String.valueOf(movies.size()));
        
        ArrayList<Rating> ratingsList= rate.getSimilarRatingsByFilter("120", 10,2,filter);      

        for (Rating ratingItem : ratingsList) {
            String title =MovieDatabase.getTitle(ratingItem.getItem());
            String directors=MovieDatabase.getDirector(ratingItem.getItem());
            System.out.println(title+"  "+String.valueOf(ratingItem.getValue()));
            System.out.println(directors);            
        }        
    } 
    
    public void printSimilarRatingsByGenreAndMinutes() {
        FourthRatings rate = new FourthRatings();
        AllFilters filter = new AllFilters();
        Filter genreFilter = new GenreFilter("Drama");
        Filter minutesFilter = new MinutesFilter(80,160);
        filter.addFilter(genreFilter );
        filter.addFilter(minutesFilter );
        System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));
        ArrayList<String> movies = MovieDatabase.filterBy(filter);
        System.out.println("Number of movies in the file "+String.valueOf(movies.size()));
        
        ArrayList<Rating> ratingsList= rate.getSimilarRatingsByFilter("168", 10, 3,filter);      

        for (Rating ratingItem : ratingsList) {
            String title =MovieDatabase.getTitle(ratingItem.getItem());
            String genres =MovieDatabase.getGenres(ratingItem.getItem());
            int minutes =MovieDatabase.getMinutes(ratingItem.getItem());
            System.out.println(title+"  "+String.valueOf(ratingItem.getValue())+" Time: "+String.valueOf(minutes));   
            System.out.println(genres);         
        }        
    }  

    public void printSimilarRatingsByYearAfterAndMinutes() {
        FourthRatings rate = new FourthRatings();
        AllFilters filter = new AllFilters();
        Filter yearFilter = new YearAfterFilter(1975);
        Filter minutesFilter = new MinutesFilter(70,200);
        filter.addFilter(yearFilter );
        filter.addFilter(minutesFilter );
        System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));
        ArrayList<String> movies = MovieDatabase.filterBy(filter);
        System.out.println("Number of movies in the file "+String.valueOf(movies.size()));
        
        ArrayList<Rating> ratingsList= rate.getSimilarRatingsByFilter("314", 10, 5,filter);      

        for (Rating ratingItem : ratingsList) {
            String title =MovieDatabase.getTitle(ratingItem.getItem());
            int year =MovieDatabase.getYear(ratingItem.getItem());
            int minutes =MovieDatabase.getMinutes(ratingItem.getItem());
            System.out.println(title+"  "+String.valueOf(ratingItem.getValue())+" "+String.valueOf(year)+" Time: "+String.valueOf(minutes));           
        }        
    }  

}
