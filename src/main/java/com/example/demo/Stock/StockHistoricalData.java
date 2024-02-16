package com.example.demo.Stock;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class StockHistoricalData {
    public static void main(String[] args) {

//        try {
//            String apiKey = "6ZC3AWD8JBACSWN0";
//            String symbol = "AAPL"; // Replace with the stock symbol you want
//
//            // Construct the URL for the API request
//           // https://www.alphavantage.co/query?function=OVERVIEW&symbol=IBM&apikey=demo
////            String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="
////                    + symbol + "&apikey=" + apiKey;
//            String apiUrl = "https://www.alphavantage.co/query?function=OVERVIEW&symbol="
//                    + symbol + "&apikey=" + apiKey;
//
//            URL url = new URL(apiUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            StringBuilder response = new StringBuilder();
//            String line;
//
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//
//            reader.close();
//            connection.disconnect();
//
//            // Process and display the retrieved data (e.g., print to console)
//            System.out.println(response);
//
//            // Parse the JSON response and extract necessary data for displaying historical stock information
//            // This would involve parsing the JSON and formatting the output according to your needs
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
    public static  Stock getStock(){
        //initialize the api key ang url
        String apiKey = "6ZC3AWD8JBACSWN0";
        String symbol = "AAPL"; // Replace with the stock symbol you want
        String apiUrl = "https://www.alphavantage.co/query?function=OVERVIEW&symbol="
                + symbol + "&apikey=" + apiKey;
        Gson gson = new Gson();
        Stock stock = new Stock();
        try{
            //Make an HttpRequest object and pass headers,method and build(Body if POST(BodyPublishers.ofString(jsonRequest)) request)
            HttpRequest httpRequest = HttpRequest.newBuilder(new URI(apiUrl))
                    .header("Authorization", apiKey)
                    .GET()
                    .build();
            //if Post request.POST(BodyPublishers.ofString(jsonRequest),
            // first convert objext to json using gson;
            //String jsonrequest =  gson.toJson(transcript)
            //

            //create a client
            HttpClient httpClient = HttpClient.newHttpClient();

            //Send the request and store the response in httpresponse
            HttpResponse<String> httpResponse =  httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse.body());
            stock = gson.fromJson(httpResponse.body(),Stock.class);
            System.out.println(stock.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return stock;
    }
}
