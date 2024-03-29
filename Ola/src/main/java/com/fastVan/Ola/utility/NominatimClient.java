package com.fastVan.Ola.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class NominatimClient {

    public double[] getCoordinates(String query) {
        double[]latLong = new double[2];
        try {
            // Prepare the query by replacing spaces with '+'
            String formattedQuery = query.replace(" ", "+");

            // Create the URL for the Nominatim API request
            URL url = new URL("https://nominatim.openstreetmap.org/search?q=" + formattedQuery + "&format=json");

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            // Set a user-agent header to identify your application
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            // Close the connections
            in.close();
            connection.disconnect();

            // Parse the JSON response
            JSONArray jsonArray = new JSONArray(content.toString());
            if (!jsonArray.isEmpty()) {
                JSONObject jsonObject = jsonArray.getJSONObject(0); // Get the first result
                String lat = jsonObject.getString("lat");
                String lon = jsonObject.getString("lon");
                System.out.println("latitude : "+lat+" "+" longitude : "+lon);
                latLong[0] = Double.parseDouble(lat);
                latLong[1] = Double.parseDouble(lon);
            } else {
                System.out.println("No results found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return latLong;
    }
    /*
    public static void main(String[] args) {
        String query = "New York City, NY";
        getCoordinates(query);
    }
    */
}
