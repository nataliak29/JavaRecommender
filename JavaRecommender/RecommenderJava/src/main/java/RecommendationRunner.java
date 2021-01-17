
import java.util.ArrayList;
import java.util.Random;

public class RecommendationRunner implements Recommender {

    @Override
    public ArrayList<String> getItemsToRate() {
        ArrayList<String> moviesToDisplay= new ArrayList<String>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        int maxNumMovies=20;
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
        int maxNumMovies=20;
        //ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        ArrayList<Rating> list =rate.getSimilarRatings(webRaterID, 5, 1); 
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<style>");
        sb.append("body {background-color: powderblue;}");
        sb.append("table, th, td { border: 1px solid black; }");
        sb.append("table, td {font: 15px Arial, sans-serif;}");
        sb.append("tr:hover {background-color: #f5f5f5;}");
        sb.append("</style>");
        sb.append("</head>");
        sb.append("<table>");
        sb.append("<th> Top 20 Recommended Movies </th>");
        for (int i=0; i<maxNumMovies; i++) {
            Rating r = list.get(i);
            String title =MovieDatabase.getTitle(r.getItem());
            sb.append("<tr>");
            sb.append("<td> " + title + " </td>");
            sb.append("</tr>");
        }

        sb.append("</table>");
        sb.append("</body>");
        sb.append("</html>");

        System.out.println(sb.toString());

    }

    public static void main(String[] args){
        RecommendationRunner r = new RecommendationRunner();
        System.out.println(r.getItemsToRate());
        r.printRecommendationsFor("test");
    }
    
}
