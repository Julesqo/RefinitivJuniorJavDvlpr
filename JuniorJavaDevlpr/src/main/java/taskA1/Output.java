package taskA1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;

import java.util.Scanner;

public class Output {
    public static void main(String[] args) {
        final String url = "http://www.mercado.ren.pt/EN/Electr/MarketInfo/Gen/Pages/Forecast.aspx";

        try{
           final Document document = Jsoup.connect(url).timeout(0).get();

           for (Element row : document.select("div.mainContent tr")) {

               final String hh = row.select("td:nth-of-type(1)").text();
               final String wind = row.select("td:nth-of-type(2)").text();
               final String solar = row.select("td:nth-of-type(3)").text();
               final String others = row.select("td:nth-of-type(3)").text();
               System.out.println(hh + " wind: " + wind + " solar: " +solar + " others: " +others);


           }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
