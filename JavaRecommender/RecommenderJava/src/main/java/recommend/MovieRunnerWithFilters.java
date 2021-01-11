package recommend;

import java.util.ArrayList;

public class MovieRunnerWithFilters {


public int getSmallestRating(ArrayList<Rating> ratingsList , int from) {
        int minIdx = from;
        for (int i = from +1; i < ratingsList.size(); i++) {
            if (ratingsList.get(i).getValue() < ratingsList.get(minIdx).getValue()) {
                minIdx = i;
            }
        }
        return minIdx;
    }

public ArrayList<Rating> sortRatings(ArrayList<Rating> ratingsList ) {
        for(int i = 0; i < ratingsList.size(); i++) {
            /* find the index of the smallest avg rating*/
            int minIdx = getSmallestRating(ratingsList, i);
            /* swap the ith avg rating with the minIdxth avg rating */
            Rating qi = ratingsList.get(i);
            Rating qmin = ratingsList.get(minIdx);
            ratingsList.set(i, qmin);
            ratingsList.set(minIdx, qi);
        }
        return ratingsList;
    }

    public void printAverageRatings() {
        ThirdRatings rate = new ThirdRatings("data/ratings.csv");
        //ThirdRatings rate = new ThirdRatings( "data/ratings_short.csv");
        System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));

        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        System.out.println("Number of movies in the file "+String.valueOf(movies.size()));
        
        int numberOfRatings=35;
        ArrayList<Rating> ratingsList = rate.getAverageRatings(numberOfRatings);
        System.out.println(ratingsList);
        System.out.println("Number of movies found : "+String.valueOf(ratingsList.size()));
        
        ArrayList<Rating> ratingsListSorted=sortRatings(ratingsList);

        for (Rating ratingItem : ratingsListSorted) {
            String title =MovieDatabase.getTitle(ratingItem.getItem());
            if (ratingItem.getValue()>0) {
                System.out.println(String.valueOf(ratingItem.getValue())+" "+title);
            }           
        }  
        
    }  

    public void printAverageRatingsByYear() {
            ThirdRatings rate = new ThirdRatings("data/ratings.csv");
            //ThirdRatings rate = new ThirdRatings( "data/ratings_short.csv");
            System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));
    
            ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
            System.out.println("Number of movies in the file "+String.valueOf(movies.size()));
            
            Filter yearFilter = new YearAfterFilter(2000);
            int numberOfRatings=20;
            ArrayList<Rating> ratingsList = rate.getAverageRatingsByFilter(numberOfRatings,yearFilter);
            System.out.println(ratingsList);
            System.out.println("Number of movies found : "+String.valueOf(ratingsList.size()));
            ArrayList<Rating> ratingsListSorted=sortRatings(ratingsList);
            
            for (Rating ratingItem : ratingsListSorted) {
                String title =MovieDatabase.getTitle(ratingItem.getItem());
                int year =MovieDatabase.getYear(ratingItem.getItem());
                if (ratingItem.getValue()>0) {
                    System.out.println(String.valueOf(ratingItem.getValue())+" "+String.valueOf(year)+" "+title);
                }           
            }  
            
        } 

    public void printAverageRatingsByGenre() {
            ThirdRatings rate = new ThirdRatings("data/ratings.csv");
            //ThirdRatings rate = new ThirdRatings( "data/ratings_short.csv");
            System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));
    
            ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
            System.out.println("Number of movies in the file "+String.valueOf(movies.size()));
            
            Filter genreFilter = new GenreFilter("Comedy");
            int numberOfRatings=20;
            ArrayList<Rating> ratingsList = rate.getAverageRatingsByFilter(numberOfRatings,genreFilter);
            System.out.println(ratingsList);
            System.out.println("Number of movies found : "+String.valueOf(ratingsList.size()));
            ArrayList<Rating> ratingsListSorted=sortRatings(ratingsList);
            
            for (Rating ratingItem : ratingsListSorted) {
                String title =MovieDatabase.getTitle(ratingItem.getItem());
                String genres =MovieDatabase.getGenres(ratingItem.getItem());
                if (ratingItem.getValue()>0) {
                    System.out.println(String.valueOf(ratingItem.getValue())+" "+title);
                    System.out.println(genres);
                }           
            }  
            
        } 
    
    public void printAverageRatingsByMinutes() {
            ThirdRatings rate = new ThirdRatings("data/ratings.csv");
            //ThirdRatings rate = new ThirdRatings( "data/ratings_short.csv");
            System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));
    
            ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
            System.out.println("Number of movies in the file "+String.valueOf(movies.size()));
            
            Filter minutesFilter = new MinutesFilter(105,135);
            int numberOfRatings=5;
            ArrayList<Rating> ratingsList = rate.getAverageRatingsByFilter(numberOfRatings,minutesFilter);
            System.out.println(ratingsList);
            System.out.println("Number of movies found : "+String.valueOf(ratingsList.size()));
            ArrayList<Rating> ratingsListSorted=sortRatings(ratingsList);
            
            for (Rating ratingItem : ratingsListSorted) {
                String title =MovieDatabase.getTitle(ratingItem.getItem());
                int minutes =MovieDatabase.getMinutes(ratingItem.getItem());
                if (ratingItem.getValue()>0) {
                    System.out.println(String.valueOf(ratingItem.getValue())+" Time: "+String.valueOf(minutes)+" "+title);
                }           
            }  
            
        } 

    
    public void printAverageRatingsByDirectors() {
            ThirdRatings rate = new ThirdRatings("data/ratings.csv");
            //ThirdRatings rate = new ThirdRatings( "data/ratings_short.csv");
            System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));
    
            ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
            System.out.println("Number of movies in the file "+String.valueOf(movies.size()));
            
            Filter directorFilter = new DirectorsFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack");
            int numberOfRatings=4;
            ArrayList<Rating> ratingsList = rate.getAverageRatingsByFilter(numberOfRatings,directorFilter);
            System.out.println(ratingsList);
            System.out.println("Number of movies found : "+String.valueOf(ratingsList.size()));
            ArrayList<Rating> ratingsListSorted=sortRatings(ratingsList);
            
            for (Rating ratingItem : ratingsListSorted) {
                String title =MovieDatabase.getTitle(ratingItem.getItem());
                String directors=MovieDatabase.getDirector(ratingItem.getItem());
                if (ratingItem.getValue()>0) {
                    System.out.println(String.valueOf(ratingItem.getValue())+" "+title);
                    System.out.println(directors);
                }           
            }  
            
        }
        
    public void printAverageRatingsByYearAfterAndGenre() {
            ThirdRatings rate = new ThirdRatings("data/ratings.csv");
            //ThirdRatings rate = new ThirdRatings( "data/ratings_short.csv");
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
            ArrayList<Rating> ratingsListSorted=sortRatings(ratingsList);
            
            for (Rating ratingItem : ratingsListSorted) {
                String title =MovieDatabase.getTitle(ratingItem.getItem());
                String genres =MovieDatabase.getGenres(ratingItem.getItem());
                int year =MovieDatabase.getYear(ratingItem.getItem());
                if (ratingItem.getValue()>0) {
                    System.out.println(String.valueOf(ratingItem.getValue())+" "+String.valueOf(year)+" "+title);
                    System.out.println(genres);
                }           
            }  
            
        } 

    public void printAverageRatingsByDirectorsAndMinutes() {
            ThirdRatings rate = new ThirdRatings("data/ratings.csv");
            //ThirdRatings rate = new ThirdRatings( "data/ratings_short.csv");
            System.out.println("Number of raters in the file "+String.valueOf(rate.getRaterSize()));
    
            ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
            System.out.println("Number of movies in the file "+String.valueOf(movies.size()));
            
            AllFilters myFilters = new AllFilters();
            Filter directorFilter = new DirectorsFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack");
            Filter minutesFilter = new MinutesFilter(90,180);
            myFilters.addFilter(directorFilter);
            myFilters.addFilter(minutesFilter );

            int numberOfRatings=3;
            ArrayList<Rating> ratingsList = rate.getAverageRatingsByFilter(numberOfRatings,myFilters);
            System.out.println(ratingsList);
            System.out.println("Number of movies found : "+String.valueOf(ratingsList.size()));
            ArrayList<Rating> ratingsListSorted=sortRatings(ratingsList);
            
            for (Rating ratingItem : ratingsListSorted) {
                String title =MovieDatabase.getTitle(ratingItem.getItem());
                String directors=MovieDatabase.getDirector(ratingItem.getItem());
                int minutes =MovieDatabase.getMinutes(ratingItem.getItem());
                if (ratingItem.getValue()>0) {
                    System.out.println(String.valueOf(ratingItem.getValue())+" Time: "+String.valueOf(minutes)+" "+title);
                    System.out.println(directors);
                }           
            }  
            
        } 
}


