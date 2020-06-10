package classes;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class ForumFetcher{


    public List<String> TitleReader(URL forumlink) {  //Loads a list with guide titles as String
        List<String> titleboard = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(String.valueOf(forumlink)).get();   //Connects to the given (forumlink) webpage
            Elements titles = doc.getElementsByClass("title");      //Parses the HTML code focusing on the specific classname 'title'
            for (Element title : titles) {
                titleboard.add(title.text());
            }  //Fills  a Lists with title Elements
        }
        catch(Exception e){
            System.out.println("Error retrieving from URL: "+ e.getMessage());
        }
        return titleboard;
    }//works accordingly


    public List<String> ViewsReader(URL forumlink){ //Loads a list with guide views as String
        List<String> viewboard = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(String.valueOf(forumlink)).get();
            Elements views = doc.getElementsByClass("post-stat"); //Parses the HTML code focusing on the specific classname 'post-stat'
            for (Element view : views) {
                viewboard.add(view.text());
            }  //Fills  a Lists with view Elements
        }
        catch(Exception e){
            System.out.println("Error retrieving from URL: "+ e.getMessage());
        }
        return viewboard;
    }//works accordingly


    public List<String> BuildLink(URL forumlink){  //Loads a list with guide links as String
        List<String> linkBoard = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(String.valueOf(forumlink)).get();
            Elements links = doc.select("div.title > a");         //Parses the HTML code focusing on the 'a' hrefs under the div class 'title'
            for (Element link : links) {
                linkBoard.add(link.attr("href"));
            }  //Fills  a Lists with url link Elements
        }
        catch(Exception e){
            System.out.println("Error retrieving from URL: "+ e.getMessage());
        }
        return linkBoard;
    }//works accordingly


    public List<Integer> ViewBoardConverter(List<String> viewboard){  //Converts views from string to integers and sorts view List with desc order
        List<Integer> viewsnumber = new ArrayList<>();
        for(int i=0; i<=(viewboard.size()-1); i++){
            viewsnumber.add(Integer.parseInt(viewboard.get(i).replaceAll("[\\D]","")));  //replaces non-number chars with ""
        }
        viewsnumber.sort(Collections.reverseOrder()); //can be replaced by -> Collections.sort(viewsnumber, Collections.reverseOrder());
        return viewsnumber;
    }//works accordingly


    public void BuildShorter(List<String> titleboard, List<String> viewboard, List<String> BuildLink, List<Integer> viewsnumber){  //Shorts rest
        //final int numberOfResults = 10;
        for (int i = 0; i <titleboard.size(); i++){
            for (int j = 0; j <titleboard.size(); j++) {
                if (viewsnumber.get(i) == Integer.parseInt(viewboard.get(j).replaceAll("[\\D]",""))){
                    //Shorting titles
                    String temp = viewboard.get(i);
                    viewboard.set(i,viewboard.get(j));
                    viewboard.set(j, temp);
                    //Shorting views
                    String temp2 = titleboard.get(i);
                    titleboard.set(i,titleboard.get(j));
                    titleboard.set(j, temp2);
                    //Shorting URL links
                    String temp3 = BuildLink.get(i);
                    BuildLink.set(i, BuildLink.get(j));
                    BuildLink.set(j, temp3);
                }
            }
        }  //this double loop shorts all Lists based on the previously shorted Views List
        for(int i=0; i<BuildLink.size();i++){
            String temp = BuildLink.get(i);
            BuildLink.set(i,"https://www.pathofexile.com"+temp);
        }
        //System.out.println();
        //for (int i = 0; i <numberOfResults; i++)
         //   System.out.println(viewboard.get(i)+"    "+"https://www.pathofexile.com"+BuildLink.get(i)+"    "+titleboard.get(i));
    }//works accordingly

}
