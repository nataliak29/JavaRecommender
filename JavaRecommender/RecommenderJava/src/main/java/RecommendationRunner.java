
import java.util.ArrayList;
import java.util.Random;

public class RecommendationRunner implements Recommender {

    @Override
    public ArrayList<String> getItemsToRate() {
        ArrayList<String> moviesToDisplay= new ArrayList<String>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        int maxNumMovies=15;
        //Random rand = new Random();

        for (int i=0; i<maxNumMovies; i++) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(movies.size()); 
            String m=movies.get(randomIndex);
            moviesToDisplay.add(m);
        }
        return moviesToDisplay;
    }

    @Override
    public void printRecommendationsFor(String webRaterID) {
        FourthRatings rate = new FourthRatings();
        int maxNumMovies=15;
        ArrayList<Rating> list =new ArrayList<Rating>(); 

        try {
            list= rate.getSimilarRatings(webRaterID, 5, 1);    
            }
             catch (Exception IndexOutOfBoundsException) {   
            }

        StringBuilder sb = new StringBuilder();
        if (list.size()< maxNumMovies) {
            maxNumMovies=list.size();
        }

        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>Recommender</title>");
        if (list.size()==0) {
            sb.append("<p> Not enough movies rated to get recommendations. Please try again</p>");
            }
        else {
            sb.append("<h1>Top 15 Recommended Movies</h1>");
            sb.append("<style>");
            sb.append("body {background-color: powderblue;text-align:center;}");
            sb.append("p {font: 15px Arial, sans-serif;}");
            sb.append("figure {margin:2px;display:inline-block;vertical-align:top;border:solid gray;}");
            sb.append("</style>");
            sb.append("</head>");
            sb.append("<div class='row'>");
            sb.append("<div class='column'>");
        for (int i=0; i<maxNumMovies; i++) {

            Rating r = list.get(i);
            Movie thisMovie=MovieDatabase.getMovie(r.getItem());
            String title =thisMovie.getTitle();
            int year =thisMovie.getYear();
            int minutes =thisMovie.getMinutes();
            String country =thisMovie.getTitle();
            String genre=thisMovie.getGenres();
            String directors =thisMovie.getDirector();
            String poster = "http://www.dukelearntoprogram.com/capstone/data/" + thisMovie.getPoster().substring(7);

            sb.append("<figure>");
            sb.append("<img src='"+poster+"'>");
            sb.append("<figcaption>");
            sb.append("<p>"+title+" ("+String.valueOf(year)+")"+"</p>");
            sb.append("</figcaption>");
            sb.append("</figure>");


        }
    }

        sb.append("</div>");
        sb.append("</body>");
        sb.append("</html>");

        System.out.println(sb.toString());

    }

}
